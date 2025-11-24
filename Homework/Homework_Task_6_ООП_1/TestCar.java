public class TestCar {
	public static void main(String args[]) {
		Car car = new Car();
		Car car1 = new Car("Porsche", "911", 2021);
		Car car2 = new Car("Mercedes-Benz", "CLS", 2023, "green", 5800000.0, false, 63700);
		
		System.out.println(car.displayInfo());
		System.out.println(car.startEngine());
		System.out.println(car.stopEngine());
		System.out.println(car.drive(250));
		System.out.println(car.repaint("blue"));
		System.out.println(car.updatePrice(1600000.0));
		System.out.println();
		
		System.out.println(car1.displayInfo());
		System.out.println(car1.startEngine());
		System.out.println(car1.stopEngine());
		System.out.println(car1.drive(123));
		System.out.println(car1.repaint("red"));
		System.out.println(car1.updatePrice(3200000.0));
		System.out.println();
		
		System.out.println(car2.displayInfo());
		System.out.println(car2.setYear(2025));
		System.out.println(car2.startEngine());
		System.out.println(car2.stopEngine());
		System.out.println(car2.drive(413));
		System.out.println(car2.repaint("grey"));
		System.out.println(car2.updatePrice(6900000.0));
		System.out.println();
	}
}