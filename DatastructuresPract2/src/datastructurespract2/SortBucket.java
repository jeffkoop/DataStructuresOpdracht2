package datastructurespract2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Jeff
 */
public class SortBucket {

    public static void sort(ArrayList<Student> s) {
        // first find out what classes are in the list so you can make them into buckets
        SortedSet<String> klassenSet = new TreeSet();
        ArrayList<Klas> klasBucket = new ArrayList<>();
        for (int i = 1; i < s.size(); i++) {
            String nextKlas = s.get(i).getKlasNummer();
            if (!klassenSet.contains(nextKlas)) {
                klassenSet.add(nextKlas);
            }
        }

        //place sorted klassen in arraylist from sortedSet
        Iterator it = klassenSet.iterator();
        while (it.hasNext()) {
            String k = it.next().toString();
            Klas temp = new Klas(k);
            klasBucket.add(temp);
        }

        //place students in klasBucket
        for (Student x : s) {
            for (Klas k : klasBucket) {
                if (k.getClassId().equalsIgnoreCase(x.getKlasNummer())) {
                    k.addStudent(x);
                    break;
                }
            }
        }

        //clear the studentList, get the students of each klas in an arrayList and sort on studentNumber, add the contents of the small list to the studentList
        s.clear();
        for (Klas k : klasBucket) {
            ArrayList<Student> sList = k.getStudentList();
            for (int i = 0; i < k.getSize(); i++) {
                for (int x = i; x > 0 && less(sList.get(x).getStudentNummer(), sList.get(x - 1).getStudentNummer()); x--) {
                    exch(sList, x, x - 1);
                }
            }
            s.addAll(sList);
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;

    }

    private static void exch(ArrayList<Student> s, int x, int y) {
        Collections.swap(s, x, y);
    }
}
