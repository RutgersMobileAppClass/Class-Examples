package com.example.instructor.dictionarygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private TextView displayedWord;
    private ListView definitionList;
    private HashMap<String,String> dictionary = new HashMap<>();
    private ArrayList<String> randomList;
    private ArrayList<String> displayedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        definitionList = (ListView) findViewById(R.id.definitionList);
        displayedWord = (TextView) findViewById(R.id.displayedWord);
        readAllDefinitions();

    }

    private void readAllDefinitions(){
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.grewords));

        while(scan.hasNextLine()){
            String currentLine = scan.nextLine();
            String[] pieces = currentLine.split("\t");
            dictionary.put(pieces[0],pieces[1]);
        }

        randomList = new ArrayList<>(dictionary.keySet());
        Collections.shuffle(randomList);
        ArrayList<String> displayedList = new ArrayList<>();
        for(int i = 0; i <= 4; i++){
            displayedList.add(randomList.get(i));
        }

        ArrayAdapter<String> name = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                displayedList);
        definitionList.setAdapter(name);


    }
}
