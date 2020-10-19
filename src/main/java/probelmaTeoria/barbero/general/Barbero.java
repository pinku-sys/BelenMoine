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
public class Barbero implements Runnable {

    //elemento compartido
    protected Barberia miTrabajo;

    public Barbero(Barberia miTrabajo) {
        this.miTrabajo = miTrabajo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                miTrabajo.esperarCliente();
                miTrabajo.atender();
                miTrabajo.terminarAtencion();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
