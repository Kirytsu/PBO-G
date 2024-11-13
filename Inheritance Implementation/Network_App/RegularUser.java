public class RegularUser extends User {

    public RegularUser(String username) {
        super(username);
    }

    @Override
    public void displayRole() {
        System.out.println(username + " is a User.");
    }
}
