package com.example.syllabus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> SEM5 = new ArrayList<String>();
        SEM5.add("Microcontroller and Embedded Programming");
        SEM5.add("Internet Programming");
        SEM5.add("Advanced Data Management Technology");
        SEM5.add("Cryptography & Network Security");
        SEM5.add("Business Communication and Ethics ");
        SEM5.add("Internet Programming Lab");
        SEM5.add("Security Lab");
        SEM5.add("OLAP Lab");
        SEM5.add(" IOT (Mini Project) Lab");
        SEM5.add("Syllabus SEM-5");

        List<String> SEM6 = new ArrayList<String>();
        SEM6.add("Software Engineering with Project Management");
        SEM6.add("Data Mining and Business Intelligence");
        SEM6.add("Cloud Computing & Services");
        SEM6.add("Wireless Networks");
        SEM6.add("Software Design Lab");
        SEM6.add("Business Intelligence Lab");
        SEM6.add("Cloud Service Design Lab");
        SEM6.add("Sensor Network Lab");
        SEM6.add("Mini-Project");
        SEM6.add("Syllabus SEM-6");


        List<String> SEM7 = new ArrayList<String>();
        SEM7.add("Enterprise Network Design");
        SEM7.add("Infrastructure Security");
        SEM7.add("Artificial Intelligence");
        SEM7.add("Department Level");
        SEM7.add("Network Design Lab");
        SEM7.add("Advanced Security Lab");
        SEM7.add("Intelligence System Lab");
        SEM7.add("Android Apps Development Lab");
        SEM7.add("Project-I");
        SEM7.add("Syllabus SEM-7");




        expandableListDetail.put("Semester-5", SEM5);

        expandableListDetail.put("Semester-6", SEM6);

        expandableListDetail.put("Semester-7", SEM7);




        return expandableListDetail;
    }
}
