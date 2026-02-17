public class TestProduct {
	public static void main(String args[]) {
		System.out.println("=== PRODUCT CLASS TEST ===");
        System.out.println("Store: " + Product.getStoreName());
        
        Product apple = new Product("Apple", 2.5, "Fruits", true, 100);
        Product chicken = new Product("Chicken", 8.0, "Meat");
        Product butter = new Product("Butter", 3.0, "Dairy", true, 30);
        
        System.out.println("=== PRODUCT INFO ===");
        System.out.println(apple.displayInfo());
        System.out.println(chicken.displayInfo(true));
        
        System.out.println("=== DISCOUNTS ===");
        System.out.println(apple.applyDiscount(20));
        System.out.println(chicken.applyDiscount(10, "MEATLOVER"));
        
        System.out.println("=== RESTOCK ===");
        System.out.println(butter.restock(20));
        System.out.println(apple.restock(50, "FreshFarms"));
        
        System.out.println("=== SALES ===");
        System.out.println(butter.sell(15));
        System.out.println(apple.sell(25, "Maria"));
        
        System.out.println("=== TOTAL VALUE CALCULATION ===");
        Product[] products = {apple, chicken, butter};
        double total = Product.calculateTotalValue(products);
        System.out.println("Total inventory value: " + total);
        
        System.out.println("=== FINAL STATS ===");
        System.out.println("Total products created: " + Product.getTotalProducts());
        System.out.println("Test completed!");
    }
}