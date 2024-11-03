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
public class Group
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
    public void checkGroupConflict()
    {
        // Comparing every i course to every j course in group
        for(int i = 0; i < list.size(); i++)
        {
            for(int j = i+1; j < list.size(); j++)
            {
                Course course1 = list.get(i);
                Course course2 = list.get(j);

                // If there's conflict
                if(course1.checkCourseConflict(course2))
                {
                    // Print out that there is conflict
                    System.out.println("There is conflict between " + course1.getCourseID() + " and " + course2.getCourseID());
                }
                else
                {
                    // If no conflict display schedule
                    displaySchedule();
                }
            }
        }
    }

    // Display Schedule of a group
    public void displaySchedule()
    {
        // Sort group first
        sortGroup();

        // Declaring a variables for printing
        String results;
        Course currentCourse;
        // For each course in the group get the toString and print it
        for(int i = 0; i < list.size(); i++)
        {
            currentCourse = list.get(i);
            results = currentCourse.toString();
            System.out.println(results);
        }
    }

    // Sorting method to sort group based on day (char) using bubble sort
    public void sortGroup()
    {
        boolean swapped;
        for(int i=0; i < list.size() - 1; i++)
        {
            swapped = false;
            for(int j=0; j < list.size() - i - 1; j++)
            {
                Course course1 = list.get(j);
                Course course2 = list.get(j + 1);

                // Compare using Integer compare based on the day's rank
                int comparison = Integer.compare(dayRank(course1.getDay()), dayRank(course1.getDay()));

                // If comparison is 0 that means they are on the same day and must compare time
                if(comparison == 0)
                {
                    LocalTime startTime1 = LocalTime.parse(course1.getStartTime(), DateTimeFormatter.ofPattern("H:mm"));
                    LocalTime startTime2 = LocalTime.parse(course2.getStartTime(), DateTimeFormatter.ofPattern("H:mm"));

                    // If start time 1 is after start time 2 swap them
                    if(startTime1.isAfter(startTime2))
                    {
                        list.set(j, course2);
                        list.set(j+1, course1);
                        swapped = true;
                    }
                }
                // If comparison is 1 or more, course1's day is after course2's day
                else if (comparison > 0)
                {
                    list.set(j, course2);
                    list.set(j+1, course1);
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
