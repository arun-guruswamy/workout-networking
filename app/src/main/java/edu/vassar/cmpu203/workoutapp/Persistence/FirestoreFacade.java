package edu.vassar.cmpu203.workoutapp.Persistence;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.workoutapp.Model.Cardio;
import edu.vassar.cmpu203.workoutapp.Model.Feed;
import edu.vassar.cmpu203.workoutapp.Model.Mobility;
import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.Model.Profile;
import edu.vassar.cmpu203.workoutapp.Model.Strength;
import edu.vassar.cmpu203.workoutapp.Model.Workout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


public class FirestoreFacade implements IPersistenceFacade {

    private static final String POST_COLLECTION = "POST_COLLECTION";
    private static final String PROFILE_COLLECTION = "PROFILE_COLLECTION";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FirestoreFacade(){}

    @Override
    public void retrieveFeed(DataListener<Feed> listener) {
        db.collection(POST_COLLECTION).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot qsnap) {
                        Feed feed = new Feed();
                        for(DocumentSnapshot dsnap : qsnap){

                            Post post = dsnap.toObject(Post.class);

                            if(post.getWorkout().getWorkoutType() == 1) {
                              Cardio cardio = new Cardio(post.getWorkout());
                              cardio.setAgilityFocus(dsnap.getBoolean("workout.agilityFocus"));
                              cardio.setEnduranceFocus(dsnap.getBoolean("workout.enduranceFocus"));
                              cardio.setSpeedFocus(dsnap.getBoolean("workout.speedFocus"));
                              post.setWorkout(cardio);
                            }
                            else if (post.getWorkout().getWorkoutType() == 2 ){
                                Strength strength = new Strength(post.getWorkout());
                                strength.setBodyWeightFocus(dsnap.getBoolean("workout.bodyWeightFocus"));
                                strength.setFullBodyFocus(dsnap.getBoolean("workout.fullBodyFocus"));
                                strength.setUpperBodyFocus(dsnap.getBoolean("workout.upperBodyFocus"));
                                strength.setLowerBodyFocus(dsnap.getBoolean("workout.lowerBodyFocus"));
                                post.setWorkout(strength);
                            }
                            else if (post.getWorkout().getWorkoutType() == 3) {
                                Mobility mobility = new Mobility(post.getWorkout());
                                mobility.setDynamicFocus(dsnap.getBoolean("workout.dynamicStretching"));
                                mobility.setStaticFocus(dsnap.getBoolean("workout.staticStretching"));
                                mobility.setYogaFocus(dsnap.getBoolean("workout.yoga"));
                                post.setWorkout(mobility);
                            }


                            feed.addPosts(post);
                        }
                        listener.onDataReceived(feed);
                    }
                });
    }

    @Override
    public void addProfile(@NonNull Profile profile, @NonNull BinaryResultListener listener) {
        String username = profile.getUsername();

        this.retrieveProfile(username, new DataListener<Profile>() {
            @Override
            public void onDataReceived(@NonNull Profile data) {
                listener.onNoResult();
            }

            @Override
            public void onNoDataFound() {
                db.collection(PROFILE_COLLECTION).document(username).
                        set(profile).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        listener.onYesResult();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        listener.onNoResult();
                    }
                });
            }
        });
    }

    @Override
    public void savePost(Post post) {
        db.collection(POST_COLLECTION).add(post);
    }

    @Override
    public void retrieveProfile(@NonNull String username, @NonNull DataListener<Profile> listener) {

        db.collection(PROFILE_COLLECTION).document(username).get().
                addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            Profile profile = documentSnapshot.toObject(Profile.class);
                            listener.onDataReceived(profile);
                        }
                        else {
                            listener.onNoDataFound();
                        }
                    }
                });
    }

    @Override
    public void saveProfile(Profile p) {
        db.collection(PROFILE_COLLECTION).document(p.getUsername()).set(p);
    }

    @Override
    public void editProfile(Profile p, String old){
        db.collection(PROFILE_COLLECTION).document(p.getUsername()).set(p);
        db.collection(PROFILE_COLLECTION).document(old).delete();
    }

}
