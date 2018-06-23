package ndaniluk.simple.webservice.employee.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import ndaniluk.simple.webservice.employee.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

  private static List<Employee> employees = new ArrayList<>();
  private static int id = 0;


  public List<Employee> findAll() {
    if (employees.size() == 0) {
      return null;
    } else {
      return employees;
    }
  }

  public Employee findById(int id) {
    Iterator<Employee> iterator = employees.iterator();
    Employee employee;

    while (iterator.hasNext()) {
      employee = iterator.next();
      if (employee.getId() == id) {
        return employee;
      }
    }
    return null;
  }

  public void create(String name, String surname, String phoneNumber) {
    employees.add(new Employee(++id, name, surname, new Date(), phoneNumber));
  }

  public Employee remove(int id) {
    Iterator<Employee> iterator = employees.iterator();
    Employee employee;

    while (iterator.hasNext()) {
      employee = iterator.next();
      if (employee.getId() == id) {
        iterator.remove();
        return employee;
      }
    }
    return null;
  }
}
