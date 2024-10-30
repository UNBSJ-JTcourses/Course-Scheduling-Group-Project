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
            System.out.println("5- To exit :) ");
            System.out.println("What would you like to do?");
            input = myScanner.nextInt();

            switch (input) {
                case 1:
                    // call create group method
                    break;
                case 2:
                    // call create group method
                    break;
                case 3:
                    // call check for conflicts
                    break;
                case 4:
                    // call add course to group
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

