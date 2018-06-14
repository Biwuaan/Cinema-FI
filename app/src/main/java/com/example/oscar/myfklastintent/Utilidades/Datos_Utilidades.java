package com.example.oscar.myfklastintent.Utilidades;

public class Datos_Utilidades {

    public static final String tablaUsuarios = "Usuarios";
    public static final String UcampoId = "usuarios_id";
    public static final String UcampoNomU = "usuario_nombreUs";
    public static final String UcampoNombre = "usuarios_nombre";
    public static final String UcampoCorreo = "usuarios_correo";
    public static final String UcampoFechaN = "usuarios_fechaN";
    public static final String UcampoContra = "usuarios_contraseña";
    public static final String UcampoSaldo = "usuarios_saldo";

    public static final String creaTablaUsuarios = " create table "
            + tablaUsuarios +" ("
            + UcampoId +" integer primary key autoincrement, "
            + UcampoNomU + " varchar(30) not null, "
            + UcampoNombre +" varchar(75) not null, "
            + UcampoCorreo +" varchar(30) not null, "
            + UcampoFechaN +" date not null, "
            + UcampoContra +" varchar(20) not null, "
            + UcampoSaldo +" real not null)";

}
