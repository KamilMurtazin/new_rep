public class Student {
	
	private String firstName;
	private String lastName;
	private int age;
	private String group;
	private double averageGrade;
	private boolean isActive;
	
	public Student() {
		this.firstName = "Name";
		this.lastName = "LastName";
		this.age = 18;
		this.group = "11-504";
		this.averageGrade = 0.0;
		this.isActive = true;
	}
	public Student(String firstName, String lastName, String group) {
		this(firstName, lastName, 18, group, 99.0, true);
	}
	public Student(String firstName, String lastName, int age, String group, double averageGrade, boolean isActive) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.group = group;
		this.averageGrade = averageGrade;
		this.isActive = isActive;
	}
	public String displayInfo(){
		String result = firstName + " " + lastName + " " + group;
		return result;
	}
}