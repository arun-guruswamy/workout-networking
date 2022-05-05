package edu.vassar.cmpu203.workoutapp.Persistence;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.workoutapp.Model.Feed;
import edu.vassar.cmpu203.workoutapp.Model.Post;
import edu.vassar.cmpu203.workoutapp.Model.Profile;

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
        db.collection(PROFILE_COLLECTION).add(p);
    }

    public void setPostNum(Profile profile){
        DocumentReference documentReference = db.document(""+PROFILE_COLLECTION+"/"+profile.getUsername());
        //documentReference.set()
    }

//    public void getProfile(String prof_id) {
//        db.collection("Profiles").get()
//            .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                @Override
//                public void onSuccess(QuerySnapshot qsnap) {
//                    Profile ledger = new Ledger();
//                    for (DocumentSnapshot dsnap : qsnap){
//                        Sale sale = dsnap.toObject(Sale.class);
//                        ledger.addSale(sale);
//                    }
//                    listener.onDataReceived(ledger);
//                }
//            });
//
//    }

//    @Override
//    public void createUserIfNotExists(@NonNull User user, @NonNull BinaryResultListener listener) {
//
//        String username = user.getUsername();
//
//        this.retrieveUser(username, new DataListener<User>() {
//            @Override
//            public void onDataReceived(@NonNull User data) {
//                listener.onNoResult();
//            }
//
//            @Override
//            public void onNoDataFound() {
//                db.collection(USERS_COLLECTION).document(username).
//                        set(user).
//                        addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void unused) {
//                                listener.onYesResult();
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        listener.onNoResult();
//                    }
//                });
//
//            }
//        });
//
//    }
//
  /*  @Override
    public void retrieveUser(@NonNull String username, @NonNull DataListener<Profile> listener) {

        db.collection("Profiles").document(username).get().
                addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                         @Override
                                         public void onSuccess(DocumentSnapshot dsnap) {
                                             if (dsnap.exists()){
                                                 Profile user = dsnap.toObject(Profile.class);
                                                 listener.onDataReceived(user);
                                             } else // no user found
                                                 listener.onNoDataFound();
                                         }
                                     }
                );

    }*/

}
