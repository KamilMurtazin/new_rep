public class Book {
	
	private String title;
	private String author;
	private int year;
	private boolean isAvailable;
	private int pageCount;
	
	public Book() {
        this("Unknown title", "Unknown author", 0);
    }
    public Book(String title, String author, int year) {
        this(title, author, year, true, 0);
    }
    public Book(String title, String author, int year, boolean isAvailable, int pageCount) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = isAvailable;
        this.pageCount = pageCount;
	}
	
	public String displayInfo() {
		return title + " " + author + " " + year + " " + isAvailable + " " + pageCount;
	}
	public String borrowBook() {
		if (isAvailable) {
			isAvailable = false;
			return "The " + title + " has been given";
		} else {
			return "The " + title + " already given";
		}
	}
	public String returnBook() {
		if (!isAvailable) {
			isAvailable = true;
			return "The " + title + " has been returned";
		} else {
			return "The " + title + " already available";
		}
	}
	public String updateYear(int newYear) {
		this.year = newYear;
		return "The year of publication has been updated to " + newYear;
	}
}