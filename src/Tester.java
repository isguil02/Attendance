public class Tester {
    public static void main(String[] args) {
        try {
            Student x1 = new Student(1, "Alice");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}