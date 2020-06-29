package com.example.synchronization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button syncBtn = findViewById(R.id.syncBtn);
        syncBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Intent.ACTION_SYNC);
                Calendar now = Calendar.getInstance();
                int hour = now.get(Calendar.HOUR_OF_DAY);
                if (hour >=6  && hour<14) {
                    intent.setData(Uri.parse("http://morning"));
                }else if (hour >=14  && hour<15){
                    intent.setData(Uri.parse("http://afternoon"));
                }else if (hour >=15 || hour < 6){
                    intent.setData(Uri.parse("http://evening"));
                }
                startActivity(intent);
            }
        });
    }
}
