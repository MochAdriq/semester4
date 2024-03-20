package tugas;

import java.util.ArrayList;

public class Teacher extends Person {
    private ArrayList<String> courses;

    public Teacher(String name, String address) {
        super(name, address);
        this.courses = new ArrayList<>();
    }

    public boolean addCourse(String course) {
        if (courses.contains(course)) {
            return false; // Course sudah ada, tidak bisa ditambahkan lagi
        }
        courses.add(course);
        return true;
    }

    public boolean removeCourse(String course) {
        return courses.remove(course);
    }

    @Override
    public String toString() {
        return "Teacher " + getName() + "(" + getAddress() + ")";
    }

    public int getNumCourses() {
        return courses.size();
    }

    public ArrayList<String> getCourses() {
        return new ArrayList<>(courses);
    }
}
