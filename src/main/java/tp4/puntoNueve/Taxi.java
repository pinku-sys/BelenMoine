/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoNueve;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class Taxi {

    /**
     * Mientras usted esta ocupado caminando por la calle buscando un taxi, el
     * taxista está durmiendo plácidamente en la cabina. Cuando usted le avisa
     * que quiere tomar el taxi, él se despierta y comienza a conducir. Cuando
     * usted arriba a su destino, el taxista le notifica que ha llegado y
     * continúa con su trabajo. El taxista debe ahora esperar y dormir
     * nuevamente una siesta hasta que el próximo pasajero llegue. Diseñe una
     * solución de comunicación de los hilos que modele dicha situación
     */
    Semaphore taxista = new Semaphore(0);
    Semaphore destino = new Semaphore(0);
    
    public void quieroAndar () throws InterruptedException {
        taxista.release();
        //deberia simular tiempo con sleep?
        destino.acquire();
    }
    
    public void conduzco() throws InterruptedException {
        taxista.acquire();
        //deberia simular tiempo con sleep?
        destino.release();
        
    }

}
