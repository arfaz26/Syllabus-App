package com.example.syllabus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button bu1;
    Button btnLogin;
    EditText et1;
    EditText et2;
    Button buCam;
    Button buLoc;
    TextView tvLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(R.string.title3);
        Toast.makeText(this,"onCreate Register",Toast.LENGTH_SHORT).show();
        openHelper=new DatabaseHelper(this);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        bu1=(Button)findViewById(R.id.bu1);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        buCam= (Button)findViewById(R.id.buCam);
        buLoc= (Button)findViewById(R.id.buLoc);
        tvLoc = (TextView)findViewById(R.id.tvLoc);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper.getWritableDatabase();
                if (et1.getText().toString().equals("") || et2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter Proper values ", Toast.LENGTH_LONG).show();
                }
                else {

                    String uname = et1.getText().toString();
                    String pass = et2.getText().toString();
                    insertdata(uname, pass);
                    Toast.makeText(getApplicationContext(), "SUCCESSFULLY REGISTERED", Toast.LENGTH_LONG).show();

                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,login.class);
                startActivity(intent);

            }
        });


        buCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,cam.class);
                startActivity(intent);
            }
        });


    }

    public void onStart(){
        super.onStart();
        Toast.makeText(this,"onStart Register",Toast.LENGTH_SHORT).show();
    }

    public void onRestart(){
        super.onRestart();
        Toast.makeText(this,"onRestart Register",Toast.LENGTH_SHORT).show();
    }

    public void onResume(){
        super.onResume();
        Toast.makeText(this,"onResume Register",Toast.LENGTH_SHORT).show();
    }

    public void onPause(){
        super.onPause();
        Toast.makeText(this,"onPause Register",Toast.LENGTH_SHORT).show();
    }

    public void onStop(){
        super.onStop();
        Toast.makeText(this,"onStop Register",Toast.LENGTH_SHORT).show();
    }

    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"onDestroy Register",Toast.LENGTH_SHORT).show();
    }

    public void insertdata(String uname,String pass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2,uname);
        contentValues.put(DatabaseHelper.COL_3,pass);
        long id = db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }

    public void buLocation(View view) {
        getlocation();
    }




    void getlocation(){
        LocationManager lm=(LocationManager)getSystemService(LOCATION_SERVICE);
       android.location.Location location=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        tvLoc.setText("Log: "+String.valueOf(location.getLongitude())+ "\n Lat: "+String.valueOf(location.getLatitude()));
    }
}
