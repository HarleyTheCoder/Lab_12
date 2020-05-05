//Part 2

//I missed the "instanceOf" part of the lecture, I think?

public class UsedCar extends Car {
	private double mileage;
	
	public UsedCar(String make, String model, int year, 
					double price, double mileage) {
		super(make, model, year, price);
		this.mileage = mileage;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	//override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" +
				year + ", price=" + price + ", mileage=" + mileage + "]";
	}

}
