package datastructurespract2;

import java.util.Comparator;

/**
 *
 * @author Jeff
 */
public class CompareStudents implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        Comparable c1 = s1.getKlasNummer();
        Comparable c2 = s2.getKlasNummer();

        int klasResult = c1.compareTo(c2);
        if (klasResult != 0) {
            return klasResult;
        }

        c1 = s1.getStudentNummer();
        c2 = s2.getStudentNummer();
        return c1.compareTo(c2);
    }
}