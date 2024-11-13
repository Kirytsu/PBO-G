import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String username;
    protected List<User> followers;
    protected List<Post> posts;

    public User(String username) {
        this.username = username;
        this.followers = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void addFollower(User user) {
        if (!followers.contains(user)) {
            followers.add(user);
            System.out.println(username + " is now followed by " + user.getUsername());
        }
    }

    public void addPost(Post post) {
        posts.add(post);
        System.out.println(username + " added a new post: \"" + post.getContent() + "\"");
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void deletePost(Post post) {
        if (posts.contains(post)) {
            posts.remove(post);
            System.out.println(username + " delete their post: \"" + post.getContent() + "\"");
        } else {
            System.out.println(username + " failed to delete a post");
        }
    }

    public void displayProfile() {
        System.out.println("\n=============================================");
        System.out.println("Profile: " + username);
        System.out.print("Role: ");
            if (this instanceof AdminUser) {
                System.out.println("Admin");
            } else if (this instanceof RegularUser) {
                System.out.println("User");
            }
        System.out.println("Followers: " + followers.size());
        System.out.println("Number of Posts: " + posts.size());
        for (Post post : posts) {
            post.displayContent();
        }
        System.out.println("=============================================");
    }
    
    public void likePost(Post post) {
        post.like();
        System.out.println(username + " liked the post: \"" + post.getContent() + "\"");
    }

    public void commentOnPost(Post post, String comment) {
        post.addComment(comment);
        System.out.println(username + " commented \"" + comment + "\" on the post: \"" + post.getContent() + "\"");
    }

    public abstract void displayRole();
}
