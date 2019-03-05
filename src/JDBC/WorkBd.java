package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by лоцманенко_рр on 04.03.2019.
 */
public class WorkBd {

    public static void insertUser(Connection con, Employee em){
        try {
            PreparedStatement st = con.prepareStatement("insert into employees (name,salary,department_id) values (?,?,?)");
            st.setString(1,em.getName());
            st.setDouble(2,em.getSalary());
            st.setInt(3,em.getDepartment_id());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertDepartment(Connection con, Department dep){

        try {
            PreparedStatement st = con.prepareStatement("insert into departments (id,name) values (?,?)");
            st.setInt(1,dep.getId());
            st.setString(2,dep.getName());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> getAllEmployee(Connection con){

        List<Employee> employees = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from employees");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int department_id = rs.getInt("department_id");
                Employee employee = new Employee(id,name,salary,department_id);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;

    }

    public static List<Employee> getByDepartment(Connection con, int department){
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement st = con.prepareStatement("select * from employees where department_id like ?");
            st.setInt(1,department);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int department_id = rs.getInt("department_id");
                Employee employee = new Employee(id,name,salary,department_id);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;

    }
    public static Employee getMaxSalaryEmployee(Connection con){

        List<Employee> employees = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from employees");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int department_id = rs.getInt("department_id");
                Employee employee = new Employee(id,name,salary,department_id);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Employee temp = new Employee();
        for (Employee e:employees) {

            if(e.getSalary() > temp.getSalary()){
                temp = e;
            }

        }

        return temp;

    }
    public static Department getByAverageValue(Connection con){

        List<Department> departments = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from departments");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Department department = new Department(id,name);
                departments.add(department);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        Department result = new Department();
        double res = Double.MAX_VALUE;

        for (Department dep:departments) {
            List<Employee> temp = getByDepartment(con,dep.getId());
            double buf = 0;
            for (Employee e:temp) {
                buf += e.getSalary();
            }
            buf /= temp.size();
            if(buf < res){
                res = buf;
                result = dep;
            }
        }
        return result;
    }

}
