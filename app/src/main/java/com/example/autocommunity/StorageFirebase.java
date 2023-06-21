package com.example.autocommunity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class StorageFirebase {

    StorageReference storageRef;

    public String uploadImage(Context context,Uri imageUri, String path){
        storageRef = FirebaseStorage.getInstance().getReference();

        StorageReference imageRef = storageRef.child(String.format("%s/%s.jpg",path, UUID.randomUUID()));
        MutableLiveData<String> finalImageUrl = null;

        if(imageUri != null){

            imageRef.putFile(imageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Task<Uri> uploadedImageUri = taskSnapshot.getStorage().getDownloadUrl();
                            finalImageUrl.setValue(uploadedImageUri.toString());
                            Toast.makeText(context,"Uploaded Successfully",Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context,"Failed to Upload",Toast.LENGTH_SHORT).show();
                        }
                    });

        }


        return null;
    }



}
