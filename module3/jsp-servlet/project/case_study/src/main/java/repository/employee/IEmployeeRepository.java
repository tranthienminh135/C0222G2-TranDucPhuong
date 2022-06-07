package repository.employee;

import model.employee.*;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getAllEmployeeIsActive();

    List<Position> getAllPosition();

    List<EducationDegree> getAllED();

    List<Division> getAllDivition();

    void deleteEmployee(int idDelete);

    void saveEmployee(Employee employee);

    List<User> getAllUser();

    Employee getEmployeeForEdit(int idEdit);

    void updateEmployee(Employee employee);

    List<Employee> searchAllEmployeeByName(String searchValue);

    List<Employee> getAllEmployee();
}
