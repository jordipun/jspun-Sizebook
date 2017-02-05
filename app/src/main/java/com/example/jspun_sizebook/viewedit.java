package com.example.jspun_sizebook;

import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import static android.R.attr.value;
import static android.provider.Telephony.Mms.Part.FILENAME;
import static com.example.jspun_sizebook.MainActivity.objectlist;

public class viewedit extends AppCompatActivity {


    Integer s;
    Records record;
    Calendar calendar = Calendar.getInstance();
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
        setContentView(R.layout.activity_viewedit);
        Bundle extras = getIntent().getExtras();
        if (extras!= null){
             s = extras.getInt("position_id");
        }
        record = objectlist.get(s);



        display = (TextView)findViewById(R.id.textView29);
        uname = (EditText) findViewById(R.id.editText);
        uneck = (EditText) findViewById(R.id.editText2);
        uchest = (EditText) findViewById(R.id.editText4);
        ucomment = (EditText) findViewById(R.id.editcom1);
        uwaist = (EditText)findViewById(R.id.editwnew);
        uhip = (EditText) findViewById(R.id.edithipnew);
        uinseam = (EditText) findViewById(R.id.editinnew);
        ubust = (EditText)findViewById(R.id.editText3);



        uname.setText(record.getName());
        uneck.setText(record.getNeck());
        uchest.setText(record.getChest());
        ucomment.setText(record.getComment());
        uhip.setText(record.getHip());
        uinseam.setText(record.getInseam());
        ubust.setText(record.getBust());
        uwaist.setText(record.getWaist());
        display.setText(record.getDate());


        final Button saveButton = (Button) findViewById(R.id.newsave);
        Button dateButton = (Button) findViewById(R.id.datenew);
        Button deleteButton = (Button) findViewById(R.id.delete);

        dateButton.setOnClickListener(new View.OnClickListener(){
            //Taken from https://developer.android.com/guide/topics/ui/controls/pickers.html
            //2017-01-28
            @Override
            public void onClick(View v){
                new DatePickerDialog(viewedit.this,listener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();


            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {


                if (uname.getText().length()==0){
                    uname.setError("Please Enter a Name!");
                }else {
                    record.setName(uname.getText().toString());


                    record.setBust(ubust.getText().toString());
                    record.setChest(uchest.getText().toString());
                    record.setComment(ucomment.getText().toString());
                    record.setHip(uhip.getText().toString());
                    record.setNeck(uneck.getText().toString());
                    record.setInseam(uinseam.getText().toString());
                    record.setWaist(uwaist.getText().toString());
                    record.setDate(display.getText().toString());
                    saveInFile();

                    finish();
                }




            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectlist.remove(record);
                saveInFile();
                finish();
            }
        });
    }








    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayofMonth){
            display.setText(year + "/" + (monthOfYear+1) + "/" + dayofMonth);

        }
    };

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
