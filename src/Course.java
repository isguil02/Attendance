import java.util.ArrayList;
import java.util.List;

/**
 * The course class for maintaining student's attendance information and provide reporting.
 * @author Seth and Isaiah
 * @since 2025.02.22
 * @version 1.0 beta
 * @see <a href="https://github.com/isguil02/Attendance.git">Github Repository</a>
 */

public class Course {
    /**
     * The course name.
     */
    private String name;
    /** The course student's
     */
    private List<Student> students;
}
/** Sets the team's name to "Unknown", and assigns players to an empty new ArrayList */
public Course() {
    name = "Unknown";
    Students = new ArrayList<>();
}

/**
 * Gets the team's name.
 * @return The team's name.
 */
public String getName() { return name; }

/**
 * Set the teams's name.
 * @param name the teams's name
 * @throws Exception if the team's name is blank (whitespace or empty)<br>
 * Error Example: Student name can not be blank.
 */
public void setName(String name) throws Exception {
    name = name.trim(); // remove leading and trailing whitespace

    //isBlank checks for both empty or whitespace
    if (name.isBlank())
        throw new Exception("Student name can not be blank.");

    this.name = name;
} // end of setName method

/**
 * Get a Student by their seat number using the ArrayList.indexOf method<br>
 * If the index Of method returns -1 then this method returns null otherwise,<br>
 * it returns the Student object associated with the seat number.
 * @param seat The Student's seat number.
 * @return If a Student is found, it will return the Student object otherwise a null value.
 * @throws Exception Creating a Student with a invalid seat number could throw an error
 */
public Student getStudent(int seat) throws Exception {
    int index = students.indexOf(new Student(seat));

    if (index == -1)
        return null;
    else
        return students.get(index);
/**
 * Add a student to the Seat, by using the overload constructor that allows setting their name and seat number too.<br>
 * This method will verify that the seat number is not already used by another student by calling the Seat.getstudent method.<br>
 * and if it is, then it will throw an exception back to the calling method
 * @param name The student's name.
 * @param seat The student's seat number.
 * @throws Exception seat number # already assigned.
 */
    public void addstudent (String name,int seat) throws Exception {
        student = getstudent(seat);
        if (student == null) {
            students.add(new student(seat, name));
        } else {
            throw new Exception("seat #" + seat + " already assigned to " + student.getName() + "!");
        }
    }
}

