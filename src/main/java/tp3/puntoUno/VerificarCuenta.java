/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoUno;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class VerificarCuenta implements Runnable {

    private CuentaBanco cb = new CuentaBanco();
    

    public void run() {
        for (int i = 0; i <= 3; i++) {
            try {
                //manejar impresiones (sout) en el run
                cb.HacerRetiro(10);
                Thread.sleep(1000);
                if (cb.getBalance() < 0) {
                    System.out.println("La cuenta está sobregirada.");
                }               
            } catch (InterruptedException ex) {
                //esta excp no corta la ejecucion del hilo 
                //link:https://www.ibm.com/developerworks/library/j-jtp05236/index.html
                Logger.getLogger(VerificarCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
