package com.example.tarea1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityResultado extends AppCompatActivity {

    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        regresar = (Button) findViewById(R.id.btnregresar);
        TextView res = findViewById(R.id.txtresultado);
        Intent intent = getIntent();
        double resultadoo = intent.getDoubleExtra("Resultado", 0.0);
        res.setText(""+resultadoo);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}