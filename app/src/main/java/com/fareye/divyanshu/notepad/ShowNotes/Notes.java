package com.fareye.divyanshu.notepad.ShowNotes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.fareye.divyanshu.notepad.R;

import java.io.File;
import java.util.ArrayList;

public class Notes extends AppCompatActivity {

    Button addaNote;
    EditText password;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        addaNote = (Button) findViewById(R.id.button);
        password = (EditText) findViewById(R.id.editText3);

        String path = Environment.getExternalStorageDirectory().toString() + "/Notes";
        Log.d("Files", "Path: " + path);
        File directory = new File(path);

        File[] files = directory.listFiles();
        Log.d("Files", "Size: " + files.length);

        ArrayList<String> arrayListOfFiles = new ArrayList<String>();
        for (int i = 0; i < files.length; i++) {
            arrayListOfFiles.add(files[i].getName());
            Log.d("Files", "FileName:" + files[i].getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayListOfFiles);

        listView.setAdapter(arrayAdapter);

        

        addaNote.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals("123456")) {
                    Log.d("AddaNote is working", "going to yournote class");
                    startActivity(new Intent(Notes.this, YourNote.class));
                }
            }
        });
    }
}