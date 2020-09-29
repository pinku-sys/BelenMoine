/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoNueve;

/**
 *
 * @author Pinku
 */
public class testTaxi {
    public static void main(String[] args) {
        Taxi t = new Taxi();
        Cliente yo = new Cliente(t);
        Taxista tachero = new Taxista(t);
        yo.start();
        tachero.start();
    }
}
