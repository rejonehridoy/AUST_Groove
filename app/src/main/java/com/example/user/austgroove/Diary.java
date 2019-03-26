package com.example.user.austgroove;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Diary extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listview;
    private DiaryDatabase toDoListDatabase;
    private AlertDialog.Builder alertDialogBuilder;
    private Button addButton;
    private LinearLayout layout;
    SharedPreferences sharedPreferences;

    ArrayList<String> listData = new ArrayList<>();
    ArrayList<String> showData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        layout = findViewById(R.id.Diary_layoutID);
        //Check if DarkMode is activated previously by a user or not
        sharedPreferences  = getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("DarkMode",false)){
            layout.setBackgroundColor(Color.DKGRAY);
        }

        listview = findViewById(R.id.listViewID);
        toDoListDatabase = new DiaryDatabase(this);
        addButton = findViewById(R.id.addiconID);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Diary.this,DiaryCreate.class);
                startActivity(intent);
                finish();
            }
        });
        loadData();
    }

    public void loadData(){



        Cursor cursor = toDoListDatabase.showAllData();
        if (cursor.getCount() ==0){
            Toast.makeText(getApplicationContext(),"no data available in database",Toast.LENGTH_LONG).show();

        }else {
            while (cursor.moveToNext()){

                listData.add(cursor.getString(1));
                showData.add(cursor.getString(2));
            }

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.listTextViewID,listData);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        final String selectedvalue = parent.getItemAtPosition(position).toString();

        //Toast.makeText(getApplicationContext(),"Selected value : "+showData.get(position),Toast.LENGTH_LONG).show();
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(selectedvalue);
        alertDialogBuilder.setMessage(showData.get(position));
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();


            }
        });
        alertDialogBuilder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int value = toDoListDatabase.delete(listData.get(position));
                if (value>=0){
                    Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_LONG).show();
                    dialog.cancel();
                    Intent intent = new Intent(getApplicationContext(),Diary.class);
                    finish();
                    startActivity(intent);

                }

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
