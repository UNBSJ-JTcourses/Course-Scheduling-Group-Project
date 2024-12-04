import java.io.Serializable;
import java.util.ArrayList;

/****************************************************************************
 * CS2043 - Project CourseList Class
 * @ author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @ version - 1.0
 * @ date - December 6th, 2024
 ****************************************************************************/
public class CourseList implements Serializable
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
        Course foundCourse = null;
        for(int i = 0; i < courseList.size(); i++)
        {
             //if the given class is in the course list
            if(courseList.get(i).getCourseID().equalsIgnoreCase(courseID))
            {
                foundCourse = courseList.get(i);
            }

        }
        if(foundCourse == null)
        {
            System.out.println("Course not found");
        }

        return foundCourse;
    }

    // Basic Methods
    public void addCourse(Course course)
    {
        courseList.add(course);
    }
}
