package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CGPAScreen1 extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout layout;
    SharedPreferences sharedPreferences;
    private EditText nameeditext,idedittext,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9;
    private Button submitbutton,clearbutton;
    private double CGPA;
    private int TotalMarks = 0;
    private double TotalGrade = 0.0;
    private String Semester,nameString,IDString,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpascreen1);

        layout  = findViewById(R.id.CGPAScreen1_layoutID);
        sharedPreferences  = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("DarkMode",false)){
            layout.setBackgroundColor(Color.DKGRAY);
        }


        nameeditext = findViewById(R.id.cgnameID);
        idedittext = findViewById(R.id.cgID);
        sub1 = findViewById(R.id.sub1ID);
        sub2 = findViewById(R.id.sub2ID);
        sub3 = findViewById(R.id.sub3ID);
        sub4 = findViewById(R.id.sub4ID);
        sub5 = findViewById(R.id.sub5ID);
        sub6 = findViewById(R.id.sub6ID);
        sub7 = findViewById(R.id.sub7ID);
        sub8 = findViewById(R.id.sub8ID);
        sub9 = findViewById(R.id.sub9ID);
        submitbutton = findViewById(R.id.cgsubmitbuttonID);
        clearbutton = findViewById(R.id.cgclearbuttonID);

        submitbutton.setOnClickListener(this);
        clearbutton.setOnClickListener(this);

        Semester = getIntent().getStringExtra("semester");


        if (Semester.equals("1.1")){
            setTitle("CGPA Calculator 1.1");
            sub1.setHint("CSE1101 - C Program");
            sub2.setHint("MATH1115 - Mathematics I");
            sub3.setHint("PHY1115 - Physics");
            sub4.setHint("CHEM1115 - Chemistry");
            sub5.setHint("HUM1107 - Critical Thinking");
            sub6.setHint("CSE1102 - C Program Lab");
            sub7.setHint("PHY1116 - Physics Lab");
            sub8.setHint("CSE1108 - Introduction Computer Lab");
            sub9.setHint("HUM1108 - Critical Thinking Lab");

        }

        if (Semester.equals("1.2")){

            setTitle("CGPA Calculator 1.2");
            sub1.setHint("CSE1205 - JAVA");
            sub2.setHint("MATH1219 - Mathematics II");
            sub3.setHint("EEE1241 - Basic Electrical Engineering");
            sub4.setHint("ME1211 - Mechanical Engineering");
            sub5.setHint("CSE1203 - Discrete Mathematics");
            sub6.setHint("CSE1200 - Software Development I");
            sub7.setHint("CSE1206 - JAVA Lab");
            sub8.setHint("EEE1242 - EEE Lab");
            sub9.setHint("ME1214 - Mechanical Engieering Lab");


        }

        if (Semester.equals("2.1")){

            setTitle("CGPA Calculator 2.1");
            sub1.setHint("MATH2101 - Mathematics III");
            sub2.setHint("EEE2141 - Electrical Devices & Circuit");
            sub3.setHint("CSE2103 - Data Structures");
            sub4.setHint("CSE2105 - Digital Logic Design");
            sub5.setHint("HUM2109 - Society,Ethics & Technology");
            sub6.setHint("CSE2100 - Software Development II");
            sub7.setHint("CSE2104 - Data Structures Lab");
            sub8.setHint("EEE2142 - EEE Lab");
            sub9.setHint("CSE2106 - Digital Logic Design Lab");


        }

        if (Semester.equals("3.1")){

            setTitle("CGPA Calculator 3.1");
            sub1.setHint("CSE3103 - Database");
            sub2.setHint("CSE3107 - Microprocessors");
            sub3.setHint("CSE3109 - Digital System Design");
            sub4.setHint("CSE3101 - Mathematical Analysis for CS");
            sub5.setHint("HUM3115 - Economics & Accounting");
            sub6.setHint("CSE3104 - Database Lab");
            sub7.setHint("CSE3100 - Software Development IV");
            sub8.setHint("CSE3108 - Microprocessors Lab");
            sub9.setHint("CSE3110 - Digital System Design Lab");

        }

        if (Semester.equals("3.2")){

            setTitle("CGPA Calculator 3.2");
            sub1.setHint("CSE3211 - Data Communication");
            sub2.setHint("CSE3213 - Operating System");
            sub3.setHint("CSE3215 - Microcontroller Based System");
            sub4.setHint("CSE3223 - Information System Design");
            sub5.setHint("HUM3207 -Industrial Law & Safety Management");
            sub6.setHint("CSE3214 - Operating System Lab");
            sub7.setHint("CSE3200 - Software Development V");
            sub8.setHint("CSE3216 - Microcontroller Based System Lab");
            sub9.setHint("CSE3224 - Information System Design Lab");
        }
    }

    private double getCGPA(String SUB1,double credit1,String SUB2,double credit2,String SUB3,double credit3,
                           String SUB4,double credit4,String SUB5,double credit5,String SUB6,double credit6,
                           String SUB7,double credit7,String SUB8,double credit8,String SUB9,double credit9) {
        TotalGrade = (getGradePoint(SUB1)*credit1) + (getGradePoint(SUB2)*credit2) + (getGradePoint(SUB3)*credit3) +
                (getGradePoint(SUB4)*credit4) + (getGradePoint(SUB5)*credit5) + (getGradePoint(SUB6)*credit6) +
                (getGradePoint(SUB7)*credit7) + (getGradePoint(SUB8)*credit8) + (getGradePoint(SUB9)*credit9);
        double TotalCredit = credit1+credit2+credit3+credit4+credit5+credit6+credit7+credit8+credit9;


        return (TotalGrade/TotalCredit);
    }

    private double getGradePoint(String sub) {

        //int mark = Integer.parseInt(sub);
        int mark = Integer.valueOf(sub);
        TotalMarks+=mark;
        if (mark>=0 && mark<40)
            return 0;
        if (mark>=40 && mark<45)
            return 2;
        if (mark>=45 && mark<50)
            return 2.25;
        if (mark>=50 && mark<55)
            return 2.5;
        if (mark>=55 && mark<60)
            return 2.75;
        if (mark>=60 && mark<65)
            return 3;
        if (mark>=65 && mark<70)
            return 3.25;
        if (mark>=70 && mark<75)
            return 3.5;
        if (mark>=75 && mark<80)
            return 3.75;
        if (mark>=80)
            return 4;

        return 0;
    }

    @Override
    public void onClick(View v) {
        nameString = nameeditext.getText().toString();
        IDString = idedittext.getText().toString();
        subject1 = sub1.getText().toString();
        subject2 = sub2.getText().toString();
        subject3 = sub3.getText().toString();
        subject4 = sub4.getText().toString();
        subject5 = sub5.getText().toString();
        subject6 = sub6.getText().toString();
        subject7 = sub7.getText().toString();
        subject8 = sub8.getText().toString();
        subject9 = sub9.getText().toString();
        if (v.getId() == R.id.cgsubmitbuttonID){
            if(CheckEmpty()){
                Toast.makeText(getApplicationContext(),"Please fill all fields",Toast.LENGTH_LONG).show();
            }
            else {
                if (Semester.equals("1.1")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,1.5,subject7,0.75,subject8,1.5,subject9,1.5);

                    ShowResult();
                }

                if (Semester.equals("1.2")){

                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,1.5,subject7,1.5,subject8,1.5,subject9,0.75);

                    ShowResult();
                }
                if (Semester.equals("2.1")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,0.75,subject7,1.5,subject8,1.5,subject9,1.5);
                    ShowResult();
                }

                if (Semester.equals("3.1")){

                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,1.5,subject7,0.75,subject8,0.75,subject9,0.75);

                    ShowResult();
                }

                if (Semester.equals("3.2")){
                    CGPA = getCGPA(subject1,3,subject2,3,subject3,3,subject4,3,subject5,3,
                            subject6,1.5,subject7,0.75,subject8,0.75,subject9,0.75);

                    ShowResult();
                }

            }


        }
        if (v.getId() == R.id.cgclearbuttonID){

            nameeditext.setText("");
            idedittext.setText("");
            sub1.setText("");
            sub2.setText("");
            sub3.setText("");
            sub4.setText("");
            sub5.setText("");
            sub6.setText("");
            sub7.setText("");
            sub8.setText("");
            sub9.setText("");
        }

    }

    private void ShowResult() {
        Intent intent = new Intent(CGPAScreen1.this,CGPAResultShow.class);
        Initialize();
        this.finish();
        startActivity(intent);
    }

    private boolean CheckEmpty() {
        if (nameString.isEmpty() || IDString.isEmpty() || subject1.isEmpty() || subject2.isEmpty()
                || subject3.isEmpty() || subject4.isEmpty() || subject5.isEmpty() || subject6.isEmpty()
                || subject7.isEmpty() || subject8.isEmpty() || subject9.isEmpty()){
            return true;
        }
        else {
            return false;
        }

    }

    private void Initialize(){
        CGPAResultShow.StudentInfo(Semester,nameString,IDString);
        CGPAResultShow.SetSubjectName(sub1.getHint().toString(),sub2.getHint().toString(),
                sub3.getHint().toString(),sub4.getHint().toString(),sub5.getHint().toString(),
                sub6.getHint().toString(),sub7.getHint().toString(),sub8.getHint().toString(),
                sub9.getHint().toString(),"");

        CGPAResultShow.SetMarks(subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9,"");
        CGPAResultShow.ShowResult(TotalMarks,TotalGrade,CGPA);
    }
}
