package com.example.oscar.myfklastintent;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.oscar.myfklastintent.Utilidades.Datos_Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    EditText usuarioNomU, usuarioContras, usuarioNombReal, usuarioEmail, usuarioNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuarioNomU = (EditText)findViewById(R.id.usuario_Nombre);
        usuarioContras = (EditText)findViewById(R.id.usuario_Contrasena);
        usuarioNombReal = (EditText)findViewById(R.id.usuario_NombreReal);
        usuarioEmail = (EditText)findViewById(R.id.usuario_Correo);
        usuarioNacimiento = (EditText)findViewById(R.id.usuario_Nacimiento);

    }

    public void registrado(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administrar", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String usuarioNom = usuarioNomU.getText().toString();
        String usuarioContra = usuarioContras.getText().toString();
        String usuarioNombRl = usuarioNombReal.getText().toString();
        String usuarioCorreo = usuarioEmail.getText().toString();
        String usuarioBirthday = usuarioNacimiento.getText().toString();
        float saldo = 100.00f;

         if(usuarioNom.isEmpty() || usuarioContra.isEmpty() || usuarioNombRl.isEmpty()
                || usuarioCorreo.isEmpty() || usuarioBirthday.isEmpty()){
            Toast.makeText(this, "Debes llenar todas las casillas", Toast.LENGTH_SHORT).show();
         }else{
            if(!validarEmail(usuarioCorreo)){
                Toast.makeText(this,"Ingrese un formato de correo valido",Toast.LENGTH_SHORT).show();
            }
            else{
                if (!validarContra(usuarioContra)){
                    Toast.makeText(this,"Ingrese un formato de contraseña valido",Toast.LENGTH_SHORT).show();
                }else{
                    if(!validarFecha(usuarioBirthday)){
                        Toast.makeText(this,"Ingrese un formato de fecha valido",Toast.LENGTH_SHORT).show();
                    }else{

                        ContentValues alta = new ContentValues();
                        alta.put(Datos_Utilidades.UcampoNomU, usuarioNom);
                        alta.put(Datos_Utilidades.UcampoContra, usuarioContra);
                        alta.put(Datos_Utilidades.UcampoNombre, usuarioNombRl);
                        alta.put(Datos_Utilidades.UcampoCorreo, usuarioCorreo);
                        alta.put(Datos_Utilidades.UcampoFechaN, usuarioBirthday);
                        alta.put(Datos_Utilidades.UcampoSaldo, saldo);


                        Long id = db.insert(Datos_Utilidades.tablaUsuarios, Datos_Utilidades.UcampoId, alta);

                        Toast.makeText(getApplicationContext(),"Id registro:" + id , Toast.LENGTH_SHORT).show();
                        //Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                        db.close();

                        Intent myIntent = new Intent(view.getContext(), Login.class);
                        startActivity(myIntent);
                    }
                }
            }
        }

    }

    private boolean validarEmail(String email) {
        String patron = "^[^\\_](\\w)+([\\w\\.\\-])*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,5})+";
        Pattern pattern = Pattern.compile(patron);
        Matcher match = pattern.matcher(email);
        return match.matches();
    }

    private boolean validarContra(String contra) {
        String patron = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d$@$!%*?&]{6,15}";
        Pattern pattern = Pattern.compile(patron);
        Matcher match = pattern.matcher(contra);
        return match.matches();
    }

    private boolean validarFecha(String fecha) {
        String patron = "^(19[0-9][0-9]|20[0-2][0-9])-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
        Pattern pattern = Pattern.compile(patron);
        Matcher match = pattern.matcher(fecha);
        return match.matches();
    }


}
