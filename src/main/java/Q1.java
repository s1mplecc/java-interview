import java.util.TreeMap;

public class Q1 {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.entrySet().forEach(System.out::println);

        Student s1 = new Student(2, "AA");
        Student s2 = new Student(1, "BB");


        TreeMap<Student, Integer> studentStringTreeMap = new TreeMap<>();
        studentStringTreeMap.put(s1, 98);
        studentStringTreeMap.put(s2, 90);
        studentStringTreeMap.entrySet().forEach(System.out::println);
    }

    static class Student implements Comparable<Student> {
        int id;
        String name;

        public Student(int id, String name) {
            this.name = name;
            this.id = id;
        }

        @Override
        public int compareTo(Student o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
