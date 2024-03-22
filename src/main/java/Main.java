import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello & Welcome to Hogwarts School Management System.\n");

        while(true){

            runMenu();

            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            while(choice > 4 || choice < 1) {
                System.out.println("Please Choose an Option from above: ");
                choice = in.nextInt();
            }

            if(choice == 1) runAdminPanel();
            else if(choice == 2) runTeacherPanel();
            else if(choice == 3) runStudentPanel();
            else break;
        }
    }

    public static void runMenu() {
        System.out.println("1)Admin Panel");
        System.out.println("2)Teacher Panel");
        System.out.println("3)Student Panel");
        System.out.println("4)Exit");
    }

    public static void runAdminPanel(){
        //        HELP
        System.out.println("---Admin Panel---\n");
        System.out.print("Help: ");
        System.out.println("Here you can sign in or sign up to your assistant account, ");
        System.out.println("create new courses, approve newly requested teachers and");
        System.out.println("remove or Check information of Teachers, Students and also Courses\n");

        //        SIGN IN / SIGN UP
        System.out.println("Please Enter Your Name: ");

        Scanner in = new Scanner(System.in);
        Assistant assistant = null;
        String name = in.next();
        if(!Assistant.doesAssistantExists(name)) {
            System.out.println("\nHey! Your new to Hogwarts School. We're Happy you joining Us as an Assistant!");
            System.out.println("Please choose a password for yourself: ");
            String pass = in.next();
            if(AccountManagement.isValidPassword(pass)) assistant = new Assistant(name, pass);
            else System.out.println("Invalid password.");

        }else {
            System.out.println("Please Enter your password: ");
            String pass = in.next();
            assistant = Assistant.getAssistant(name, pass);
        }

        if(assistant == null){
            System.out.println("Something failed, Please try again...");
            return;
        }
        Assistant.requestNewTeacher("Hosein", "23123ads");
        Assistant.requestNewTeacher("Ali", "asdwer213");
        Assistant.requestNewTeacher("MMD", "asdwer213");
        assistant.approveTeacher(2);
        assistant.createCourse("Physics");
        assistant.createCourse("Advanced Magics");
        assistant.createCourse("Illusion Magics");

        //        PANEL
        while(true){

            System.out.println("\n\tWelcome to Your Panel.");
            System.out.println("\t1)List All Teachers");
            System.out.println("\t2)List All Students");
            System.out.println("\t3)List All Courses");
            System.out.println("\t4)Create a Course");
            System.out.println("\t5)List Requested Teachers");
            System.out.println("\t6)Sign out / Exit");

            int choice = in.nextInt();
            if(choice == 1){
                Assistant.showTeachers();
                System.out.println("You can select anyone to Remove him/her, Or Enter e to continue...");

                String ch = in.next();
                if(ch.equals("e")) continue;
                else assistant.removeTeacher(Integer.parseInt(ch)-1);
            }else if(choice == 2){
                Assistant.showStudents();
                System.out.println("You can select anyone to Remove him/her, Or Enter e to continue...");

                String ch = in.next();
                if(ch.equals("e")) continue;
                else assistant.removeStudent(Integer.parseInt(ch)-1);
            }else if(choice == 3){
                Assistant.showCourses();
                System.out.println("You can select any of them to remove, Or Enter e to continue...");

                String ch = in.next();
                if(ch.equals("e")) continue;
                else assistant.removeCourse(Integer.parseInt(ch)-1);
            }else if (choice == 4){
                System.out.println("Please Enter title of the course: ");
                String title = in.next();
                assistant.createCourse(title);
            }else if(choice == 5) {
                assistant.showRequestedTeachers();
                System.out.println("You can select anyone to Approve him/her, Or Enter e to continue...");

                String ch = in.next();
                if(ch.equals("e")) continue;
                else assistant.approveTeacher(Integer.parseInt(ch)-1);
            }else if(choice == 6) break;
        }

    }

    public static void runTeacherPanel(){
        //        HELP
        System.out.println("---Teacher Panel---\n");
        System.out.print("Help: ");
        System.out.println("Here you can sign in or sign up to your Teacher account, ");
        System.out.println("View Courses List, Take a Course, Score your Students and");
        System.out.println("see your score.\n");

        //        SIGN IN / SIGN UP
        System.out.println("Please Enter Your Name:");

        Scanner in = new Scanner(System.in);
        Teacher teacher = null;
        String name = in.nextLine();
        if(!Assistant.doesTeacherExists(name)) {
            System.out.println("Hey! Your new to Hogwarts School. We're Happy you're joining Us as a Teacher!");
            System.out.println("Please choose a password for yourself : ");
            String pass = in.next();
            if(AccountManagement.isValidPassword(pass)){
                Assistant.requestNewTeacher(name, pass);
                System.out.println("Thanks for Signing Up! \nPlease Wait a few hours to Approve you Data.\n\n");
                return;
            }else System.out.println("Invalid password.");
        }else {
            System.out.println("Please Enter your password: ");
            String pass = in.next();
            teacher = Assistant.getTeacher(name, pass);
        }

        if(teacher == null){
            System.out.println("Something failed, Please try again...");
            return;
        }

        //        PANEL
        System.out.println("Welcome to Your Panel.");

        while(true){

            System.out.println("\nWelcome to Your Panel.");
            System.out.println("\t1)Available Courses / Take a Course");
            System.out.println("\t2)Score Your Students");
            System.out.println("\t3)Your Score");
            System.out.println("\t4)Sign out / Exit");

            int choice = in.nextInt();
            if(choice == 1){
                teacher.showAllCourses();
                System.out.println("You can select a course to be The Teacher for it. (Enter e to exit)");

                String ch = in.next();
                if(ch.equals("e")) continue;
                else teacher.takeCourse(Integer.parseInt(ch)-1);
            }else if(choice == 2){
                teacher.showTeacherCourses();
                System.out.println("You can select a course to see the Students and Score them. (Enter e to exit)");

                String course = in.next();
                if(course.equals("e")) continue;
                else teacher.showCourseStudents(Integer.parseInt(course)-1);

                System.out.println("Select a student to score him/her. (Enter e to exit)");
                String student = in.next();
                if(student.equals("e")) continue;

                System.out.println("Enter The Score. (Enter e to exit)");
                String score = in .next();
                if(score.equals("e")) continue;
                else teacher.scoreStudent(Integer.parseInt(course)-1, Integer.parseInt(student)-1, Integer.parseInt(score));
            }else if(choice == 3){
            //  TODO (Completing Hogwarts Class)
            }else if(choice == 4) break;
        }

    }

    public static void runStudentPanel(){
        //        HELP
        System.out.println("---Student Panel---\n");
        System.out.print("Help: ");
        System.out.println("Here you can sign in or sign up to your Student account, ");
        System.out.println("View Courses List, Enroll in a Course, View your courses");
        System.out.println("and view your teachers.\n");

        //        SIGN IN / SIGN UP
        System.out.println("Please Enter Your Name:");

        Scanner in = new Scanner(System.in);
        Student student = null;
        String name = in.nextLine();
        if(!Assistant.doesStudentExists(name)) {
            System.out.println("Hey! Your new to Hogwarts School. We're Happy you're joining Us as a Student!");
            System.out.println("Please choose a password for yourself : ");
            String pass = in.next();
            if(AccountManagement.isValidPassword(pass)){
                Assistant.requestNewStudent(name, pass);
                System.out.println("Thanks for Signing Up! \nPlease Wait a few hours to Administrators Approve you.\n\n");
                return ;
            }else System.out.println("Weak Password.");
        }else {
            System.out.println("Please Enter your password: ");
            String pass = in.next();
            student = Assistant.getStudent(name, pass);
        }

        if(student == null){
            System.out.println("Something failed, Please try again...");
            return;
        }

        //        PANEL
        System.out.println("Welcome to Your Panel.");

        while(true){

            System.out.println("\nWelcome to Your Panel.");
            System.out.println("\t1)Available Courses / Take a Course");
            System.out.println("\t2)Your Courses");
            System.out.println("\t3)Your Teachers / Rate you Teachers");
            System.out.println("\t4)Sign out / Exit");

            int choice = in.nextInt();
            if(choice == 1){
                student.showAllCourses();
                System.out.println("You can select a course to enroll in it. (Enter e to exit)");

                String course = in.next();
                if(course.equals("e")) continue;
                else student.takeCourse(Integer.parseInt(course)-1);
            }else if(choice == 2){
                student.showStudentCourses();
                System.out.println("press any key to exit");

                String inp = in.next();
                continue;
            }else if(choice == 3){
                student.showTeachers();
                System.out.println("You can select a teacher to review him (Enter e to exit)");

                String teacher = in.next();
                if(teacher.equals("e")) continue;

                System.out.println("Please Put a number out of 10. (Enter e to exit)");
                String point = in.next();
                if(point.equals("e")) continue;

                System.out.println("Do you want to Write a text Review for Teacher and Course ?. (Enter e to exit)");
                System.out.println("y / n");
                String dec = in.next();

                String text = "";
                if(dec.equals("e")) continue;
                else if (dec.equals("y")){
                    System.out.println("(Optional) Write a text about The Teacher and the Course. (Enter e to exit)");
                    text = in.next();
                    if(text.equals("e")) continue;
                }
                System.out.println("Thanks for the Review! Appreciated!");
                student.putReview(Integer.parseInt(teacher)-1, text, Integer.parseInt(point));
            }else if(choice == 4) break;
        }
    }
}
