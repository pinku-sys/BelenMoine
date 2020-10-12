/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoCatorce;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import utiles.Aleatorio;

/**
 *
 * @author Pinku
 */
public class Silla {

    /**
     * R-LCOK NO deja que otro hilo haga unlock.. si no fue el que hizo lock.
     * semaphore si. OJO
     * 3 opciones:
     * Quiero bebida. mozo
     * quiero comida. cocinero.
     * quiero comida y bebida. cocinero y mozo, primero mozo y luego cocinero, en ese orden.
     */
    int opcion;
    boolean estoyOcupada=false;
    Semaphore libre = new Semaphore(1, true);
    Semaphore semOrden = new Semaphore(0);
    ReentrantLock lockEstoyOcupada = new ReentrantLock();

    public boolean sentarse() throws InterruptedException {
        //me siento en la silla y aviso al mozo
        lockEstoyOcupada.lock();
        estoyOcupada = libre.tryAcquire();
        if(estoyOcupada)
        System.out.println(Thread.currentThread().getName() + " Me sente en la silla ");
        lockEstoyOcupada.unlock();
        //no despierta a ndie, porque deberia en realidad, elegir lo que quiere y luego despertarl.
        return estoyOcupada;
    }
    /**
     * elegirPedido comer salir
     *
     * @param semMenu
     * @return
     * @throws InterruptedException
     */
    public void elegirPedido(Semaphore cocinero, Semaphore mozo) throws InterruptedException {
        /**
         * Opcion 1: quiero bebida. despierto al mozo.
         * Opcion 2: quiero comer. despierto al cocinero.
         * Opcion 3: quiero beber y comer. despierto al mozo, luego, al cocinero. 
         * Primero puede solicitar la bebida, una vez que tiene su bebida, puede solicitar su comida.
         */
        
        System.out.println(Thread.currentThread().getName() + " Eligiendo opcion...");
        this.opcion = Aleatorio.intAleatorio(1, 3);
        Thread.sleep(1000);
        switch (opcion) {
            case 1,3: mozo.release();
            break;
            case 2: cocinero.release();
            break;                  
        }
    }

    public void consumirPedido(Semaphore bebidaLista, Semaphore cocineroListo, Semaphore cocinero) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " ESPERANDO PEDIDO...");
        
        switch (opcion) {
            case 1:
                System.out.println("Elegi la opción beber");
                System.out.println("...esperando mi bebida...");
                bebidaLista.acquire();
                System.out.println("...bebiendo...");
                Thread.sleep(2000);
                break;                
            case 2:
                System.out.println("Elegi la opcion comer");
                 System.out.println("...esperando mi comida...");
                cocineroListo.acquire();
                System.out.println("...comiendo...");
                Thread.sleep(2000);
                break;                
            case 3:
                System.out.println("Elegi la opcion beber y comer");
                System.out.println("...Esperando primero mi bebida...");
                bebidaLista.acquire();
                System.out.println("...bebiendo...");
                Thread.sleep(2000);
                System.out.println("Solicitando comida...");
                cocinero.release();
                System.out.println("esperando mi comida...");
                cocineroListo.acquire();
                System.out.println("comiendo...");
                Thread.sleep(2000);
                break;
        }
        Thread.sleep(1000);
    }

    public void salir() {
        System.out.println("Soy " + Thread.currentThread().getName() + " y salgo");
        //me voy despues decomer
        libre.release();
    }

    public Semaphore getsemOrden() {
        return semOrden;
    }

}
