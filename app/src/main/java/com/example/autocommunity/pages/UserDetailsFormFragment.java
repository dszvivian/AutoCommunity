package com.example.autocommunity.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.autocommunity.R;

import java.util.Objects;

public class UserDetailsFormFragment extends Fragment {


    Button uploadAvatar,btnSave;
    ImageButton btnCancel;
    EditText etFName,etDesc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_userdetailsform, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCancel = view.findViewById(R.id.ib_udfCancel);
        btnSave = view.findViewById(R.id.btn_UDFSave);
        uploadAvatar = view.findViewById(R.id.btn_UDFUploadAvatar);
        etFName = view.findViewById(R.id.et_UDFFName);
        etDesc = view.findViewById(R.id.et_UDFDescription);


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
            }
        });





    }
}
