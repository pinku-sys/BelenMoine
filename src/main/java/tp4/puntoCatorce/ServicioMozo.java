/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoCatorce;

import tp4.puntoTrece.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class ServicioMozo {
    
    Semaphore semPedido = new Semaphore(0);
    Semaphore semPedidoListo = new Semaphore(0);
    /**
     * hobby
     * ofrezcoMenu
     * tomoPedido
     * preparoPedido
     * llevoPedido
     * @param semMozo
     * @return
     * @throws InterruptedException 
     */
    
    public void hobby() throws InterruptedException {
        Thread.sleep(1000);
    }
       
    public void tomoPedido() throws InterruptedException {
        semPedido.acquire();
        System.out.println("soy mozo y recibi una bebida");
    }
    
    public void preparoPedido() throws InterruptedException {
        Thread.sleep(1000);
    }
    
    public void llevoPedido() {
        semPedidoListo.release();
        System.out.println("Llevo pedido...");
    }

    public Semaphore getSemPedidoMozo() {
        return semPedido;
    }

    public Semaphore getSemPedidoListoMozo() {
        return semPedidoListo;
    }       
}
