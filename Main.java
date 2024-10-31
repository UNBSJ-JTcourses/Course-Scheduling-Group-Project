import java.util.Scanner;

/****************************************************************************
 * CS2043 - Project Main Method
 *
 * @author - Nicolas Serrano, Domenica Vasco and Taryn Cail
 * @version - 1.0
 * @date - October 30th, 2024
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

        // Ask user about options until they're done
        System.out.println("Hello! How would you like to alter the schedule?");
        do
        {
            System.out.println("Enter:");
            System.out.println("1- Create a new course");
            System.out.println("2- Create a  group");
            System.out.println("3- Check conflicts");
            System.out.println("4- Add course to group");
            // Should we add another display schedule option?
            System.out.println("5- To exit :) ");
            System.out.println("What would you like to do?");
            input = myScanner.nextInt();

            switch (input) {
                case 1:
                    System.out.println("What is the courseID?");
                    String courseID = myScanner.next();
                    System.out.println("Is this a Lecture, Tutorial or Lab?");
                    String extraText = myScanner.next();
                    System.out.print("What is the time slot?");
                    String timeSlot = myScanner.next();
                    // CALL PARSE? store things separately in the course class?
                    System.out.println("Is there a prof? Yes/No");
                    if (myScanner.next().equals("Yes"))
                    {
                        String prof = myScanner.next();
                        Course newCourse = new Course(courseID, extraText, timeSlot, prof);
                    }
                    else
                    {
                        Course newCourse = new Course(courseID, extraText, timeSlot);
                    }
                    break;
                case 2:
                    System.out.println("What is the group name?");
                    String groupName = myScanner.next();
                    Group newGroup = new Group(groupName);
                    break;
                case 3:
                    System.out.println("What is the name of the group?");
                    String checkConflictGroup = myScanner.next();
                    System.out.println("What is the courseID of the first class?");
                    String firstClass = myScanner.next();
                    System.out.println("What is the courseID of the second class?");
                    String secondClass = myScanner.next();
                    // Not sure if this is the right way to call it \/
                    checkConflictGroup.checkConflict(firstClass, secondClass);
                    break;
                case 4:
                    System.out.println("What is the name of the group?");
                    String thisGroup = myScanner.next();
                    System.out.println("What is the courseID of the class?");
                    String className = myScanner.next();
                    // Should work? \/
                    thisGroup.add(className);
                    break;
                case 5:
                    done = true;
                    break;
                default:
                    System.out.println("Sorry that is not a valid option!");
            }
        }while(!done);
    }
}

