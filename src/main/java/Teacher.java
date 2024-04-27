import java.util.ArrayList;

public class Teacher extends Account{

    private ArrayList<Course> teacherCourses;

    public Teacher(String name, String password){
        changePassword(password);
        changeUsername(name);
        this.teacherCourses = new ArrayList<>();
    }

    public void showAllCourses(){
        ArrayList<Course> allCourses = Assistant.getCourses();
        if(allCourses.isEmpty()){
            System.out.println("There is no Courses available currently.");
            return;
        }

        System.out.println("All Courses: ");
        for (int i = 0; i < allCourses.size(); i++){
            if(this.teacherCourses.contains(allCourses.get(i))) continue;
            System.out.println((i+1) + ") " + allCourses.get(i).getCourseTitle());
            allCourses.get(i).getStudents();
        }
    }

    public void showTeacherCourses(){
        if(this.teacherCourses.isEmpty()){
            System.out.println("You have not taken any courses yet.");
            return;
        }

        System.out.println("All Your Courses: ");
        for (int i = 0; i < this.teacherCourses.size(); i++){
            System.out.println((i+1) + ") " + this.teacherCourses.get(i).getCourseTitle());
            this.teacherCourses.get(i).getStudents();
        }
    }

    public void takeCourse(int index){
        ArrayList<Course> allCourses = Assistant.getCourses();
        allCourses.get(index).setTeacher(this);
        this.teacherCourses.add(allCourses.get(index));
    }

    public void showCourseStudents(int index){
        this.teacherCourses.get(index).getStudents();
    }
    public void scoreStudent(int courseIndex, int studentIndex, int value){
        this.teacherCourses.get(courseIndex).setStudentScore(studentIndex, value);
    }
}