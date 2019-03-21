/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eslotto;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

/**
 *
 * @author pizzd
 */
public class ThSecondo extends Thread{
      private DatiCondivisi PtrDati;
    
    
    public ThSecondo(DatiCondivisi dati) {
        PtrDati=dati;
    }
     public void run() {
        try {
            while(!PtrDati.isFinito()) {
            PtrDati.WaitSem3();
            for(int i=0;i<5;i++) {
                if(PtrDati.RestituisciNumero(i)==PtrDati.getSecondoNumero()) {
                    PtrDati.setSecondoTrovato(true);
                }
            }
            
            PtrDati.SignalSem1();
            }
        } catch (InterruptedException ex) {
           
        }
    }
}

