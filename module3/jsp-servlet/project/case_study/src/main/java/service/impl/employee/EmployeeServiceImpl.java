package service.impl.employee;

import model.employee.Employee;
import repository.employee.IEmployeeRepository;
import repository.impl.employee.EmployeeRepositoryImpl;
import service.employee.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> getAllEmployeeIsActive() {
        return employeeRepository.getAllEmployeeIsActive();
    }
}
