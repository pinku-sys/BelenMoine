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
public class Pasajero implements Runnable {
     Tren atraccion;
     String nombre;
    public Pasajero(Tren atraccion, String nombre) {
        this.atraccion = atraccion;
        this.nombre = nombre;
    }

    @Override
    public void run() {
         try {
             
             atraccion.comprarTicket();
             System.out.println(nombre+ " compre un ticket con exito");
             atraccion.subirseTren();
             atraccion.bajarseTren();
             System.out.println(nombre + " me baje del recorrido con exito");
         } catch (InterruptedException ex) {
             Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
