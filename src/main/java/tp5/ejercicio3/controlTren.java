/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class controlTren implements Runnable{
     Tren atraccion;

    public controlTren(Tren atraccion) {
        this.atraccion = atraccion;
    }

    @Override
    public void run() {
         try {
             while (true) {
             atraccion.empezarRecorrido();
             System.out.println(" Iniciamos el recorrido");
             atraccion.terminarRecorrido();
             System.out.println(" Fin del recorrido");
             }
         } catch (InterruptedException ex) {
             Logger.getLogger(controlTren.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
 