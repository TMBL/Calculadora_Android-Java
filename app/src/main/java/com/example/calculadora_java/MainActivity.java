package com.example.calculadora_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button sum,res,mul,div;
    private EditText numero1,numero2;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast toast = Toast.makeText(this,"Activity 1",Toast.LENGTH_LONG);
        toast.show();

        /*Valores*/
        numero1=findViewById(R.id.Numero1);
        numero2=findViewById(R.id.Numero2);
        total=findViewById(R.id.Total);

        /*Operaciones*/
        sum=findViewById(R.id.btn_suma);
        res=findViewById(R.id.btn_resta);
        mul=findViewById(R.id.btn_multiplicacion);
        div=findViewById(R.id.btn_division);

        /*Evento OnClick*/
        sum.setOnClickListener(this::onClick);
        res.setOnClickListener(this::onClick);
        mul.setOnClickListener(this::onClick);
        div.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        try{
            Double a= Double.valueOf(String.valueOf(numero1.getText()));
            Double b= Double.valueOf(String.valueOf(numero2.getText()));
            switch (view.getId()){
                case R.id.btn_suma:
                    total.setText(String.valueOf(a+b));
                    break;
                case R.id.btn_resta:
                    total.setText(String.valueOf(a-b));
                    break;
                case R.id.btn_multiplicacion:
                    total.setText(String.valueOf(a*b));
                    break;
                case R.id.btn_division:
                    total.setText(String.valueOf(a/b));
                    break;
            }
        }
        catch(Exception e){
            if (numero2.getText().length()==0){
                total.setText("Falta ingresar valor 2");
            }

            if (numero1.getText().length()==0) {
                total.setText("Falta ingresar valor 1");
            }
        }
    }

    public void calculadoraIot(View view){
        Intent intent = new Intent(this, Calculadora_IOT.class);
        intent.putExtra("numero", total.getText());
        this.finish();
        startActivity(intent);
    }
}