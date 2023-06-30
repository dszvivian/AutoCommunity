package com.example.autocommunity.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.autocommunity.R;

public class EventConfirmFragment extends Fragment {

    AppCompatButton btnAttend;
    ImageView coverImage;
    TextView tvPlace,tvAgenda;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.eventconfirm_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnAttend = view.findViewById(R.id.btnECFAttend);
        tvPlace = view.findViewById(R.id.tvECFPlace);
        tvAgenda = view.findViewById(R.id.tvECFagenda);
        coverImage = view.findViewById(R.id.ivECFCoverimage);

        Bundle bd = requireActivity().getIntent().getExtras();
        String title = bd.getString("title");
        String place = bd.getString("place");
        String coverImageUrl = bd.getString("coverImage");

        Glide
                .with(requireActivity())
                .load(coverImageUrl)
                .centerCrop()
                .into(coverImage);

        tvPlace.setText(place);
        tvAgenda.setText(title);



        btnAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                requireActivity().onBackPressed();
            }
        });

    }
}
