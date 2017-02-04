package com.example.jspun_sizebook;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


/**
 * The type Add records.
 */
public class AddRecords extends AppCompatActivity{
    /**
     * The Calendar.
     */
    Calendar calendar = Calendar.getInstance();
    /**
     * The Display.
     */
    TextView display;
    EditText uname;
    EditText uneck;
    EditText uwaist;
    EditText uhip;
    EditText uchest;
    EditText ucomment;
    EditText ubust;
    EditText uinseam;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_records);
        display = (TextView)findViewById(R.id.displaydate);
        uname = (EditText) findViewById(R.id.editname);
        uneck = (EditText) findViewById(R.id.editneck);
        uchest = (EditText) findViewById(R.id.editchest);
        ucomment = (EditText) findViewById(R.id.editcom);
        uwaist = (EditText)findViewById(R.id.editw);
        uhip = (EditText) findViewById(R.id.edithip);
        uinseam = (EditText) findViewById(R.id.editin);
        ubust = (EditText)findViewById(R.id.editbust);



        Button saveButton = (Button) findViewById(R.id.save);
        Button dateButton = (Button) findViewById(R.id.date);
        Button deleteButton = (Button) findViewById(R.id.delete);
        dateButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                new DatePickerDialog(AddRecords.this,listener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                Records record = new Records(uname.getText().toString());

                if (uname.getText().length()==0){
                    uname.setError("Please Enter a Name!");
                }else{
                    record.setName(uname.getText().toString());

                }
                record.setBust(ubust.getText().toString());
                record.setChest(uchest.getText().toString());
                record.setComment(ucomment.getText().toString());
                record.setHip(uhip.getText().toString());
                record.setNeck(uneck.getText().toString());
                record.setInseam(uinseam.getText().toString());
                record.setWaist(uwaist.getText().toString());
                record.setDate(display.getText().toString());


                finish();




            }
        });

    }




    /**
     * The Listener.
     */
    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view,int year,int monthOfYear,int dayofMonth){
            display.setText(year + "/" + (monthOfYear+1) + "/" + dayofMonth);

    }
};


}
