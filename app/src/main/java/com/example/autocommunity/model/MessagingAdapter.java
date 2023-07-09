package com.example.autocommunity.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autocommunity.Preferences;
import com.example.autocommunity.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessagingAdapter extends RecyclerView.Adapter<MessagingAdapter.ViewHolder> {




    public MessagingAdapter(Context context, ArrayList<MessageModel> messages) {
        this.messages = messages;
        this.context = context;
    }

    ArrayList<MessageModel> messages = new ArrayList<>();
    Context context;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageModel item = messages.get(position);


        Preferences pf =new Preferences();
        String username = pf.isLoggedIn(context);

//        holder.tvSender.setText(item.getUsername());


        //todo: fix the naming sender<-->receiver
        if(Objects.equals(item.username, username)){
            holder.tvReciever.setVisibility(View.VISIBLE);
            holder.tvReciever.setText(item.getMessage());
            holder.tvSenderUsername.setVisibility(View.GONE);
            holder.tvSender.setVisibility(View.GONE);
        }else{
            holder.tvSenderUsername.setVisibility(View.VISIBLE);
            holder.tvSender.setVisibility(View.VISIBLE);
            holder.tvSender.setText(item.getMessage());
            holder.tvSenderUsername.setText(item.getUsername());
            holder.tvReciever.setVisibility(View.GONE);


        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView tvSender,tvReciever,tvSenderUsername;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSender = itemView.findViewById(R.id.tv_message);
            tvReciever = itemView.findViewById(R.id.tv_bot_message);
            tvSenderUsername = itemView.findViewById(R.id.tvSenderUsername);
        }
    }

    public void addMessage(MessageModel msg){
        messages.add(msg);
        notifyItemChanged(messages.size());
    }


}
