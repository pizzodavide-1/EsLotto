/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eslotto;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Scanner;

/**
 *
 * @author pizzd
 */
public class Eslotto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input=new Scanner(System.in);
        String ruoteVinc="";
        int contVinc=0;
        
        System.out.println("Inserire il numero di estrazioni che si vogliono fare");
        int nEstrazioni=input.nextInt();
        
        System.out.println("Inserire i 2 numeri su cui si vuole  puntare:");
        System.out.print("1)");
        int n1=input.nextInt();
         System.out.print("2)");
         int n2=input.nextInt();
         
         DatiCondivisi dati=new DatiCondivisi(nEstrazioni);
          dati.setPrimoNumero(n1);
        dati.setSecondoNumero(n2);
        
          ThGenera th1=new ThGenera(dati);
        ThPrimoNumero th2=new ThPrimoNumero(dati);
        ThSecondo th3=new ThSecondo(dati);
        
        th1.start();
        th2.start();
        th3.start();
        
         try {
            dati.WaitSemFinito();
            
            for(int i=0;i<nEstrazioni;i++) {
                if(dati.RestituisciRuotaVincente(i)) {
                    contVinc++;
                    ruoteVinc=ruoteVinc+(i+1)+" ";
                }
            }
            ruoteVinc=ruoteVinc.trim();
            ruoteVinc=ruoteVinc+")";
            if(contVinc==0) {
                System.out.println("Nessuna ruota vincente");
            }
            else {
                System.out.println("Complimenti ha vinto su: "+contVinc+" ruota/e"+ruoteVinc);
            }
            
            
            
        } catch (InterruptedException ex) {
           
        }
        
    }
    
}
