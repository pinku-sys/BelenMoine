/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DelayQTeoria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Consumidor implements Runnable {
    Buffer buffer;
    String nombre;

    public Consumidor(Buffer buffer, String nombre) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            this.buffer.extraer();
            System.out.println(nombre +" extrajo cabecera");
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
