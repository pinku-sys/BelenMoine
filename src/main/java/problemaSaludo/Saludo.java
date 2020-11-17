/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaSaludo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Pinku
 */
public class Saludo {

    private int empleadosActuales = 0;
    private int numEmpleadosTotales; //preguntar si esta bien.
    private boolean saludoJefe = false;
    //private Lock llave = new ReentrantLock(true);
    //private Condition empleados;
    //private Condition jefe; //preguntar¿

    public Saludo(int numEmpleadosTotales) {
        this.numEmpleadosTotales = numEmpleadosTotales;
        //empleados = llave.newCondition(); //conjunto de espera empleados
        //jefe = llave.newCondition(); //conjunto de espera jefe
    }

    public synchronized void saludaJefe() throws InterruptedException {
        while (empleadosActuales < numEmpleadosTotales) {
            this.wait();
        }
        System.out.println("Hola empleados");
        saludoJefe = true;
        this.notifyAll();
    }

    public synchronized void saludaEmpleado(String nombre) throws InterruptedException {
        empleadosActuales++;
        if (empleadosActuales == numEmpleadosTotales) {
            this.notifyAll(); // como es monitores y no puedo elegir el que se despierta debo despertarlos a todos
        }
         
        //espero hasta que mi jefe salude
        while (!saludoJefe) {
            this.wait();
        }

        System.out.println(nombre + " :Hola jefe!");
    }

}
