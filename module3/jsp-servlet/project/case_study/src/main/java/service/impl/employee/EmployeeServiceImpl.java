package service.impl.employee;

import common.check_regex.CheckRegex;
import model.customer.CustomerType;
import model.employee.*;
import repository.employee.IEmployeeRepository;
import repository.impl.employee.EmployeeRepositoryImpl;
import service.employee.IEmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
    public Map<String,String> saveEmployee(Employee employee) {
        Map<String, String> errMap = new HashMap<>();
        if (employee.getEmployeeName() == null || employee.getEmployeeName().equals("")) {
            errMap.put("errEmployeeName", "Tên không được để trống nha bạn!");
        }
        if (employee.getEmployeeBirthday() == null || employee.getEmployeeBirthday().equals("")) {
            errMap.put("errEmployeeBirthday", "Nhập dữ liệu đi bạn!");
        } else {
            try {
                employee.setEmployeeBirthday(simpleDateFormat.format(simpleDateFormat.parse(employee.getEmployeeBirthday())));
            } catch (ParseException e) {
                errMap.put("errEmployeeBirthday", "Ôi bạn ơi! đừng f12!");
            }
        }
        try {
            if (simpleDateFormat.parse(employee.getEmployeeBirthday()).getTime() > (new Date()).getTime()) {
                errMap.put("errEmployeeBirthday", "Ôi bạn ơi bạn sinh ra ở tương lai à?");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (employee.getEmployeeIdCard() == null || employee.getEmployeeIdCard().equals("")) {
            errMap.put("errEmployeeIdCard", "Id Card không để trống bạn ơi!");
        } else if (!CheckRegex.checkRegexIDCard(employee.getEmployeeIdCard())) {
            errMap.put("errEmployeeIdCard", "Id Card phải có 9 hoặc 12 số bạn à");
        }
        if (employee.getEmployeeSalary() == null || employee.getEmployeeSalary().equals("")) {
            errMap.put("errEmployeeSalary", "Salary không để trống bạn ơi!");
        }
        if (employee.getEmployeePhone() == null || employee.getEmployeePhone().equals("")) {
            errMap.put("errEmployeePhone", "Phone không để trống bạn ơi!");
        } else if (!CheckRegex.checkRegexPhone(employee.getEmployeePhone())) {
            errMap.put("errEmployeePhone", "Số điện thoại phải có 9 số và bắt đầu bằng 09-XXXXXXX hoặc 849-XXXXXXX nhé bạn!");
        }
        if (employee.getEmployeeEmail() == null || employee.getEmployeeEmail().equals("")) {
            errMap.put("errEmployeeEmail", "Email không được để trống nha bạn!");
        } else if (!CheckRegex.checkRegexEmail(employee.getEmployeeEmail())) {
            errMap.put("errEmployeeEmail", "Email không đúng định dạng (VD: lethitai69@gmail.com) nè bạn!");
        }
        if (employee.getEmployeeAddress() == null || employee.getEmployeeAddress().equals("")) {
            errMap.put("errEmployeeAddress", "Address không được để trống nha bạn!");
        }

        if (employee.getUsername() == null || employee.getEmployeeName().equals("")) {
            errMap.put("errUserName", "Chọn đi bạn đừng sợ!");
        } else {
            List<User> users = employeeRepository.getAllUser();
            boolean flagU = false;
            for (User user : users) {
                if (employee.getUsername().equals(user.getUsername())) {
                    flagU = true;
                    break;
                }
            }
            if (!flagU) {
                errMap.put("errUserName", "Ôi bạn ơi! đừng f12!");
            }
        }

        List<Position> positions = employeeRepository.getAllPosition();
        boolean flagPo = false;
        for (Position position : positions) {
            if (employee.getPositionId() == position.getPositionId()) {
                flagPo = true;
                break;
            }
        }
        if (!flagPo) {
            errMap.put("errPositionId", "Ôi bạn ơi! đừng f12!");
        }

        List<EducationDegree> educationDegrees = employeeRepository.getAllED();
        boolean flagED = false;
        for (EducationDegree educationDegree : educationDegrees) {
            if (employee.getEducationDegreeId() == educationDegree.getEducationDegreeId()) {
                flagED = true;
                break;
            }
        }
        if (!flagED) {
            errMap.put("errEducationDegree", "Ôi bạn ơi! đừng f12!");
        }

        List<Division> divisions = employeeRepository.getAllDivition();
        boolean flagDv = false;
        for (Division division : divisions) {
            if (employee.getDivisionId() == division.getDivisionId()) {
                flagDv = true;
                break;
            }
        }
        if (!flagDv) {
            errMap.put("errDivision", "Ôi bạn ơi! đừng f12!");
        }
        if (errMap.isEmpty()) {
            employeeRepository.saveEmployee(employee);
        } else {
            return errMap;
        }
        return errMap;
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
    public Map<String, String> updateEmployee(Employee employee) {
        Map<String, String> errMap = new HashMap<>();
        if (employee.getEmployeeName() == null || employee.getEmployeeName().equals("")) {
            errMap.put("errEmployeeName", "Tên không được để trống nha bạn!");
        }
        if (employee.getEmployeeBirthday() == null || employee.getEmployeeBirthday().equals("")) {
            errMap.put("errEmployeeBirthday", "Nhập dữ liệu đi bạn!");
        } else {
            try {
                employee.setEmployeeBirthday(simpleDateFormat.format(simpleDateFormat.parse(employee.getEmployeeBirthday())));
            } catch (ParseException e) {
                errMap.put("errEmployeeBirthday", "Ôi bạn ơi! đừng f12!");
            }
        }
        try {
            if (simpleDateFormat.parse(employee.getEmployeeBirthday()).getTime() > (new Date()).getTime()) {
                errMap.put("errEmployeeBirthday", "Ôi bạn ơi bạn sinh ra ở tương lai à?");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (employee.getEmployeeIdCard() == null || employee.getEmployeeIdCard().equals("")) {
            errMap.put("errEmployeeIdCard", "Id Card không để trống bạn ơi!");
        } else if (!CheckRegex.checkRegexIDCard(employee.getEmployeeIdCard())) {
            errMap.put("errEmployeeIdCard", "Id Card phải có 9 hoặc 12 số bạn à");
        }
        if (employee.getEmployeeSalary() == null || employee.getEmployeeSalary().equals("")) {
            errMap.put("errEmployeeSalary", "Salary không để trống bạn ơi!");
        }
        if (employee.getEmployeePhone() == null || employee.getEmployeePhone().equals("")) {
            errMap.put("errEmployeePhone", "Phone không để trống bạn ơi!");
        } else if (!CheckRegex.checkRegexPhone(employee.getEmployeePhone())) {
            errMap.put("errEmployeePhone", "Số điện thoại phải có 9 số và bắt đầu bằng 09-XXXXXXX hoặc 849-XXXXXXX nhé bạn!");
        }
        if (employee.getEmployeeEmail() == null || employee.getEmployeeEmail().equals("")) {
            errMap.put("errEmployeeEmail", "Email không được để trống nha bạn!");
        } else if (!CheckRegex.checkRegexEmail(employee.getEmployeeEmail())) {
            errMap.put("errEmployeeEmail", "Email không đúng định dạng (VD: lethitai69@gmail.com) nè bạn!");
        }

        List<Position> positions = employeeRepository.getAllPosition();
        boolean flagPo = false;
        for (Position position : positions) {
            if (employee.getPositionId() == position.getPositionId()) {
                flagPo = true;
                break;
            }
        }
        if (!flagPo) {
            errMap.put("errPositionId", "Ôi bạn ơi! đừng f12!");
        }

        List<EducationDegree> educationDegrees = employeeRepository.getAllED();
        boolean flagED = false;
        for (EducationDegree educationDegree : educationDegrees) {
            if (employee.getEducationDegreeId() == educationDegree.getEducationDegreeId()) {
                flagED = true;
                break;
            }
        }
        if (!flagED) {
            errMap.put("errEducationDegree", "Ôi bạn ơi! đừng f12!");
        }

        List<Division> divisions = employeeRepository.getAllDivition();
        boolean flagDv = false;
        for (Division division : divisions) {
            if (employee.getDivisionId() == division.getDivisionId()) {
                flagDv = true;
                break;
            }
        }
        if (!flagDv) {
            errMap.put("errDivision", "Ôi bạn ơi! đừng f12!");
        }
        if (errMap.isEmpty()) {
            employeeRepository.updateEmployee(employee);
        } else {
            return errMap;
        }
        return errMap;
    }

    @Override
    public List<Employee> searchAllEmployeeByName(String searchValue) {
        return employeeRepository.searchAllEmployeeByName(searchValue);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }
}
