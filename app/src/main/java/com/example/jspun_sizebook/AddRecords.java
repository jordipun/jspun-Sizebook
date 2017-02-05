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
     * The Calendar object.
     */
    Calendar calendar = Calendar.getInstance();
    /**
     * The Display.
     */
    TextView display;
    /**
     * The Uname.
     */
    EditText uname;
    /**
     * The Uneck.
     */
    EditText uneck;
    /**
     * The Uwaist.
     */
    EditText uwaist;
    /**
     * The Uhip.
     */
    EditText uhip;
    /**
     * The Uchest.
     */
    EditText uchest;
    /**
     * The Ucomment.
     */
    EditText ucomment;
    /**
     * The Ubust.
     */
    EditText ubust;
    /**
     * The Uinseam.
     */
    EditText uinseam;


    /**
     *The following onCreate method initializes all EditText and TextView from the layout
     * Also sets up the buttons for use
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
         * Sets up the datebutton for onclick
         * Retrieves the user selected dates and sends to listener
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
         * Sets up saveButton for onclick
         * Creates a record object and sets the values in the object if the user enters a name
         * FLAW ALERT: When the user enters a line of spaces instead, no error will occur as a space
         * is still considered a character.
         * Adds this new object into the list of arrays to be added to the listview in Main
         */
        saveButton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                Records record = new Records(uname.getText().toString());
                /**
                 * Checks if the user leaves the name empty
                 */
                if (uname.getText().length()==0){
                    uname.setError("Please Enter a Name!");
                }else {
                    /**
                     * Sets the corresponding values to the object and adds the object to the array
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
                     * Saves the object in the disk
                     *ie. so the array doesnt get cleared with the object upon relaunch
                     */
                    saveInFile();

                    /**
                     * end the activity and return to main
                     */
                    finish();


                }

            }
        });

    }


    /**
     * The Listener.
     * Sets the text on textview to the user selected date
     */
    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view,int year,int monthOfYear,int dayofMonth){
            display.setText(year + "/" + (monthOfYear+1) + "/" + dayofMonth);

    }
};

    /**
     * Method for saving the object into the disk
     * taken from Lonelytwitter lab
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
