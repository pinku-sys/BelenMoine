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
public class Hamster implements Runnable {
    Jaula miJaula;

    public Hamster(Jaula miJaula) {
        this.miJaula = miJaula;
    }
    
    
    public void run () {
        while (true) {
            miJaula.comer();
            miJaula.rodar();
        }       
    }
    
}
