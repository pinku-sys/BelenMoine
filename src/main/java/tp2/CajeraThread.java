/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class CajeraThread {
private String nombre;
private ClienteCajera cliente;
private long initialTime;

    public CajeraThread(String nombre, ClienteCajera cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

// Constructor, y métodos de acceso

public void run() {
System.out.println("La cajera " + this.nombre +
" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
+ this.cliente.getNombre() + " EN EL TIEMPO: "
+ (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
    try {
        this.esperarXsegundos(cliente.getCarroCompra()[i]);
    } catch (InterruptedException ex) {
        Logger.getLogger(CajeraThread.class.getName()).log(Level.SEVERE, null, ex);
    }
System.out.println("Procesado el producto " + (i + 1) + "del cliente " + this.cliente.getNombre() + "->Tiempo: " +(System.currentTimeMillis() - this.initialTime) / 1000+ "seg");
}
System.out.println("La cajera" + this.nombre + "HA TERMINADO DEPROCESAR"+ this.cliente.getNombre() + " EN EL TIEMPO: " +(System.currentTimeMillis() - this.initialTime) / 1000 +
"seg");
}

  public void esperarXsegundos(int obj) throws InterruptedException {
        Thread.sleep(obj*1000);
    }
}
