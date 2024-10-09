package com.arraylistcrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtname;
    Button btnapply,btndetails;
    ArrayList<String> std_name = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtname = findViewById(R.id.edtname);
        btnapply = findViewById(R.id.btnapply);
        btndetails = findViewById(R.id.btndetails);

        btnapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                std_name.add(edtname.getText().toString());
                Toast.makeText(MainActivity.this, "Successfully Done!", Toast.LENGTH_SHORT).show();
            }
        });

        btndetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainActivity.this,DetailsActivity.class);
                next.putStringArrayListExtra("std_name",std_name);
                startActivity(next);
            }
        });

    }
}