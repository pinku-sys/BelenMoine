/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaSaludo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class TestSaludo {

    public static void main(String argv[]) throws InterruptedException {
        int cantidadEmpleados = 5;
        Saludo hola = new Saludo(cantidadEmpleados);
        Thread[] elPersonal = new Thread[cantidadEmpleados+1];
        elPersonal[0] = new Thread(new Jefe("Jefe",hola));
        for (int i = 1; i <= cantidadEmpleados; i++) {
            elPersonal[i] = new Thread(new Empleado("EMPLEADO "+i,hola));
        }
        for (int i = 0; i < 6; i++) {
            elPersonal[i].start();
        }
        
        for (int i = 0; i < 6; i ++) {
            elPersonal[i].join();
        }
        
        System.out.println("LISTO, ahora que todos han saludado - a trabajar");
    }

}
