/**
 * A Student in a Course and student's seat
 * @author Seth Pipim and Isaiah
 * @since 2025.02.21
 * @version 1.0 beta
 * @see <a href="https://github.com/isguil02/Attendance.git">Github Repository</a>
 */

public class Student {
    private int seat;
    private String name;

    public Student(int seat, string name) {
        this.seat = seat;
        this.name = name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
    @overide
    public String toString() {
        return "Student{" +
                "seat=" + seat +
                ", name='" + name + '\'' +
                '}';
    }
}

