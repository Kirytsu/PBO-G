import java.util.ArrayList;
import java.util.List;

public class Post {
    private String content;
    private User author;
    private List<String> comments;
    private int likes;

    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
        this.likes = 0;
    }

    public String getContent() {
        return content;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public void like() {
        likes++;
    }

    public void displayContent() {
        System.out.println("\n[Post by " + author.getUsername() + "]");
        System.out.println("Content: \"" + content + "\"");
        System.out.println("Likes: " + likes);
        System.out.println("Comments:");
        for (String comment : comments) {
            System.out.println(" - " + comment);
        }
        System.out.println("");
    }
}
