package com.example.autocommunity.pages.forms;

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
import com.example.autocommunity.Preferences;
import com.example.autocommunity.R;
import com.example.autocommunity.model.Post;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class ANPFromFragment extends Fragment {


    Button btnSave, btnChooseImage, btnUploadImage;
    ImageButton btnCancel;
    EditText etCaptions;

    final int IMAGE_REQ_CODE = 28;

    Uri uri;

    FirebaseStorage storage;
    StorageReference storageRef;
    String uploadedImageUrl;

    Preferences pf;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.anpform_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSave = view.findViewById(R.id.btn_ANPFSave);
        btnChooseImage = view.findViewById(R.id.btn_ANPFChooseImage);
        btnUploadImage = view.findViewById(R.id.btn_ANPFUploadImage);
        etCaptions = view.findViewById(R.id.et_ANPFcaptions);
        btnCancel = view.findViewById(R.id.iv_ANPFcancel);


        pf = new Preferences();

        String username = pf.isLoggedIn(requireActivity());



        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
            }
        });

        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });

        btnChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getImage = new Intent();
                getImage.setAction(Intent.ACTION_GET_CONTENT);
                getImage.setType("image/*");
                startActivityForResult(getImage, IMAGE_REQ_CODE);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String captions = etCaptions.getText().toString();
                ApiViewModel vm = new ApiViewModel();

                if(!captions.isEmpty()){
                    //get it from shared preferences
                    vm.addNewPost(username,new Post(uploadedImageUrl)).observe(requireActivity(), new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean aBoolean) {
                            if(aBoolean){
                                Toast.makeText(requireActivity(), "New Post Updated", Toast.LENGTH_SHORT).show();
                                requireActivity().onBackPressed();
                            }else{
                                Toast.makeText(requireActivity(), "Failed to Add AssetData", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(requireActivity(), "Some Fields are Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void uploadImage() {
        if (uri != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog
                    = new ProgressDialog(requireActivity());
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            // Defining the child of storageReference
            StorageReference ref
                    = storageRef
                    .child(
                            "postImages/"
                                    + UUID.randomUUID().toString());

            // adding listeners on upload
            // or failure of image
            ref.putFile(uri)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot) {

                                    // Image uploaded successfully
                                    // Dismiss dialog

                                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            Log.d("URL", uri.toString());
                                            // This is the complete uri, you can store it to realtime database


                                            progressDialog.dismiss();
                                            Toast.makeText(requireActivity(),
                                                            "Suceessfully Uploaded Image",
                                                            Toast.LENGTH_SHORT)
                                                    .show();
                                            uploadedImageUrl = uri.toString();
                                        }
                                    });


                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

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
                                        UploadTask.TaskSnapshot taskSnapshot) {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "Uploaded "
                                                    + (int) progress + "%");
                                }
                            });

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_REQ_CODE &&
                resultCode == RESULT_OK &&
                data != null
        ) {
            uri = data.getData();
        }

    }

}
