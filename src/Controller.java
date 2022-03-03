public class Controller {

    Controller() {}

    public static void main(String[] args) {
        Feed f = new Feed();
        UI ui = new UI();
        ui.intro();
        while (true) {
            String choice = ui.action();

            if (choice.equalsIgnoreCase("post")) {
                addPost(f, ui);
            } else if (choice.equalsIgnoreCase("view")) {
                displayPosts(f, ui);
            }
            else if (choice.equalsIgnoreCase("quit")) {
                ui.outro();
                break;
            }
        }
    }

    static void addPost(Feed f, UI ui) {
        Post p = new Post();

        while (true) {
            String action = ui.postOptions();

            if (action.equalsIgnoreCase("workout")) {

                if (p.WRKnum == 1) {
                    ui.workoutLimitWarning();
                    continue;
                }

                String type = ui.askWorkoutType();
                while (true) {
                    if (type.equalsIgnoreCase("cardio") || type.equalsIgnoreCase("Strength")) {
                        p.addWorkout(type);
                        ui.successfulWorkout();
                        break;

                    } else {
                        ui.typeWarning();
                        type = ui.askWorkoutType();
                    }
                }
                continue;
            } else if (action.equalsIgnoreCase("caption")) {
                p.addCaption();
                continue;
            } else if (action.equalsIgnoreCase("done")) {
                f.feed.push(p);
                ui.successfulPost();
                break;
            } else {
                ui.postOptionWarning();
                continue;
            }
        }
    }

    static void displayPosts(Feed f, UI ui) {
     ui.showFeed(f);
    }
}
