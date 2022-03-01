import java.util.Stack;

public class Difficulty implements Filter {
    public Stack<Post> filter(Feed f, int difficulty) {
        for (Post post : f.feed) {
            if (post.workout.difficulty != difficulty && difficulty != 0) {}
                // filteredFeed.remove(post);
        }

        return null;
    }
}
