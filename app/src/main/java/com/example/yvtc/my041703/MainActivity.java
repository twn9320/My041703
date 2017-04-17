package com.example.yvtc.my041703;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView);
        img2 = (ImageView) findViewById(R.id.imageView2);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        ImageRequest request = new ImageRequest("https://uc.udn.com.tw/photo/2017/04/10/1/3379440.jpg", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                img.setImageBitmap(response);
                Log.d("NET","GET IT");
            }
        }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("NET","Error");
            }
        });
        queue.add(request);
        queue.start();


        Picasso.with(MainActivity.this).load("https://uc.udn.com.tw/photo/2017/04/10/1/3379440.jpg").into(img2);  //Picasso用法
    }
}
