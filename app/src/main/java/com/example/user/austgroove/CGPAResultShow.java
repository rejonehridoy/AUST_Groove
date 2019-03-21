package com.example.user.austgroove;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class CGPAResultShow extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout layout;
    SharedPreferences sharedPreferences;
    private static double resultshow;
    private static String Semester,Name,ID,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,mark1,mark2,mark3,mark4,mark5,mark6
            ,mark7,mark8,mark9,mark10;
    private static int totalmark;
    private static double totalGrade;
    private Button savebutton,sharebutton;
    private TextView nameview,idview,s1view,s2view,s3view,s4view,s5view,s6view,s7view,s8view,s9view,s10view,gpaview,marksview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgparesult_show);

        layout  = findViewById(R.id.CGPAShow_layoutID);
        sharedPreferences  = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("DarkMode",false)){
            layout.setBackgroundColor(Color.DKGRAY);
        }


        nameview  =findViewById(R.id.rsnameID);
        idview = findViewById(R.id.rsidID);
        s1view = findViewById(R.id.rssub1ID);
        s2view = findViewById(R.id.rssub2ID);
        s3view = findViewById(R.id.rssub3ID);
        s4view = findViewById(R.id.rssub4ID);
        s5view = findViewById(R.id.rssub5ID);
        s6view = findViewById(R.id.rssub6ID);
        s7view = findViewById(R.id.rssub7ID);
        s8view = findViewById(R.id.rssub8ID);
        s9view = findViewById(R.id.rssub9ID);
        s10view = findViewById(R.id.rssub10ID);
        gpaview = findViewById(R.id.rsGPAid);
        marksview = findViewById(R.id.rstotalmarksid);
        savebutton = findViewById(R.id.rssaveID);
        sharebutton = findViewById(R.id.rsshareID);

        nameview.setText("Name :  "+Name);
        idview.setText("ID :    "+ID);
        s1view.setText(sub1+" :    "+mark1);
        s2view.setText(sub2+" :    "+mark2);
        s3view.setText(sub3+" :    "+mark3);
        s4view.setText(sub4+" :    "+mark4);
        s5view.setText(sub5+" :    "+mark5);
        s6view.setText(sub6+" :    "+mark6);
        s7view.setText(sub7+" :    "+mark7);
        s8view.setText(sub8+" :    "+mark8);
        s9view.setText(sub9+" :    "+mark9);
        s10view.setText(sub10+"     "+mark10);
        gpaview.setText("GPA :  "+resultshow);
        marksview.setText("Total Marks :  "+totalmark);




        savebutton.setOnClickListener(this);
        sharebutton.setOnClickListener(this);
    }

    public static void ShowResult(int Totalmarks,double totalgrade,double result){
        totalmark = Totalmarks;
        resultshow = result;
        totalGrade = totalgrade;

    }
    public static void SetSubjectName(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10){


        sub1 = s1;
        sub2 = s2;
        sub3 = s3;
        sub4 = s4;
        sub5 = s5;
        sub6 = s6;
        sub7 = s7;
        sub8 = s8;
        sub9 = s9;
        sub10 = s10;
    }

    public static void SetMarks(String m1,String m2,String m3,String m4,String m5,String m6,String m7,String m8,String m9,String m10){

        mark1 = m1;
        mark2 = m2;
        mark3 = m3;
        mark4 = m4;
        mark5 = m5;
        mark6 = m6;
        mark7 = m7;
        mark8 = m8;
        mark9 = m9;
        mark10 = m10;
    }

    public static void StudentInfo(String semester,String name,String id){
        Semester = semester;
        Name = name;
        ID = id;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rssaveID){
            /*markSheetDatabase = new MarkSheetDatabase(this);
            SQLiteDatabase sqLiteDatabase = markSheetDatabase.getWritableDatabase();

            if (sub10.equals("") && mark10.equals("")){
                try {
                    long rowId = markSheetDatabase.insertData("MarkSheet_"+Semester,Name,ID,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,mark1,mark2,
                            mark3,mark4,mark5,mark6,mark7,mark8,mark9,resultshow,totalmark);

                    if(rowId>=0)
                        Toast.makeText(this,"Marks Saved Successfully",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(CGPAResultShow.this,Home.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Exceeption : "+e,Toast.LENGTH_LONG).show();
                }

            }
            else {
                long rowId = markSheetDatabase.insertData("MarkSheet_"+Semester,Name,ID,sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,sub10,mark1,mark2,
                        mark3,mark4,mark5,mark6,mark7,mark8,mark9,mark10,resultshow,totalmark);

                if(rowId>=0)
                    Toast.makeText(this,"Marks Saved Successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CGPAResultShow.this,Home.class);
                startActivity(intent);
                finish();
            }*/

            //File directory = new File("CGPA Results");
            String FileName = Name + "_" + ID+".txt";
            try {
                Formatter cgpaFile = new Formatter(FileName);
                cgpaFile.format("%s : %s\r\n",sub1,mark1);
                cgpaFile.format("%s : %s\r\n",sub2,mark2);
                cgpaFile.format("%s : %s\r\n",sub3,mark3);
                cgpaFile.format("%s : %s\r\n",sub4,mark4);
                cgpaFile.format("%s : %s\r\n",sub5,mark5);
                cgpaFile.format("%s : %s\r\n",sub6,mark6);
                cgpaFile.format("%s : %s\r\n",sub7,mark7);
                cgpaFile.format("%s : %s\r\n",sub8,mark8);
                cgpaFile.format("%s : %s\r\n",sub9,mark9);
                if (!sub10.isEmpty() && !mark10.isEmpty())
                    cgpaFile.format("%s : %s\r\n",sub9,mark9);
                cgpaFile.format("%s : %.4f\r\n","GPA",resultshow);
                cgpaFile.format("%s : %d\r\n","Total Marks",totalmark);
                cgpaFile.close();

            } catch (FileNotFoundException e) {
                Toast.makeText(getApplicationContext(),"File Not Found",Toast.LENGTH_LONG).show();
            }


        }

        if (v.getId() == R.id.rsshareID){

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            //intent.putExtra(Intent.EXTRA_EMAIL,new String[] {""});

            intent.putExtra(Intent.EXTRA_SUBJECT,"Mark Sheet");
            intent.putExtra(Intent.EXTRA_TEXT,"Name :  "+Name+"\nID :  "+ID+"\n"+sub1+" :  "+mark1+"\n"+sub2+" : "+
                    mark2+"\n"+sub3+" :  "+mark3+"\n"+sub4+" :  "+mark4+"\n"+sub5+" :  "+mark5+"\n"+sub6+" :  "+mark6+"\n"+
                    sub7+" :  "+mark7+"\n"+sub8+" :  "+mark8+"\n"+sub9+" :  "+mark9+"\n"+sub10+"    "+mark10+"\n\nGPA :  "+resultshow+"\nTotal Marks :  "+totalmark);

            startActivity(Intent.createChooser(intent," Share with "));

        }

    }
}
