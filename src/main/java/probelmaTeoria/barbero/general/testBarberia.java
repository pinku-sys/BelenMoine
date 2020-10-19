/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probelmaTeoria.barbero.general;

import problemaTeoria.barbero.*;

/**
 *
 * @author Pinku
 */
public class testBarberia {

    public static void main(String[] args) {
        Barberia br = new Barberia();
        Barbero barb = new Barbero(br);
        Thread hiloBarbero = new Thread(barb);       
        for (int i = 0; i< 5; i++) {
            new Thread(new Cliente(br)).start();
        }
        hiloBarbero.start();
    }

}
