package service.employee;

import model.employee.*;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployeeIsActive();

    List<Position> getAllPosition();

    List<EducationDegree> getAllED();

    List<Division> getAllDivition();

    void deleteEmployee(int idDelete);

    void saveEmployee(Employee employee);

    List<User> getAllUser();
}
