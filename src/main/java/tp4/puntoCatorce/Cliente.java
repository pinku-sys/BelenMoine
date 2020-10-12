/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoCatorce;

import tp4.puntoTrece.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Cliente implements Runnable {

    Restoran buffet;
    String nombre;

    public Cliente(Restoran buffet, String nombre) {
        this.buffet = buffet;
        this.nombre=nombre;
    }

    @Override
    public void run() {
        try {
            int miLugar = buffet.sentarse();
            System.out.println("soy: " +nombre + "voy a intentar sentarme..");
            while (miLugar == -1){
   
                miLugar= buffet.sentarse();
                Thread.sleep(3000);
            }
            buffet.elegirPedido(miLugar);
            buffet.consumirPedido(miLugar);
            buffet.salir(miLugar);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
