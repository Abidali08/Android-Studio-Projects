package com.example.crudapprecyclerview;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Tour> data = new ArrayList<>();
    TourAdapter tourAdapter;
    FloatingActionButton btnOpenDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        btnOpenDialog = findViewById(R.id.btnopenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        data.add(new Tour(R.drawable.ic_launcher_background,"Karachi"));
        data.add(new Tour(R.drawable.ic_launcher_background,"Hyderabad"));
        data.add(new Tour(R.drawable.ic_launcher_background,"Larkhana"));
        data.add(new Tour(R.drawable.ic_launcher_background,"Rawalpindi"));
        data.add(new Tour(R.drawable.ic_launcher_background,"Lahore"));
        data.add(new Tour(R.drawable.ic_launcher_background,"Multan"));
        data.add(new Tour(R.drawable.ic_launcher_background,"Islamabad"));
        data.add(new Tour(R.drawable.ic_launcher_background,"Sukkar"));
        data.add(new Tour(R.drawable.ic_launcher_background,"Gilgit"));
        data.add(new Tour(R.drawable.ic_launcher_background,"Hunza"));

        tourAdapter = new TourAdapter(this,data);
        recyclerView.setAdapter(tourAdapter);

    }
}