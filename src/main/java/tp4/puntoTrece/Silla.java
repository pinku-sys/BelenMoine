/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoTrece;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class Silla {

    /**
     * R-LCOK NO deja que otro hilo haga unlock.. si no fue el que hizo lock.
     * semaphore si. OJO
     */
    Semaphore libre = new Semaphore(1, true);
    Semaphore semOrden = new Semaphore(0);

    public void sentarse(Semaphore mozo) throws InterruptedException {
        //me siento en la silla y aviso al mozo
        libre.acquire();
        System.out.println(Thread.currentThread().getName() + " Me sente en la silla ");
        mozo.release();
    }
    /**
     * elegirPedido comer salir
     *
     * @param semMenu
     * @return
     * @throws InterruptedException
     */
    public void elegirPedido(Semaphore semMenu) throws InterruptedException {
        //como no esta muy especificado solo hagoun sleep simulando que esta eligiendo algo...
        semMenu.acquire();
        System.out.println(Thread.currentThread().getName() + " Eligiendo opcion...");
        Thread.sleep(1000);
        semOrden.release(); //libero la orden del semaforo para activar al mozo que prepara el pedido.
    }

    public void comer(Semaphore semPedidoListo) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ " ESPERANDO PEDIDO..");
        semPedidoListo.acquire();
        System.out.println(Thread.currentThread().getName() + " Estoy comiendo.");
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
