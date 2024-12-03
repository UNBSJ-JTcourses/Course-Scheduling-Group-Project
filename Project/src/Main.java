import java.io.Serializable;
import java.util.Scanner;
/****************************************************************************
 * CS2043 - Project Main Method
 * @ author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @ version - 1.0
 * @ date - October 30th, 2024
 ****************************************************************************/
public class Main implements Serializable
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
            System.out.println("2 - Create Non-Course Block");
            System.out.println("3 - Create a  group");
            System.out.println("4 - Add course to group");
            System.out.println("5 - Check conflicts");
            System.out.println("6 - Save the file ");
            System.out.println("7 - Read a file");
            System.out.println("8 - Exit :) ");
            System.out.println("What would you like to do?");
            input = myScanner.nextInt();
            myScanner.nextLine();

            switch (input) {
                case 1:
                    // Creating a new course
                    System.out.println("What is the courseID?");
                    String courseID = myScanner.nextLine();
                    System.out.println("Is this a Lecture, Tutorial or Lab?");
                    String extraText = myScanner.nextLine();
                    System.out.print("What is the time slot?");
                    String timeSlot = myScanner.nextLine();
                    System.out.println("Is there a prof? Yes/No");
                    String answer = myScanner.nextLine();

                    if (answer.equalsIgnoreCase("Yes"))
                    {
                        // If there is a prof it will call constructor with prof
                        System.out.println("What is the name of the Prof?");
                        String prof = myScanner.nextLine();
                        Course newCourse = new Course(courseID, extraText, timeSlot, prof);
                        mainCourseList.addCourse(newCourse);
                    }
                    else
                    {
                        // If no prof will call constructor without prof
                        Course newCourse = new Course(courseID, extraText, timeSlot);
                        mainCourseList.addCourse(newCourse);
                    }
                    System.out.print("Course made successfully!\n");
                    break;

                case 2:
                    // Creating a group
                    System.out.println("What is the group name?");
                    String groupName = myScanner.nextLine();
                    Group newGroup = new Group(groupName);
                    mainGroupList.addGroup(newGroup);
                    System.out.print("Group made successfully!\n");
                    break;

                case 3:
                    // Adding courses to a group
                    System.out.println("What is the name of the group?");
                    String thisGroupName = myScanner.nextLine();
                    System.out.println("What is the courseID of the class?");
                    String thisClassName = myScanner.nextLine();
                    // Need to implement search in GroupList
                    Group currentGroup2 = mainGroupList.searchForGroup(thisGroupName);
                    // Need to implement search in CourseList
                    Course currentCourse = mainCourseList.searchForCourse(thisClassName);
                    currentGroup2.addToGroup(currentCourse);
                    System.out.print("Course added to group successfully!\n");
                    break;

                case 4:
                    // Checking conflicts in a group, will display if none found
                    System.out.println("What is the name of the group?");
                    String currentGroupName = myScanner.nextLine();
                    Group currentGroup1 = mainGroupList.searchForGroup(currentGroupName);
                    // If no conflict will display schedule
                    currentGroup1.checkGroupConflict();
                    break;

                case 5:
                    // Writes everything into a file
                    ArraySerialization.save(mainGroupList);
                    break;

                case 6:
                    // Reads from a file named "OutputFile.dat"
                    ArraySerialization.read(mainGroupList);
                    break;

                case 7:
                    // Exits loop and program
                    System.out.println("Goodbye!\n");
                    done = true;
                    break;

                default:
                    // If any wrong input will display an error message
                    System.out.println("Sorry that is not a valid option!\n");
                    break;
            }
        }while(!done);
    }
}