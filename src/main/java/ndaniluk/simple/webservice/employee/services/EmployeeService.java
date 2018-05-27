package ndaniluk.simple.webservice.employee.services;

import ndaniluk.simple.webservice.employee.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> employees = new ArrayList<>();
    private static int id = 0;
    static{
        employees.add(new Employee(++id, "Norbox", "Dennilak", new Date(), "12345678"));
        employees.add(new Employee(++id, "Marcel", "Ukrainski", new Date(), "456789123"));
    }


    public List<Employee> findAll(){
        if(employees.size() == 0)
            return null;
        else
            return employees;
    }

    public Employee findById(int id){
        Iterator<Employee> iterator = employees.iterator();
        Employee employee;

        while (iterator.hasNext()){
            employee = iterator.next();
            if (employee.getId() == id)
                return employee;
        }
        return null;
    }

    public void create(String name, String surname, String phoneNumber){
        employees.add(new Employee(++id, name, surname, new Date(), phoneNumber));
    }

    public Employee remove(int id){
        Iterator<Employee> iterator = employees.iterator();
        Employee employee;

        while(iterator.hasNext()){
            employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                return employee;
            }
        }
        return null;
    }
}
