package com.example.apiapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);
        // Fetch data from JSONPlaceholder
        fetchPosts();

    }
    private void fetchPosts() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,new Response.Listener<JSONArray>()
        {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject post = response.getJSONObject(i);
                                int userId = post.getInt("userId");
                                int id = post.getInt("id");
                                String title = post.getString("title");
                                String body = post.getString("body");

//                                Post p = new Post(userId, id, title, body);
//                                postList.add(p);

                                // Log the data or do something with it
                                Log.d("Post", "UserId: " + userId + ", ID: " + id + ", Title: " + title + ", Body: " + body);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley Error", error.toString());
                    }
                });

        requestQueue.add(jsonArrayRequest);
    }
}