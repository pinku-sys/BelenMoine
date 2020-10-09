/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoTrece;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Mozo implements Runnable{
    Restoran buffet;

    public Mozo(Restoran buffet) {
        this.buffet = buffet;
    }
    
    @Override
    public void run() {
        try {
            while(true) {
            buffet.hooby();
            buffet.ofrezcoMenu();
            buffet.tomoPedido();
            buffet.preparoPedido();
            buffet.llevoPedido();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
