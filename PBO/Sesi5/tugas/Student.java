package tugas;

public class Student extends Person {
    private String[] courses;
    private int[] grades;
    private int numCourses;

    public Student(String name, String address) {
        super(name, address);
        courses = new String[10]; // Ukuran awal bisa disesuaikan
        grades = new int[10]; // Ukuran awal bisa disesuaikan
        numCourses = 0;
    }

    public void addCourseGrade(String course, int grade) {
        if (numCourses < courses.length) {
            courses[numCourses] = course;
            grades[numCourses] = grade;
            numCourses++;
        } else {
            System.out.println("Kapasitas kursus telah tercapai.");
        }
    }

    public void printGrades() {
        System.out.println("Grades for " + getName() + ":");
        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses[i] + ": " + grades[i]);
        }
    }

    public double getAverageGrade() {
        if (numCourses == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum += grades[i];
        }
        return (double) sum / numCourses;
    }

    @Override
    public String toString() {
        return "Student " + getName() + "(" + getAddress() + ")";
    }
}
