/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/**
 *
 * @author Pinku
 */
public class ThreadTestingRunnable {
    public static void main(String[] args) throws InterruptedException {
        //creo el obj runnable
        MiEjecucionRunnable obj = new MiEjecucionRunnable();
        //creo el hilo al que le voy a pasar el runnable
        Thread miHiloRunnable = new Thread(obj);
        
        //lo inicio
        miHiloRunnable.start();
        
        System.out.println("En el main");
    }
}
