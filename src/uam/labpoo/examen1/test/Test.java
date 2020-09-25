/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.labpoo.examen1.test;
import java.util.Date;
import uam.labpoo.examen1.clasesBase.*;

/**
 *
 * @author mario
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*----------------------------------------- FUNCIONAMIENTO DEL TEST -------------------------------------------
            Se crean dos cuentas y a su vez dos cliente, con ellos se hacen diversas operaciones definidas previamente
            en cada clase, el objetivo es demostrar el funcionamiento del programa. Cada seccion nueva contiene
            comentarios indicando las operaciones a realizar y que es lo que se espera visualizar por computadora
        */
        

        //CREAMOS UNA CUENTA 
        Cuenta cuenta1 = new Cuenta("123456", "personal"); 
        cuenta1.setTarjetaDebitoInfo("44556699787", new Date(), 45000.0);
        // MOSTRAMOS EL ESTAOD DE LA PRIMERA CUENTA
        System.out.println("\n\n----------------------------------------------- CUENTA 1 --------------------------------------------");
        System.out.println(cuenta1.toString());
        System.out.println("\n\n--------------------------------------- TARJETA DE LACUENTA 1 ---------------------------------------");
        System.out.println(cuenta1.getTarjetaDebito().toString());
        
        //CREAMOS UN CLIENTE 
        Cliente cliente = new Cliente("7777", cuenta1, "Juan Mario", "Sastre Cuahutle", new Date(), "La paz 97", "soltero", "2464637333");
        System.out.println("\n\n----------------------------------------------- CLIENTE 1 --------------------------------------------");
        System.out.println(cliente.toString());
        
        //CREAMOS OTRA TARJETA ASOCIADA A LA PRIMERA CUENTA 
        TarjetaCredito tc = new TarjetaCredito("8889999111555", cuenta1, new Date(), 40000.0, 0.0); 
        //AGREGAMOS LA TARJETA A LA CUENTA 
        System.out.println("\n\n------------------------------------ AGREGAMOS OTRA TARJETA A LA CUENTA 1 ------------------------------");
        cuenta1.agregarTarjeta(tc);
        
        //CREAMOS OTRA CUENTA 
        Cuenta cuenta2 = new Cuenta("6694122", "personal"); 
        cuenta2.setTarjetaDebitoInfo("66992233441", new Date(), 70000.0);
        //MOSTRAMOS EL ESTADO DE LA SEGUNDA CUENTA
        System.out.println("\n\n----------------------------------------------- CUENTA 2 --------------------------------------------");
        System.out.println(cuenta2.toString());
        System.out.println("\n\n--------------------------------------- TARJETA DE LACUENTA 2 ---------------------------------------");
        System.out.println(cuenta2.getTarjetaDebito().toString());
        
       
        //CREAMOS OTRO CLIENTE 
        Cliente cliente2 = new Cliente("7777", cuenta2, "Carlos", "Perez Hernandez", new Date(), "Juarez 89", "soltero", "2468896631");
        System.out.println("\n\n----------------------------------------------- CLIENTE 2 --------------------------------------------");
        System.out.println(cliente.toString());
        System.out.println("\n\n");
        //HACEMOS UNA TRANSFERENCIA DE LA TARJETA DE LA CUENTA 1 A LA 2
        cuenta1.getTarjetaDebito().transferencia(cuenta2.getTarjetaDebito(), 2000.0);
        //MOSTRAMOS EL ESTADO DE LA TARJETA RECEPTORA
        System.out.println("\n\n------------------------------ TARJETA 2 ACTUALIZADA DESPUPES DE TRANSFEREBCIA ------------------------");
        System.out.println(cuenta2.getTarjetaDebito().toString());
        
        //OBTENEMOS LA ANUALIDAD DE LA PRIMERA TARJETA
        System.out.println("\n\n------------------ CANTIDAD A PAGAR ANUALIDAD PRIMERA TARJETA -----------------");
        Double pago1 = cuenta1.getTarjetaDebito().consultaPagoAnualidad(); 
        System.out.println("Cantidad: " + pago1);
        System.out.println("\n\n---------------------- PAGO DE ANUALIDAD PRIMERA TARJETA -----------------------");
       
        cuenta1.getTarjetaDebito().pagoAnualidad(pago1);
        //OBTENEMOS LA ANUALIDAD DE LA SEGUNDA TARJETA
        System.out.println("\n\n------------------ CANTIDAD A PAGAR ANUALIDAD SEGUNDA TARJETA -----------------");
        System.out.println("Cantidad: " + cuenta2.getTarjetaDebito().consultaPagoAnualidad());
        
        //DEPÓSITO A LA TARJETA DE DÉBITO DE LA CUENTA 2 
        System.out.println("\n\n");
        cuenta2.getTarjetaDebito().depositar(20000.0);
        
        //RETIRO DE LA TARJETA DE DÉBITO DE LA CUENTA 1
        System.out.println("\n\n");
        cuenta1.getTarjetaDebito().retiro(10000.0);
        
        
    }
    
}
