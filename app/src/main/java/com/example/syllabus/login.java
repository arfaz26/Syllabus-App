package com.example.syllabus;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button btnLogin;
    EditText etu;
    EditText etp;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle(R.string.title2);
        Toast.makeText(this,"onCreate Subjects",Toast.LENGTH_SHORT).show();
        openHelper=new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        btnLogin=(Button)findViewById(R.id.btnLogin);
        etu=(EditText)findViewById(R.id.etu);
        etp=(EditText)findViewById(R.id.etp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usrname = etu.getText().toString();
                String pwd = etp.getText().toString();
                cursor = db.rawQuery("SELECT * FROM " +DatabaseHelper.TABLE_NAME+" WHERE "+DatabaseHelper.COL_2+" =? AND "+DatabaseHelper.COL_3+" =? ",new String[]{usrname,pwd});
                if (cursor!=null){
                    if (cursor.getCount()>0){
                        cursor.moveToNext();
                        Intent intent= new Intent(getApplicationContext(),Data.class);
                        startActivity(intent);
                                Toast.makeText(getApplicationContext(),"Welcome " +etu.getText().toString() ,Toast.LENGTH_LONG).show();


                    }
                    else {
                        Toast.makeText(getApplicationContext(),"login Failed",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }



    public void onStart(){
        super.onStart();
        Toast.makeText(this,"onStart Login",Toast.LENGTH_SHORT).show();
    }

    public void onRestart(){
        super.onRestart();
        Toast.makeText(this,"onRestart Login",Toast.LENGTH_SHORT).show();
    }

    public void onResume(){
        super.onResume();
        Toast.makeText(this,"onResume Login",Toast.LENGTH_SHORT).show();
    }

    public void onPause(){
        super.onPause();
        Toast.makeText(this,"onPause Login",Toast.LENGTH_SHORT).show();
    }

    public void onStop(){
        super.onStop();
        Toast.makeText(this,"onStop Login",Toast.LENGTH_SHORT).show();
    }

    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"onDestroy Login",Toast.LENGTH_SHORT).show();
    }
}
