/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaTeoria.barbero;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class Barberia {
    
    Semaphore semSillon = new Semaphore(1);
    Semaphore semBarbero =new Semaphore(0);
    Semaphore semSalida =new Semaphore(0);
    int sillasDisponibles = 3; //pasar por parametro con el main
    Semaphore semSilla = new Semaphore (1);
    
    //metodos de barbero
    public void esperarCliente() throws InterruptedException{
        System.out.println("esperando cliente");
        semBarbero.acquire();
    }
    
    public void atender() throws InterruptedException {
        System.out.println("El barbero esta realizando el corte");
        Thread.sleep(2000);
    }
    
    public void terminarAtencion(){
        System.out.println("termine la atencion");
        semSalida.release();
    }
    
    //fin metodos barbero
    
    
    //metodos de cliente
    public boolean sentarmeSilla() throws InterruptedException {
        /**
         * Verifica si hay sillas disponibles para esperar sillon.
         * Semsilla solo sincroniza cuando pregunta por las sillas.
         */
        boolean sentarme = false;
        semSilla.acquire();
        if (sillasDisponibles>0) {
            sillasDisponibles--;
            sentarme = true;
        } else {
            System.out.println("No hay lugares para sentarme a esperar. Me voy.");
        }
        semSilla.release();
        return sentarme;
    }
    public void sentarseSillon() throws InterruptedException {
        /**
         * Espera sentarse en un sillon, y libera una silla.
         */
        semSillon.acquire();
        System.out.println("Me pude sentar en el sillon");
        //una vez que ya me sente en un sillon, libero la silla, uso el semaforo de la silla.
        semSilla.acquire();
        sillasDisponibles++;
        semSilla.release();
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
