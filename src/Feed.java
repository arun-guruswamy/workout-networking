import java.util.Stack;

public class Feed {
    Stack<Post> feed = new Stack<Post>();
    Stack<Post> filteredFeed = new Stack<Post>();

    public Feed() {}

    public String toString() {
        String res = "";

        for(int i= 0; i < feed.size(); i++) {
            res += feed.get(i).toString() + "\n\n";
        }

        return res;
    }
}
