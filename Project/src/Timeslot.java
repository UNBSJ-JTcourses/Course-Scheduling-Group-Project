import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class Timeslot implements Serializable
{
    private char day;
    private String startTime;
    private String endTime;

    public Timeslot(char day, String startTime, String endTime)
    {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Checking for conflicts
    public boolean checkConflict(Timeslot other)
    {
        if(this.day!= other.day){
            return false;
        }

        // Define a date time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Put each separate time into a LocalTime variable so they can be compared
        LocalTime thisStart = LocalTime.parse(this.startTime, formatter);
        LocalTime thisEnd = LocalTime.parse(this.endTime, formatter);
        LocalTime otherStart = LocalTime.parse(other.startTime, formatter);
        LocalTime otherEnd = LocalTime.parse(other.endTime, formatter);

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

    public char getDay()
    {
        return day;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setDay(char day) {
        this.day = day;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return day + " " + startTime + "-" + endTime;
    }
}
