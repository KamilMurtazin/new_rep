public class Product {
	
	private String name;
	private double price;
	private String category;
	private boolean isStock;
	private int quantity;
	
	public Product() {
		this("Unknown product", 100.0, "Unknown category", true, 0);
	}
	public Product(String name, double price, String category) {
		this(name, price, category, false, 100);
	}
	public Product(String name, double price, String category, boolean isStock, int quantity) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.isStock = isStock;
		this.quantity = quantity;
	}
	
	public String displayInfo() {
		return name + " " + price + " " + category + " " + isStock + " " + quantity;
	}
	public String applyDiscount(double percent) {
		this.price = price * (1 - percent * 0.01);
		return "You use discount " + percent + "%. New price: " + price;
	}
	public String restock(int amount) {
		this.quantity = quantity + amount;
		return "The warehouse has been replenished on " + amount + ". New quantity: " + quantity;
	}
	public String sell(int amount) {
		if (quantity - amount < 0) {
			int difference = amount - quantity;
			this.quantity = 0;
			return "You bought all products! You can't buy " + difference + " more products";
		} else {
			this.quantity = quantity - amount;
			return "You could buy all produts you need. There are " + quantity + " more products in the warehous";
		}
	}
}