public class Main {
	public static void main(String args[]) {
		Student student = new Student();
		Student student1 = new Student("Kamil", "Murtazin", "11-504");
		Student student2 = new Student("Kamil", "Mingaleev", 18, "11-504", 50.0, true);
		
		String result = student.displayInfo();
		System.out.println(result);
		String result1 = student1.displayInfo();
		System.out.println(result1);
		String result2 = student2.displayInfo();
		System.out.println(result2);
	}
}
