package datastructurespract2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jeff
 */
public class SortBucket {

    public static void sort(ArrayList<Student> s) {
        // first find out what classes are in the list so you can make them into buckets
        ArrayList<String> klassen = null;
        String previous = s.get(0).getKlasNummer();
        klassen.add(previous);
        for (int i = 1; i < s.size(); i++) {
            String nextKlas =  s.get(i).getKlasNummer();
            if(!nextKlas.equals(previous)){
                klassen.add(nextKlas);
            }
        }

        for (int i = 0; i < s.size(); i++) {
            for (int j = i; j > 0 && less(s.get(j).getKlasNummer(), s.get(j - 1).getKlasNummer()); j--) {
                exch(s, j, j - 1);
            }
        }

        for (int i = 0; i < s.size(); i++) {
            for (int j = i; j > 0 && less(s.get(j).getStudentNummer(), s.get(j - 1).getStudentNummer()); j--) {
                exch(s, j, j - 1);
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;

    }

    private static void exch(ArrayList<Student> s, int x, int y) {
        Collections.swap(s, x, y);
    }
}
