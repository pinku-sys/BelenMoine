/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.Aleatorio;

/**
 *
 * @author Pinku
 */
public class Termostato implements Runnable {

    Museo m;

    public Termostato(Museo m) {
        this.m = m;
    }

    @Override
    public void run() {
        while (true) {
            int tempRandom = Aleatorio.intAleatorio(10, 50);
            
            m.notificarTemperatura(tempRandom);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Termostato.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(" se cambio la temperatura ");
        }
    }

}
