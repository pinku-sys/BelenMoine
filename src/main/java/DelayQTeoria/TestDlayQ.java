/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DelayQTeoria;

import MoineFAI1641Parcial2.ejercicio1.HiloExtrae;
import MoineFAI1641Parcial2.ejercicio1.HiloInsertor;

/**
 *
 * @author Pinku
 */
public class TestDlayQ {
        public static void main(String[] args) {
        //Variables que llevan la cantidad
        int hc = 2;
        int hp = 4;
        Buffer bf = new Buffer();
        //Creacion de hilos 
        for (int i = 0; i <= hp; i++) {
            new Thread(new Productor(bf, "HILO productor " + i)).start();
        }
         for (int i = 0; i <= hc; i++) {
            new Thread(new Consumidor(bf, "HILO consumidor " + i)).start();
        }
        
    }
}
