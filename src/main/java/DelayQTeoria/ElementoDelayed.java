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
    private long tiempoDelay;

    public ElementoDelayed(int item, long delay) {
        this.item = item;
        this.tiempoDelay = delay;
        //Tiempo expira es el tiempo actual + delay
        this.tiempoExpira = System.currentTimeMillis()+delay;
    }
    
    

    @Override
    public long getDelay(TimeUnit unit) {
        return this.tiempoDelay;
    }

    @Override
    public int compareTo(Delayed o) {
        int res;
        long miTiempo = this.getDelay(TimeUnit.MILLISECONDS);
        long suTiempo = o.getDelay(TimeUnit.MILLISECONDS);
        if ( miTiempo < suTiempo) {
            res = -1; //menor
        } else {
            res = 1; //mayorOIgual
        }
        return res;
    }
    
}
