package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public Integer Parse(String text){
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e){
            return null;
        }
    }
    public void onClick(View view){

        EditText edBegin = findViewById(R.id.begin);
        EditText edEnd = findViewById(R.id.end);
        Intent i = new Intent(getApplicationContext(), GameActivity.class);

        Integer begin = Parse(edBegin.getText().toString());
        i.putExtra("begin", begin);

        Integer end = Parse(edEnd.getText().toString());
        i.putExtra("end", end);

        startActivity(i);

    }

}