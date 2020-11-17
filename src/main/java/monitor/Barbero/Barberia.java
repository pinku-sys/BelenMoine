/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Barbero;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class Barberia {

    Semaphore semSillon = new Semaphore(1);
    private boolean hayCliente = false; //un cliente solicitando un corte.
    private boolean sillonLibre = true; // el sillon esta libre al principio.
    private boolean salirBarberia = false; //sirve para que el cliente salga de la barberia.
    Silla sillas; //sillas, usan sincronizacion con monitores.

    public Barberia(int maxSillas) {
        //Silla es una clase que representa la cantidad de sillas totales y usa mecanismo de monitores
        this.sillas = new Silla(maxSillas);
    }

    //metodos de barbero
    public synchronized void esperarCliente() throws InterruptedException {
        System.out.println("esperando cliente");
        while (!hayCliente) {
            this.wait();
        }
    }

    public synchronized void terminarAtencion() {
        salirBarberia = true;
        this.notifyAll();
    }

    //fin metodos barbero
    //metodos de cliente. preguntar.
    public void sentarmeSilla() throws InterruptedException {
        sillas.intentarSentarse();
    }

    public synchronized void sentarseSillon() throws InterruptedException {
        /**
         * Espera sentarse en un sillon, y libera una silla.
         */
        while ( !sillonLibre ) {
            this.wait();
        }
        
        sillonLibre = false;
        System.out.println(Thread.currentThread().getName() + " se sento en el sillon");
        //una vez que ya me sente en un sillon, libero la silla. Metodo abajo.

    }
    //preguntar. sillas tiene monitores.
    public void dejarSilla () {
        sillas.dejarSilla(); //libero una silla
    }

    public synchronized void solicitarCorte() {
        System.out.println(Thread.currentThread().getName() + " solicito corte");
        this.hayCliente = true;
        this.notifyAll();
    }

    public synchronized void esperarAtencion() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " esperando antencion");
        while (!this.salirBarberia) {
            this.wait();
        }
    }

    public synchronized void salirBarberia() {
        System.out.println(Thread.currentThread().getName() + " sali de la barberia");
        this.sillonLibre = true;
        this.notifyAll();
    }
    //fin metodos cliente
}
