/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaFilosofos.v2;

/**
 *
 * @author Pinku
 */
public class Mesa {
    
    /*
    * Solo toman de a dos tenedores.
     */
    //private Semaphore tenedores;
    private Boolean[] tenedores;

    public Mesa(int tenedores) {
        /**
         * en una primera instancia todos los tenedores estan en true " libres
         * ".
         * Podria considerar otra forma en la que el filosofo envia su posición.
         * 
         */
        this.tenedores = new Boolean[tenedores];
        for (int i = 0; i < tenedores; i++) {
            this.tenedores[i] = true;
        }

    }

    public synchronized void tomarTenedores(int tenedorI, int tenedorD) throws InterruptedException {

        boolean tenedorIzq = tenedores[tenedorI];
        boolean tenedorDer = tenedores[tenedorD];

        while (!(tenedorIzq && tenedorDer)) {
            this.wait();
            tenedorIzq = tenedores[tenedorI];
            tenedorDer = tenedores[tenedorD];
        }
        tenedores[tenedorI] = false;
        tenedores[tenedorD] = false;
    }

    public synchronized void soltarTenedores(int tenedorI, int tenedorD) {
        tenedores[tenedorI] = true;
        tenedores[tenedorD] = true;
        notifyAll();
    }
}
