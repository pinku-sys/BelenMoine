/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoTres;

/**
 *
 * @author Pinku
 */
public class testProceso {
    public static void main(String[] args) throws InterruptedException {
        
    //cambiar el nombre de la clase escribe
    Turno manejador = new Turno();
    Proceso a = new Proceso(1,'A',manejador,1);
    Proceso b = new Proceso(2,'B',manejador,2);
    Proceso c = new Proceso(3,'C',manejador,3);
    Thread a1 = new Thread(a);
    Thread b1 = new Thread(b);
    Thread c1 = new Thread(c);
    a1.start();
    b1.start();
    c1.start();
    }
    
    
}
