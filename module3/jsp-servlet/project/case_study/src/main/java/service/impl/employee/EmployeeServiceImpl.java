package service.impl.employee;

import model.employee.*;
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

    @Override
    public List<Position> getAllPosition() {
        return employeeRepository.getAllPosition();
    }

    @Override
    public List<EducationDegree> getAllED() {
        return employeeRepository.getAllED();
    }

    @Override
    public List<Division> getAllDivition() {
        return employeeRepository.getAllDivition();
    }

    @Override
    public void deleteEmployee(int idDelete) {
        employeeRepository.deleteEmployee(idDelete);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee);
    }

    @Override
    public List<User> getAllUser() {
        return employeeRepository.getAllUser();
    }

    @Override
    public Employee getEmployeeForEdit(int idEdit) {
        return employeeRepository.getEmployeeForEdit(idEdit);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    @Override
    public List<Employee> searchAllEmployeeByName(String searchValue) {
        return employeeRepository.searchAllEmployeeByName(searchValue);
    }
}
