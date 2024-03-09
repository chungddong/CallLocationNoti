package com.sophra.calllocationnoti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_main; //리사이클러뷰
    ArrayList<CallNumberClass> items = new ArrayList<CallNumberClass>(); //전화번로 리스트 클래스
    CallNumberListAdapter rvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //리스트뷰 바인딩
        rv_main = findViewById(R.id.rv_main);
        rvAdapter = new CallNumberListAdapter();

        rv_main.setAdapter(rvAdapter);
        rv_main.setLayoutManager(new LinearLayoutManager(this));

        items.add(new CallNumberClass("1111","대충메모"));
        items.add(new CallNumberClass("2222","대충메모"));
        items.add(new CallNumberClass("3333","대충메모"));
        items.add(new CallNumberClass("4444","대충메모"));
        items.add(new CallNumberClass("5555","대충메모"));
        items.add(new CallNumberClass("6666","대충메모"));
        items.add(new CallNumberClass("7777","대충메모"));
        items.add(new CallNumberClass("8888","대충메모"));


        rvAdapter.setList(items);



        //ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.list_item, (List) listView_main);

        //listView_main.setAdapter(adapter);

    }
}