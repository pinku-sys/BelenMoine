/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoCatorce;

import tp4.puntoTrece.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class Restoran {

    /**
     * Una pequeña empresa (Los Pollos Hermanos) de 6 empleados dispone de un
     * pequeño lugar donde los empleados pueden tomar algo rápido (por ejemplo 1
     * café y una porción de pollo frito). La pequeña confitería es atendida por
     * un mozo y tiene espacio para 1 empleado. El mozo se encarga de servir
     * bebidas y el cocinero se encarga de la comida. Cuando un empleado desea
     * servirse algo se acerca al lugar, si el espacio está libre se queda, e
     * indica al mozo que está allí para que le sirvan. Elige lo que desea de
     * una pequeña lista de opciones, y espera pacientemente que le sirvan.
     * Cuando le han servido, le indican que puede empezar a comer. El empleado
     * come y cuando termina deja la silla libre, agradece al mozo y vuelve a
     * trabajar. Por su parte el mozo, cuando no hay empleados que atender,
     * aprovecha a disfrutar de su hobbie de inventar nuevas versiones de pollo,
     * hasta que llegue otro empleado.
     */
    Silla[] unaSilla = {new Silla(), new Silla()};
    ServicioMozo unServicioMozo = new ServicioMozo();
    ServicioCocinero unServicioCocinero = new ServicioCocinero();

    //metodos propios de cliente
    /**
     *
     * este medoo avisa al cliente si se sento, si se sento i es iguala la
     * posicion de su silla sino i = -1
     */
    public int sentarse() throws InterruptedException {
        int i = 0;
        boolean meSente = false;
        while (i < unaSilla.length && meSente==false) {
            
            meSente = unaSilla[i].sentarse();
            if (meSente==false) 
            i++;
        }

        //si no me sente, soy -1.
        if (meSente==false) {
            i = -1;
        }

        //retornare la pos del arreglo o un -1 como error.
        return i;
    }

    /**
     * Este metodo elige el pedido para cada silla del restoran. La verificacion
     * de que la silla este ocupada está arriba.
     *
     * @throws InterruptedException
     */
    public void elegirPedido(int miLugar) throws InterruptedException {

        Semaphore semCocinero = unServicioCocinero.getSemPedidoComida();
        Semaphore semMozo = unServicioMozo.getSemPedidoMozo();
        unaSilla[miLugar].elegirPedido(semCocinero, semMozo);
    }

    public void consumirPedido(int miLugar) throws InterruptedException {
        Semaphore cocineroListo = unServicioCocinero.getSemPedidoComidaListo();
        Semaphore cocineroParaOp3 = unServicioCocinero.getSemPedidoComida();
        Semaphore mozoListo = unServicioMozo.getSemPedidoListoMozo();
        unaSilla[miLugar].consumirPedido(mozoListo, cocineroListo, cocineroParaOp3);
    }

    public void salir(int miLugar) {
        unaSilla[miLugar].salir();
    }

    //fin metdos cliente
    //metodos mozo
    public void hooby() throws InterruptedException {
        unServicioMozo.hobby();
    }

    public void tomoPedido() throws InterruptedException {
        unServicioMozo.tomoPedido();
    }

    public void preparoPedido() throws InterruptedException {
        unServicioMozo.preparoPedido();
    }

    public void llevoPedido() {
        unServicioMozo.llevoPedido();
    }

    //fin metodos mozo
    
    /**inicio metodos cocinero
     preparoRecetasNuevas
     * tomoPedidoComida
     * preparoComida
     * llevoComidaç^*/
    public void preparoRecetasNuevas() throws InterruptedException {
        unServicioCocinero.preparoRecetasNuevas();
    }
    
    public void tomoPedidoComida() throws InterruptedException{
        unServicioCocinero.tomoPedidoComida();
    }
    
    public void preparoComida() throws InterruptedException {
        unServicioCocinero.preparoComida();
    }
    
    public void llevoComida() {
        unServicioCocinero.llevoComida();
    }
    //fin metodos Cocinero
}
