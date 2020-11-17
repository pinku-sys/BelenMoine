/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaProdCons;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jck-c
 */
public class Productor implements Runnable {

    private String nombre;
    private Buffer buf;

    public Productor(String n, Buffer b) {
        this.nombre = n;
        this.buf = b;
    }

    public void run() {
        while (true) {
            try {
                buf.producir();
                //System.out.println("Soy un productor y creé un objeto.");
                Thread.sleep((int) (Math.random() * (2500 - 1500) + 1500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
