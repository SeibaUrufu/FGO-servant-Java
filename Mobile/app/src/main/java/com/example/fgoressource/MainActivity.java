package com.example.fgoressource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fgoressource.NA.MainView.NAServantList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VolleyRequestQueue.getInstance(this);

        Button global = (Button) findViewById(R.id.versionNA);
        Button japan = (Button) findViewById(R.id.versionJP);

        global.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent na = new Intent(MainActivity.this, NAServantList.class);

                try {
                    startActivity(na);
                } catch (ActivityNotFoundException e) {
                    Log.e("Error Intent", e.getMessage());
                }

            }
        });

        japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"WIP", Toast.LENGTH_SHORT).show();
            }
        });
    }
}