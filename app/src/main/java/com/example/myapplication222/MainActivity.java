package com.example.myapplication222;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    TextView tv2;

    //   public static final String URL = "https://developers.zomato.com/api/v2.1/reviews?res_id=9186&start=0&count=100\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.tv);
        tv2=(TextView) findViewById(R.id.tv2);


        String url = "https://developers.zomato.com/api/v2.1/restaurant?res_id=9186";

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("aaaaaaaaaaaaa", response);

                try {


                    JSONObject jsonObject1 = new JSONObject(response);



                    JSONObject employee = jsonObject1.getJSONObject("location");

                    // tv.setText(jsonObject1.getString("address"));
                    tv2.setText(employee.getString("address"));

                    tv.setText(employee.getString("city"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                        //creating a hero object and giving them the values from json object



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();

            }
        }) {    //this is the part, that adds the header to the request
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user-key", "fb389f073ed04e9144195b2073424aca");
                params.put("Accept", "application/json");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
