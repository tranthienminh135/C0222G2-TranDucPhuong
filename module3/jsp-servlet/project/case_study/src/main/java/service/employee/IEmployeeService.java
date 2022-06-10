package service.employee;

import model.employee.*;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    List<Employee> getAllEmployeeIsActive();

    List<Position> getAllPosition();

    List<EducationDegree> getAllED();

    List<Division> getAllDivition();

    void deleteEmployee(int idDelete);

    Map<String,String> saveEmployee(Employee employee);

    List<User> getAllUser();

    Employee getEmployeeForEdit(int idEdit);

    Map<String, String> updateEmployee(Employee employee);

    List<Employee> searchAllEmployeeByName(String searchValue);

    List<Employee> getAllEmployee();
}
