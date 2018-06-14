package com.example.oscar.myfklastintent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscar.myfklastintent.Utilidades.Datos_Utilidades;

public class Menu_Administrador extends AppCompatActivity {

    TextView administrador, num_Usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__administrador);

        num_Usuarios = (TextView)findViewById(R.id.numUsuarios);

        administrador = (TextView)findViewById(R.id.admin);
        String admin = getIntent().getStringExtra("admin");
        administrador.setText(admin);

        AdminSQLiteOpenHelper bd = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = bd.getReadableDatabase();

        String query = " SELECT COUNT(*) FROM " +Datos_Utilidades.tablaUsuarios;
        Cursor cuenta = db.rawQuery(query,null);
        cuenta.moveToFirst();
        num_Usuarios.setText(cuenta.getInt(0));
        Toast.makeText(this, "Num User: " +num_Usuarios, Toast.LENGTH_SHORT).show();




    }
}


