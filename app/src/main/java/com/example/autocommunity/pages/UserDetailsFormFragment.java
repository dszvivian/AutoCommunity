package com.example.autocommunity.pages;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.autocommunity.ApiViewModel;
import com.example.autocommunity.R;
import com.example.autocommunity.StorageFirebase;
import com.example.autocommunity.model.ProfileDetails;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

public class UserDetailsFormFragment extends Fragment {


    Button uploadAvatar,btnSave;
    ImageButton btnCancel;
    EditText etFName,etDesc;

    final int IMAGE_REQ_CODE = 22;

    Uri avatarUri;

    StorageFirebase storageFirebase;


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

        storageFirebase =new StorageFirebase();


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
            }
        });


        uploadAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getImage = new Intent();
                getImage.setAction(Intent.ACTION_GET_CONTENT);
                getImage.setType("image/*");
                startActivityForResult(getImage,IMAGE_REQ_CODE);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etFName.getText().toString();
                String desc = etDesc.getText().toString();
//                String url = storageFirebase.uploadImage(getActivity(),avatarUri,"profileimages");
//todo: fix upload image
                if(!(name.isEmpty() && desc.isEmpty())){

                    ApiViewModel vm= new ApiViewModel();

                    ProfileDetails pd = new ProfileDetails(name,"vdkfnkvjfv",desc);


                    vm.updateUser("dszvivian",pd
                            ).observe(requireActivity(), new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
                            if(aBoolean){
                                Toast.makeText(requireActivity(),"Profile details Updated",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(requireActivity(),"Failed To Update Profile Details",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    Toast.makeText(requireActivity(),"Some Fields are Empty",Toast.LENGTH_SHORT).show();
                }


            }
        });







    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==IMAGE_REQ_CODE &&
            resultCode == RESULT_OK &&
                data != null
        ){
            avatarUri = data.getData();
        }

    }
}
