public class AdminUser extends User {

    public AdminUser(String username) {
        super(username);
    }

    @Override
    public void displayRole() {
        System.out.println(username + " is an Admin.");
    }

    // Admin can delete any user's post
    public void deletePost(User user, Post post) {
        if (user.getPosts().contains(post)) {
            user.getPosts().remove(post);
            System.out.println("Admin " + username + " deleted a post by " + 
                user.getUsername() + ": \"" + post.getContent() + "\"");
        } else {
            System.out.println("Admin " + username + " could not find the specified post.");
        }
    }
}
