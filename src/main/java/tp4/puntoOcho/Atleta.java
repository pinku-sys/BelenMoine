/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoOcho;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Atleta implements Runnable {
    private Carril miCarril;
    private int milugar;

    public Atleta(Carril miCarril, int lugar) {
        this.miCarril = miCarril;
        this.milugar = lugar;
    }
    
    @Override
    public void run() {
        try {
            miCarril.correr(milugar);
        } catch (InterruptedException ex) {
            Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
