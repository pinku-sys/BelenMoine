/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaProdCons;


/**
 *
 * @author jck-c
 */
public class Mainej1 {

    public static void main(String[] args) {
        
        int maximoProductos=5;

        Buffer buffer = new Buffer(maximoProductos);
        Productor prod = new Productor("Productor1", buffer);
        Consumidor consum = new Consumidor("Consumidor1", buffer);

        new Thread(prod,"Productor1").start();
        new Thread(consum).start();
        
    }
    
}
