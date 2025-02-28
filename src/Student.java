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
    } // end of default constructor

    /**
     * This overload constructor should only be used by the ArrayList indexOf method
     * to detect if a seat is already filled by overriding the equals method to test
     * if two students are equal based on their seat number.
     * @param seat The Student's seat #
     * @throws Exception if the setSeat method throws a data validation error.
     */
    public Student(int seat) throws Exception {
        this();
        setSeat(seat);
    } // end of jesery overload constructor

    /**
      * Allow creating a Student plus setting their name and seat number.
      * The constructor first calls the default constructor and then
      * calls both the setName and setSeat methods for data validation.
      * @param name The Students' name
      * @param seat The Students' seat #
      * @throws Exception if the name or seat setters throws an error
      */


    public Student(int seat, String name) throws Exception {
        this();
        setSeat(seat);
        setName(name);
    }

    /**
     * Get the Student seat number.
     * @return The Student's seat number
     */

    public int getSeat() { return seat; }
    /**
     * Get the Student's name.
     * @return The Student's name.
     */

    public String getName(){ return name; }

    /**
     * Get the Student's number of onTime arrivals.
     * @return the number of onTime arrivals by the Student.
     */
    
    public int getOnTime() { return onTime; }
    /**
     * Get the Student's number of late arrivals.
     * @return the number of late arrivals by the Student.
     */

    public int getLate() { return late; }

    /**
     * Get the Student's number of excused absence.
     * @return the number of excused absence by the Student.
     */
    public int getExcused() { return excused; }

    /**
     * Get the Student's number of unexcused absence.
     * @return the number of unexcused absence by the Student.
     */
    public int getUnexcused() { return unexcused; }

    /**
     * Set the Student's seat number if it's a positive number between 1 and 55
     * otherwise it throws an error.
     * @param seat the player's seat number
     * @throws Exception if the seat number isn't between 0 and 55 inclusively.<br>
     * Error Example: Invalid seat number #10 for name Bob!
     */
    public void setSeat(int seat) throws Exception {
        if (seat >= 0 && seat <= 55)
            this.seat = seat;
        else
            throw new Exception("Invalid seat number #" + seat + "for name" + name + "!");
    }
    /**
     * Set the Student's name. Uses the trim method to remove leading and trailing spaces
     * and then if the name is an empty string, it will throw an error
     * if not then it will set the student's name.
     * @param name The Student's name
     * @throw Exception if the student's name is blank (whitespace or empty)<br>
     * Error Example: Name cannot be blank for seat number #10!
     */
    public void setName(String name) throws Exception {
        name = name.trim();

        if (name.isBlank())
            throw new Exception("Name cannot be blank for student number #" + seat + "!" );
        else
            this.name = name;

    }

    public void updateAttendance(int onTime) throws Exception {
    switch (onTime) {
        case 0:
            unexcused++;
            break;
        case 1:
            excused++;
            break;
        case 2:
            late++;
            break;
        case 3:
            this.onTime++;
            break;
        default:
            throw new Exception("Invalid attendance code " + onTime);
        }
    }



    /**
     * Display the attendance details of the student.
     */
    public void displayAttendance() {
        System.out.println("On Time: " + onTime);
        System.out.println("Late: " + late);
        System.out.println("Excused: " + excused);
        System.out.println("Unexcused: " + unexcused);
    }

    /**
     * Checks if this student is equal to another object.
     * Two students are considered equal if they have the same seat number.
     *
     * @param object the object to compare with
     * @return true if the object is a Student with the same seat number, false otherwise
     */
    public boolean equals(Object object) {
        if(!(object instanceof Student))
            return false;
        Student other = (Student)object;
        return this.seat == other.getSeat();
    }
    @Override
    public String toString() {
        return "Student{" +
                "seat=" + seat +
                ", name='" + name + '\'' +
                '}';
    }
}

