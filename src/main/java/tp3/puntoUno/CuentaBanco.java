/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoUno;

/**
 *
 * @author Pinku
 */
public class CuentaBanco {

    private int balance = 50;

    public CuentaBanco() {
    }

    public synchronized int getBalance() {
        return balance;
    }

    private void retiroBancario(int retiro) {
        balance = balance - retiro;
    }
    

    public synchronized void HacerRetiro(int cantidad){
      //retornar balance y fijar como se imprime, es mejor retornar cosas y que los sout esten por fuera para que sea mas rapido
            if (this.balance >= cantidad) {
                System.out.println(Thread.currentThread().getName() + " está realizando un retiro de: " + cantidad + ".");
                this.retiroBancario(cantidad);
                System.out.println(Thread.currentThread().getName() + " : Retiro realizado.");
                System.out.println(Thread.currentThread().getName() + " : Los fondos son de: " + this.balance);
            } else {
                System.out.println("No hay suficiente dinero en la cuentapara realizar el retiro Sr." + Thread.currentThread().getName());
                System.out.println("Su saldo actual es de" + this.balance);
            }   
    } // de hacer retiro

}
