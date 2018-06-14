package com.example.oscar.myfklastintent.Entidades;

import java.util.Date;

public class Entidad_Usuario {

    private int usuarios_id;
    private int usuario_nombreUs;
    private String usuarios_nombre;
    private String usuarios_correo;
    private Date usuarios_fechaNacimiento;
    private String usuarios_contrasena;
    private float usuarios_saldo;

    public Entidad_Usuario(int usuarios_id, int usuario_nombreUs, String usuarios_nombre, String usuarios_correo, Date usuarios_fechaNacimiento, String usuarios_contraseña, float usuarios_saldo) {
        this.usuarios_id = usuarios_id;
        this.usuario_nombreUs = usuario_nombreUs;
        this.usuarios_nombre = usuarios_nombre;
        this.usuarios_correo = usuarios_correo;
        this.usuarios_fechaNacimiento = usuarios_fechaNacimiento;
        this.usuarios_contrasena = usuarios_contraseña;
        this.usuarios_saldo = usuarios_saldo;
    }

    public int getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(int usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public int getUsuario_nombreUs() {
        return usuario_nombreUs;
    }

    public void setUsuario_nombreUs(int usuario_nombreUs) {
        this.usuario_nombreUs = usuario_nombreUs;
    }

    public String getUsuarios_nombre() {
        return usuarios_nombre;
    }

    public void setUsuarios_nombre(String usuarios_nombre) {
        this.usuarios_nombre = usuarios_nombre;
    }

    public String getUsuarios_correo() {
        return usuarios_correo;
    }

    public void setUsuarios_correo(String usuarios_correo) {
        this.usuarios_correo = usuarios_correo;
    }

    public Date getUsuarios_fechaNacimiento() {
        return usuarios_fechaNacimiento;
    }

    public void setUsuarios_fechaNacimiento(Date usuarios_fechaNacimiento) {
        this.usuarios_fechaNacimiento = usuarios_fechaNacimiento;
    }

    public String getUsuarios_contrasena() {
        return usuarios_contrasena;
    }

    public void setUsuarios_contrasena(String usuarios_contrasena) {
        this.usuarios_contrasena = usuarios_contrasena;
    }

    public float getUsuarios_saldo() {
        return usuarios_saldo;
    }

    public void setUsuarios_saldo(float usuarios_saldo) {
        this.usuarios_saldo = usuarios_saldo;
    }
}
