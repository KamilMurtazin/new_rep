public class TestProduct {
	public static void main(String args[]) {
		Product product = new Product();
		Product product1 = new Product("Chicken", 120, "Meet");
		Product product2 = new Product("Butter", 200, "Milk products", true, 20);
		
		System.out.println(product.displayInfo());
		System.out.println(product.applyDiscount(15));
		System.out.println(product.restock(20));
		System.out.println(product.sell(5));
		System.out.println();
		
		System.out.println(product1.displayInfo());
		System.out.println(product1.applyDiscount(50));
		System.out.println(product1.restock(20));
		System.out.println(product1.sell(130));
		System.out.println();
		
		System.out.println(product2.displayInfo());
		System.out.println(product2.applyDiscount(0));
		System.out.println(product2.restock(20));
		System.out.println(product2.sell(87));
		System.out.println();
	}
}
