import java.util.ArrayList;
import java.util.Scanner;

public class Length implements Filter {
    public ArrayList<Post> filter(Feed f, int length) {
        for (Post post : f.feed) {
            if (post.workout.length == length || length == 0)
                f.filteredFeed.add(post);
        }
        return f.filteredFeed;
    }
}
