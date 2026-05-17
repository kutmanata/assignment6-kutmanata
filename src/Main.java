import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<>();

        
        map.put("1", new Student("Ali", 3.5, 20));
        map.put("2", new Student("Bek", 3.5, 21));
        map.put("3", new Student("Aizada", 4.0, 19));
        map.put("4", new Student("Nurs", 2.8, 22));
        map.put("5", new Student("Meerim", 3.2, 20));

        for (String id : map.keySet()) {
        System.out.println(id + " -> " + map.get(id));
}

        System.out.println("\nFind ID 3:");
        System.out.println(map.get("3"));

        map.remove("4");

        map.get("1").gpa = 3.9;
        // ====================== SORTING (IMPORTANT) ======================
        ArrayList<Student> list = new ArrayList<>(map.values());

        Collections.sort(list);

        for (Student s : list) {
            System.out.println(s);
        }
        list.sort(new Comparator<Student>() {
         @Override
            public int compare(Student a, Student b) {
                return a.name.compareTo(b.name);
            }
        });

        for (Student s : list) {
            System.out.println(s);
        }
        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        list.sort((a, b) -> Double.compare(b.gpa, a.gpa));

        for (int i = 0; i < 3 && i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        HashMap<Double, List<String>> gpaMap = new HashMap<>();

        for (Student s : map.values()) {

            gpaMap.putIfAbsent(s.gpa, new ArrayList<>());
            gpaMap.get(s.gpa).add(s.name);
        }

        for (double gpa : gpaMap.keySet()) {

            if (gpaMap.get(gpa).size() > 1) {
                System.out.println(gpa + " -> " + gpaMap.get(gpa));
            }
        }

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        HashMap<Course, List<Student>> courseMap = new HashMap<>();

        Course math = new Course("Math");
        Course cs = new Course("CS");

        courseMap.put(math, new ArrayList<>());
        courseMap.put(cs, new ArrayList<>());

        courseMap.get(math).add(map.get("1"));
        courseMap.get(math).add(map.get("2"));

        courseMap.get(cs).add(map.get("3"));

        for (Course c : courseMap.keySet()) {
            System.out.println(c + " -> " + courseMap.get(c));
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        list.sort(new Comparator<Student>() {
        @Override
        public int compare(Student a, Student b) {

            if (a.gpa == b.gpa) {
                return a.name.compareTo(b.name);
            }

            return Double.compare(b.gpa, a.gpa);
        }
    });

    for (Student s : list) {
        System.out.println(s);
    }
    }
}



