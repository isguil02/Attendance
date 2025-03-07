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


public int getTotalAttendancePoints() {
    int totalAttendancePoints = 0;

    for (Student student : students) {
        totalAttendancePoints += student.getAttendancePoints();
    }

    return totalAttendancePoints;
}



/**
 * Get the total number of absences for the entire course using the Student.getAbsences method.
 * Uses a for loop to sum all the course's students' absences.
 * @return The total number of absences for the course.
 */
public int getTotalAbsences() {
    int totalAbsences = 0;

    for (Student student : students) {
        totalAbsences += student.getAbsences();
    }

    return totalAbsences;
}

/**
 * Display the course's summary stats using the Course.getTotalAbsences and getTotalAttendancePoints methods.<br>
 * Example: <br>
 * <pre>Course Java Programming Absences=4 Attendance Points=23</pre>
 */
public void displayCourseStats() {
    System.out.println("Course " + name + " Absences=" + getTotalAbsences() + " Attendance Points=" + getTotalAttendancePoints());
}

/**
 * Displays each Student's detail stats for the entire course using the Student's getter methods.<br>
 * This method uses the printf method for proper stats alignment. Example:<br>
 * <pre>
 * Seat Number Name           OnTime Late Excused Unexcused
 * =========== =============== ====== ==== ====== =========
 *          10 Billy               3    2      1         0
 *          24 Tammy               4    1      0         0
 * </pre>
 */
public void displayDetailStats() {

    Student student;

    displayCourseStats();

    System.out.println("Seat Number Name           OnTime Late Excused Unexcused");
    System.out.println("=========== =============== ====== ==== ====== =========");

    for (Student value : students) {

        student = value;

        System.out.printf("%11d %-15s %6d %4d %6d %9d\n",
                student.getSeatNumber(),
                student.getName(),
                student.getOnTime(),
                student.getLate(),
                student.getExcused(),
                student.getUnexcused());
    }

    System.out.println();
}

/**
 * Returns the course's name.
 * @return Course name.
 */
@Override
public String toString() {
    return name;
}
} // end of Course class

