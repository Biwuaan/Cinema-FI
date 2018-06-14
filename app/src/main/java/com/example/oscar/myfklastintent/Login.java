package com.example.oscar.myfklastintent;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oscar.myfklastintent.Utilidades.Datos_Utilidades;

public class Login extends AppCompatActivity {

    EditText usuarioNombre, usuarioContrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        usuarioNombre = (EditText)findViewById(R.id.usuarionombre);
        usuarioContrasena = (EditText)findViewById(R.id.usuariocontrasena);

    }

    public void iniciar (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        String usuarioName = usuarioNombre.getText().toString();
        String usuarioPassword = usuarioContrasena.getText().toString();
        Cursor fila = db.rawQuery("select "+ Datos_Utilidades.UcampoNomU+", "+Datos_Utilidades.UcampoContra+" from "+Datos_Utilidades.tablaUsuarios+" where "+Datos_Utilidades.UcampoNomU+" = '"+usuarioName+"' and "+Datos_Utilidades.UcampoContra+" = '"+usuarioPassword+"'",null);

        if (!usuarioName.isEmpty() && !usuarioPassword.isEmpty()){

            if(usuarioName.contentEquals("ldp@admin.com") && usuarioPassword.contentEquals("Admin123")){
                String administrador = "ldp@admin.com";
                Intent i = new Intent(this, Menu_Administrador.class);
                i.putExtra("admin", administrador);
                startActivity(i);
            }else{
                try {

                    fila.moveToFirst();
                    String NomU = fila.getString(0);
                    String NomC = fila.getString(1);
                    fila.close();

                    if (usuarioName.contentEquals(NomU) && usuarioPassword.contentEquals(NomC)) {
                        Toast.makeText(this, "Existes", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(this, "Usuario no Existente", Toast.LENGTH_SHORT).show();
                }
            }

        }else{
            Toast.makeText(this, "Llena todas las casillas", Toast.LENGTH_SHORT).show();
        }

    }

    public void registrar(View view){
        Intent myIntent = new Intent(view.getContext(), Registro.class);
        startActivity(myIntent);
    }

}
