package com.example.androidapp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.androidapp.R;
import com.example.androidapp.ext.GsonRequest;
import com.example.androidapp.model.Person;
import com.example.androidapp.utils.LogUtil;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 2017/5/12 butter knife

        requestQueue = Volley.newRequestQueue(this);
    }

    public void submit(View view) {
        // TODO: 2017/5/12 GsonRequest 泛型
        requestQueue.add(new GsonRequest<>("http://192.168.3.117:8080/A", Person.class, new Response.Listener<Person>() {
            @Override
            public void onResponse(Person response) {
                LogUtil.d("name:" + response.name);
                LogUtil.d("age:" + response.age);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage());
            }
        }));
    }
}
