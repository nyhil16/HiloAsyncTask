package com.example.hiloasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button b1;
    ProgressBar pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txtUsuario);
        et2 = findViewById(R.id.txtClave);
        b1 = findViewById(R.id.btnIniciar);
        pb1 = findViewById(R.id.progressBar);
        pb1.setVisibility(View.INVISIBLE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task1().execute(et1.getText().toString());
            }
        });


    }

    class Task1 extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            pb1.setVisibility(View.VISIBLE);
            b1.setEnabled(false);
        }


        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return strings[0];
        }

        @Override
        protected  void onPostExecute(String s) {
            pb1.setVisibility(View.INVISIBLE);
            b1.setEnabled(false);
            Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
            intent.putExtra("usuario", et1.getText().toString());
            startActivity(intent);
        }

    }

}