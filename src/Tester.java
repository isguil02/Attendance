public class Tester {
    public static void main(String[] args) {
        try {
            Student x1 = new Student(1, "Alice");
            x1.displayAttendance();
            System.out.println(x1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}