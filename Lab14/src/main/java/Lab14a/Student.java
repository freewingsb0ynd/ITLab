package Lab14a;

public class Student {
    private String studentName;
    private String studentAddress;

    public Student(String studentName, String studentAddress) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
}
