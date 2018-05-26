package ndaniluk.simple.webservice.employee.services;

import ndaniluk.simple.webservice.employee.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> employees = new ArrayList<>();
    private static int id = 0;
    static{
        employees.add(new Employee(++id, "Norbox", "Dennilak", new Date(), "12345678"));
    }


    public List<Employee> findAll(){
        return employees;
    }

    public Employee findById(int id){
        if (employees.get(id) == null)
            return null;
        else
            return employees.get(id);
    }

    public void create(String name, String surname, String phoneNumber){
        employees.add(new Employee(++id, name, surname, new Date(), phoneNumber));
    }

    public Employee remove(int id){
        if(employees.get(id) == null)
            return null;
        else {
            employees.remove(id);
            return employees.get(id);
        }
    }
}
