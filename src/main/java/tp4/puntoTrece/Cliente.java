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
public class Cliente implements Runnable {

    Restoran buffet;

    public Cliente(Restoran buffet) {
        this.buffet = buffet;
    }

    @Override
    public void run() {
        try {
            buffet.sentarse();
            buffet.elegirPedido();
            buffet.comer();
            buffet.salir();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
