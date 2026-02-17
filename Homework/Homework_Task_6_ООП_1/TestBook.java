public class TestBook {
	public static void main(String args[]) {
		Book book1 = new Book("Java Basics", "John Pork", 2007);
		Book book = new Book();
		Book book2 = new Book("Python Basics", "Ronaldinho", 2001, false, 371);
		
		System.out.println(book.displayInfo());
        System.out.println(book.returnBook());
        System.out.println(book.updateYear(2025));
		System.out.println();
		
		System.out.println(book1.displayInfo(true));
        System.out.println(book1.borrowBook("Kamil"));
        System.out.println(book1.returnBook());
        System.out.println(book1.updateYear(2000));
		System.out.println("Total books: " + Book.getTotalBook());
		System.out.println();
		
		System.out.println(book2.displayInfo());
        System.out.println(book2.borrowBook());
        System.out.println(book2.returnBook());
        System.out.println(book2.updateYear(2010));
	}
}