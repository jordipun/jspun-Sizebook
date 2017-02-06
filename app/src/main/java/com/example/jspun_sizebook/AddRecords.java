package com.example.jspun_sizebook;

import android.content.Context;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.provider.Telephony.Mms.Part.FILENAME;
import static com.example.jspun_sizebook.MainActivity.objectlist;


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
    /**
     * Defining Edittext and objects
     */
    Records record;
    TextView display;
    EditText uname;
    EditText uneck;
    EditText uwaist;
    EditText uhip;
    EditText uchest;
    EditText ucomment;
    EditText ubust;
    EditText uinseam;


    /**
     * On create activity, the following variables are defined by their layout ids and the buttons are inititialized
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_records);
        display = (TextView)findViewById(R.id.displaydatnew);
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

        /**
         * Set up the datebutton to retrieve user date input
         */
        dateButton.setOnClickListener(new View.OnClickListener(){
            //Taken from https://developer.android.com/guide/topics/ui/controls/pickers.html
            //2017-01-28
            @Override
            public void onClick(View v){
                new DatePickerDialog(AddRecords.this,listener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

        /**
         * Set up the save button for use
         */

        saveButton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                record = new Records(uname.getText().toString());

                if (uname.getText().length()==0){
                    uname.setError("Please Enter a Name!");
                }else {
                    /**
                     * Sets the corresponding values to the object
                     Sets the corresponding values to the object and adds the object to the array
                     */
                    record.setName(uname.getText().toString());


                    record.setBust(ubust.getText().toString());
                    record.setChest(uchest.getText().toString());
                    record.setComment(ucomment.getText().toString());
                    record.setHip(uhip.getText().toString());
                    record.setNeck(uneck.getText().toString());
                    record.setInseam(uinseam.getText().toString());
                    record.setWaist(uwaist.getText().toString());
                    record.setDate(display.getText().toString());
                    objectlist.add(record);
                    /**
                     *Finish the acivity and return to main
                     * Saves the object in the disk
                     * *ie. so the array doesnt get cleared with the object upon relaunch
                     */
                    saveInFile();
                    finish();


                }

            }
        });

    }




    /**
     * The Listener for setting the date time to display on textview
     *
     */
    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view,int year,int monthOfYear,int dayofMonth){
            display.setText(year + "/" + (monthOfYear+1) + "/" + dayofMonth);

    }
};

    /**
     * method taken from lonelytwitter to save files on to disk to preserve dependecny
     */
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(objectlist, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            //TODO: Handle the Exception properly later
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
