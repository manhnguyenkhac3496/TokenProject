package com.tokenproject.controllers;

import com.tokenproject.dao.EmployeeDAO;
import com.tokenproject.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to String boot + rest + JWT Example";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "{greeting: 'Hello'}";
    }

    // URL  http://localhost:8080/employees
    @RequestMapping(value = "/employees",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeDAO.getAllEmployee();
        return list;
    }

    // URL  http://localhost:8080/employee/{id}
    @RequestMapping(value = "/employee/{id}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") String id) {
        return employeeDAO.getEmployee(id);
    }

    // URL  http://localhost:8080/employee
    @RequestMapping(value = "/employee", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee e) {

        System.out.println("(Service Side) Creating employee: " + e.getId());

        return employeeDAO.addEmployee(e);
    }

    // URL:  http://localhost:8080/employee
    @RequestMapping(value = "/employee", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee e) {

        System.out.println("(Service Side) Editing employee: " + e.getId());

        return employeeDAO.updateEmployee(e);
    }

    // URL:  http://localhost:8080/employee/{id}
    @RequestMapping(value = "/employee/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("id") String id) {

        System.out.println("(Service Side) Deleting employee: " + id);

        employeeDAO.deleteEmployee(id);
    }
}
