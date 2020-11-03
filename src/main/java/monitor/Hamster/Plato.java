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
public class Plato {

    private int cantidad;
    private int comiendo;

    public Plato(int maximo) {
        cantidad = maximo;
        comiendo = 0;
    }

    public synchronized void empezarAComer() {
        try {
            while (comiendo >= cantidad) {
                System.out.println(Thread.currentThread().getName() + "debe esperar para comer");
                this.wait();
            }
        } catch (InterruptedException ex) {

        }
        System.out.println(Thread.currentThread().getName() + " empieza a comer");
        comiendo++;
    }

    public synchronized void terminarDeComer() {
        System.out.println(Thread.currentThread().getName()+ " termino de comer");
        comiendo--;
        this.notify();
    }
}


