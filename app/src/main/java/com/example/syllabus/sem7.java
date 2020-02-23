package com.example.syllabus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class sem7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem7);
        this.setTitle("SEM_VII Syllabus");
        PDFView pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("BE-INFT.pdf").load();
    }
}
