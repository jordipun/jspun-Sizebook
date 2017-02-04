package com.example.jspun_sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


import static com.example.jspun_sizebook.R.id.addnew;



/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    private ListView recordList;
    private ArrayAdapter<Records> adapter;
    private ArrayList<Records> objectlist;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recordList = (ListView) findViewById(R.id.recordList);
        init();




    }

    /**
     * Initialzes the buttons and sets the activity link
     */
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


    @Override
    protected void onStart(){
        super.onStart();
        
        adapter = new ArrayAdapter<Records>(this, R.layout.record_list,objectlist);
        recordList.setAdapter(adapter);
    }



}
