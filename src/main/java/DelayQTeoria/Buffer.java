/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DelayQTeoria;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 *
 * @author Pinku
 */
public class Buffer {

    /**
     * DelayQueue habla de que al insertar un elemento se le agrega un tiempo de
     * expiracion. Al expirar ese tiempo segun el metodo que se utilice SE
     * PUEEDE OBTENER o no el elemento. SOLO SE LE PUEDE INGRESAR ELEMENTOS CON
     * DELAY "DELAYED" Una interfaz de estilo mixto para marcar objetos sobre
     * los que se debe actuar después de un retraso determinado.
     */
    private DelayQueue<ElementoDelayed> colaSincronizada;

    public Buffer() {
        this.colaSincronizada = new DelayQueue<ElementoDelayed>();

    }

    /**
     * put(E e) Inserta el elemento especificado en esta cola de retardo. (si la
     * cola es ilimitada nunca se bloquea el hilo offer(E e) Inserta el elemento
     * especificado en esta cola de retardo. add(E e) Inserta el elemento
     * especificado en esta cola de retardo.
     *
     * @param algo
     */
    public void insertar(ElementoDelayed algo) {
        this.colaSincronizada.put(algo);
    }

    /**
     * Utilizo metodo TAKE: take() Recupera y elimina el encabezado de esta
     * cola, esperando si es necesario hasta que un elemento con un retraso
     * vencido esté disponible en esta cola.REMOVE: RECUPera y elimina el
     * encabezado de la cola, si esta presente haya EXPIRADO SU TIEMPO D ESPERA
     * o no.
     *
     * @throws java.lang.InterruptedException
     */
    public ElementoDelayed extraer() throws InterruptedException {
        System.out.println("me voy  a trabar");
        ElementoDelayed cabeza = this.colaSincronizada.take();
        System.out.println(" me destrabe");
        return cabeza;
    }

    public int cantidadElementos() {
        int cantElementos;
        cantElementos = this.colaSincronizada.size();
        return cantElementos;
    }

    public void eliminarTodo() {
        this.colaSincronizada.clear();

    }
}
