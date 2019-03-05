package JDBC;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;

public class Main {

    public static void printEmployees(List<Employee> list){
        for (Employee e:list) {
            System.out.println(e.getName()+ " " + e.getSalary() + " " + e.getDepartment_id());
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:My.db");
            Statement statement = conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        WorkBd.insertDepartment(conn,new Department(1,"IT"));
//        WorkBd.insertDepartment(conn,new Department(2,"Sale"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            try {
                if(reader.readLine().contains("stop")) {
                    break;
                }
                System.out.println("Введите имя");
                String name = reader.readLine();
                System.out.println("Введите зарплату");
                int salary = Integer.parseInt(reader.readLine());
                System.out.println("Введите отдел");
                int department = Integer.parseInt(reader.readLine());
                WorkBd.insertUser(conn, new Employee(name, salary, department));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("---------------");

        Employee max = WorkBd.getMaxSalaryEmployee(conn);

        Employee.printEmployee(max);

        System.out.println("---------------");

        List<Employee> employees = WorkBd.getAllEmployee(conn);

        printEmployees(employees);

        System.out.println("---------------");

        List<Employee> employees1 = WorkBd.getByDepartment(conn,1);

        printEmployees(employees1);

        System.out.println("---------------");

        Department withLowSalary = WorkBd.getByAverageValue(conn);

        Department.printDep(withLowSalary);

        System.out.println("---------------");

        WorkBd.updateSalary(conn);

        List<Employee> employees2 = WorkBd.getAllEmployee(conn);

        printEmployees(employees2);

        System.out.println("---------------");

        List<Department> departmentList = WorkBd.getAllDepartments(conn);
        for (Department d:departmentList) {
            Department.printDep(d);
        }




        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
