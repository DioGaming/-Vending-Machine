
package vending.machine;

/**
 *
 * @author Richard Lam
 */
import java.util.Scanner;
public class VendingMachine {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
         
        while (true) {
        System.out.println("Welcome to the Spirits Machine.");
        System.out.println("The selection of drinks\n=======================");
        System.out.println("1. Dreadrum\n2. Fetching Fizz\n3. Werewhiskey\n0. Quit the program");
        System.out.print("Please enter your selection by entering the number: ");
        
        //drink selection I guess for the lols
        int selection = Integer.parseInt(reader.nextLine());
        
        if (selection == 0) {
            break;
        } else if (selection == 1) {
            
        } else if (selection == 2) {
            
        } else if (selection == 3) {
            
        } else {
            
        }
        }
    }
    
}
