package ndaniluk.simple.webservice.employee.services;

import ndaniluk.simple.webservice.employee.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> employees = new ArrayList<>();


    public List<Employee> findAll(){
        return employees;
    }

}
