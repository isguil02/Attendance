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

