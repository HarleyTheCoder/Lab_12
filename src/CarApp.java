import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//"Make sure to match the signature of toString() from Object"
//What does this mean? I think I may have missed something while at my appointment.

public class CarApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a;
		int carNum;
		List<Car> cars = new ArrayList<>();
		
		//I'm combining part 1 and part 2 into one app
		System.out.print("Run part 1 or part 2? (1-2): ");
		a = Validator.getIntInRange(1, 2, scan);
		System.out.print("\n");
		
		if (a == 1) { //Part 1
			//Saying welcome, asking how many cars
			System.out.println("Welcome to the Grand Circus Motors admin console!");
			System.out.print("How many cars are you entering: ");
			
			//Get number of cars to enter
			carNum = Validator.getIntInRange(0, 15, scan);
			
			//Get input for each car
			CarApp.setCars(carNum, cars, scan);
			
			//test
			//CarApp.addTestCars1(cars);
			
			//Show the cars
			CarApp.showCars(cars);
			
		} else { //Part 2
			
			//test - required this time
			CarApp.addTestCars2(cars);
			
			//this loop ends when user quits
			while (true) {
				CarApp.showMenu(cars);
				System.out.println("");
				CarApp.pickMenuOption(cars, scan);
			}
		}
		scan.close();
	}
	
	//Part 1
	//Get input for a car
	public static void setCars (int numCars, List<Car> cars, Scanner scan) {
		for (int i = 0; i < numCars; i++) {
			int carNum = i + 1;
			cars.add(new Car());
			System.out.print("Enter Car #" + carNum + " Make: ");
			cars.get(i).setMake(Validator.getString(scan));
			System.out.print("Enter Car #" + carNum + " Model: ");
			cars.get(i).setModel(Validator.getString(scan));
			System.out.print("Enter Car #" + carNum + " Year: ");
			cars.get(i).setYear(Validator.getIntInRange(1920, 2100, scan));
			System.out.print("Enter Car #" + carNum + " Price: ");
			cars.get(i).setPrice(Validator.getDouble(scan));
			System.out.println("");
		}
	}
	
	//Part 1
	//Display the cars
	public static void showCars(List<Car> cars) {
		if (cars.size() == 0) {
			System.out.println("\nThere are no cars in the inventory.");
		} else {
			System.out.println("\nCurrent Inventory:");
			DecimalFormat decimalFormat = new DecimalFormat("$###,###.00");
			
			for(Car car: cars) {
				String format = decimalFormat.format(car.getPrice());
				System.out.printf("%-15s", car.getMake());
				System.out.printf("%-15s", car.getModel());
				System.out.printf("%-15s", car.getYear());
				System.out.printf("%-15s", format);
				System.out.print("\n");
			}
		}
	}
	
	//Part 1
	//method to test app
	public static void addTestCars1(List<Car> cars) {
		cars.add(new Car("Nikolai", "Model S", 2017, 54999.9));
		cars.add(new Car("Fourd", "Escapade", 2017, 31999.9));
		cars.add(new Car("Chewie", "Vette", 2017, 44989.95));
		cars.add(new Car("Hyonda", "Prior", 2017, 23795.5));
	}
	
	//Part 2
	//Show a line with all the car properties
	public static void showLine(int a, Car car) {
		DecimalFormat decimalFormat = new DecimalFormat("$###,###.00");
		String format = decimalFormat.format(car.getPrice());
		System.out.printf("%-15s", a + ". " + car.getMake());
		System.out.printf("%-15s", car.getModel());
		System.out.printf("%-15s", car.getYear());
		//If it's a used car, display last line differently
		if (car.getClass().toString().equals("class UsedCar")) {
			System.out.printf("%-15s", format + " (Used) " + 
								((UsedCar)car).getMileage() + " miles");
		} else {
			System.out.printf("%-15s", format);
		}
		System.out.print("\n");
	}
	
	//Part 2
	//Display the menu
	public static void showMenu(List<Car> cars) {
		int count = 1;
		if (cars.size() == 0) {
			System.out.println("\nThere are no cars to display.");
			CarApp.quit();
		} else {
			for(Car car: cars) {
				CarApp.showLine(count, car);
				count++;
			}
		}
		System.out.println(count + ". Quit");
	}
	
	//Part 2
	//Choose option
	public static void pickMenuOption (List<Car> cars, Scanner scan) {
		int choice;
		System.out.print("Which car would you like? ");
		choice = Validator.getIntInRange(1, cars.size() + 1, scan);
		
		if (choice <= cars.size()) {
			CarApp.showLine(choice, cars.get(choice - 1));
			System.out.print("Would you like to buy this car? (y/n) ");
			if (Validator.isYesNo(scan)) {
				System.out.println("Excellent! Our finance department will be in touch shortly.\n");
				cars.remove(choice - 1);
			} else {
				System.out.println("No problem. Returning to the menu.\n");
			}
		} else {
			CarApp.quit();
		}
	}
	
	//Part 2
	//Quit the program
	public static void quit() {
		System.out.println("Have a great day!");
		System.exit(0);
	}
	
	//Part 2
	//Method to help with testing
	public static void addTestCars2(List<Car> cars) {
		cars.add(new Car("Nikolai", "Model S", 2017, 54999.9));
		cars.add(new Car("Fourd", "Escapade", 2017, 31999.9));
		cars.add(new Car("Chewie", "Vette", 2017, 44989.95));
		cars.add(new UsedCar("Hyonda", "Prior", 2015, 14795.5, 35987.6));
		cars.add(new UsedCar("GC", "Chirpus", 2013, 8500.0, 12345));
		cars.add(new UsedCar("GC", "Witherell", 2016, 14450, 3500.3));
	}
	
	
	
}
