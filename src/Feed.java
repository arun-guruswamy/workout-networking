import java.util.Stack;

public class Feed {
    Stack<Post> feed;
    Stack<Post> filteredFeed = new Stack<>();

    public Feed() {
        feed = new Stack<>();
    }

    public String toString() {
        String res = "";

        for (Post post : feed) {
            res += post.toString() + "\n\n";
        }

        return res;
    }


}
