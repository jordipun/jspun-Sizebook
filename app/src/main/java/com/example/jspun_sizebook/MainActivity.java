package com.example.jspun_sizebook;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import static android.provider.Telephony.Mms.Part.FILENAME;
import static com.example.jspun_sizebook.R.id.addnew;


/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The constant recordList.
     */
    public static ListView recordList;
    /**
     * The Adapter.
     */
    public static ArrayAdapter<Records> adapter;
    /**
     * The Objectlist.
     */
    public static ArrayList<Records> objectlist;


    /**
     * OnCreate creates the initial object list and listview
     * init method to initialize button
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objectlist = new ArrayList<Records>();
        recordList = (ListView) findViewById(R.id.recordList);
        init();

        /**
         * Initizalze item click and send the position of the object from the list to the activity
         */
        recordList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent viewintent = new Intent(MainActivity.this, viewedit.class);
                viewintent.putExtra("position_id", position);
                startActivity(viewintent);





            }
        });





    }

    /**
     * Initizalized add button clicker
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

    /**
     * Load from file ensures persistence in the case of the app terminating
     * also initialzes the adapter
     */

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();



        adapter = new ArrayAdapter<Records>(this, R.layout.record_list, objectlist);
        recordList.setAdapter(adapter);

    }


    /**
     * method for loadfromfile taken from lonelytwitter to ensure persistence and data content
     * in the case of the app closing
     */

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Records>>(){}.getType();

            objectlist = gson.fromJson(in,listType);

            //taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            //2017-01-24 18:19

        } catch (FileNotFoundException e) {
            objectlist= new ArrayList<Records>();
            // TODO Auto-generated catch block

        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

    }

}
