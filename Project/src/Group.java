import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalTime;
/****************************************************************************
 * CS2043 - Project Group Class
 * @ author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @ version - 1.0
 * @ date - October 31st, 2024
 ****************************************************************************/
public class Group implements Serializable
{
    // Instance Data
    private String name;
    private ArrayList<Course> list;

    // Constructor
    public Group(String name)
    {
        this.name = name;
        this.list = new ArrayList<>();
    }

    // Check for conflict in a group
    // NEED TO FIX THIS
    public void checkGroupConflict()
    {
        // Create an arrayList that will hold every course in the group with every timeslot
        ArrayList<Course> allCoursesInGroup = new ArrayList<>();

        // For each course in the group
        // Creat a new course for every time slot if there is more than one

        for(Course c: list)
        {
            // If there's multiple class times make each individual course
            if(c.getHasMultipleTimes())
            {
                for (int i = 0; i<c.getClassTimes().size(); i++)
                {
                    // Make new course and add to arraylist of all courses
                    allCoursesInGroup.add(new Course(c.getCourseID(), c.getExtraText(), c.getTimeslot(i), c.getInstructor()));
                }
            }
            else
            {
                allCoursesInGroup.add(c);
            }
        }


        boolean conflict = false;
        // Comparing every i course to every j course in group
        for(int i = 0; i < allCoursesInGroup.size(); i++)
        {
            for(int j = i+1; j < allCoursesInGroup.size(); j++)
            {
                Course course1 = allCoursesInGroup.get(i);
                Course course2 = allCoursesInGroup.get(j);

                // If there's conflict
                if(course1.checkCourseConflict(course2))
                {
                    // Print out that there is conflict
                    System.out.println("There is conflict between " + course1.getCourseID() + " and " + course2.getCourseID());
                    conflict = true;
                }

            }
        }
        if (!conflict)
        {
            displaySchedule(allCoursesInGroup);
        }
    }

    // Display Schedule of a group
    // For every course with multiple timeslots create each individual course
    public void displaySchedule(ArrayList<Course> allCoursesInGroup)
    {
        // Sort group first
        sortGroup(allCoursesInGroup);

        // Declaring a variables for printing
        String results;
        Course currentCourse;
        // For each course in the group get the toString and print it
        for(int i = 0; i < allCoursesInGroup.size(); i++)
        {
            currentCourse = list.get(i);
            results = currentCourse.toString();
            System.out.println(results);
        }
    }

    // Sorting method to sort group based on day (char) using bubble sort
    public void sortGroup(ArrayList<Course> allCoursesInGroup)
    {
        boolean swapped;

        for(int i=0; i < allCoursesInGroup.size() - 1; i++)
        {
            swapped = false;
            for(int j=0; j < allCoursesInGroup.size() - i - 1; j++)
            {
                Course course1 = allCoursesInGroup.get(j);
                Course course2 = allCoursesInGroup.get(j + 1);

                // Compare using Integer compare based on the day's rank
                int comparison = Integer.compare(dayRank(course1.getTimeslot(0).getDay()), dayRank(course2.getTimeslot(0).getDay()));

                // If comparison is 0 that means they are on the same day and must compare time
                if(comparison == 0)
                {
                    LocalTime startTime1 = LocalTime.parse(course1.getTimeslot(0).getStartTime(), DateTimeFormatter.ofPattern("HH:mm"));
                    LocalTime startTime2 = LocalTime.parse(course2.getTimeslot(0).getStartTime(), DateTimeFormatter.ofPattern("HH:mm"));

                    // If start time 1 is after start time 2 swap them
                    if(startTime1.isAfter(startTime2))
                    {
                        allCoursesInGroup.set(j+1, course2);
                        allCoursesInGroup.set(j, course1);
                        swapped = true;
                    }
                }
                // If comparison is 1 or more, course1's day is after course2's day
                else if (comparison > 0)
                {
                    allCoursesInGroup.set(j+1, course2);
                    allCoursesInGroup.set(j, course1);
                    swapped = true;
                }
                // Anything else no swap is required
            }
        }
    }

    // Method to define the ranks of each day to enable sorting
    public int dayRank(char day)
    {
        // Create an array of the char days setting H as thursday for now
        List<Character> dayOrder = Arrays.asList('M', 'T', 'W', 'H', 'F');
        // return the index of the day
        return dayOrder.indexOf(day);
    }

    // Basic Methods
    public void addToGroup(Course course)
    {
        list.add(course);
    }

    public String getGroupName()
    {
        return name;
    }

    public void setGroupName(String name)
    {
        this.name = name;
    }
}
