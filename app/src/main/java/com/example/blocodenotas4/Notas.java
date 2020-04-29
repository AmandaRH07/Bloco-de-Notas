package com.example.blocodenotas4;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Notas {
    SharedPreferences preferencias;
    SharedPreferences.Editor editor;
    Context context;

    private static final String PREFERENCIAS_FILE = "Notas";

    public Notas(Context c) {
        this.context = c;
        preferencias = this.context.getSharedPreferences(PREFERENCIAS_FILE, Context.MODE_PRIVATE);
        editor = preferencias.edit();
    }

    public void salvaNota(String S) {
        editor.putString("Notas", S);
        editor.commit();
        //Log.i( preferencias.getString("Notas","Não foi possível recuperar a chave") );
    }


    public String recuperaNota() {
        if (this.preferencias.contains("Notas")) {
            String s = "";//context.getResources().getString(R.string.nota_recuperada);
            Toast.makeText(context, s, Toast.LENGTH_LONG).show();
            return this.preferencias.getString("Notas", " ");
        } else {
            return " ";
        }
    }

    public boolean contains() {
        return preferencias.contains("Notas");
    }
}