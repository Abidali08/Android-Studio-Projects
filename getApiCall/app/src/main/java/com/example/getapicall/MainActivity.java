package com.example.getapicall;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.getapicall.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    ArrayList<String> Student;
    Handler mainHandler = new Handler();
    ProgressDialog progressDialog;
    ArrayAdapter<String> ListAdapter;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initializedlist();

        binding.fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new fetchdata().start();
            }
        });


    }


    void initializedlist()
    {
        Student = new ArrayList<>();
        ListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Student);
        binding.listview.setAdapter(ListAdapter);
    }
    class fetchdata extends Thread
    {
        String data = "";

        @Override
        public void run() {

            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setMessage("Fetching data");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                }
            });

            try {
                URL url = new URL("https://api.npoint.io/8d8df57b1ac46aeb49d");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;

                while ((line = bufferedReader.readLine()) != null)
                {
                    data = data + line;
                }
                if (!data.isEmpty())
                {
                    JSONObject jsonObject = new JSONObject(data);
                    JSONArray jsonArray = jsonObject.getJSONArray("Users");
                    Student.clear();
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject names = jsonArray.getJSONObject(i);
                        System.out.println(names);
                        String name = names.getString("name");
                        Student.add(name);
                    }
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    if(progressDialog.isShowing())
                    {
                        progressDialog.dismiss();
                    }
                    ListAdapter.notifyDataSetChanged();
                }
            });
        }

    }
}