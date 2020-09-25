/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.labpoo.examen1.clasesBase;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mario
 */
public class Cuenta {
    private String numeroCuenta; 
    private String tipoCuenta; 
    private TarjetaDebito tarjetaDebito; 
    private ArrayList<Tarjeta> tarjetasAsociadas; 

    /**
     * Constructos sin parametros, el estado de los atributos se asigna con los setters
     */
    public Cuenta() {
    }

    /**
     *
     * @param numeroCuenta numero de cuenta 
     * @param tipoCuenta el tipo de cuenta que es
     * 
     */
    public Cuenta(String numeroCuenta, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.tarjetasAsociadas = new ArrayList<>();
        this.tarjetaDebito = new TarjetaDebito(); 
        
    }
    /**
     * Asigna los valores a la tarjeta de débito que se crea al momento de generar un cuenta
     * @param numeroTarjetaDebito numero que tendrá la tarjeta
     * @param fechaVencimiento fecha de vencimiento que tiene la tarjeta
     * @param Saldo saldo inicial con el que se crea la tarjeta 
     */
    public void setTarjetaDebitoInfo(String numeroTarjetaDebito, Date fechaVencimiento, Double Saldo){
        this.tarjetaDebito.setNumeroTarjeta(numeroTarjetaDebito);
        this.tarjetaDebito.setCuentaAsociada(this);
        this.tarjetaDebito.setFechaVencimiento(fechaVencimiento);
        this.tarjetaDebito.setsaldo(Saldo);
        this.tarjetasAsociadas.add(tarjetaDebito); 
    }

    /**
     * Asigna el numero de cuenta 
     * @param numeroCuenta numero que tendrá la cuenta
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Asigna el tipo de cuenta
     * @param tipoCuenta el tipo de cuenta que es
     */
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /**
     * Asgina la tarjeta de debito
     * @param tarjetaDebito tarjeta de debito asosciada por defecto a la cuenta
     */
    public void setTarjetaDebito(TarjetaDebito tarjetaDebito) {
        this.tarjetaDebito = tarjetaDebito;
    }

    /**
     * Obtener el numero de cuenta
     * @return <b>String - </b> el numero de la cuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Obtener el tipo de cuenta
     * @return <b>String - </b> el tipo de la cuenta 
     */
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Obtener la tarjeta de debito 
     * @return <b>String - </b> la tarjeta de debito 
     */
    public TarjetaDebito getTarjetaDebito() {
        return tarjetaDebito;
    }
    
    /**
     * Agrega o asocia una tarjeta a la cuenta
     * @param tarjeta tarjeta, puede ser de crédito o debito
     */
    public void agregarTarjeta(Tarjeta tarjeta){
        System.out.println("\n\n-------------------- TARJETA AGREGADA -----------------");
        this.tarjetasAsociadas.add(tarjeta); 
        System.out.println("A continuación se muestran la tarjetas asociadas");
        mostrarTarjetasAsociadas();
        
    }
    
    public void mostrarTarjetasAsociadas(){
        System.out.println("\n\n-------------------- TARJETAS ASOCIADAS ----------------------");
        for(Tarjeta tarjeta : tarjetasAsociadas){
            System.out.println("***************************");
            System.out.println(tarjeta.toString());
        }
    }
    
    /**
     *
     * @return <b>String - </b> estado de la cuenta 
     */
    @Override
    public String toString(){
        return  "\nNumero de cuenta: " + this.numeroCuenta  + 
                "\nTipo de cuenta" + this.tipoCuenta +
                "\nNúmero de tarjeta de crédito : " + this.tarjetaDebito.getNumeroTarjeta() ;  
    }
    
}
