/****************************************************************************
 * CS2043 - Project Group Class
 * @ author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @ version - 1.0
 * @ date - October 31st, 2024
 ****************************************************************************/
public class Group
{
    // Instance Data (groupName and list)

    // Constructor

    // Check for conflict in a group
    public boolean checkGroupConflict()
    {
        // Comparing every i course to every j course in group
        for(int i = 0; i < list.size(); i++)
        {
            for(int j = i+1; j < list.size() j++)
            {
                Course course1 = list.get(i);
                Course course2 = list.get(j);

                // If there's conflict
                if(course1.checkCourseConflict(course2))
                {
                    // Print out that there is conflict
                    System.out.println("There is conflict between " + course1.getCourseID() + " and " + course2.getCourseID());
                    return true;
                }
                else
                {
                    // If no conflict display schedule
                    displaySchedule();
                    return false;
                }
            }
        }
    }

    // Display Schedule of a group
    void displaySchedule()
    {
        // Declaring a variables for printing
        String results;
        Course currentCourse;
        // For each course in the group get the toString and print it
        for(int i = 0; i < list.length(); i++)
        {
            currentCourse = list.get(i);
            results = currentCourse.toString();
            System.out.println(results);
        }
    }

    // Sorting method to sort group based on day (char)
    void sortGroup()
    {

    }

    // Basic Methods

}
