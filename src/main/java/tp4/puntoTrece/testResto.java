/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoTrece;

/**
 *
 * @author Pinku
 */
public class testResto {

    public static void main(String[] args) {
        Restoran resto = new Restoran();
        for (int i = 0; i < 6; i++) {
            new Thread(new Cliente(resto), "Cliente  " + i).start();
        }
        new Thread(new Mozo(resto)).start();

    }

}
