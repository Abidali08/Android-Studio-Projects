package com.arraylistcrud;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    Button btndetails;
    ListView std_listview;
    ArrayList<String> std_data = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        btndetails = findViewById(R.id.btndetails);
        std_listview = findViewById(R.id.std_listview);
        btndetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Intent next;
                next = new Intent(DetailsActivity.this,MainActivity.class);
               startActivity(next);*/
                finish();
            }
        });

        show();




    }
    void show()
    {
        Intent intent = getIntent();
        std_data = intent.getStringArrayListExtra("std_name");

        if (std_data == null) {
            std_data = new ArrayList<>();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, std_data);
        std_listview.setAdapter(adapter);

        std_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                std_data.remove(i);
                adapter.notifyDataSetChanged();


            }
        });


    }
}