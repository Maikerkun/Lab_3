import java.util.*;

public class Student extends Person {
    private String groupId;
    private List<Double> grades = new ArrayList<>();



    public Student(String firstName, String lastName, String emailAddress, String groupId) {
        super(firstName, lastName, emailAddress);
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
            grades.add(grade);
    }

    public double getGradesAvarage(){
        double avarageGrades=0;
        for(int i=0; i<grades.size(); i++){
            avarageGrades=avarageGrades+grades.get(i);
        }
        avarageGrades=avarageGrades/grades.size();
        return avarageGrades;
    }
}
