abstract class Employee {
    abstract void calculateSalary();
}

class FullTimeEmployee extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Calculating full-time employee salary... \n 1000000");
    }
}

class PartTimeEmployee extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Calculating part-time employee salary... \n 9000000");
    }
}

public class gajiKaryawan {
    public static void main(String[] args) {
        Employee fullTimeEmp = new FullTimeEmployee();
        Employee partTimeEmp = new PartTimeEmployee();

        fullTimeEmp.calculateSalary();
        partTimeEmp.calculateSalary();
    }
}