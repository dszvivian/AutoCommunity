package com.example.autocommunity.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autocommunity.R;
import com.example.autocommunity.model.MessageModel;
import com.example.autocommunity.model.MessagingAdapter;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Random;

public class DiscussionFragment extends Fragment {

    EditText etMessage;
    RecyclerView rvDiscuss;
    Button btnSend;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference dbRef;

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

        dbRef = db.collection("globalchat");


        ArrayList<MessageModel> list = new ArrayList<>();

        MessagingAdapter adapter = new MessagingAdapter(list);

        rvDiscuss.setAdapter(adapter);
        rvDiscuss.setLayoutManager(new LinearLayoutManager(requireActivity()));

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etMessage.getText().toString();

                String[] u = {"dszvivian","roshangirish","dkljfhlkjdfkj"};
                Random random = new Random();
                String r = u[random.nextInt(u.length)];

                MessageModel m1 = new MessageModel(r,msg);

                adapter.addMessage(m1);
                etMessage.setText("");
            }
        });



    }
}
