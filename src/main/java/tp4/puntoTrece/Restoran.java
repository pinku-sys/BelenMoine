/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoTrece;

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
    Silla unaSilla = new Silla();
    ServicioMozo unServicioMozo = new ServicioMozo();

    //metodos propios de cliente
    /**
     * sentarse elegirPedido comer salir
     */
    public void sentarse() throws InterruptedException {
        unaSilla.sentarse(unServicioMozo.getSemMozo());
    }

    public void elegirPedido() throws InterruptedException {
        unaSilla.elegirPedido(unServicioMozo.getSemMenu());
    }

    public void comer() throws InterruptedException {
        unaSilla.comer(unServicioMozo.getSemPedidoListo());
    }

    public void salir() {
        unaSilla.salir();
    }

    public void hooby() throws InterruptedException {
        unServicioMozo.hobby();
    }

    public void ofrezcoMenu() throws InterruptedException {
        unServicioMozo.ofrezcoMenu(1);
    }

    public void tomoPedido() throws InterruptedException {
        unServicioMozo.tomoPedido(unaSilla.getsemOrden(), 0);
    }

    public void preparoPedido() throws InterruptedException {
        unServicioMozo.preparoPedido();
    }

    public void llevoPedido() {
        unServicioMozo.llevoPedido();
    }
}
