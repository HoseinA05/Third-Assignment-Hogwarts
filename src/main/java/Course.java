import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private String title;
    private UUID courseID;
    private ArrayList<Student> students;
    private ArrayList<Integer> studentsScore;
    private ArrayList<Review> reviews;
    private Teacher teacher;

    public Course(String title){
        this.title = title;
        this.courseID = UUID.randomUUID();
        this.students = new ArrayList<>();
        this.studentsScore = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student){
        this.students.add(student);
        this.studentsScore.add(null);
    }

    public void setStudentScore(int index, int value){
        this.studentsScore.set(index, value);
    }

    public void putReview(Student student, String text, int point){
        Review r = new Review(text, point, student);
        this.reviews.add(r);
    }

    public void getStudents(){
        for(Student s : this.students){
            System.out.println("\t-" + s.getUsername());
        }
    }

    public String getCourseTitle(){
        return this.title;
    }
    public String getTeacherName(){
        return this.teacher.getUsername();
    }
}
