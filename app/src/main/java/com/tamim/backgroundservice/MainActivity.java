package com.tamim.backgroundservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    EditText edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.editText);
    }

    public void StartService(View view) {
        String input = edit.getText().toString();

        Intent serviceIntent = new Intent(this, ExampleSrvice.class);
        serviceIntent.putExtra("inputExtra", input);

        ContextCompat.startForegroundService(this,serviceIntent);


    }

    public void StopService(View view) {
        Intent serviceIntent = new Intent(this, ExampleSrvice.class);
        stopService(serviceIntent);
    }
}