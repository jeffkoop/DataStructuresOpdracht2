/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurespract2;

import java.util.ArrayList;
import nl.hva.dmci.ict.inf.ads.lib.StdOut;
import nl.hva.dmci.ict.inf.ads.lib.Stopwatch;

/**
 *
 * @author Hokaki
 */
public class sortCijfer {
    
    private static Student temp = null;
    private static int index = 0;

    private static Stopwatch stopwatch = new Stopwatch();
    private static double t0;
    private static double t1;
    private static double lapTime;
    
      
    public static void Insertion(ArrayList<Student> sort){
           
      for (int i = 0; i < sort.size() ; i++) {
          temp = sort.get(i);
          index = i;
          t0 = stopwatch.elapsedTime();
                while (index > 0 && temp.compareTo(sort.get(index - 1)) > 0)
                {
                sort.set(index, sort.get(index - 1));
                index --;
                }
                
            sort.set(index, temp);
            t1 = stopwatch.elapsedTime();
            lapTime = (1000*t1-1000*t0)/1000;
            
            StdOut.println(i +  ": (" + lapTime + "\t " + t1 +")"); 
          }
      
      System.out.println("\n\nStudenten gesorteerd op Cijfer:\n\n");
      
      for (int i = 0; i < sort.size(); i++) {
          System.out.println(sort.get(i));
      }
    } 
}
