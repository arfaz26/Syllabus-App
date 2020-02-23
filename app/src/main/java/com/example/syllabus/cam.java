package com.example.syllabus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class cam extends AppCompatActivity {

    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);
        imgView =(ImageView) findViewById(R.id.imgView);
    }
    int tag = 1;
    public void buCapture(View view) {

        Intent intent= new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,tag);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==tag && resultCode==RESULT_OK){
            Bundle b=data.getExtras();
            Bitmap img=(Bitmap)b.get("data");
            imgView.setImageBitmap(img);
        }
    }
}
