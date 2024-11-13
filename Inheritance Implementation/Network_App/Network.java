import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<User> users;

    public Network() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("Added new user: " + user.getUsername());
    }

    public User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    public void displayAllUsers() {
        System.out.println("\n========== All Users ==========");
        for (User user : users) {
            user.displayRole();
        }
        System.out.println("===============================");
    }
    
    public void displayAllProfiles() {
        System.out.println("\nAll User Profiles");
        for (User user : users) {
            user.displayProfile();
        }
        System.out.println("");
    }
}
