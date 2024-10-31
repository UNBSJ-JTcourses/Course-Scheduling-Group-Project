import java.util.Scanner;
/****************************************************************************
 * CS2043 - Project Main Method
 * @ author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @ version - 1.0
 * @ date - October 30th, 2024
 ****************************************************************************/
public class Main
{
    public static void main(String[] args)
    {
        // Declaring scanner
        Scanner myScanner = new Scanner(System.in);

        // Declaring variables
        int input;
        boolean done = false;

        // Creating the main courseList that will hold all courses
        CourseList mainCourseList = new CourseList();

        // Declaring the main groupList that will hold all groups
        GroupList mainGroupList = new GroupList();

        // Ask user about options until they're done
        System.out.println("Hello! How would you like to alter the schedule?");
        do
        {
            System.out.println("Enter:");
            System.out.println("1 - Create a new course");
            System.out.println("2 - Create a  group");
            System.out.println("3 - Check conflicts");
            System.out.println("4 - Add course to group");
            System.out.println("5 - To exit :) ");
            System.out.println("What would you like to do?");
            input = myScanner.nextInt();

            switch (input) {
                case 1:
                    // Creating a new course
                    System.out.println("What is the courseID?");
                    String courseID = myScanner.next();
                    System.out.println("Is this a Lecture, Tutorial or Lab?");
                    String extraText = myScanner.next();
                    System.out.print("What is the time slot?");
                    String timeSlot = myScanner.next();
                    System.out.println("Is there a prof? Yes/No");
                    String answer = myScanner.next();
                    if (answer.equalsIgnoreCase("Yes"))
                    {
                        // If there is a prof it will call constructor with prof
                        String prof = myScanner.next();
                        Course newCourse = new Course(courseID, extraText, timeSlot, prof);
                    }
                    else
                    {
                        // If no prof will call constructor without prof
                        Course newCourse = new Course(courseID, extraText, timeSlot);
                    }
                    break;

                case 2:
                    // Creating a group
                    System.out.println("What is the group name?");
                    String groupName = myScanner.next();
                    Group newGroup = new Group(groupName);
                    mainGroupList.addGroup(newGroup);
                    break;

                case 3:
                    // Checking conflicts in a group, will display if none found
                    System.out.println("What is the name of the group?");
                    String currentGroupName = myScanner.next();
                    mainGroupList.searchGroup(currentGroupName);
                    // If no conflict will display schedule
                    currentGroup.checkGroupConflict();
                    break;

                case 4:
                    // Adding courses to a group
                    System.out.println("What is the name of the group?");
                    String thisGroupName = myScanner.next();
                    System.out.println("What is the courseID of the class?");
                    String thisClassName = myScanner.next();
                    // Need to implement search in GroupList
                    Group currentGroup = mainGroupList.searchForGroup(thisGroupName);
                    // Need to implement search in CourseList
                    Course currentCourse = mainCourseList.searchForCourse(thisClassName);
                    currentGroup.add(currentCourse);
                    break;

                case 5:
                    // Exits loop and program
                    done = true;
                    break;
                default:
                    // If any wrong input will display an error message
                    System.out.println("Sorry that is not a valid option!");
            }
        }while(!done);
    }
}



