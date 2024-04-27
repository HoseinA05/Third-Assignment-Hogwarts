import java.util.ArrayList;
public class Assistant extends Account{

    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private static ArrayList<Student> students = new ArrayList<Student>();
    private static ArrayList<Course> courses;
    private static ArrayList<Assistant> assistants = new ArrayList<Assistant>();
    private static ArrayList<Teacher> requestedTeachers = new ArrayList<Teacher>();

    public Assistant(String name, String password){
        changePassword(password);
        changeUsername(name);
        courses = new ArrayList<Course>();

        assistants.add(this);
    }

    public static void showTeachers(){
        if(teachers.isEmpty()){
            System.out.println("There is no Teachers yet.");
            return;
        }
        System.out.println("All Teachers: ");
        for (int i = 0; i < teachers.size(); i++){
            System.out.println((i+1) + ") " + teachers.get(i).getUsername());
        }
    }
    public void removeTeacher(int index){
        teachers.remove(index);
    }

    public static void showStudents(){
        System.out.println("All Students: ");
        for (int i = 0; i < students.size(); i++){
            System.out.println((i+1) + ") " + students.get(i).getUsername());
        }
    }
    public void removeStudent(int index){
        students.remove(index);
    }

    public static void showCourses(){
        if(courses.isEmpty()){
            System.out.println("There is no Courses available currently.");
            return;
        }
        System.out.println("All Courses: ");
        for (int i = 0; i < courses.size(); i++){
            System.out.println((i+1) + ") " + courses.get(i).getCourseTitle());
            courses.get(i).getStudents();
        }
    }
    public void removeCourse(int index){
        courses.remove(index);
    }

    public void createCourse(String title){
        Course c = new Course(title);
        courses.add(c);
    }

    public void showRequestedTeachers(){
        if(requestedTeachers.isEmpty()){
            System.out.println("There is no requests yet.");
            return;
        }
        for(int i = 0; i < requestedTeachers.size(); i++){
            if(!teachers.contains(requestedTeachers.get(i)))
            System.out.println((i+1) + ") " + requestedTeachers.get(i).getUsername());
        }
    }

    public void approveTeacher(int index){
        teachers.add(requestedTeachers.get(index));
        requestedTeachers.remove(index);
    }

    public static boolean doesTeacherExists(String name){
        for (Teacher t : teachers){
            if(t.getUsername().equals(name)){
                System.out.println("Teacher Found!");
                return true;
            }
        }
        System.out.println("Teacher Not Found!");
        return false;
    }

    public static void requestNewTeacher(String name, String password){
        Teacher t = new Teacher(name, password);
        requestedTeachers.add(t);
    }

    public static Teacher getTeacher(String name, String password){
        boolean isFound = false;
        for (Teacher t : teachers){
            if(t.getUsername().equals(name)){
                isFound = true;
                if(t.isPasswordCorrect(password))
                    return t;
            }
        }
        if(isFound) System.out.println("Incorrect Password");
        else System.out.println("No Such person found!");
        return null;
    }

    public static boolean doesAssistantExists(String name){
        for (Assistant a : assistants){
            if(a.getUsername().equals(name)){
                System.out.println("Assistant Found!");
                return true;
            }
        }
        System.out.println("Assistant Not Found!");
        return false;
    }

    public static Assistant getAssistant(String name, String password){
        for (Assistant a : assistants){
            if(a.getUsername().equals(name)){
                if(a.isPasswordCorrect(password))
                    return a;
                else
                    return null;
            }
        }
        System.out.println("No Such person found!");
        return null;
    }

    public static boolean doesStudentExists(String name){
        for (Student t : students){
            if(t.getUsername().equals(name)){
                System.out.println("Student Found!");
                return true;
            }
        }
        System.out.println("Student Not Found!");
        return false;
    }
    public static void requestNewStudent(String name, String password){
        Student t = new Student(name, password);
        students.add(t);
    }
    public static Student getStudent(String name, String password){
        boolean isFound = false;
        for (Student t : students){
            if(t.getUsername().equals(name)){
                isFound = true;
                if(t.isPasswordCorrect(password))
                    return t;
            }
        }
        if(isFound) System.out.println("Incorrect Password");
        else System.out.println("No Such person found!");
        return null;
    }

    public static ArrayList<Course> getCourses(){
        return new ArrayList<>(courses);
    }
}
