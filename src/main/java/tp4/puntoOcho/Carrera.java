/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoOcho;

/**
 *
 * @author Pinku
 */
public class Carrera {

    public static void main(String[] args) {
        Carril carrilPrincipal = new Carril(4);
        for (int i = 1; i <= 4; i++) {
            new Thread(new Atleta(carrilPrincipal,i), "atleta " + i).start();
        }
    }
}
