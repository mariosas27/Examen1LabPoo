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
public abstract class Tarjeta {
    protected String numeroTarjeta; 
    protected Cuenta cuentaAsociada; 
    protected Date fechaVencimiento; 

    /**
     * Asigna el numero de tarjeta
     * @param numeroTarjeta numero que tiene la tarjeta 
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Asocia la tarjeta a una cuenta
     * @param cuentaAsociada cuenta a la que se asociará la cuenta
     */
    public void setCuentaAsociada(Cuenta cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
    }

    /**
     * Asigna la fecha de vencimiento de la tarjeta
     * @param fechaVencimiento fecha de vencimiento de la tarjeta 
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Obtener el numero de la tarjeta 
     * @return <b>String - </b> el numero de la tarjeta 
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Obtener la cuenta asociada a la tarjeta 
     * @return <b>Cuenta - </b> cuenta asociada a la tarjeta 
     */
    public Cuenta getCuentaAsociada() {
        return cuentaAsociada;
    }

    /**
     * Obtener la fecha de vencimiento de la tarjeta 
     * @return <b>Date - </b> fecha de vencimiento de la tarjeta 
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    /**
     * Permite depositar dinero a la cuenta
     */
    abstract public void depositar(Double cantidad); 

    /**
     * Retirar dinero de la cuenta
     */
    abstract public void retiro(Double cantidad); 

    /**
     * Transferir dinero entre cuentas del mismo tipo 
     */
    abstract public void transferencia(Tarjeta tarjeta, Double cantidad); 

    /**
     * Consulta el pago de la anualidad de la tarjeta
     */
    abstract public Double consultaPagoAnualidad(); 
    /**
     * Pago de la anualidad de la tarjeta
     */
    abstract public void pagoAnualidad(Double pago); 
    
}
