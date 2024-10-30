
/****************************************************************************
 * CS2043 - Project Course Class
 *
 * @author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @version - 1.0
 * @date - October 30th, 2024
 ****************************************************************************/

public class Course
{
    //Declare attributes
    private int courseID;
    private String type;
    private String timeSlot;
    private String instructor;

    //Constructor if the instructor is specified
    Course (int courseID, String type, String timeSlot, String instructor)
    {
        this.courseID = courseID;
        this.type = type;
        this.timeSlot = timeSlot;
        this.instructor =  instructor;
    }

    //Constructor if instructor is NOT specified
    Course (int courseID, String type, String timeSlot)
    {
        this.courseID = courseID;
        this.type = type;
        this.timeSlot = timeSlot;
        this.instructor = "";
    }

    //Accessor methods
    int getCourseID()
    {
        return courseID;
    }

    String getType()
    {
        return type;
    }

    String getTimeSlot()
    {
        return  timeSlot;
    }

    String getInstructor()
    {
        return instructor;
    }

    //Mutator methods
    void changeCourseID(int newCourseID)
    {
        courseID = newCourseID;
    }

    void changeType(String newType)
    {
        type = newType;
    }

    void changeTimeSlot(String newTimeSlot)
    {
        timeSlot = newTimeSlot;
    }

    void changeInstructor(String newInstructor)
    {
        instructor = newInstructor;
    }



}

