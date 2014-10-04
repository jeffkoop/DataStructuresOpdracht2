package datastructurespract2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jeff
 */
public class SortKlasStudent {

    public static void sort(ArrayList<Student> s) {
        for (int i = 1; i < s.size(); i++) {
            for (int x = i; x > 0 && less(s.get(x), s.get(x - 1)); x--) {
                exch(s, x, x - 1);
            }
        }
    }

    private static boolean less(Student s1, Student s2) {
        CompareStudents cs = new CompareStudents();
        return cs.compare(s1, s2) < 0;
    }

    private static void exch(ArrayList<Student> s, int x, int y) {
        Collections.swap(s, x, y);
    }
}
