package com.example.syllabus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data extends AppCompatActivity {

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        ExpandableListView expandableListView = findViewById(R.id.expandableListView);

        HashMap<String, List<String>> item = new HashMap<>();



        ArrayList<String> Sem1Group= new ArrayList<>();
        Sem1Group.add("Mathematics");
        Sem1Group.add("Physics");
        Sem1Group.add("Chemistry");
        Sem1Group.add("Basic Electronic Engineering");
        Sem1Group.add("Basic Civil and Environmental Engineering");
        Sem1Group.add("Fundamentals Of Programming Languages");
        Sem1Group.add("Workshop Practice");


        ArrayList<String> Sem2Group= new ArrayList<>();
        Sem2Group.add("Mathematics");
        Sem2Group.add("Physics");
        Sem2Group.add("Chemistry");
        Sem2Group.add("Basic Mechanical Engineering");
        Sem2Group.add("Engineering Mechanics");
        Sem2Group.add("Fundamentals Of Programming Languages 2");
        Sem2Group.add("Engineering Graphics 2");
        Sem2Group.add("C Programming");
        Sem2Group.add("Professional Communication and Ethics");




        ArrayList<String> Sem3Group= new ArrayList<>();
        Sem3Group.add("Applied Mathematics III");
        Sem3Group.add("Logic Design");
        Sem3Group.add("Data Structures & Analysis");
        Sem3Group.add("Database Management System");
        Sem3Group.add("Principle of Communications");
        Sem3Group.add("Digital Design Lab");
        Sem3Group.add("Data Structures Lab");
        Sem3Group.add("SQL Lab");
        Sem3Group.add("Java Programming Lab");





        ArrayList<String> Sem4Group= new ArrayList<>();
        Sem4Group.add("Applied Mathematics 4");
        Sem4Group.add("Computer Networks");
        Sem4Group.add("Operating Systems");
        Sem4Group.add("Computer Organization and Architecture");
        Sem4Group.add("Automata Theory");
        Sem4Group.add("Networking Lab");
        Sem4Group.add("Unix Lab");
        Sem4Group.add("Microprocessor Programming Lab");
        Sem4Group.add("Python Lab");





        ArrayList<String> Sem5Group= new ArrayList<>();
        Sem5Group.add("Microcontroller and Embedded Programming");
        Sem5Group.add("Internet Programming");
        Sem5Group.add("Advanced Data Management Technology");
        Sem5Group.add("Cryptography & Network Security ");
        Sem5Group.add("Business Communication and Ethics ");
        Sem5Group.add("Internet Programming Lab");
        Sem5Group.add("Security Lab");
        Sem5Group.add("OLAP Lab");
        Sem5Group.add("IOT (Mini Project) Lab");




        ArrayList<String> Sem6Group= new ArrayList<>();
        Sem6Group.add("Software Engineering with Project Management");
        Sem6Group.add("Data Mining and Business Intelligence");
        Sem6Group.add("Cloud Computing & Services");
        Sem6Group.add("Wireless Networks");
        Sem6Group.add("Software Design Lab");
        Sem6Group.add("Business Intelligence Lab");
        Sem6Group.add("Cloud Service Design Lab");
        Sem6Group.add("Sensor Network Lab");
        Sem6Group.add("Mini Project");




        ArrayList<String> Sem7Group= new ArrayList<>();
        Sem7Group.add("Enterprise Network Design");
        Sem7Group.add("Infrastructure Security");
        Sem7Group.add("Artificial Intelligence");
        Sem7Group.add("Network Design Lab");
        Sem7Group.add("Advanced Security Lab");
        Sem7Group.add("Intelligence System Lab");
        Sem7Group.add("Android Apps Development Lab");
        Sem7Group.add("Project");



        ArrayList<String> Sem8Group= new ArrayList<>();
        Sem8Group.add("Storage Network Management and Retrieval");
        Sem8Group.add("Big Data Analytics");
        Sem8Group.add("Computer Simulation and Modeling");
        Sem8Group.add("Storage Network Management and Retrieval Lab");
        Sem8Group.add("Big Data Analytics Lab");
        Sem8Group.add("Computer Simulation and Modeling Lab");
        Sem8Group.add("Project");


        item.put("1.Semester",Sem1Group);
        item.put("2.Semester",Sem2Group);
        item.put("3.Semester",Sem3Group);
        item.put("4.Semester",Sem4Group);
        item.put("5.Semester",Sem5Group);
        item.put("6.Semester",Sem6Group);
        item.put("7.Semester",Sem7Group);
        item.put("8.Semester",Sem8Group);



        MyExpandableListAdapter adapter=new MyExpandableListAdapter(item);
    expandableListView.setAdapter(adapter);

    } */
  ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(R.string.app_name);
        Toast.makeText(this,"onCreate Subjects",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_data);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new MyExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                // Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
              //  Toast.makeText(getApplicationContext(), expandableListTitle.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {


                if (expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition)=="Syllabus SEM-5"){
                    Toast.makeText(getApplicationContext(),"Download Semester 5 files",Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(Data.this,sem5.class);
                   startActivity(intent);
                }

                else if (expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition)=="Syllabus SEM-6"){
                    Toast.makeText(getApplicationContext(),"Download Semester 6 files",Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(Data.this,sem6.class);
                   startActivity(intent);
                }
                else if (expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition)=="Syllabus SEM-7"){
                    Toast.makeText(getApplicationContext(),"Download Semester 7 files",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Data.this,sem7.class);
                    startActivity(intent);
                }


               /* Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show(); */

                return false;
            }
        });
    }


    public void onStart(){
        super.onStart();
        Toast.makeText(this,"onStart Subjects",Toast.LENGTH_SHORT).show();
    }

    public void onRestart(){
        super.onRestart();
        Toast.makeText(this,"onRestart Subjects",Toast.LENGTH_SHORT).show();
    }

    public void onResume(){
        super.onResume();
        Toast.makeText(this,"onResume Subjects",Toast.LENGTH_SHORT).show();
    }

    public void onPause(){
        super.onPause();
        Toast.makeText(this,"onPause Subjects",Toast.LENGTH_SHORT).show();
    }

    public void onStop(){
        super.onStop();
        Toast.makeText(this,"onStop Subjects",Toast.LENGTH_SHORT).show();
    }

    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"onDestroy Subjects",Toast.LENGTH_SHORT).show();
    }
}
