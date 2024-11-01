import java.util.ArrayList;

/****************************************************************************
 * CS2043 - Project CourseList Class
 * @ author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @ version - 1.0
 * @ date - October 30th, 2024
 ****************************************************************************/
public class CourseList
{
    // Instance Data
    private ArrayList<Course> courseList;

    // Constructor
    public CourseList()
    {
        courseList = new ArrayList<>();
    }

    // Search Method to find a specific course using the CourseID
    // NEEDED for adding courses to a group in main method
    Course searchForCourse(String courseID)
    {
        for(int i = 0; i < courseList.size(); i++)
        {
             //if the given class is in the course list
            if(courseList.get(i).getCourseID().equalsIgnoreCase(courseID))
            {
                return courseList.get(i);
            }
        }
        System.out.println("Course not found");
        return null;
    }

    // Basic Methods
    public void addCourse(Course course)
    {
        courseList.add(course);
    }
}
