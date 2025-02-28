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
}

public void main() {
}
}