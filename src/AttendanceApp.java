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
    System.out.println("DOUBLE_DASH_LINE");
    System.out.println("Welcome to Attendance App");
    System.out.println("DOUBLE_DASH_LINE");
    System.out.println();
} // ending of displayAppHeading

private void setupCourses() throws Exception {
    String userInput;
        userInput = Input.getLine("Enter the course name for section 1: ");
        section1.setName(userInput);
        setupCourses(section1);

        System.out.println();
        System.out.println(SINGLE_DASH_LINE);
        System.out.println();

        userInput = Input.getLine("Enter the course name for section 2: ");
        section2.setName(userInput);
        setupCourses(section2);
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
                    if (userInput)
                        updateTeamStats(section1);
                    else
                        updateTeamStats(section2);

                case 3:
                    displayStudentAttendance();
                    break;
                default:
                    System.out.println("Invalid menu choice = " + userInput);
            } // end of switch
        }
    } // end of mainMenu
public void main() {
}
}
//main menu , detail report course attendence, student attendence