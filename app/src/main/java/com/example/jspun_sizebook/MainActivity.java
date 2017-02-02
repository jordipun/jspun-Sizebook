package com.example.jspun_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


import static com.example.jspun_sizebook.R.id.addnew;
import static com.example.jspun_sizebook.R.id.deletez;



public class MainActivity extends AppCompatActivity {

    private ListView recordList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button deleteButton= (Button) findViewById(deletez);
        recordList = (ListView) findViewById(R.id.recordList);
        init();


    }

    public void init() {
        Button addButton= (Button) findViewById(addnew);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clicker = new Intent(MainActivity.this, AddRecords.class);
                startActivity(clicker);
            }
        });

    }






}
