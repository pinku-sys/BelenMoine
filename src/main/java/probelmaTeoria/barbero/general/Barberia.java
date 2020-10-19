/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probelmaTeoria.barbero.general;

import problemaTeoria.barbero.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class Barberia {

    Semaphore semSillon = new Semaphore(1);
    Semaphore semBarbero = new Semaphore(0);
    Semaphore semSalida = new Semaphore(0);
    //genero 3 permisos de silla, lo que simularia que tengo 3 sillas.
    Semaphore semSilla = new Semaphore(3);

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
    public boolean sentarmeSilla() throws InterruptedException {
        /**
         * Verifica si hay sillas disponibles para esperar sillon. 
         */
        boolean sentarme = false;
        /**
         * al probar su ejecucion varias veces, podemos observar
         * que segun la suerte del hilo y de como esta dado compartir el CPU
         * se pueden sentar y cortar el pelo 3 hilos, 4 hilos o hasta 5 hilos cliente (en esta prueba
         * solo hay 5 hilos clientes)
         * */
        
        if (semSilla.tryAcquire()) {
            sentarme = true;
        }
       
        return sentarme;
    }

    public void sentarseSillon() throws InterruptedException {
        /**
         * Espera sentarse en un sillon, y libera una silla.
         */
        semSillon.acquire();
        semSilla.release();
        System.out.println("Me pude sentar en el sillon");
        //una vez que ya me sente en un sillon, libero la silla, uso el semaforo de la silla.

    }

    public void solicitarCorte() {
        System.out.println("solicito corte");
        semBarbero.release();

    }

    public void esperarAtencion() throws InterruptedException {
        System.out.println("esperando antencion");
        semSalida.acquire();

    }

    public void salirBarberia() {
        System.out.println(" sali de la barberia");
        semSillon.release();

    }
    //fin metodos cliente
}
