package edu.vassar.cmpu203.workoutapp.Persistence;

import edu.vassar.cmpu203.workoutapp.Model.Feed;
import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.Model.Profile;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
                            feed.addPosts(post);
                        }
                        listener.onDataReceived(feed);
                    }
                });
    }

//    public void addProfile(DataListener<Profile> listener) {
//        db.collection(PROFILE_COLLECTION).get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot qsnap) {
//                        Profile p = new Profile();
//                        for(DocumentSnapshot dsnap : qsnap){
//                            p = dsnap.toObject(Profile.class);
//                        }
//                        listener.onDataReceived(p);
//                    }
//                });
//    }

    @Override
    public void savePost(Post post) {

    }

    public void saveProfile(Profile p) {
        db.collection(PROFILE_COLLECTION).add(p);
    }
}
