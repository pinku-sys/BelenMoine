/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaFilosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Pinku
 */
public class Mesa {
    private Semaphore tenedores;

    public Mesa(int tenedores) {
        this.tenedores= new Semaphore(tenedores);
    }
    
    public void tomarTenedores() throws InterruptedException {
        this.tenedores.acquire(2); 
    }
    
    public void soltarTenedores() {
        this.tenedores.release(2);
    }
    
    
}
