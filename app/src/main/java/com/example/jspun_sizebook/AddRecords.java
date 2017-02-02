package com.example.jspun_sizebook;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;


public class AddRecords extends AppCompatActivity{
    Calendar calendar = Calendar.getInstance();
        TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_records);
display = (TextView)findViewById(R.id.displaydate);

        Button dateButton = (Button) findViewById(R.id.date);
        dateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new DatePickerDialog(AddRecords.this,listener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

    }


DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){
    @Override
    public void onDateSet(DatePicker view,int year,int monthOfYear,int dayofMonth){
        display.setText(year + "/" + (monthOfYear+1) + "/" + dayofMonth);
    }
};


}
