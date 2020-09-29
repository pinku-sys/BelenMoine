/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoNueve;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Taxista extends Thread {
    Taxi miTaxi;

    public Taxista(Taxi miTaxi) {
        this.miTaxi = miTaxi;
    }
    
    
    
    public void run() {
        try {
            miTaxi.conduzco();
            System.out.println("Termine un viaje");
        } catch (InterruptedException ex) {
            Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
