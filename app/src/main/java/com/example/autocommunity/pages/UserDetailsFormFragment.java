package com.example.autocommunity.pages;

import static android.app.Activity.RESULT_OK;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class UserDetailsFormFragment extends Fragment {


    Button uploadAvatar,btnSave;
    ImageButton btnCancel;
    EditText etFName,etDesc;

    final int IMAGE_REQ_CODE = 22;

    Uri avatarUri;

    FirebaseStorage storage;
    StorageReference storageRef;
    String uploadedImageUrl;


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


        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();


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
                uploadImage();

//todo: fix upload image
//                if(!(name.isEmpty() && desc.isEmpty())){
//
//                    ApiViewModel vm= new ApiViewModel();
//
//                    ProfileDetails pd = new ProfileDetails(name,uploadedImageUrl,desc);
//
//
//                    vm.updateUser("dszvivian",pd
//                            ).observe(requireActivity(), new Observer<Boolean>() {
//                        @Override
//                        public void onChanged(Boolean aBoolean) {
//                            if(aBoolean){
//                                Toast.makeText(requireActivity(),"Profile details Updated",Toast.LENGTH_SHORT).show();
//                            }else{
//                                Toast.makeText(requireActivity(),"Failed To Update Profile Details",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//
//                }else{
//                    Toast.makeText(requireActivity(),"Some Fields are Empty",Toast.LENGTH_SHORT).show();
//                }


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

    private void uploadImage()
    {
        if (avatarUri != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog
                    = new ProgressDialog(requireActivity());
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference
            StorageReference ref
                    = storageRef
                    .child(
                            "profileImages/"
                                    + UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(avatarUri)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    // Image uploaded successfully
                                    // Dismiss dialog

                                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            Log.d("URL", uri.toString());
                                            // This is the complete uri, you can store it to realtime database

                                            progressDialog.dismiss();
                                            uploadedImageUrl = uri.toString();

                                            Toast.makeText(requireActivity(),
                                                            uri.toString(),
                                                            Toast.LENGTH_SHORT)
                                                    .show();
                                        }
                                    });





                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(requireActivity(),
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int)progress + "%");
                                }
                            });

        }
    }



}
