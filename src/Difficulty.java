import java.util.ArrayList;
import java.util.Scanner;

public class Difficulty implements Filter {
    public ArrayList<Post> filter(Feed f, int difficulty) {
        for (Post post : f.feed) {
            if (post.workout.difficulty == difficulty || difficulty == 0)
                f.filteredFeed.add(post);
        }
        return f.filteredFeed;
    }
}
