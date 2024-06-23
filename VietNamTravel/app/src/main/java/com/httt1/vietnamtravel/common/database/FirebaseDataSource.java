package com.httt1.vietnamtravel.common.database;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseDataSource {
    private static final FirebaseStorage storage = FirebaseStorage.getInstance();
    private static final StorageReference storageRef = storage.getReference();
    private StorageReference getImgFireBase(String link) {

        StorageReference imageRef = storageRef.child(link); // Đường dẫn ảnh trong Firebase Storage //ImgTour/CBBTTV/1.jpeg

        return imageRef;
    }
}
