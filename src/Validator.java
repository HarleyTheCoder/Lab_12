import java.util.Scanner;

public class Validator {
	
	//Get any integer
	public static int getInt(Scanner scan) {
		while(true) {
			try {
				int num = Integer.parseInt(scan.nextLine());
				return num;
			} catch (NumberFormatException e) {
				System.out.print("Input must be a valid integer. Please try again: ");
			}
		}
	}

	//Get integer within a specific range
	public static int getIntInRange(int a, int b, Scanner scan) {
		boolean cont = true;
		while(cont) {
			try {
				int num = Integer.parseInt(scan.nextLine());
				if (num < a || num > b) {
					throw new IndexOutOfBoundsException();
				} else {
					return num;
				}
			} catch (IndexOutOfBoundsException ie) {
				System.out.print("Integer must be between " + a +
						" and " +  b + ". Please try again. (" + a + "-" + b + "): ");
			} catch (NumberFormatException e) {
				System.out.print("Input must be a number (" + a + "-" + b + 
									"). Please try again: ");
			}
		}
		return -1;
	}
	
	/**
	 * Get any string.
	 */
	//Grand Circus code, edited 
	public static String getString(Scanner scnr) {
		// This approach uses exception handling.
		while (true) {
			try {
				return scnr.nextLine();
			} catch (Exception e) {
				System.out.print("Invalid string. Please try again: ");
			}
		}
	}
	
	//Get double
	public static double getDouble(Scanner scan) {
		while (true) {
			String temp = scan.nextLine();
			try {
				double num = Double.parseDouble(temp);
				return num;
			} catch (Exception e) { //make more specific
				System.out.print("Input is not a double. Please try again: ");
			}
		}
	}
	
	//Check if they answered yes or no, ask again if not
	public static boolean isYesNo(Scanner scan) {
		String input = scan.nextLine().toLowerCase();
		while (true) {
			if (input.startsWith("y")) {
				return true;
			} else if (input.startsWith("n")) {
				return false;
			} else {
				System.out.println("Invalid input. Please try again. (y/n)");
				input = scan.nextLine().toUpperCase();
			}
		}
	}
	
}
