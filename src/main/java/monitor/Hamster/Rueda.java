/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Hamster;

/**
 *
 * @author Pinku
 */
public class Rueda {

    public synchronized void rodar() {
        System.out.println(Thread.currentThread().getName() + " empieza a rodar");
        try {
            Thread.sleep((long) Math.random() * 1500);
        } catch (InterruptedException ex) {

        }

    }
}
