package com.example.autocommunity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class StorageUtils {

    public MutableLiveData<String> uploadImage(Context context,Uri uri,StorageReference storageRef)
    {
        MutableLiveData<String> uploadedImageUrl = null;


        if (uri != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog
                    = new ProgressDialog(context);
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
            ref.putFile(uri)
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

                                            Toast.makeText(context,
                                                            "Suceessfully Uploaded Image",
                                                            Toast.LENGTH_SHORT)
                                                    .show();
                                            uploadedImageUrl.setValue(uri.toString());
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
                                    .makeText(context,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();

                            uploadedImageUrl.setValue("failed");
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

        return uploadedImageUrl;
    }

}
