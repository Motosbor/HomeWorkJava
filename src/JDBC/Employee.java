package JDBC;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int department_id;

    public Employee() {
    }

    public Employee(String name, double salary, int department_id) {
        this.name = name;
        this.salary = salary;
        this.department_id = department_id;
    }

    public Employee(int id, String name, double salary, int department_id) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department_id = department_id;
    }

    public static void printEmployee(Employee e){
        System.out.println(e.name + " " + e.getSalary() + " " + e.department_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
}

