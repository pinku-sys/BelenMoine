/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

/**
 *
 * @author Pinku
 */
public class testMuseo {

    public static void main(String[] args) {
        int cantidadP = 60;
        int cantJ = 15;
        Museo m = new Museo();

        for (int i = 1; i < cantidadP; i++) {
            new Thread(new NoJubilada("Persona " + i, m)).start();
        }
        for (int i = 1; i < cantJ; i++) {
            new Thread(new Jubilada("Jubilado " + i, m)).start();
        }
        new Thread(new Termostato(m)).start();
    }

}
