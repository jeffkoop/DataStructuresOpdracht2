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
   
    public static void Insertion(ArrayList<Student> sort){
           
      for (int i = 0; i < sort.size() ; i++) {
          temp = sort.get(i);
          index = i;
   
          //temp(student) vergeleken met de vorige student in compareTo method van de Class Student.
          //Als temp hoger is dan verplaats het vorig student een index hoger, 
          //'index' wordt steeds lager en de getallen worden steeds hoger totdat temp een getal tegen komt 
          //die hoger is dan hem zelf.
                while (index > 0 && temp.compareTo(sort.get(index - 1)) > 0)
                {
                sort.set(index, sort.get(index - 1));
                index --;
                }
            sort.set(index, temp);
          }
    } 
}
