/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/**
 *
 * @author Pinku
 */
public class Prueba {

    public static void main(String[] args) {
        PingPong t1 = new PingPong("PING", 33);
        PingPong t2 = new PingPong("PONG", 40);
        PingPong t3 = new PingPong("PANG", 40);
        PingPong t4 = new PingPong("PUNG", 40);
        // Activación
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        for (int i = 1 ; i<50;i++) {
            System.out.println("EN EL MAIN ITERO");
            try {
            System.out.println("duerme");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
            
        }
        // Espera unos segundos
      /**  try {
            System.out.println("duerme");
            Thread.sleep(5000);
            System.out.println("duerme");
        } catch (InterruptedException e) {
        };
        * 
        * */
        // Finaliza la ejecución de los threads
    }
}

