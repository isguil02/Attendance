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

    /**
     * The course students.
     */
    private List<Student> students;

    /**
     * Sets the course's name to "Unknown", and assigns students to an empty new ArrayList.
     */
    public Course() {
        this.name = "Unknown";
        this.students = new ArrayList<>();
    }
    /**
     * Gets the course's name.
     * @return The course's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the course's name.
     * @param name The course's name.
     * @throws Exception if the course's name is blank (whitespace or empty)<br>
     * Error Example: Student name cannot be blank.
     */
    public void setName(String name) throws Exception {
        name = name.trim(); // remove leading and trailing whitespace

        // isBlank checks for both empty or whitespace
        if (name.isBlank()) {
            throw new Exception("Student name cannot be blank.");
        }

        this.name = name;
    } // end of setName method

    /**
     * Gets a Student by their seat number using the ArrayList.indexOf method.<br>
     * If the indexOf method returns -1, then this method returns null; otherwise,<br>
     * it returns the Student object associated with the seat number.
     * @param seat The Student's seat number.
     * @return If a Student is found, it will return the Student object; otherwise, a null value.
     * @throws Exception Creating a Student with an invalid seat number could throw an error.
     */
    public Student getStudent(int seat) throws Exception {
        int index = students.indexOf(new Student(seat));

        if (index == -1) {
            return null;
        } else {
            return students.get(index);
        }
    }

    /**
     * Adds a student to the list, by using the overloaded constructor that allows setting their name and seat number.<br>
     * This method will verify that the seat number is not already used by another student by calling the getStudent method.<br>
     * If it is, then it will throw an exception back to the calling method.
     * @param name The student's name.
     * @param seat The student's seat number.
     * @throws Exception If seat number is already assigned.
     */
    public void addStudent(String name, int seat) throws Exception {
        Student student = getStudent(seat);
        if (student == null) {
            students.add(new Student(seat, name));
        } else {
            throw new Exception("Seat #" + seat + " is already assigned to " + student.getName() + "!");
        }
    }
}



