package com.example.tarea1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnsuma, btnresta,btndivision,btnmullti;
    EditText numero1;
    EditText numero2;
    String resul;
    double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = (EditText) findViewById(R.id.num1);
        numero2 = (EditText) findViewById(R.id.num2);

        btnsuma = (Button) findViewById(R.id.btnsuma);
        btnresta = (Button) findViewById(R.id.btnresta);
        btndivision = (Button) findViewById(R.id.btndivision);
        btnmullti = (Button) findViewById(R.id.btnmultiplicacion);

        btnsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumarDosNumeros();
                limpiar();
                Intent intent = new Intent(getApplicationContext(),ActivityResultado.class);
                intent.putExtra("Resultado",resultado);
                startActivity(intent);
            }

        });
        btnresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restarDosNumeros();
                limpiar();
                Intent intent = new Intent(getApplicationContext(),ActivityResultado.class);
                intent.putExtra("Resultado",resultado);
                startActivity(intent);
            }
        });
        btndivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Double.parseDouble(numero2.getText().toString()) == 0){
                    Toast.makeText(MainActivity.this, "No se puede dividir entre cero.", Toast.LENGTH_SHORT).show();
                }
                else {
                    dividirDosNumeros();
                    limpiar();
                    Intent intent = new Intent(getApplicationContext(),ActivityResultado.class);
                    intent.putExtra("Resultado",resultado);
                    startActivity(intent);
                }
            }
        });
        btnmullti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiDosNumeros();
                limpiar();
                Intent intent = new Intent(getApplicationContext(),ActivityResultado.class);
                intent.putExtra("Resultado",resultado);
                startActivity(intent);
            }
        });
    }

    private void multiDosNumeros() {
        if(numero1.getText().toString().isEmpty() || numero2.getText().toString().isEmpty())
        {
            validaciones();
        }
        else {
            double num1 = Double.parseDouble(numero1.getText().toString());
            double num2 = Double.parseDouble(numero2.getText().toString());
            resultado = num1 * num2;
        }
    }

    private void dividirDosNumeros() {
        if(numero1.getText().toString().isEmpty() || numero2.getText().toString().isEmpty())
        {
            validaciones();
        }
        else {
            double num1 = Double.parseDouble(numero1.getText().toString());
            double num2 = Double.parseDouble(numero2.getText().toString());
            resultado = num1 / num2;
        }
    }

    private void restarDosNumeros() {
        if(numero1.getText().toString().isEmpty() || numero2.getText().toString().isEmpty())
        {
            validaciones();
        }
        else {
            double num1 = Double.parseDouble(numero1.getText().toString());
            double num2 = Double.parseDouble(numero2.getText().toString());
            resultado = num1 - num2;
        }
    }

    public void sumarDosNumeros()
    {
        if(numero1.getText().toString().isEmpty() || numero2.getText().toString().isEmpty())
        {
            validaciones();
        }
        else {
            double num1 = Double.parseDouble(numero1.getText().toString());
            double num2 = Double.parseDouble(numero2.getText().toString());
            resultado = num1 + num2;
        }
    }

    public void validaciones(){
        if(numero1.getText().toString().isEmpty() && numero2.getText().toString().isEmpty())
        {
            Toast.makeText(this,"ALERTA, NO DEJAR CAMPOS VACIOS", Toast.LENGTH_LONG).show();
        }
        else if(numero1.getText().toString().isEmpty())
        {
            Toast.makeText(this,"ALERTA, INGRESE EL NUMERO 1", Toast.LENGTH_LONG).show();
        }
        else if(numero2.getText().toString().isEmpty())
        {
            Toast.makeText(this,"ALERTA, INGRESE EL NUMERO 2", Toast.LENGTH_LONG).show();
        }
    }

    public void limpiar(){
        numero1.setText("");
        numero2.setText("");
    }
}