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
public class Cliente extends Persona{
    private String numeroCliente; 
    private Cuenta cuenta; 

    /**
     * Constructor sin parámetros, el estado de los atributos se asigna con los setters 
     */
    public Cliente() {
    }

    /**
     *
     * @param numeroCliente numero de cliente que tiene la persona en el banco 
     * @param cuenta cuenta que tiene la persona en el banco 
     */
    public Cliente(String numeroCliente, Cuenta cuenta) {
        this.numeroCliente = numeroCliente;
        this.cuenta = cuenta;
    }

    public Cliente(String numeroCliente, Cuenta cuenta, String nombre, String apellidos, Date fechaNacimiento, String direccion, String estadoCivil, String numeroCelular) {
        super(nombre, apellidos, fechaNacimiento, direccion, estadoCivil, numeroCelular);
        this.numeroCliente = numeroCliente;
        this.cuenta = cuenta;
    }
    

    /**
     * Asgina el numero de cliente
     * @param numeroCliente numero de cliente en el banco 
     */
    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    /**
     * Asigna una cuenta al cliente 
     * @param cuenta cuenta del cliente 
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Obtener el numero de cliente
     * @return <b>String - </b> el número de cliente 
     */
    public String getNumeroCliente() {
        return numeroCliente;
    }

    /**
     * Obtener la cuenta del cliente
     * @return <b>Cuenta - </b> cuenta del cliente 
     */
    public Cuenta getCuenta() {
        return cuenta;
    }
    
    /**
     * 
     * @return <b>String - </b> estado de la cuenta 
     */
    @Override 
    public String toString(){
        return super.toString() + "\nNumero de cliente: " + this.numeroCliente +
                "\nNúmero de Cuenta: " + this.cuenta.getNumeroCuenta() + 
                "\nTipo de cuenta: " + this.cuenta.getTipoCuenta() + 
                "\nTarjeta de débito: " + this.cuenta.getTarjetaDebito().getNumeroTarjeta(); 
    }
    
}
