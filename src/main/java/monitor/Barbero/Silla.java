/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Barbero;

/**
 *
 * @author Pinku
 */
public class Silla {
    int maximo; //cantidad maxima de sillas
    int sentado; //cantidad actual de sillas ocupadas

    public Silla(int maximo) {
        this.maximo = maximo;
        this.sentado = 0;
    }
    
    public synchronized void intentarSentarse() {
        try {
            while (sentado >= maximo) {
                System.out.println(Thread.currentThread().getName() + "debe esperar para sentarse");
                this.wait();
            }
        } catch (InterruptedException ex) {

        }
        System.out.println(Thread.currentThread().getName() + "se sento");
        sentado ++;
    }

    public synchronized void dejarSilla() {
        System.out.println(Thread.currentThread().getName()+ " dejo la silla");
        sentado --;
        this.notify();
    }
}
