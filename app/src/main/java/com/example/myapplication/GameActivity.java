package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    int begin, end;
    Button yes, no;
    TextView message, beginView, endView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent i = getIntent();
        begin = i.getIntExtra("begin", 0);
        end = i.getIntExtra("end", 100);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);

        beginView = findViewById(R.id.begin);
        endView = findViewById(R.id.end);

        Log.d("MyBegin", String.valueOf(begin));
        Log.d("MyEnd", String.valueOf(end));

        message = findViewById(R.id.message);
        message.setText("Is your number greater than " + (begin + end)/2);

        beginView.setText(String.valueOf(begin));
        endView.setText(String.valueOf(end));
    }

    public void onClick(View view){

        if(view == yes) {
            begin = (begin + end) / 2 + 1;
        }

        if(view == no){
            end = (begin + end) / 2;
        }

        beginView.setText(String.valueOf(begin));
        endView.setText(String.valueOf(end));

        if(end-begin == 0){
            yes.setVisibility(View.GONE);
            no.setVisibility(View.GONE);
            message.setText("Your number is " + begin);
            return;
        }

        if(end - begin > 1){
            message.setText("Is your number greater than " + (begin + end)/2);
        } else {
            message.setText("Is your number " + end);
        }

    }

}