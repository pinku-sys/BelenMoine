/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DelayQTeoria;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Pinku
 */
public class ElementoDelayed implements Delayed{    
    private int item;
    private long tiempoExpira;

    public ElementoDelayed(int item, long delay) {
        this.item = item;
        //Tiempo expira es el tiempo actual + delay
        this.tiempoExpira = System.currentTimeMillis()+delay;
    }
    
    
    @Override
    public long getDelay(TimeUnit unit) { /**
     * GET DELAY LO QUE HACE ES DESCONTAR TIEMPO DEL TIEMPO ACTUAL EN REALIDAD con el tiempo del sistema.
     */
        long diferencia = this.tiempoExpira  - System.currentTimeMillis();
        return unit.convert(diferencia, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        /**
         * Metodo necesario para dar un "orden". 
         */
        int res;
        long miTiempo = this.getDelay(TimeUnit.MILLISECONDS);
        long suTiempo = o.getDelay(TimeUnit.MILLISECONDS);
        if ( miTiempo < suTiempo) {
            res = -1; //MENOR
        } else {
            if (miTiempo > suTiempo) {
                res = -1; //MAYOR
            } else {
                res = 0; //IGUAL
            }
        }
        return res;
    }
    
    public String imprimir() {
       return("elemento : "+ this.item + "con Tiempo expiracion: " + this.tiempoExpira);
    }
    
}
