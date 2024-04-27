import java.util.ArrayList;
import java.util.Random;

public class Student extends Account{

    private ArrayList<Course> enrolledCourses;
    private int house;

    public Student(String name, String password){
        changePassword(password);
        changeUsername(name);
        Random r = new Random();
        this.house = r.nextInt(4);
        this.enrolledCourses = new ArrayList<>();
    }

    public String getHouse(){
        return switch (this.house) {
            case 0 -> "Gryffindor";
            case 1 -> "Hufflepuff";
            case 2 -> "Ravenclaw";
            case 3 -> "Slytherin";
            default -> "";
        };
    }

    public void showAllCourses(){
        ArrayList<Course> allCourses = Assistant.getCourses();
        if(allCourses.isEmpty()){
            System.out.println("There is no courses available currently.");
            return;
        }
        System.out.println("All Courses: ");
        for (int i = 0; i < allCourses.size(); i++) System.out.println((i+1) + ") " + allCourses.get(i).getCourseTitle());
    }

    public void takeCourse(int index){
        ArrayList<Course> allCourses = Assistant.getCourses();
        allCourses.get(index).addStudent(this);
        this.enrolledCourses.add(allCourses.get(index));
    }

    public void putReview(int courseIndex, String text, int point){
        this.enrolledCourses.get(courseIndex).putReview(this, text, point);
    }

    public void showStudentCourses(){
        if(this.enrolledCourses.isEmpty()){
            System.out.println("You have not enrolled in any courses yet.");
            return;
        }

        System.out.println("All Your Courses: ");
        for (int i = 0; i < this.enrolledCourses.size(); i++){
            System.out.println((i+1) + ") " + this.enrolledCourses.get(i).getCourseTitle());
        }
    }

    public void showTeachers(){
        if(this.enrolledCourses.isEmpty()){
            System.out.println("You have not enrolled in any courses yet.");
            return;
        }

        System.out.println("All Your Courses: ");
        for (int i = 0; i < this.enrolledCourses.size(); i++){
            System.out.println((i+1) + ") " + this.enrolledCourses.get(i).getCourseTitle());
            System.out.println("\tTeacher: " + this.enrolledCourses.get(i).getTeacherName());
        }
    }
}
