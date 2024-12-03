import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/****************************************************************************
 * CS2043 - Project Course Class
 * @ author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @ version - 1.0
 * @ date - October 31st, 2024
 ****************************************************************************/
public class Course implements Serializable
{
    // Instance Data
    private String courseID;
    private String extraText;
    private boolean hasMultipleTimes;
    private ArrayList<Timeslot> classTimes;
    private Timeslot timeslot;
    private String instructor;

    // Constructor with instructor
    public Course(String courseID, String extraText, String timeSlot, String instructor)
    {
        this.courseID = courseID;
        this.extraText = extraText;
        this.instructor = instructor;
        // This divides the separate courses on ';'
        this.classTimes = createSeperateCourses(timeSlot);
        // If there is more than one timeslot it will be true
        this.hasMultipleTimes = classTimes.size() > 1;
    }

    // Constructor WITHOUT instructor
    public Course(String courseID, String extraText, String timeSlot)
    {
        this.courseID = courseID;
        this.extraText = extraText;
        // This divides the seperate courses on ';'
        this.classTimes = createSeperateCourses(timeSlot);
        // If there is more than one timeslot it will be true
        this.hasMultipleTimes = classTimes.size() > 1;
        instructor = "TBD";
    }

    // Constructor of a basic course without multiple times
    public Course(String courseID, String extraText, Timeslot timeslot, String instructor)
    {
        this.courseID = courseID;
        this.extraText = extraText;
        this.classTimes.add(timeslot);
        this.instructor = instructor;
    }

    // Add a non-course block constructor here


    // Method to create multiple classes from courses seperated by a ';'
    public static ArrayList<Timeslot> createSeperateCourses(String timeslot)
    {
        // Creating arrayList
        ArrayList<Timeslot> classTimes = new ArrayList<>();

        // Creating a string array to split the classes
        String[] slots = timeslot.split(";");

        // For each String slot in slots
        for(String slot: slots)
        {
            slot = slot.trim();
            // Parse the timeslot
            classTimes.add(parseTimeSlot(slot));
        }
        // return arraylist of courses
        return classTimes;
    }

    // Parsing the inputted string into different times
    public static Timeslot parseTimeSlot(String timeSlot)
    {
        // Create an array of strings in order to extract the first day char
        String[] parts = timeSlot.split(" ",2);

        // Putting the first part into the day
        char day = parts[0].charAt(0);

        // Create another array of strings to get the times
        String[] times = parts[1].split("-");

        // Putting the first part into the startTime
        String startTime = times[0].trim();

        // Putting the second part into the endTime
        String endTime = times[1].trim();

        return new Timeslot(day, startTime, endTime);
    }

/* */ // MAYBE NOT NEEDED ANYMORE?
    // Check for Conflicts Method
    public boolean checkCourseConflict(Course other)
    {

        // Check if courses are on the same day, if not then no conflict
        if(this.getTimeslot(0).getDay() != other.getTimeslot(0).getDay())
        {
            // Return no conflict
            return false;

        }

        // Define a date time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Put each separate time into a LocalTime variable so they can be compared
        LocalTime thisStart = LocalTime.parse(this.getTimeslot(0).getStartTime(), formatter);
        LocalTime thisEnd = LocalTime.parse(this.getTimeslot(0).getEndTime(), formatter);
        LocalTime otherStart = LocalTime.parse(other.getTimeslot(0).getStartTime(), formatter);
        LocalTime otherEnd = LocalTime.parse(other.getTimeslot(0).getEndTime(), formatter);

        // If this class ends before that on starts or this one starts after that one ends
        if(thisEnd.isBefore(otherStart) || thisStart.isAfter(otherEnd))
        {
            // Return that there is no conflict
            return false;
        }
        else
        {
            // There is a conflict between courses
            return true;
        }
    }

// */

    // Basic Methods
    public String getCourseID()
    {
        return courseID;
    }

    public void setCourseID(String courseID)
    {
        this.courseID = courseID;
    }

    public ArrayList getClassTimes()
    {
        return classTimes;
    }

    public Timeslot getTimeslot(int i)
    {
        return classTimes.get(i);
    }

    public String getExtraText()
    {
        return extraText;
    }

    public void setExtraText(String extraText) {
        this.extraText = extraText;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public boolean getHasMultipleTimes()
    {
        return hasMultipleTimes;
    }

    // FIX THIS maybe
    public String toString()
    {
        return courseID + ", " + extraText + ", " + this.classTimes.toString() + ", " + instructor ;

    }
}

