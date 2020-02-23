package com.example.syllabus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;



public class sem5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem5);
        this.setTitle("SEM_V Syllabus");
        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("INFT_Sem_V.pdf").load();
    }
}
