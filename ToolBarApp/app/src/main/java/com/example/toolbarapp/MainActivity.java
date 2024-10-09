package com.example.toolbarapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My ToolBar");
        }
        toolbar.setTitle("My tool Bar");
        toolbar.setSubtitle("Sub Titles");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();

        if(item_id==R.id.opt_new)
        {
            Toast.makeText(this, "Created New Folder", Toast.LENGTH_SHORT).show();
        }
        else if(item_id==R.id.opt_open)
        {
            Toast.makeText(this, "open Folder Successfully", Toast.LENGTH_SHORT).show();
        } else if (item_id==android.R.id.home) {
            Toast.makeText(this, "Welcome To Home", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        } else
        {
            Toast.makeText(this, "Folder Have been Deleted", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}