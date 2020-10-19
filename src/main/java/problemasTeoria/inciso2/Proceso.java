/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemasTeoria.inciso2;

import problemasTeoria.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Proceso implements Runnable {
    private int numero;
    private semaforosDePaso rc;

    public Proceso(int numero, semaforosDePaso rc) {
        this.numero = numero;
        this.rc = rc;
    }
    
    
    @Override
    public void run() {
        while(true){
        try {
            rc.andar(numero);
        } catch (InterruptedException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
}
