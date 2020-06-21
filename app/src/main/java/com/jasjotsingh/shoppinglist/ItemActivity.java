package com.jasjotsingh.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> input = new ArrayList<String>();
    Context context = ItemActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        init();
        for (int i = 0;i<12;++i){
            input.add("Item "+i);
        }
        adapter = new ArrayAdapter<String>(ItemActivity.this,android.R.layout.simple_list_item_2,
                android.R.id.text1, input);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(ItemActivity.this,MainActivity.class);
                intent.putExtra("item",item);
                startActivity(intent);
            }
        });
    }
    public void init(){
        listView = findViewById(R.id.listView);
    }
}