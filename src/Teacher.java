public class Teacher extends Person {
    private String courseName;

    public Teacher (String firstName, String lastName, String emailAddress, String courseName){
        super (firstName, lastName, emailAddress);
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String groupId) {
        this.courseName = courseName;
    }
}
