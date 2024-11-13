public class Main {
    public static void main(String[] args) {
        Network network = new Network();

        RegularUser user1 = new RegularUser("Alice");
        RegularUser user2 = new RegularUser("Bob");
        AdminUser admin = new AdminUser("Charlie");

        network.addUser(user1);
        network.addUser(user2);
        network.addUser(admin);

        user1.addFollower(user2);
        user1.addFollower(admin);
        user2.addFollower(user1);

        Post post1 = new Post("Hello world!", user1);
        Post post2 = new Post("Halo dunia!", user2);
        Post post3 = new Post("test", admin);

        user1.addPost(post1);
        user2.addPost(post2);
        admin.addPost(post3);

        user2.likePost(post1); 
        user2.commentOnPost(post1, "Hi");

        user1.likePost(post2); 
        admin.likePost(post2);
        user1.commentOnPost(post2, "Hello");
        admin.commentOnPost(post2, "Halo");

        user2.deletePost(post1); 
        admin.deletePost(user1, post1);
        admin.deletePost(post3);

        network.displayAllUsers();
        network.displayAllProfiles();
    }
}
