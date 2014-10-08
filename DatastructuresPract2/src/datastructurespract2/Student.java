package datastructurespract2;

/**
 *
 * @author Jeff
 */
public class Student implements Comparable<Student> {

    private int studentNummer;
    private final String cijfer;
    private String klasNummer;

    public Student(int studentNummer, String cijfer) {
        this.studentNummer = studentNummer;
        this.cijfer = cijfer;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public void setStudentNummer(int studentNummer) {
        this.studentNummer = studentNummer;
    }

    public String getKlasNummer() {
        return klasNummer;
    }

    public void setKlasNummer(String klasNummer) {
        this.klasNummer = klasNummer;
    }

    public String getCijfer() {
        return cijfer;
    }

    @Override
    public int compareTo(Student s) {
       final String temp = "99";
        
        if(s.getCijfer().equals("10"))
            return cijfer.compareTo(temp);

        if(this.cijfer.equals("10"))
            return temp.compareTo(s.getCijfer());
      
        return cijfer.compareTo(s.getCijfer());
    }

    @Override
    public String toString() {
        return studentNummer + "\t" + cijfer + "\t" + klasNummer;
    }
}
