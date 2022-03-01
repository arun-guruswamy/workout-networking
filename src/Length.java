import java.util.Stack;

public class Length implements Filter {
    public Stack<Post> filter(Feed f, int length) {
        for (Post post : f.feed) {
            if (post.workout.length != length && length != 0) {}
            // filteredFeed.remove(post);
        }

        return null;
    }
}
