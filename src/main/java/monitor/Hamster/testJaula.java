/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Hamster;

/**
 *
 * @author Pinku
 */
public class testJaula {

    public static void main(String[] args) {
        int maximo = 3;
        Jaula j = new Jaula(new Rueda(), new Plato(maximo));
        for (int i = 0; i < 3; i++) {
            new Thread(new Hamster(j), "Hamster " + i).start();
        }
    }
}
