package ndaniluk.simple.webservice.employee.resources;

import ndaniluk.simple.webservice.employee.Employee;
import ndaniluk.simple.webservice.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    EmployeeService service;

    @GetMapping(path = "/employees")
    public List<Employee> retrieveAllEmployees(){
        return service.findAll();
    }

    @GetMapping(path = "/employees/{id}")
    public Employee retrieveEmployee(@PathVariable int id){
        return service.findById(id-1);
    }

    @PostMapping(path = "/employees")
    public void createEmployee(@RequestBody Employee employee){
        service.create(employee.getName(), employee.getSurname(), employee.getPhoneNumber());
    }

    @DeleteMapping(path = "/employees/{id}")
    public void removeEmployee(@PathVariable int id){
        service.remove(id-1);
    }

}
