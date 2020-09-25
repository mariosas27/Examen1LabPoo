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
public class TarjetaCredito extends Tarjeta{
    private Double limiteCredito; 
    private Double deuda; 

    /**
     * Constructor sin parámetros, el estado de los atributos se debe de asignar con los setters
     */
    public TarjetaCredito() {
    }

    /**
     *
     * @param numeroTarjeta número de la tarjeta de crédito
     * @param cuentaAsociada cuenta asociada a la tarjeta de crédito
     * @param fechaVencimiento fecha de vencimiento de la tarjeta de crédito
     * @param limiteCredito límite de crédito que tiene la tarjeta de crédito
     * @param deuda deuda que tiene la tarjeta de crédito 
     */
    public TarjetaCredito(String numeroTarjeta, Cuenta cuentaAsociada, Date fechaVencimiento, Double limiteCredito, Double deuda) {
        this.numeroTarjeta = numeroTarjeta; 
        this.cuentaAsociada = cuentaAsociada; 
        this.fechaVencimiento = fechaVencimiento; 
        this.limiteCredito = limiteCredito;
        this.deuda = deuda;
    }

    /**
     * Asgina el límite de credito que tiene la tarjeta
     * @param limiteCredito límite de crédito de la tarjeta 
     */
    public void setLimiteCredito(Double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    /**
     * Asigna la deuda que tiene la tarjeta de crédito
     * @param deuda deuda de la tarjeta de crédito 
     */
    public void setDeuda(Double deuda) {
        this.deuda = deuda;
    }

    /**
     * Obtener el límite de crédito 
     * @return <b>Double - </b> límite de crédito de la tarjeta 
     */
    public Double getLimiteCredito() {
        return limiteCredito;
    }

    /**
     * Obtener la deuda de la tarjeta
     * @return <b>Double - </b> Deuda que tiene la tarjeta de crédito 
     */
    public Double getDeuda() {
        return deuda;
    }
    
    

    @Override
    public void depositar(Double cantidad) {
        this.deuda -= cantidad; 
        System.out.println("---------------------------- DEPÓSITO A LA TARJETA DE CRÉDITO ------------------------");
        System.out.println("Número de cuenta: " + this.cuentaAsociada.getNumeroCuenta());
        System.out.println("Número de tarjeta de crédito: " + this.numeroTarjeta);
        System.out.println("Depósito de $" + cantidad + " realizado");
        System.out.println("La deuda de la tarjeta ha sido reducida");
        System.out.println("******************************* Depósito realizado ***************************");
        System.out.println("Información actualizada de la tarjeta: ");
        System.out.println(this.toString()); 
    }

    @Override
    public void retiro(Double cantidad) {
        if((this.limiteCredito - this.deuda) > 0.0 && ((this.limiteCredito - this.deuda)>cantidad)){
            this.deuda += cantidad; 
            System.out.println("---------------------------- RETIRO DE LA TARJETA DE CRÉDITO ------------------------");
            System.out.println("Número de cuenta: " + this.cuentaAsociada.getNumeroCuenta());
            System.out.println("Número de tarjeta de crédito: " + this.numeroTarjeta);
            System.out.println("Retiro de $" + cantidad + " realizado");
            System.out.println("La deuda de la tarjeta ha incrementado");
            System.out.println("******************************* Retiro realizado ***************************");
            System.out.println("Información actualizada de la tarjeta: ");
            System.out.println(this.toString());
        }else{
            System.out.println("---------------------------- SALDO INSUFICIENTE ------------------------");
        }
        
    }

    @Override
    public void transferencia(Tarjeta tarjeta, Double cantidad) {
        //verificamos que la tarjeta a la que se le hará una transferencia es igual de crédito 
        if(tarjeta instanceof TarjetaCredito ){
            if((this.limiteCredito - this.deuda)>cantidad){
                this.deuda += cantidad; 
                ((TarjetaCredito) tarjeta).setDeuda(((TarjetaCredito) tarjeta).getDeuda()-cantidad);
                System.out.println("---------------------------- TRANSFERENCIA A OTRA TARJETA DE CRÉDITO ------------------------");
                System.out.println("Número de la tarjeta desde donde se hace la transferencia:  " + this.numeroTarjeta);
                System.out.println("Numero de la tarjeta receptora: " + tarjeta.getNumeroTarjeta());
                System.out.println("Cantidad a transferir: " + cantidad);
                System.out.println("******************************* Transferencia realizada ***************************");
                System.out.println("Información actualizada de la tarjeta: ");
                System.out.println(this.toString());
            }else{
                System.out.println("---------------------------- SALDO INSUFICIENTE ------------------------");
            }
        }else{
            System.out.println("---------------------------- LA TARJETA NO ES COMPATIBLE ------------------------");
        }
    }
    
    @Override
    public Double consultaPagoAnualidad(){
        Double pago = this.deuda*0.15; 
        return pago; 
    }
    
    @Override
    public void pagoAnualidad(Double pago) {
        System.out.println("---------------------------- PAGO DE ANUALIDAD TARJETA DE CRÉDITO REALIZADO ------------------------");
        System.out.println("Número de tarjeta: " + this.numeroTarjeta);
    }
    
    @Override
    public String toString(){
        return  "\nNúmero de tarjeta: " + this.numeroTarjeta + 
                "\nNúmero de cuenta asociada: " + this.cuentaAsociada.getNumeroCuenta() +
                "\nTipo de cuenta: " + this.cuentaAsociada.getTipoCuenta() + 
                "\nFecha de vencimiento: " + this.fechaVencimiento + 
                "\nLímte de crédito: " + this.limiteCredito + 
                "\nDeuda: " + this.deuda; 
    }
}
