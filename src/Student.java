public class Student implements Comparable<Student> {

    String name;
    double gpa;
    int age;

    public Student(String name, double gpa, int age) {
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }

    public String toString() {
        return name + " " + gpa + " " + age;
    }
}