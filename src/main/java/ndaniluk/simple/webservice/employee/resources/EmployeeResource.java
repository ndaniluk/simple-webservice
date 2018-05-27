package ndaniluk.simple.webservice.employee.resources;

import ndaniluk.simple.webservice.employee.Employee;
import ndaniluk.simple.webservice.employee.exceptions.UserNotFoundException;
import ndaniluk.simple.webservice.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    EmployeeService service;

    @GetMapping(path = "/employees")
    public List<Employee> retrieveAllEmployees(){
        if(service.findAll() == null)
            throw new UserNotFoundException("Can't find any employee");
        else
            return service.findAll();
    }

    @GetMapping(path = "/employees/{id}")
    public Employee retrieveEmployee(@PathVariable int id) {
        if (service.findById(id) == null)
            throw new UserNotFoundException("Employee with id " + id + " not found");
        else
            return service.findById(id);
    }

    @PostMapping(path = "/employees")
    public void createEmployee(@Valid @RequestBody Employee employee){
        service.create(employee.getName(), employee.getSurname(), employee.getPhoneNumber());
    }

    @DeleteMapping(path = "/employees/{id}")
    public void removeEmployee(@PathVariable int id){
        if (service.remove(id) == null)
            throw new UserNotFoundException("Employee with id " + id + " not found");
    }

}
