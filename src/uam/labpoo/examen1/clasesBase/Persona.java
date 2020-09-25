/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.labpoo.examen1.clasesBase;

import java.util.Date;

/**
 *
 * @author mario
 */
public class Persona {
    private String nombre; 
    private String apellidos; 
    private Date fechaNacimiento; 
    private String direccion; 
    private String estadoCivil; 
    private String numeroCelular; 

    /**
     * Constructor sin parámetros, el estado de los atributos se asigna con los setters
     */
    public Persona() {
    }

    /**
     *
     * @param nombre nombre de la persona
     * @param apellidos apellidos de la persona
     * @param fechaNacimiento fecha de nacimiento de la persona 
     * @param direccion direccion de la persona 
     * @param estadoCivil estado civil de la persona
     * @param numeroCelular numero celular de la persona 
     */
    public Persona(String nombre, String apellidos, Date fechaNacimiento, String direccion, String estadoCivil, String numeroCelular) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.numeroCelular = numeroCelular;
    }

    /**
     * Asigna el nombre a la persona
     * @param nombre nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Asigna los apellidos a la persona
     * @param apellidos apellidos de la persona
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Asigna la fecha de nacimiento a la persona
     * @param fechaNacimiento fecha de nacimiento de la persona
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Asgina la direccion a la persona
     * @param direccion direccion de la persona 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Asigna el estado civil de la persona 
     * @param estadoCivil estado civil de la persona 
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * Asigna el numero de celular de la persona
     * @param numeroCelular numero de celular de la persona 
     */
    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    /**
     * Obtener el nombre de la persona
     * @return <b>String - </b> nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtener los apellidos de la persona 
     * @return <b>String - </b> apellidos de la persona
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Obtener la fecha de nacimiento de la persona
     * @return <b>Date - </b> fecha de nacimiento de la persona 
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtener la dieccion de la persona 
     * @return <b>String - </b> direccion de la persona
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Obtener el estado civil de la persona
     * @return <b>String - </b> estado civil de la persona
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * Obtener el numero de celular de la persona
     * @return <b>String - </b> numero de celular de la persona 
     */
    public String getNumeroCelular() {
        return numeroCelular;
    }
    
    /**
     * 
     * @return <b>String - </b> estado actual de la persona 
     */
    @Override
    public String toString(){
        return  "\nNombre: " + this.nombre + 
                "\nApellidos: " + this.apellidos + 
                "\nFecha de nacimiento: " + this.fechaNacimiento +
                "\nDireccion: " + this.direccion + 
                "\nEstado civil: " + this.estadoCivil + 
                "\nNumero de celular: " + this.numeroCelular; 
    }
    
}
