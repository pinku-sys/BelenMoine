/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaSaludo.Condicional;

import problemaSaludo.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Pinku
 */
public class SaludoConditions {

    private int empleadosActuales = 0;
    private int numEmpleadosTotales; //preguntar si esta bien.
    private boolean saludo  = false;
    private Lock llave = new ReentrantLock(true);
    private Condition empleados;
    private Condition jefe; //preguntar¿

    public SaludoConditions(int numEmpleadosTotales) {
        this.numEmpleadosTotales = numEmpleadosTotales;
        empleados = llave.newCondition(); //conjunto de espera empleados
        jefe = llave.newCondition(); //conjunto de espera jefe
    }

    public void saludaJefe() throws InterruptedException {
        llave.lock();
        while (empleadosActuales < numEmpleadosTotales) {
            jefe.await();
        }
        System.out.println("Hola empleados");
        saludo=true;
        empleados.signalAll();
        llave.unlock();
    }

    public void saludaEmpleado(String nombre) throws InterruptedException {
        llave.lock();
        empleadosActuales++;
        if (empleadosActuales == numEmpleadosTotales) {
           jefe.signalAll();
        } 
        //espero hasta que mi jefe salude
        while (!saludo) {
            empleados.await();
        }
        System.out.println(nombre + " :Hola jefe!");
        llave.unlock();
    }

}
