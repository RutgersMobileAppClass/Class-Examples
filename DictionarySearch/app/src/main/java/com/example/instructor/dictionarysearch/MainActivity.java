package com.example.instructor.dictionarysearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private EditText edittext;
    private Button searchButton;
    private TextView definitionText;
    private HashMap<String,String> dictionaryList = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = (EditText) findViewById(R.id.editText);
        searchButton = (Button) findViewById(R.id.searchButton);
        definitionText = (TextView) findViewById(R.id.definitionText);

        addAllDefinitions();

    }

    public void searchButtonClick(View view) {
        String word = edittext.getText().toString();
        if(dictionaryList.containsKey(word.toLowerCase().trim())){
            String definition = dictionaryList.get(word.toLowerCase().trim());
            definitionText.setText(definition);
        }else{
            definitionText.setText("Word not found!");
        }

    }

    public void addAllDefinitions(){
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.grewords));

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] pieces = line.split("\t");
            dictionaryList.put(pieces[0],pieces[1]);

        }


    }
}
