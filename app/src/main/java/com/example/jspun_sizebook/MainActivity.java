package com.example.jspun_sizebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


import static com.example.jspun_sizebook.R.id.clear;
import static com.example.jspun_sizebook.R.id.recordList;
import static com.example.jspun_sizebook.R.id.save;

public class MainActivity extends AppCompatActivity {

    private ListView recordList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveButton= (Button) findViewById(save);
        Button clearButton= (Button) findViewById(clear);
        recordList = (ListView) findViewById(R.id.recordList);

    }


}
