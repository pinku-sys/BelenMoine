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
public class ServicioMozo {
    
    Semaphore semPedido = new Semaphore(0);
    Semaphore semPedidoListo = new Semaphore(0);
    Semaphore semMenu = new Semaphore(0);
    Semaphore semMozo = new Semaphore(0);
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
    
    public void ofrezcoMenu(int opcion) throws InterruptedException {
        semMozo.acquire();
        System.out.println("Soy el mozo y muestro opciones, el cliente me dice lo que desea...");
        semMenu.release();
    }
    
    public void tomoPedido(Semaphore tomarOrden, int opcion) throws InterruptedException {
        tomarOrden.acquire();
        System.out.println("Tomando pedido y actuando de acuerdo a eso");
    }
    
    public void preparoPedido() throws InterruptedException {
        Thread.sleep(1000);
    }
    
    public void llevoPedido() {
        semPedidoListo.release();
        System.out.println("Llevo pedido...");
    }

    public Semaphore getSemPedido() {
        return semPedido;
    }

    public Semaphore getSemPedidoListo() {
        return semPedidoListo;
    }

    public Semaphore getSemMenu() {
        return semMenu;
    }

    public Semaphore getSemMozo() {
        return semMozo;
    }
    
    
    
}
