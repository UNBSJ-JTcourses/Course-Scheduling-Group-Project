import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/****************************************************************************
 * CS2043 - Project Course Class
 * @ author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @ version - 1.0
 * @ date - October 31st, 2024
 ****************************************************************************/
public class Course
{
    // Instance Data
    private String courseID;
    private String extraText;
    private char day;
    private String startTime;
    private String endTime;
    private String instructor;

    // Constructor with instructor
    public Course(String courseID, String extraText, String timeSlot, String instructor)
    {
        this.courseID = courseID;
        this.extraText = extraText;
        this.instructor = instructor;
        parseTimeSlot(timeSlot);
    }

    // Constructor WITHOUT instructor
    public Course(String courseID, String extraText, String timeSlot)
    {
        this.courseID = courseID;
        this.extraText = extraText;
        parseTimeSlot(timeSlot);
        instructor = " ";
    }

    // Check for Conflicts Method
    public boolean checkCourseConflict(Course other)
    {
        // Check if courses are on the same day, if not then no conflict
        if(this.day != other.day)
        {
            // Return no conflict
            return false;
        }

        // Define a date time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");

        // Put each separate time into a LocalTime variable so they can be compared
        LocalTime thisStart = new LocalTime.parse(this.startTime, formatter);
        LocalTime thisEnd = new LocalTime.parse(this.endTime, formatter);
        LocalTime otherStart = new LocalTime.parse(other.startTime, formatter);
        LocalTime otherEnd = new LocalTime.parse(other.endTime, formatter);

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

    // Parsing the inputted string into different times
    public void parseTimeSlot(String timeSlot)
    {
        // Create an array of strings in order to extract the first day char
        String[] parts = timeSlot.split(" ");
        // Putting the first part into the day
        this.day = parts[0].charAt(0);
        // Create another array of strings to get the times
        String[] times = parts[1].split("-");
        // Putting the first part into the startTime
        this.startTime = times[0];
        // Putting the second part into the endTime
        this.endTime = times[1];

    }


    // Basic Methods
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getExtraText() {
        return extraText;
    }

    public void setExtraText(String extraText) {
        this.extraText = extraText;
    }

    public char getDay() {
        return day;
    }

    public void setDay(char day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString()
    {
        String results = courseID + ", ";
        results = results + extraText + ", ";
        results = results + day + " ";
        results = results + startTime + "-";
        results = results + endTime + "\n";
        return results;
    }
}
