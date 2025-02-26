/**
 *The type Student that tracks their seat and the number of unexcused and excused attendance, late and on time arrivals.
 * @since 2025.02.21
 * @version 1.0 beta
 * @author Seth Pipim and Isaiah
 * @see <a href="https://github.com/isguil02/Attendance.git">Github Repository</a>
 */

public class Student {
    /**
     * The Students's seat.
     */
    private int seat;

    /**
     * The Student's name.
     */
    private String name;

    /**
     * The number of on time arrivals the student has had.
     */
    private int onTime;

    /**
     * The number of late arrivals the student has had.
     */
    private int late;

    /**
     * The number of excused absences the student has had.
     */
    private int excused;

    /**
     * The number of unexcused absences the student has had.
     */
    private int unexcused;

    /**
     * Set the Student's fields to default values null and zeroes.
     * The default constructor is PRIVATE, so it is ONLY called by the overload constructor.
     */

    private Student() {
        name = null;
        seat = 0;
        onTime = 0;
        late = 0;
        excused = 0;
        unexcused = 0;
    }// end of default constructor

    public Student(int seat, String name) {
        this.seat = seat;
        this.name = name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Student{" +
                "seat=" + seat +
                ", name='" + name + '\'' +
                '}';
    }
}

