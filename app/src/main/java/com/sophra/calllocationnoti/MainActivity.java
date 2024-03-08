package com.sophra.calllocationnoti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //리스트뷰 바인딩
        listView_main = findViewById(R.id.listview_main);

        List<String> testlist = new ArrayList<String>();

        testlist.add("dsfsdf");
        testlist.add("dsfsdf");
        testlist.add("dsfsdf");

        //ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.list_item, (List) listView_main);

        //listView_main.setAdapter(adapter);

    }
}