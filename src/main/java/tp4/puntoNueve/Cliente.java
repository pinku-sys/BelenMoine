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
public class Cliente extends Thread {
    //cambiar nombre a pasajero
    Taxi elTaxi;

    public Cliente(Taxi elTaxi) {
        this.elTaxi = elTaxi;
    }
    
    
    public void run() {
        try {
            //simular que estoy caminando
            Thread.sleep(5000);
            //hasta subirme al taxi
            elTaxi.quieroAndar();
            System.out.println("llegue a destino");
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
        
        
    }
}
