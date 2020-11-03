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
    Semaphore semBarbero = new Semaphore(0);
    Semaphore semSalida = new Semaphore(0);
    Silla sillas;

    public Barberia(int maxSillas) {
        //Silla es una clase que representa la cantidad de sillas totales y usa mecanismo de monitores
        this.sillas = new Silla(maxSillas);
    }

    //metodos de barbero
    public void esperarCliente() throws InterruptedException {
        System.out.println("esperando cliente");
        semBarbero.acquire();
    }

    public void atender() throws InterruptedException {
        System.out.println("El barbero esta realizando el corte");
        Thread.sleep(2000);
    }

    public void terminarAtencion() {
        System.out.println("termine la atencion");
        semSalida.release();
    }

    //fin metodos barbero
    //metodos de cliente
    public void sentarmeSilla() throws InterruptedException {
        sillas.intentarSentarse();
    }

    public void sentarseSillon() throws InterruptedException {
        /**
         * Espera sentarse en un sillon, y libera una silla.
         */
        semSillon.acquire(); //me atiende el barbero
        sillas.dejarSilla(); //libero una silla
        System.out.println(Thread.currentThread().getName() + " se sento en el sillon");
        //una vez que ya me sente en un sillon, libero la silla, uso el semaforo de la silla.

    }

    public void solicitarCorte() {
        System.out.println(Thread.currentThread().getName()+ " solicito corte");
        semBarbero.release();
    }

    public void esperarAtencion() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " esperando antencion");
        semSalida.acquire();
    }

    public void salirBarberia() {
        System.out.println(Thread.currentThread().getName() +" sali de la barberia");
        semSillon.release();
    }
    //fin metodos cliente
}
