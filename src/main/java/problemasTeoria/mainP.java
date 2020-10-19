/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemasTeoria;

/**
 *
 * @author Pinku
 */
public class mainP {
    public static void main(String[] args) {
        semaforosDePaso rc  = new semaforosDePaso();
        for(int i=0;i<3;i++) {
            new Thread(new Proceso(i,rc)).start();
        }
        
    }
    
}
