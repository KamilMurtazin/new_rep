public class Car {
	
	private String brand;
	private String model;
	private int year;
	private String color;
	private double price;
	private boolean isRunning;
	private double mileage;
	
	public Car() {
		this("Unknown brand", "Unknown model", 2000, "Black", 2000000.0, false, 250000.0);
	}
	public Car(String brand, String model, int year) {
		this(brand, model, year, "White", 4000000.0, true, 87000.0);
	}
	public Car(String brand, String model, int year, String color, double price, boolean isRunning, double mileage){
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.color = color;
		this.price = price;
		this.isRunning = isRunning;
		this.mileage = mileage;
	}
	public void setYear(int newYear) {
		year = newYear;
	}
	
	public String displayInfo() {
		return brand + " " + model + " " + year + " " + color + " " + price + " " + isRunning + " " + mileage;
	}
	public String startEngine() {
		if (!isRunning) {
			this.isRunning = true;
			return "Engine has been started";
		} else {
			return "Engine is already has been started";
		}
	}
	public String stopEngine() {
		if (isRunning) {
			this.isRunning = false;
			return "Engine has been stoppeded";
		} else {
			return "Engine is already has been stopped";
		}
	}
	public String drive(double distance) {
		this.mileage = mileage + distance;
		return "You drive " + distance + " miles. New mileage: " + mileage + " miles";
	}
	public String repaint(String newColor) {
		this.color = newColor;
		return "Your car has been repainted. New color: " + color;
	}
	public String updatePrice(double newPrice) {
		if (price < newPrice) {
			this.price = newPrice;
			return "Your car gone up in price. New price: " + price;
		} else {
			this.price = newPrice;
			return "Your car has become cheaper. New price: " + price;
		}
	}
}