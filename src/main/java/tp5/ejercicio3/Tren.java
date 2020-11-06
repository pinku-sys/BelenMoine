/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class Tren {

    Semaphore vendedor = new Semaphore(0);
    Semaphore tickets;
    Semaphore tren = new Semaphore(0);
    Semaphore bajarse = new Semaphore(0);
    Semaphore venta = new Semaphore(1);
    int cantidadTickets;

    public Tren(int cantidadTickets) {
        this.tickets = new Semaphore(cantidadTickets, true);
        this.cantidadTickets = cantidadTickets;
    }

    //metodos vendedor
    public void venderTicket() throws InterruptedException {
        vendedor.acquire();
        tren.release(); //ticket comprado.
    }

    //metodos pasajero
    public void comprarTicket() throws InterruptedException {
        tickets.acquire();
        vendedor.release();
    }

    public void subirseTren() {
        System.out.println(Thread.currentThread().getName() + " me subi al tren.");
    }

    public void bajarseTren() throws InterruptedException {
        bajarse.acquire();
    }

    //metodos controltren
    public void empezarRecorrido() throws InterruptedException {
        tren.acquire(cantidadTickets);
        //no deja vender mas tickets.
    }

    public void terminarRecorrido() {
        //termino recorrido.
        bajarse.release(cantidadTickets);
        tickets.release(cantidadTickets);
        venta.release();
    }
}
