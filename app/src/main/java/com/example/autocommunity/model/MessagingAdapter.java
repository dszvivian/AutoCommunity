package com.example.autocommunity.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autocommunity.R;

import java.util.ArrayList;

public class MessagingAdapter extends RecyclerView.Adapter<MessagingAdapter.ViewHolder> {

    public MessagingAdapter(ArrayList<MessageModel> messages) {
        this.messages = messages;
    }

    ArrayList<MessageModel> messages = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageModel item = messages.get(position);

        if(item.getUsername().equals("dszvivian")){
            holder.tvSender.setVisibility(View.VISIBLE);
            holder.tvSender.setText(item.getMessage());
            holder.tvReciever.setVisibility(View.GONE);
        }else{
            holder.tvReciever.setVisibility(View.VISIBLE);
            holder.tvReciever.setText(item.getMessage());
            holder.tvSender.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView tvSender,tvReciever;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSender = itemView.findViewById(R.id.tv_message);
            tvReciever = itemView.findViewById(R.id.tv_bot_message);
        }
    }

    public void addMessage(MessageModel msg){
        messages.add(msg);
        notifyItemChanged(messages.size());
    }


}