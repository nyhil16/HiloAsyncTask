package com.example.hiloasynctask;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends Activity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tv1 = findViewById(R.id.txtResultado);
        String nombreUsuario = getIntent().getStringExtra("usuario");
        tv1.setText(nombreUsuario);


    }

}
