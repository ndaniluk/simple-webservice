package ndaniluk.simple.webservice.employee.services;

import ndaniluk.simple.webservice.employee.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee("Arek", "Kowalski", "123456789"));
    }

    public List<Employee> findAll(){
        return employees;
    }

    public Employee findEmployee(){
        return new Employee("1", "1", "1");
    }
}
