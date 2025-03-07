/**
 * The Attendance Application
 *
 * @author Seth Pipim and Isaiah
 * @version 1.0 beta
 * @since 2025.02.21
 * @see <a href="https://github.com/isguil02/Attendance.git">Github Repository</a>
 */
public class AttendanceApp {

    /** The first course section. */
    private Course section1;

    /** The second course section. */
    private Course section2;

    /** Standard double dash line for display output */
    private static String DOUBLE_DASH_LINE = String.format("%50s", "").replace(' ', '=');

    /** Standard single dash line for display output */
    private static String SINGLE_DASH_LINE = DOUBLE_DASH_LINE.replace('=', '-');

    /** Default constructor that instantiate both course sections. */
    public AttendanceApp() {
        section1 = new Course();
        section2 = new Course();

    }// end of default constructor
/**
 *  Displays the Attendance App header. Example:<br>
 *  <pre>
 *  =========================================
 *  Welcome to the Attendance App
 *  =========================================
 *  </pre>
 */
private void displayAppHeading() {
    System.out.println(DOUBLE_DASH_LINE);
    System.out.println("Welcome to Attendance App");
    System.out.println(DOUBLE_DASH_LINE);
    System.out.println();
} // ending of displayAppHeading

private void setupCourses() throws Exception {
    String userInput;
    userInput = Input.getLine("Enter the course name for section 1: ");
    section1.setName(userInput);
    setupStudents(section1); // Corrected method call

    System.out.println();
    System.out.println(SINGLE_DASH_LINE);
    System.out.println();

    userInput = Input.getLine("Enter the course name for section 2: ");
    section2.setName(userInput);
    setupStudents(section2); // Corrected method call
} // end of setupCourses
    /**
     * Sets up the course's students.<br>
     * Calls Input.getLine to get the student's name<br>
     * Calls Input.getIntRange to get the student's seat number between 0 and 55<br>
     * Example:<br>
     * <pre>
     * Enter course student's name or 'q' to quit: user input
     * Enter Alice's seat number: user input
     * </pre>
     * @param course The course to setup students for.
     */
    private void setupStudents(Course course) {
        String courseName = course.getName();
        String name;
        int seat;

        while (true) {
            System.out.println();
            name = Input.getLine("Enter " + courseName + " student's name or 'q' to quit: ");
            if (name.equals("q"))
                return;
            try {
                seat = Input.getIntRange("Enter " + name + "'s seat number: ", 0, 55);
                course.addStudent(name, seat);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Unable to add student!");
            }
        }
    } // end of setupStudents
    /**
     * Keeps the application running via menu options. Example:<br>
     * <pre>
     * -----------------------------------------
     * Main Menu
     * -----------------------------------------
     * 0 = End Application
     * 1 = Setup Courses
     * 2 = Display Course Attendance
     * 3 = Display Student Attendance
     * -----------------------------------------
     * Menu Choice:
     * </pre>
     * @throws Exception if an invalid option is selected
     */
    private void mainMenu() throws Exception {
        boolean runApp = true;
        int userInput;
        System.out.println();
        System.out.println(DOUBLE_DASH_LINE);
        System.out.println("Attendance App Started!");
        System.out.println(DOUBLE_DASH_LINE);
        System.out.println();
        while (runApp) {
            System.out.println(SINGLE_DASH_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_DASH_LINE);
            System.out.println("0 = End Application");
            System.out.println("1 = Take " + section1.getName() + " Attendance");
            System.out.println("2 = Take " + section2.getName() + " Attendance");
            System.out.println("3 = Display all Attendance Report");
            System.out.println(SINGLE_DASH_LINE);
            userInput = Input.getIntRange("Menu Choice: ", 0, 3);
            System.out.println(SINGLE_DASH_LINE);

            System.out.println();

            switch (userInput) {
                case 0:
                    runApp = false;
                    System.out.println("Ending Application...");
                    System.out.println();
                    break;
                case 1:
                case 2:
                    if (userInput==1)
                        updateCourseAttendance(section1);
                    else
                        updateCourseAttendance(section2);

                case 3:
                    displayAttendanceStatus();
                    break;
                default:
                    System.out.println("Invalid menu choice = " + userInput);
            } // end of switch
        }
    } // end of mainMenu
/**
 * Update the selected course's attendance.<br>
 * Calls Input.getIntRange using range from 1 and 55.<br>
 * Example: <br>
 * <pre>
 * Enter Alice's seat number: user input
 * </pre>
 * @param course The course to update attendance for.
 * @throws Exception getStudent could throw an invalid seat number error
 */
private void updateCourseAttendance(Course course) throws Exception {
    int seat;
    Student student;
    while (true) {
        seat = Input.getIntRange("Enter " + course.getName() + "'s seat number: ", 1, 55);
        student = course.getStudent(seat);
        if (student == null) {
            System.out.println("Invalid seat number, please try again!");
            continue;
        }
        updateStudentAttendance(student);
        break;
    }
    System.out.println();
    System.out.println(SINGLE_DASH_LINE);
} // end of updateCourseAttendance

/**
 * Displays the student's name along with the attendance menu. Example:
 * <pre>
 * -----------------------------------------
 * Enter #10 Alice Attendance
 * -----------------------------------------
 * 0 = Absent
 * 1 = Present
 * -----------------------------------------
 * Enter Attendance Type: 1
 * -----------------------------------------
 * #10 Alice Attendance=Present
 * -----------------------------------------
 * </pre>
 * @param student The student to enter attendance for
 */
private void updateStudentAttendance(Student student) {
    int type;
    System.out.println();
    System.out.println(SINGLE_DASH_LINE);
    System.out.println("Enter #" + student.getSeat() + " " + student.getName() + " Attendance");
    System.out.println(SINGLE_DASH_LINE);
    System.out.println("0 = Absent");
    System.out.println("1 = Present");
    System.out.println(SINGLE_DASH_LINE);
    type = Input.getIntRange("Enter Attendance Type: ", 0, 1);
    System.out.println(SINGLE_DASH_LINE);
    try {
        student.updateAttendance(type);
    } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Unable to update student's attendance!");
    }
    student.displayAttendance();
}

/**
 * Display the updated attendance report for both courses. Calls the Course's
 * displayCourseAttendance for both section1 and section2.
 */
private void updateAttendanceReport() {
    section1.displayCourseStats();
    section2.displayCourseStats();
}

/**
 * Display all students' detailed attendance. Calls the displayDetailedAttendance
 * for both section1 and section2.
 */
private void displayAttendanceStatus() {
    section1.displayDetailStats();
    section2.displayDetailStats();
} // end of displayAttendanceStatus

/**
 * Main method that creates the AttendanceApp object and then
 * sets up the courses and takes attendance via menu options.
 * <br>
 * 1) creates a new AttendanceApp<br>
 * 2) calls the displayAppHeading method<br>
 * 3) using a try-catch calls setupCourses and mainMenu methods<br>
 * <br>
 * @param args No command line input args are used for this application
 */
public static void main(String[] args) {
    AttendanceApp app = new AttendanceApp();
    app.displayAppHeading();
    try {
        app.setupCourses();
        app.mainMenu();
    } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Sorry but this program ended with an error. Please contact support!");
    }
    Input.sc.close();
} // end of main
} // end of AttendanceApp

//main menu , detail report course attendence, student attendence