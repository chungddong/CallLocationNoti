package com.sophra.calllocationnoti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_main;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //리스트뷰 바인딩
        rv_main = findViewById(R.id.rv_main);

        //ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.list_item, (List) listView_main);

        //listView_main.setAdapter(adapter);

    }
}