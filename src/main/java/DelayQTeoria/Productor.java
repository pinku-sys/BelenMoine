/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DelayQTeoria;

import utiles.Aleatorio;

/**
 *
 * @author Pinku
 */
public class Productor implements Runnable {

    Buffer buffer;
    String nombre;

    public Productor(Buffer buffer, String nombre) {
        this.buffer = buffer;
        this.nombre = nombre;
    }
    

    @Override
    public void run() {
        int item;
        long delay;
            item = Aleatorio.intAleatorio(100, 500);
            delay = Aleatorio.intAleatorio(1, 10);
            ElementoDelayed algo = new ElementoDelayed(item, delay);
            this.buffer.insertar(algo);
            System.out.println(nombre+ " agrego elem: " + algo.imprimir());      
    }

}
