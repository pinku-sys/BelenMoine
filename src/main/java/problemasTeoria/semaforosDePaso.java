/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemasTeoria;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class semaforosDePaso {

    Semaphore s0 = new Semaphore(2);
    Semaphore s0_1 = new Semaphore(0);
    Semaphore s0_2 = new Semaphore(0);
    Semaphore s1_3 = new Semaphore(0);
    Semaphore s2_3 = new Semaphore(0);

    public void andar(int numeroProceso) throws InterruptedException {
        switch (numeroProceso) {
            case 0:                
                s0.acquire();
                System.out.println("actuando p0");
                s0_1.release();
                s0_2.release();
                Thread.sleep(1000);                              
                break;
            case 1:               
                System.out.println("hola. agarre");
                s0_1.acquire();
                System.out.println("actuando p1");
                s1_3.release();
                 Thread.sleep(1000);
                break;
            case 2:
                s0_2.acquire();
                System.out.println("actuando p2");
                s2_3.release();
                 Thread.sleep(1000);
            case 3:
                s1_3.acquire();
                s2_3.acquire();
                System.out.println("actuando p3");
                 Thread.sleep(1000);
        }
    }
}
