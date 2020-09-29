/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoSeis;

import java.util.HashMap;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class Turno {

    /**
     * Preguntar si debo crear clases concretas para cada tipo de hilo, y asi
     * cada clase llamara al metodo que corresponde, en vez de usar un switch
     * que pregunte por el nombre del hilo entonces irá al método
     * correspondiente.
     *
     * Preguntar tambien si puedo liberar varios permisos.
     *
     * utilizar un hashmap -- NO USAR SWITCH.
     *
     * diccionario con claves que sean las letras. arreglo con 2 semaforos.
     */
    private Semaphore[] mapaSemaforos;

    private void inicializarArreglo() {

    }

    public Turno(int cantidadLetras) {
        //permito elegir la cantidad de letras que quiera escribir
        //caso especial, el primer semaforo siempre es 1.
        mapaSemaforos = new Semaphore[cantidadLetras + 1];
        mapaSemaforos[1] = new Semaphore(1);

        for (int i = 2; i < mapaSemaforos.length; i++) {
            //los siguientes son 0.
            mapaSemaforos[i] = new Semaphore(0);
        }
    }

    private void escribeAux(char letra, int repeticion) {
        for (int i = 0; i < repeticion; i++) {
            System.out.print(letra);
        }
    }

    public void escribe(char letra, int repeticion, int mipos) throws InterruptedException {
        //en mod cuando el primero mas chico el resultado de mod es el primer numero.
        int tamañoArreglo = mapaSemaforos.length;
        int siguiente = ((mipos + 1) % tamañoArreglo);
  
        mapaSemaforos[mipos].acquire();
        escribeAux(letra, repeticion);
        if (mipos != tamañoArreglo-1) { 
            mapaSemaforos[siguiente].release();
        } else {
            mapaSemaforos[1].release();
        }
        

    }

}
