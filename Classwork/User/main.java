public class Main {
    public static void main(String[] args) {
		User user1 = new User("alex", UserRole.ADMIN, 25);
        User user2 = new User("dinar", UserRole.MODERATOR, 17);
        User user3 = new User("ivan", UserRole.USER, 20);
		
		Action action = new Action() {
			@Override
			public void execute(User user) {
				System.out.println("Username: " + user.getUsername());
				System.out.println("Role: " + user.getRole() + "; Age: " + user.getAge());
				
				try {
					user.checkAge();
					switch (user.getRole()){
						case ADMIN:
							System.out.println(user.getUsername() + " has admin rights");
							break;
						case MODERATOR:
							System.out.println(user.getUsername() + " has moderator rights");
							break;
						case USER:
							System.out.println(user.getUsername() + " is simple user");
							break;
					}
				} catch (IllegalArgumentException a) {
					System.out.println("ERROR: " + a.getMessage());
				}
			}
		};
		action.execute(user1);
        action.execute(user2);
        action.execute(user3);
    }
}