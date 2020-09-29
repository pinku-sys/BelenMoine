/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoSeis;

/**
 *
 * @author Pinku
 */
public class testProceso {
    public static void main(String[] args) {
        
    
    Turno elturno = new Turno(3);
    Proceso a= new Proceso('A',elturno,1,1);
    Proceso b= new Proceso('B',elturno,2,2);
    Proceso c= new Proceso('C',elturno,3,3);
       Thread a1= new Thread(a);
       Thread b2= new Thread(b);
       Thread b3= new Thread(c);
       a1.start();b2.start();b3.start();
        
    }
}
