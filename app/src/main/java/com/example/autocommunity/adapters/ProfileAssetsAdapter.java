package com.example.autocommunity.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.autocommunity.R;
import com.example.autocommunity.pages.model.UserAssetsItemModel;

import java.util.List;

public class ProfileAssetsAdapter extends RecyclerView.Adapter<ProfileAssetsAdapter.ViewHolder> {

    private List<UserAssetsItemModel> list;

    public ProfileAssetsAdapter(List<UserAssetsItemModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.example.autocommunity.R.layout.item_userassetsitem,parent,false);
        return new ProfileAssetsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserAssetsItemModel item = list.get(position);
        holder.assetImage.setImageResource(item.getAssetImage());
        holder.assetName.setText(item.getAssetName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView assetImage;
        TextView assetName;

        public ViewHolder(View itemView) {
            super(itemView);

            assetImage = itemView.findViewById(R.id.iv_profileAssetItem);
            assetName = itemView.findViewById(R.id.tv_profileAssetNameItem);

        }
    }

}
