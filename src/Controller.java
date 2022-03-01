public class Controller {

    Controller() {}

    public static void main(String[] args) {
        Feed f = new Feed();
        UI ui = new UI();
        ui.intro();
        while (true) {
            String choice = ui.action();

            if (choice.equalsIgnoreCase("post")) {
                f = addPost(f, ui);
            } else if (choice.equalsIgnoreCase("view")) {
                displayPosts(f, ui);
            }
            else if (choice.equalsIgnoreCase("quit")) {
                ui.outro();
                break;
            }
        }
    }

    static Feed addPost(Feed f, UI ui) {
        Post p = new Post();
        p.addWorkout();
        p.addCaption();
        f.feed.push(p);
        ui.successfulPost();
        return f;
    }

    static void displayPosts(Feed f, UI ui) {
     ui.showFeed(f);
    }
}
