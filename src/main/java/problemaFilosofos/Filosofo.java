/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaFilosofos;

import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.Aleatorio;

/**
 *
 * @author Pinku
 */
public class Filosofo implements Runnable {

    String nombre;
    Mesa mesa;

    public Filosofo(String nombre, Mesa mesa) {
        this.nombre = nombre;
        this.mesa = mesa;
    }

    @Override
    public void run() {
        try {
            mesa.tomarTenedores();//tomo los tenedores
            int esperaRandom = Aleatorio.intAleatorio(1000, 3000);
            Thread.sleep(esperaRandom);
            System.out.println(nombre + " comiendo...");
            mesa.soltarTenedores();
            System.out.println(nombre + " pensando...");
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
