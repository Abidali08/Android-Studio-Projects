package com.spannerapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    AutoCompleteTextView actxtview;
    ArrayList<String> arrIds = new ArrayList<>();
    ArrayList<String> arrLanguage = new ArrayList<>();
    CardView cardView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        actxtview = findViewById(R.id.actxtview);
        cardView = findViewById(R.id.cardview);

        arrIds.add("100");
        arrIds.add("101");
        arrIds.add("102");
        arrIds.add("103");
        arrIds.add("104");
        arrIds.add("105");
        arrIds.add("106");
        arrIds.add("107");
        arrIds.add("108");
        arrIds.add("109");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrIds);
        spinner.setAdapter(spinnerAdapter);

        arrLanguage.add("C++");
        arrLanguage.add("Python");
        arrLanguage.add("C");
        arrLanguage.add("CSharp");
        arrLanguage.add("Java");

        ArrayAdapter<String> actvAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrLanguage);
        actxtview.setAdapter(actvAdapter);
        actxtview.setThreshold(1);

    }
}