package com.example.calculadora_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora_IOT extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_iot);

        Toast toast = Toast.makeText(this,"Activity 2",Toast.LENGTH_LONG);
        toast.show();

        Intent intent = getIntent();
        String message= intent.getStringExtra("numero");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    public void calculadora(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.finish();
        startActivity(intent);
    }
}