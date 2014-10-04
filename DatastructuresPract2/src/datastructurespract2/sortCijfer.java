/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructurespract2;

import java.util.ArrayList;

/**
 *
 * @author Hokaki
 */
public class sortCijfer {
    
    private static Student temp = null;
    private static int index = 0;

      public static void Insertion(ArrayList<Student> sort){
          
      for (int i = 1; i < sort.size() ; i++) {
          temp = sort.get(i);
          index = i;
          
                while (index > 0 && temp.compareTo(sort.get(index - 1)) > 0)
                {
                sort.set(index, sort.get(index - 1));
                index --;
                }
            sort.set(index, temp);
          }
      
      System.out.println("\n\nStudenten gesorteerd op Cijfer:\n\n");
      
      for (int i = 0; i < sort.size(); i++) {
          System.out.println(sort.get(i));
      }
    } 
}
