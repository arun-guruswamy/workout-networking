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
                       Workout w = p.addWorkout(type);
                       String description = ui.workoutDescription();
                       p.addWorkoutDescription(w, description);

                       while (true) {
                           String length = ui.getWorkoutLength();
                           try {
                               int l = Integer.parseInt(length);
                               p.addWorkoutLength(w, l);
                               break;
                           }
                           catch(NumberFormatException e) {
                               ui.lengthInputError();
                           }

                       }
                        while(true) {
                            String difficulty = ui.getWorkoutDifficulty();

                            try {
                                int d = Integer.parseInt(difficulty);
                                p.addWorkoutDifficulty(w, d);
                                break;
                            } catch (NumberFormatException e) {
                                ui.difficultyInputError();
                            }
                        }


                        ui.successfulWorkout();
                        break;

                    } else {
                        ui.typeWarning();
                        type = ui.askWorkoutType();
                    }
                }
                continue;

            } else if (action.equalsIgnoreCase("caption")) {
                if (p.CAPnum == 1) {
                    ui.captionLimitWarning();
                    continue;
                }

                String caption = ui.askCaption();
                p.addCaption(caption);
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

        if(f.feed.size() == 0){
            ui.emptyFeed();
        }

     ui.showFeed(f);
    }
}
