package com.example.blocodenotas4;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Notas notas;
    EditText editText;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        //fab= findViewById(R.id.fab);

        notas = new Notas(getApplicationContext());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                //Chamada do metodo para salvar o conteúdo
                notas.salvaNota(editText.getText().toString());
            }
        });
    }

    protected void onStart() {
        super.onStart();
        if (notas.contains()) {
            editText.setText(notas.recuperaNota());
        }
    }

   // protected void onPause() {
      //  super.onPause();
        //notas.salvaNota(editText.getText().toString());
   // }
}