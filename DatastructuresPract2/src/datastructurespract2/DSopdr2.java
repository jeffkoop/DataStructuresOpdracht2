package datastructurespract2;

import java.util.Collections;

/**
 *
 * @author Jeff
 */
public class DSopdr2 {

    public static void main(String[] args) {
//        Generator gen = new Generator(400);
////        gen.printList();
//        sortCijfer.Insertion(gen.getStudentList());
//        gen.printClass(0);
        Generator gen = new Generator(128);
        System.out.println("before sort:");
        gen.printList();
        
        SortBucket.sort(gen.getStudentList());
        System.out.println("after bucket sort:");
        gen.printList();
        
        System.out.println("shuffle list again...");
        Collections.shuffle(gen.getStudentList());
        SortKlasStudent.sort(gen.getStudentList());
        System.out.println("after KlasStudent sort:");
        gen.printList();
    }

}
