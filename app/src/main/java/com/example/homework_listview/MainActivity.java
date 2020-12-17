package com.example.homework_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView= findViewById(R.id.mylistview);
        final EditText editText=findViewById(R.id.namebox);
        Button button=findViewById(R.id.btninsert);
        String[] friendarray ={"Tehrim", "Khizra","Habiba"};
        final ArrayList<String> friendArrayList = new ArrayList<String>(asList(friendarray));
        final ArrayAdapter<String> friendArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friendArrayList);
        listView.setAdapter(friendArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> AdapterView, View view, int Position, long id) {
                                                Toast.makeText(MainActivity.this.getApplicationContext(), "You Clicked" + friendArrayList.get(Position),Toast.LENGTH_SHORT).show();
                                            }
                                        }

        );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametoinsert=editText.getText().toString();
                friendArrayList.add(nametoinsert);
                friendArrayAdapter.notifyDataSetChanged();
            }
        });
    }
}