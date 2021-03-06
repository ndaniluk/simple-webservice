package ndaniluk.simple.webservice.employee.controllers;

import java.util.List;
import javax.validation.Valid;
import ndaniluk.simple.webservice.employee.exceptions.UserNotFoundException;
import ndaniluk.simple.webservice.employee.models.Employee;
import ndaniluk.simple.webservice.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeService service;

  @GetMapping(path = "/employees")
  public List<Employee> retrieveAllEmployees() {
    if (service.findAll() == null) {
      throw new UserNotFoundException("Can't find any employee");
    } else {
      return service.findAll();
    }
  }

  @GetMapping(path = "/employees/{id}")
  public Employee retrieveEmployee(@PathVariable int id) {
    if (service.findById(id) == null) {
      throw new UserNotFoundException("Employee with id " + id + " not found");
    } else {
      return service.findById(id);
    }
  }

  @PostMapping(path = "/employees")
  public void createEmployee(@Valid @RequestBody Employee employee) {
    service.create(employee.getName(), employee.getSurname(), employee.getPhoneNumber());
  }

  @DeleteMapping(path = "/employees/{id}")
  public void removeEmployee(@PathVariable int id) {
    if (service.remove(id) == null) {
      throw new UserNotFoundException("Employee with id " + id + " not found");
    }
  }

}
