package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    List<String> items;

    Button btnAdd;
    EditText etItem;
    RecyclerView rvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        etItem = findViewById(R.id.etItem);
        rvItem = findViewById(R.id.rvItem);

        items = new ArrayList<>();
        items.add("Buy milk");
        items.add("go to the gym");
        items.add("have fun");

        ItemsAdapter itemsAdapter = new ItemsAdapter(items);
        Log.d("MainActivity" , itemsAdapter.getItemCount() + "");
        rvItem.setAdapter(itemsAdapter);
        rvItem.setLayoutManager(new LinearLayoutManager(this ));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String todoItem = etItem.getText().toString();
                 items.add(todoItem);
                 itemsAdapter.notifyItemInserted(items.size() - 1);
                  etItem.setText("");
                      Toast.makeText(getApplicationContext(),"Item was added", Toast.LENGTH_SHORT).show();

         }
      });
    }
}