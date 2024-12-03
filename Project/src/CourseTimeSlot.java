// Helper class to associate a course with a specific timeslot
public class CourseTimeSlot
{
    private final Course course;
    private final Timeslot timeslot;

    public CourseTimeSlot(Course course, Timeslot timeslot) {
        this.course = course;
        this.timeslot = timeslot;
    }

    @Override
    public String toString() {
        return course.getCourseID() + ", " + course.getExtraText() + ", " +
                timeslot + ", " + course.getInstructor();
    }
}
