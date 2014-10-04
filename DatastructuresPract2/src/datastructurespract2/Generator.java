package datastructurespract2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Jeff
 */
public class Generator {

    private final int numStudents;
    private final int MAX_STUDENTS = 32;
    private final int CLASS_TYPES = 4;
    private final ArrayList<Student> studentList;
    private ArrayList<Klas> klassen;

    private final String[] CLASS_TYPE = {"IG", "IN", "IS", "IT"};
    private final int[] CLASS_NUMBER = {201, 201, 201, 201};

    public Generator(int numStudents) {
        this.numStudents = numStudents;
        studentList = new ArrayList<>();
        generateStudents();
        Collections.shuffle(studentList);//shuffle before generating classes means the students have a greater range of student numbers instead of:50060001, 50060002 etc.
        generateClasses();
        Collections.shuffle(studentList);//shuffle again or else the classes will appear in order on the studentList
    }

    private void generateClasses() {
        //calcultate amount of classes per orientations, amount of classes, amount of students per class.
        int numClasses = 0;
        int studentsPerClass = 0;
        int studentsPerOrientation = numStudents / CLASS_TYPES;
        if (studentsPerOrientation < MAX_STUDENTS) {
            numClasses = 1;
            studentsPerClass = studentsPerOrientation;
        } else {
            int r = 2;
            while (r < studentsPerOrientation) {
                int result = studentsPerOrientation / r;
                if (result < MAX_STUDENTS) {
                    numClasses = r;
                    studentsPerClass = result;
                    break;
                }
                r++;
            }
        }
        int numTotalClasses = numClasses * CLASS_TYPES;
        int restStudentsOrientations = ((studentsPerOrientation - (studentsPerClass * numClasses)) * CLASS_TYPES);
        int restStudentsPerOrientation = (studentsPerOrientation - (studentsPerClass * numClasses));
        int restStudents = numStudents % CLASS_TYPES;
        int restSumStudents = numStudents % ((studentsPerClass * numClasses) * CLASS_TYPES);
//
//        System.out.println("Students: " + numStudents);
//        System.out.println("Students per orientation: " + studentsPerOrientation);
//        System.out.println("number of classes per orientation: " + numClasses + " total classes: " + numTotalClasses);
//        System.out.println("max capacity: " + numClasses * MAX_STUDENTS);
//        System.out.println("students per class " + studentsPerClass + " per orientation " + (studentsPerClass * numClasses)
//                + " total " + ((studentsPerClass * numClasses) * CLASS_TYPES));
//
//        System.out.println("rest students per orientation: " + restStudentsPerOrientation);
//        System.out.println("rest students from all orientations: " + restStudentsOrientations);
//        System.out.println("total rest students: " + restStudents);
//        System.out.println("sum: " + restSumStudents +"\n");

        //create a klas arraylist and add new classes with classname
        klassen = new ArrayList<>();
        for (int i = 0; i < CLASS_TYPES; i++) {
            for (int j = 0; j < numClasses; j++) {
                String className = CLASS_TYPE[i] + CLASS_NUMBER[i];
                Klas klas = new Klas(className);
                klassen.add(klas);
                CLASS_NUMBER[i]++;
            }
        }
        //add students to the classes(fills each class until the studentsPerClass is reached then moves on to the next class.
        int studentCounter = 0;
        for (int i = 0; i < numTotalClasses; i++) {
            if (klassen.get(i).getSize() == 0) {
                while (klassen.get(i).getSize() < studentsPerClass) {
                    klassen.get(i).addStudent(studentList.get(studentCounter));
                    studentCounter++;
                }
            }
        }
    }

    private void generateStudents() {
        for (int i = 0; i < numStudents; i++) {
            studentList.add(new Student(generateStudentNumber(i), generateGrade()));
        }
    }

    private int generateStudentNumber(int i) {
        return 5006001 + i;
    }

    private String generateGrade() {
        float result = (float) (1 + (Math.random() * 9));
        if (result > 9.95) {
            return String.format("%.0f", result);
        }
        return String.format("%.1f", result);
    }

//    public void printList() {
//        for (Object s : studentList) {
//            System.out.println(s.toString());
//        }
//    }

    public void printClass(int index) {
        Iterator iterator = klassen.get(index).getStudentList().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    public ArrayList getStudentList() {
        return studentList;
    }
        public ArrayList getKlassen(){
        return klassen;
    }
    
    public int compareKlas(int x, int z){
        System.out.println(klassen.get(x).toString());
        System.out.println(klassen.get(z).toString());
        return klassen.get(x).compareTo(klassen.get(z));
    }
    
    public void sortKlasStudent(){
        SortKlasStudent.sort(studentList);
    }
}
