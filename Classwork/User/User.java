public class User {
	private String username;
	private UserRole role;
	private int age;
	
	public User(String username, UserRole role, int age) {
		this.username = username;
		this.role = role;
		this.age = age;
	}
	
	public String getUsername() {
		return username;
	}
	public UserRole getRole() {
		return role;
	}
	public int getAge() {
		return age;
	}
	public void checkAge() {
		if (age < 18) {
			throw new IllegalArgumentException("Возраст должен быть не менее 18 лет");
        }
        System.out.println("Возраст принят: " + age);
    }
}