/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoCatorce;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Cocinero implements Runnable {
     Restoran buffet;

    public Cocinero(Restoran buffet) {
        this.buffet = buffet;
    }
     
    @Override
    public void run() {
         try {
             while(true) {
             buffet.preparoRecetasNuevas();
             buffet.tomoPedidoComida();
             buffet.preparoComida();
             buffet.llevoComida();
             }
         } catch (InterruptedException ex) {
             Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
