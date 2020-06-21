package com.jasjotsingh.shoppinglist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    ListView list;
    List<String> input = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    String[] array = new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        list = findViewById(R.id.list);
        input.add("My Shopping List");

        if (savedInstanceState!=null){
            array =  savedInstanceState.getStringArray("input");
            if (array!=null){
                for (int i =0;i<array.length;++i){
                    input.set(i,array[i]);
                }
            }

        }

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_checked, android.R.id.text1, input);
        list.setAdapter(adapter);


        if (getIntent().getExtras() != null) {
            populateItems();
        }
    }

    public void AddItem(View view) {
        Intent intent = new Intent(MainActivity.this, ItemActivity.class);
        startActivity(intent);
    }

    public void populateItems() {
        input.add(getIntent().getExtras().getString("item"));
        Bundle bundle = new Bundle();
        for (int i =0;i<input.size();++i){
            array[i] = input.get(i);
        }
        bundle.putStringArray("input", array);
        onSaveInstanceState(bundle);

    }

}