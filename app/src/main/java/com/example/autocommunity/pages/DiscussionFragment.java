package com.example.autocommunity.pages;

import android.nfc.Tag;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autocommunity.Preferences;
import com.example.autocommunity.R;
import com.example.autocommunity.model.MessageModel;
import com.example.autocommunity.model.MessagingAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiscussionFragment extends Fragment {

    EditText etMessage;
    RecyclerView rvDiscuss;
    Button btnSend;

    FirebaseFirestore db ;
    CollectionReference dbRef;
    ArrayList<MessageModel> list;
    MessagingAdapter adapter;

    Preferences pf ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_discussion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etMessage = view.findViewById(R.id.etDiscussMessage);
        btnSend = view.findViewById(R.id.btnDiscussMessageSend);

        rvDiscuss = view.findViewById(R.id.rvDiscuss);
        rvDiscuss.setHasFixedSize(true);
        rvDiscuss.setLayoutManager(new LinearLayoutManager(requireActivity()));
        db = FirebaseFirestore.getInstance();
        dbRef = db.collection("globalchat");


        list = new ArrayList<>();
        list.add(new MessageModel("dszvivian","default message"));
        adapter = new MessagingAdapter(requireActivity(),list);
        rvDiscuss.setAdapter(adapter);


        pf = new Preferences();
        String username = pf.isLoggedIn(requireActivity());
        getMessages();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etMessage.getText().toString();

                /*
                String[] u = {"dszvivian","roshangirish","dkljfhlkjdfkj"};
                Random random = new Random();
                String r = u[random.nextInt(u.length)];

                MessageModel m1 = new MessageModel(r,msg);

                adapter.addMessage(m1);
                etMessage.setText("");*/

                dbRef.add(new MessageModel(username,msg) ).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(requireActivity(),"msg added",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("FirebaseError",e.getMessage());
                    }
                });

                etMessage.setText("");

            }
        });

    }

    private void getMessages() {

//        dbRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                if (error != null) {
//                    Log.e("FirebaseError", "Listen failed.", error);
//                    return;
//                }
//
//                for(DocumentChange dc : value.getDocumentChanges()){
//                    if(dc.getType() == DocumentChange.Type.ADDED){
//                        list.add(dc.getDocument().toObject(MessageModel.class));
//                        Log.w("FirebaseResult", dc.getDocument().toObject(MessageModel.class).toString() );
//                    }
//                    adapter.notifyDataSetChanged();
//
//                }
//
//
//
//
//
//
//
//            }
//        });


        dbRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> ds = queryDocumentSnapshots.getDocuments();
                for(DocumentSnapshot q:ds){
                    list.add(q.toObject(MessageModel.class));
                }
//                Log.d("FirebaseResult",list.get(2).getMessage());
                adapter.notifyDataSetChanged();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("FirebaseError",e.getMessage());
            }
        });

    }
}
