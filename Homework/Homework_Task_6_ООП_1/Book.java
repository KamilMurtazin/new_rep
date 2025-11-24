public class Book {
	
	private String title;
	private String author;
	private int year;
	private boolean isAvailable;
	private int pageCount;
	
	private static int totalBooks = 0;
	private static final int MAX_YEAR = 2025;
	
	
	public Book() {
        this("Unknown title", "Unknown author", 2024, 100);
    }
    public Book(String title, String author, int year) {
        this(title, author, year, true, 0);
    }
	public Book(String title, String author, int year, int pageCount) {
        this(title, author, year, true, pageCount);
    }
    public Book(String title, String author, int year, boolean isAvailable, int pageCount) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
		setPageCount(pageCount);
        setIsAvailable(isAvailable);
        totalBooks++;
	}
	
	public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYear() {
        return year;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public int getPageCount() {
        return pageCount;
    }
	
	public void setTitle(String title) {
		if (title != null && !title.trim().isEmpty()) {
			this.title = title.trim();
		} else {
			this.title = "Unknown title";
		}
	}
	public void setAuthor(String author) {
		if (author != null && !author.trim().isEmpty()) {
			this.author = author.trim();
		} else {
			this.author = "Unknown author";
		}
	}
	public void setYear(int year) {
		if (year >= 1 && year <= MAX_YEAR) {
			this.year = year;
		} else {
			this.year = 2024;
		}
	}
	public void setPageCount(int pageCount) {
		if (pageCount > 0) {
			this.pageCount = pageCount;
		} else {
			this.pageCount = 100;
		}
	}
	public void setIsAvailable(boolean available) {
		this.isAvailable = available;
	}
	
	public static int getTotalBook() {
		return totalBooks;
	}
	
	
	public String displayInfo() {
		return displayInfo(false);
	}
	public String displayInfo(boolean detailed) {
		if (detailed) {
			return "Book: " + title + " " + author + " " + year + ". Pages: " + pageCount + ". Status: " +  isAvailable;
		} else {
			return "Book: " + title + " " + author + " " + year;
		}
	}
	
	public String borrowBook() {
		return borrowBook("Unknown borrower");
	}
	public String borrowBook(String borrowerName) {
		if (!isAvailable) {
			return "The " + title + " already borrowed";
		} else {
			setIsAvailable(false);
			return "The " + title + " has been borrowed by " + borrowerName;
		}
	}
	
	public String returnBook() {
		if (!isAvailable) {
			setIsAvailable(true);
			return "The " + title + " has been returned";
		} else {
			return "The " + title + " already available";
		}
	}
	public String updateYear(int newYear) {
		setYear(newYear);
		return "The year of publication has been updated to " + newYear;
	}
}