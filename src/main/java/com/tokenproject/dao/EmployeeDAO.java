package com.tokenproject.dao;

import com.tokenproject.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDAO {
    private static final Map<String, Employee> empMap = new HashMap<String, Employee>();

    static {
        initEmps();
    }

    private static void initEmps() {
        Employee emp1 = new Employee("1", "Manh1", "developer1");
        Employee emp2 = new Employee("2", "Manh2", "developer2");
        Employee emp3 = new Employee("3", "Manh3", "developer3");

        empMap.put(emp1.getId(), emp1);
        empMap.put(emp2.getId(), emp2);
        empMap.put(emp3.getId(), emp3);
    }

    public Employee getEmployee(String id) {
        return empMap.get(id);
    }

    public Employee addEmployee(Employee e) {
        empMap.put(e.getId(), e);
        return e;
    }

    public Employee updateEmployee(Employee e) {
        empMap.put(e.getId(), e);
        return e;
    }

    public void deleteEmployee(String e) {
        empMap.remove(e);
    }

    public List<Employee> getAllEmployee() {
        Collection<Employee> all = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(all);
        return list;
    }
}
