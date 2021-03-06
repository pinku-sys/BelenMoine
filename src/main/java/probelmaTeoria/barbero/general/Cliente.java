/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probelmaTeoria.barbero.general;

import problemaTeoria.barbero.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Cliente implements Runnable {

    protected Barberia laBarberia;

    public Cliente(Barberia laBarberia) {
        this.laBarberia = laBarberia;
    }

    @Override
    public void run() {
        try {
            if (laBarberia.sentarmeSilla()) {
                laBarberia.sentarseSillon();
                laBarberia.solicitarCorte();
                laBarberia.esperarAtencion();
                laBarberia.salirBarberia();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

}
