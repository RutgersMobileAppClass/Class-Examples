package com.example.instructor.dictionarygamelistview;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private ListView definitionList;
    private TextView displayedWord;
    private HashMap<String, String> dictionary;
    private ArrayList<String> displayedDefinitions;
    private ArrayList<String> randomizedWords;
    private String correctWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        definitionList = (ListView) findViewById(R.id.definitionList);
        displayedWord = (TextView) findViewById(R.id.displayedWord);
        dictionary = new HashMap<>();

        populateDictionary();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,displayedDefinitions);
        definitionList.setAdapter(adapter);

        definitionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedDefinition = definitionList.getItemAtPosition(position).toString();
                String correctDefinition = dictionary.get(correctWord);

                if(selectedDefinition.equals(correctDefinition)){
                    Toast.makeText(MainActivity.this, "You're right!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "You're wrong!", Toast.LENGTH_SHORT).show();
                }



            }
        });

        System.out.println("Oncreate!");


    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("OnPause!");
    }

    private void populateDictionary(){

        // Read the file into the hashmap
        Scanner scan = new Scanner(getResources().openRawResource(R.raw.grewords));
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] pieces = line.split("\t");
            dictionary.put(pieces[0],pieces[1]);
        }

        // Randomized word collection
        randomizedWords = new ArrayList<>(dictionary.keySet());
        Collections.shuffle(randomizedWords);

        correctWord = randomizedWords.get(0);
        displayedWord.setText(correctWord);


        // Populating the displayed array list on the screen
        displayedDefinitions = new ArrayList<>();
        for(int i = 0; i <5; i++){
            String word = randomizedWords.get(i);
            String definition = dictionary.get(word);
            displayedDefinitions.add(definition);
        }








    }


}
