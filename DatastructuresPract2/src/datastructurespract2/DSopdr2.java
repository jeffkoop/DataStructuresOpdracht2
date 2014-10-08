package datastructurespract2;

import java.util.Collections;
import nl.hva.dmci.ict.inf.ads.lib.Stopwatch;

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

        Stopwatch stopwatch = new Stopwatch();
        double t0;
        double t1;
        double lapTime;
        Generator gen;
        
        int[] inputValues = {200, 400, 800, 1600, 3200};

        for (int j = 0; j < inputValues.length; j++) {
            gen = new Generator(inputValues[j]);
            System.out.println(inputValues[j]);
            
            System.out.println("after cijfer sort:");
            t0 = stopwatch.elapsedTime();
            sortCijfer.Insertion(gen.getStudentList());
            t1 = stopwatch.elapsedTime();
            lapTime = (1000 * t1 - 1000 * t0) / 1000;
            System.out.println("(" + t0 + "\t " + t1 + "\t laptime:" + lapTime + ")");
            
            Collections.shuffle(gen.getStudentList());
            
            System.out.println("after KlasStudent sort:");
            t0 = stopwatch.elapsedTime();
            SortKlasStudent.sort(gen.getStudentList());
            t1 = stopwatch.elapsedTime();
            lapTime = (1000 * t1 - 1000 * t0) / 1000;
            System.out.println("(" + t0 + "\t " + t1 + "\t laptime:" + lapTime + ")");

            Collections.shuffle(gen.getStudentList());

            System.out.println("after bucket sort:");
            t0 = stopwatch.elapsedTime();
            SortBucket.sort(gen.getStudentList());
            t1 = stopwatch.elapsedTime();
            lapTime = (1000 * t1 - 1000 * t0) / 1000;
            System.out.println("(" + t0 + "\t " + t1 + "\t laptime:" + lapTime + ")");
            System.out.println("\n");
        }

    }
}
