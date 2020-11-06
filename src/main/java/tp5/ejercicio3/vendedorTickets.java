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
public class vendedorTickets implements Runnable {
    Tren atraccion;
    String nombre;
    public vendedorTickets(Tren atraccion, String nombre) {
        this.atraccion = atraccion;
        this.nombre= nombre;
    }
    
    @Override
    public void run() {
        try {   
            while (true ) {
            atraccion.venderTicket();
            System.out.println(nombre+ " vendi un ticket");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(vendedorTickets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
