package com.example.tp_leboncoin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import java.io.File;
import java.io.FileOutputStream;
import com.example.tp_leboncoin.sqlite.DBManager;


import android.os.Bundle;

// Package + Import

public class CameraAdAddActivity extends AppCompatActivity {

    // Define the pic id
    private static final int CAMERA_PERM_CODE = 101;
    private String filePath = "";
    // Define the button and imageview type variable
    Button camera_open_id;
    Button gallery_open_id;
    ImageView click_image_id;

    ActivityResultLauncher<Intent> cameraActivityResultLauncher = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                Bitmap image = (Bitmap) data.getExtras().get("data");

                ContextWrapper cw = new ContextWrapper(getApplicationContext());
                File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
                Long tsLong = System.currentTimeMillis()/1000;
                String ts = tsLong.toString();
                File file = new File(directory, ts + ".jpg");
                if (!file.exists()) {
                    Log.d("path", file.toString());
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(file);
                        image.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                        fos.flush();
                        fos.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
                filePath = file.toString();
                click_image_id.setImageBitmap(image);
            }
        }
    });

    ActivityResultLauncher<Intent> galleryActivityResultLauncher = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                Uri image = (Uri) result.getData().getData();
                click_image_id.setImageURI(image);
                filePath = image.toString();
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int selectedThemeId = getResources().getIdentifier(ThemeSelectionActivity.SELECTED_THEME, "style", getPackageName());
        setTheme(selectedThemeId);

        setContentView(R.layout.activity_camera_ad_add);

        camera_open_id = findViewById(R.id.camera_open_id);
        gallery_open_id = findViewById(R.id.gallery_open_id);
        click_image_id = findViewById(R.id.click_image_id);

        DBManager dbManager = DBManager.getDBManager(this);
        dbManager.open();

        camera_open_id.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraActivityResultLauncher.launch(intent);
        });

        gallery_open_id.setOnClickListener(v -> {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            galleryActivityResultLauncher.launch(gallery);
        });

        Button send = findViewById(R.id.bt_send_ad);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = findViewById(R.id.click_image_id);
                EditText title = findViewById(R.id.textProduit2);
                EditText address = findViewById(R.id.textAdress2);
                EditText phone = findViewById(R.id.textPhone2);

                AdModel ad = new AdModel(title.getText().toString(), address.getText().toString(), phone.getText().toString(), filePath); // Passer le numéro de téléphone
                dbManager.insert(ad);

                Intent intent = new Intent(CameraAdAddActivity.this, AdListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
