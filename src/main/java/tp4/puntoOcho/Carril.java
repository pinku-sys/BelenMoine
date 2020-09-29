/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoOcho;

import java.util.concurrent.Semaphore;
import utiles.Aleatorio;

/**
 *
 * @author Pinku
 */
public class Carril {

    /**
     * el tryacquire intenta tomar y es para hacer otra tarea que no
     * necesariamente sean las 2 seguidas
     *
     * primera: 2 equipos (sin orden¿-que los atletas no usen testigos que no
     * sean de su equipo) (2 testigos) segunda: 1 equipo de 4 en orden
     * secuencial (1 testigo) generar un orden con mas semaforos
     */
    Semaphore testigo = new Semaphore(1);
    Semaphore[] atletas;

    public Carril(int cantidadAtletas) {
        //permito elegir la cantidad de letras que quiera escribir
        //caso especial, el primer semaforo siempre es 1.
        atletas = new Semaphore[cantidadAtletas + 1];
        atletas[1] = new Semaphore(1);

        for (int i = 2; i < atletas.length; i++) {
            //los siguientes son 0.
            atletas[i] = new Semaphore(0);
        }
    }

    public void correr(int lugar) throws InterruptedException {
        atletas[lugar].acquire();
        testigo.acquire();
        System.out.println("el atleta " + lugar + " esta corriendo ");
        int tiempoCorrer = Aleatorio.intAleatorio(9000, 11000);
        Thread.sleep(tiempoCorrer);
        System.out.println("el atleta " + Thread.currentThread().getName() + " tardo: " + tiempoCorrer / 1000 + " segundos en correr ");
        testigo.release();
        if (lugar != atletas.length - 1) {
            atletas[lugar + 1].release();
        }
    }

}
