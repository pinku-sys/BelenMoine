/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoCuatro;

/**
 *
 * @author Pinku
 */
public class TestAuto {

    public static void main(String[] args) {

        Gasolinera gasolineria = new Gasolinera(1000);
        Auto a1 = new Auto(1244, 5, "BELEN", 500, gasolineria);
        Auto a2 = new Auto(1254, 4, "RAMON", 100, gasolineria);
        Auto a3 = new Auto(1264, 3, "PABLO", 800, gasolineria);
        Auto a4 = new Auto(1284, 2, "VENTO", 700, gasolineria);
        Auto a5 = new Auto(1294, 1, "BORA", 800, gasolineria);

        Thread a11 = new Thread(a1);
        Thread a12 = new Thread(a2);
        Thread a13 = new Thread(a3);
        Thread a14 = new Thread(a4);
        Thread a15 = new Thread(a5);

        a11.start();
        a12.start();
        a13.start();
        a14.start();
        a15.start();

    }
}
