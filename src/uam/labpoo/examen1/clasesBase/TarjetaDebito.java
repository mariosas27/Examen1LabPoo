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
public class TarjetaDebito extends Tarjeta {
    private Double saldo; 

    /**
     * Constructor sin parámetros, el estado de los atributos se debe de asignar con los setters
     */
    public TarjetaDebito() {
    }

    /**
     *
     * @param numeroTarjeta número de la tarjeta de débito
     * @param cuentaAsociada cuenta asociada a la tarjeta de débito
     * @param fechaVencimiento fecha de vencimiento de la tarjeta de débito
     * @param saldo saldo que tiene la tarjeta de débito 
     */
    public TarjetaDebito(String numeroTarjeta, Cuenta cuentaAsociada, Date fechaVencimiento, Double saldo) {
        this.numeroTarjeta = numeroTarjeta; 
        this.cuentaAsociada = cuentaAsociada; 
        this.fechaVencimiento = fechaVencimiento; 
        this.saldo = saldo;
    }

    /**
     * Asigna el saldo a la tarjeta de débito
     * @param saldo saldo que tiene la tarjeta de débito 
     */
    public void setsaldo(Double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtener el saldo de la tarjeta de débito 
     * @return <b>Double - </b> saldo de la tarjeta de débito 
     */
    public Double getsaldo() {
        return saldo;
    }

    @Override
    public void depositar(Double cantidad) {
        this.saldo += cantidad;
        System.out.println("---------------------------- DEPÓSITO A LA TARJETA DE DÉBITO ------------------------");
        System.out.println("Número de cuenta: " + this.cuentaAsociada.getNumeroCuenta());
        System.out.println("Número de tarjeta de débito: " + this.numeroTarjeta);
        System.out.println("Depósito de $" + cantidad + " realizado");
        System.out.println("******************************* Depósito realizado ***************************");
        System.out.println("Información actualizada de la tarjeta: ");
        System.out.println(this.toString()); 
    }

    @Override
    public void retiro(Double cantidad) {
        if(this.saldo > cantidad){
            this.saldo -= cantidad; 
            System.out.println("---------------------------- RETIRO DE LA TARJETA DE DÉBITO ------------------------");
            System.out.println("Número de cuenta: " + this.cuentaAsociada.getNumeroCuenta());
            System.out.println("Número de tarjeta de débito: " + this.numeroTarjeta);
            System.out.println("Retiro de $" + cantidad + " realizado");
            System.out.println("******************************* Retiro realizado ***************************");
            System.out.println("Información actualizada de la tarjeta: ");
            System.out.println(this.toString());
        }
    }

    @Override
    public void transferencia(Tarjeta tarjeta, Double cantidad) {
        //verificamos que la tarjeta a la que se le hará una transferencia es igual de débito 
        if(tarjeta instanceof TarjetaDebito ){
            if(this.saldo > cantidad){
                ((TarjetaDebito) tarjeta).setsaldo(((TarjetaDebito) tarjeta).getsaldo()+cantidad);
                this.saldo -= cantidad;
                System.out.println("---------------------------- TRANSFERENCIA A OTRA TARJETA DE DÉBITO ------------------------");
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
    public Double consultaPagoAnualidad() {
        Double pago = (this.saldo > 10000.0) ? this.saldo*0.10 : this.saldo*0.30; 
        return pago; 
    }

    @Override
    public void pagoAnualidad(Double pago) {
        System.out.println("-------------- PAGO DE ANUALIDAD TARJETA DE DÉBITO REALIZADO --------------");
        System.out.println("Número de tarjeta: " + this.numeroTarjeta);
    }
    
    @Override
    public String toString(){
        return  "\nNúmero de tarjeta: " + this.numeroTarjeta + 
                "\nNúmero de cuenta asociada: " + this.cuentaAsociada.getNumeroCuenta() +
                "\nTipo de cuenta: " + this.cuentaAsociada.getTipoCuenta() + 
                "\nFecha de vencimiento: " + this.fechaVencimiento + 
                "\nSaldo " + this.saldo; 
    }
}
