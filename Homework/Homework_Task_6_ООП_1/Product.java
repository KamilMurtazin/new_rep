 public class Product {
	
	private String name;
	private double price;
	private String category;
	private boolean isStock;
	private int quantity;
	
	private static int totalProducts = 0;
	private static String STORE_NAME = "Supermarket 'Near the house'";
	
	public Product() {
		this("Unknown product", 100.0, "Unknown category", true, 0);
	}
	public Product(String name, double price, String category) {
		this(name, price, category, false, 100);
	}
	public Product(String name, double price, String category, boolean isStock, int quantity) {
		setName(name);
		setPrice(price);
		setCategory(category);
		setStock(isStock);
		setQuantity(quantity);
		totalProducts ++;
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
	public boolean getStock() {
		return isStock;
	}
	public int getQuantity() {
		return quantity;
	}
	public static int getTotalProducts() {
		return totalProducts;
	}
	public static String getStoreName() {
		return STORE_NAME;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		if (price >= 0 && price <= 1000000) {
			this.price = price;
		} else {
			System.out.println("Incorrect price!");
		}
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setStock(boolean stock) {
		this.isStock = stock;
	}
	public void setQuantity(int quantity) {
		if (quantity >= 0) {
			this.quantity = quantity;
		} else {
			System.out.println("Quantity couldn't be negative");
		}
	}
	
	
	public String displayInfo() {
		return displayInfo(false);
	}
	public String displayInfo(boolean showStockStatus) {
		if (showStockStatus) {
			return "Product: " + name + " " + price + "$ | Category: " + category + " | Is stock: " + isStock + " | Quantity: " + quantity;
		} else {
			return "Product: " + name + " " + price + "$ | Is stock: " + isStock + " | Quantity: " + quantity;
		}
	}
	
	public String applyDiscount(double percent) {
		setPrice(price * (1 - percent * 0.01));
		return "You use discount " + percent + "%. New price: " + price;
	}
	public String applyDiscount(double percent, String promoCode) {
		setPrice(price * (1 - percent * 0.01));
		return "You use promocode: " + promoCode + " | discount " + percent + "%. New price: " + price;
	}
	
	public String restock(int amount) {
		if (amount > 0) {
			setQuantity(quantity + amount);
			return "The warehouse has been replenished on " + amount + ". New quantity: " + quantity;
		} else {
			return "Incorrect amount";
		}
	}
	public String restock(int amount, String supplier) {
		if (amount > 0) {
			setQuantity(quantity + amount);
			return "The warehouse has been replenished on " + amount + ". New quantity: " + quantity + " | Supplier: " + supplier;
		} else {
			return "Incorrect amount";
		}
	}
	
	public String sell(int amount) {
		if (quantity - amount < 0) {
			int difference = amount - quantity;
			setQuantity(0);
			return "You bought all products! You can't buy " + difference + " more products";
		} else {
			setQuantity(quantity - amount);
			return "You could buy all produts you need. There are " + quantity + " more products in the warehous";
		}
	}
	public String sell(int amount, String customer) {
		if (quantity - amount < 0) {
			int difference = amount - quantity;
			setQuantity(0);
			return customer + " bought all products! You can't buy " + difference + " more products";
		} else {
			setQuantity(quantity - amount);
			return customer + " could buy all produts you need. There are " + quantity + " more products in the warehous";
		}
	}
	
	public static double calculateTotalValue(Product[] products) {
		double totalValue = 0;
		if (products != null) {
			for (int i = 0; i < products.length; i ++) {
				Product product = products[i];
				if (product != null) {
					System.out.println(product.getName());
					totalValue += product.getPrice() * product.getQuantity();
				}
			}
		}
		System.out.println("Price of all products: " + totalValue);
		return totalValue;
	}
}