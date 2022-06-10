package controller.employee;

import model.employee.*;
import service.employee.IEmployeeService;
import service.impl.employee.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeController", value = "/employee")
public class EmployeeController extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "getAll":
                showAllEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "search":
                searchEmployeeByName(request, response);
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

    private void showAllEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPosition", employeeService.getAllPosition());
        request.setAttribute("listED", employeeService.getAllED());
        request.setAttribute("listDivision", employeeService.getAllDivition());
        request.setAttribute("listEmployee", employeeService.getAllEmployee());
        request.getRequestDispatcher("employee/employee-home.jsp").forward(request, response);
    }

    private void searchEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchValue = request.getParameter("employeeSearchValue");
        request.setAttribute("listPosition", employeeService.getAllPosition());
        request.setAttribute("listED", employeeService.getAllED());
        request.setAttribute("listDivision", employeeService.getAllDivition());
        request.setAttribute("listEmployee", employeeService.searchAllEmployeeByName(searchValue));
        request.getRequestDispatcher("employee/employee-home.jsp").forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        Employee employee = employeeService.getEmployeeForEdit(idEdit);
        request.setAttribute("employeeName", employee.getEmployeeName());
        request.setAttribute("employeeBirthday", employee.getEmployeeBirthday());
        request.setAttribute("employeeIdCard", employee.getEmployeeIdCard());
        request.setAttribute("employeeSalary", employee.getEmployeeSalary());
        request.setAttribute("employeePhone", employee.getEmployeePhone());
        request.setAttribute("employeeEmail", employee.getEmployeeEmail());
        request.setAttribute("employeeAddress", employee.getEmployeeAddress());
        request.setAttribute("positionId1", employee.getPositionId());
        request.setAttribute("educationDegreeId1", employee.getEducationDegreeId());
        request.setAttribute("divisionId1", employee.getDivisionId());
        request.setAttribute("username1", employee.getUsername());
        request.setAttribute("status", employee.getStatus());
        request.setAttribute("listPosition", employeeService.getAllPosition());
        request.setAttribute("listED", employeeService.getAllED());
        request.setAttribute("listDivision", employeeService.getAllDivition());
        request.setAttribute("listUser", employeeService.getAllUser());
        request.getRequestDispatcher("employee/employee-form-edit.jsp").forward(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPosition", employeeService.getAllPosition());
        request.setAttribute("listED", employeeService.getAllED());
        request.setAttribute("listDivision", employeeService.getAllDivition());
        request.setAttribute("listUser", employeeService.getAllUser());
        request.getRequestDispatcher("employee/employee-form-create.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));
        employeeService.deleteEmployee(idDelete);
        response.sendRedirect("/employee");
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPosition", employeeService.getAllPosition());
        request.setAttribute("listED", employeeService.getAllED());
        request.setAttribute("listDivision", employeeService.getAllDivition());
        request.setAttribute("listEmployee", employeeService.getAllEmployeeIsActive());
        request.getRequestDispatcher("employee/employee-home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
            default:
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idEdit = Integer.valueOf(request.getParameter("idEdit"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = 0;
        String errEmployeeSalary = null;
        try {
            employeeSalary = Double.valueOf(request.getParameter("employeeSalary"));
        } catch (NumberFormatException e) {
            errEmployeeSalary = "Ôi bạn ơi! nhập số đi bạn";
        }
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = 0;
        String errPositionId = null;
        try {
            positionId = Integer.valueOf(request.getParameter("positionId"));
        } catch (NumberFormatException e) {
            errPositionId = "Ôi bạn ơi! nhập chữ đi bạn";
        }
        int educationDegreeId = 0;
        String errEducationDegreeId = null;
        try {
            educationDegreeId = Integer.valueOf(request.getParameter("educationDegreeId"));
        } catch (NumberFormatException e) {
            errEducationDegreeId = "Ôi bạn ơi! đừng f12";
        }
        int divisionId = 0;
        String errDivisionId = null;
        try {
            divisionId = Integer.valueOf(request.getParameter("divisionId"));
        } catch (NumberFormatException e) {
            errDivisionId = "Ôi bạn ơi! đừng f12";
        }
        String username = request.getParameter("username");
        int status = 0;
        String errStatus = null;
        try {
            status = Integer.parseInt(request.getParameter("status"));
        } catch (NumberFormatException e) {
            errStatus = "Ôi bạn ơi! đừng f12";
        }
        Employee employee = new Employee(idEdit, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username, status);
        Map<String, String> errMap = employeeService.updateEmployee(employee);
        if (errPositionId != null) {
            errMap.put("errPositionId", errPositionId);
        }
        if (errEducationDegreeId != null) {
            errMap.put("errEducationDegreeId", errEducationDegreeId);
        }
        if (errDivisionId != null) {
            errMap.put("errDivisionId", errDivisionId);
        }
        if (errEmployeeSalary != null) {
            errMap.put("errEmployeeSalary", errEmployeeSalary);
        }
        if (errStatus != null) {
            errMap.put("errStatus", errStatus);
        }
        if (errMap.isEmpty()) {
            response.sendRedirect("/employee");
        } else {
            request.setAttribute("employeeName", employeeName);
            request.setAttribute("employeeBirthday", employeeBirthday);
            request.setAttribute("employeeIdCard", employeeIdCard);
            request.setAttribute("employeeSalary", employeeSalary);
            request.setAttribute("employeePhone", employeePhone);
            request.setAttribute("employeeEmail", employeeEmail);
            request.setAttribute("employeeAddress", employeeAddress);
            request.setAttribute("listPosition", employeeService.getAllPosition());
            request.setAttribute("listED", employeeService.getAllED());
            request.setAttribute("listDivision", employeeService.getAllDivition());
            request.setAttribute("listUser", employeeService.getAllUser());
            request.setAttribute("status", employee.getStatus());
            request.setAttribute("errMap", errMap);
            request.getRequestDispatcher("employee/employee-form-edit.jsp").forward(request, response);
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = 0;
        String errEmployeeSalary = null;
        try {
            employeeSalary = Double.valueOf(request.getParameter("employeeSalary"));
        } catch (NumberFormatException e) {
            errEmployeeSalary = "Ôi bạn ơi! nhập số đi bạn";
        }
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = 0;
        String errPositionId = null;
        try {
            positionId = Integer.valueOf(request.getParameter("positionId"));
        } catch (NumberFormatException e) {
            errPositionId = "Chọn đi bạn đừng sợ!";
        }
        int educationDegreeId = 0;
        String errEducationDegreeId = null;
        try {
            educationDegreeId = Integer.valueOf(request.getParameter("educationDegreeId"));
        } catch (NumberFormatException e) {
            errEducationDegreeId = "Chọn đi bạn đừng sợ!";
        }
        int divisionId = 0;
        String errDivisionId = null;
        try {
            divisionId = Integer.valueOf(request.getParameter("divisionId"));
        } catch (NumberFormatException e) {
            errDivisionId = "Chọn đi bạn đừng sợ!";
        }
        String username = request.getParameter("username");
        Employee employee = new Employee(employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, username);
        Map<String, String> errMap = employeeService.saveEmployee(employee);
        if (errPositionId != null) {
            errMap.put("errPositionId", errPositionId);
        }
        if (errEducationDegreeId != null) {
            errMap.put("errEducationDegreeId", errEducationDegreeId);
        }
        if (errDivisionId != null) {
            errMap.put("errDivisionId", errDivisionId);
        }
        if (errEmployeeSalary != null) {
            errMap.put("errEmployeeSalary", errEmployeeSalary);
        }
        if (errMap.isEmpty()) {
            response.sendRedirect("/employee");
        } else {
            request.setAttribute("employeeName", employeeName);
            request.setAttribute("employeeBirthday", employeeBirthday);
            request.setAttribute("employeeIdCard", employeeIdCard);
            request.setAttribute("employeeSalary", employeeSalary);
            request.setAttribute("employeePhone", employeePhone);
            request.setAttribute("employeeEmail", employeeEmail);
            request.setAttribute("employeeAddress", employeeAddress);
            request.setAttribute("positionId1", positionId);
            request.setAttribute("educationDegreeId1", educationDegreeId);
            request.setAttribute("divisionId1", divisionId);
            request.setAttribute("username1", username);
            request.setAttribute("listPosition", employeeService.getAllPosition());
            request.setAttribute("listED", employeeService.getAllED());
            request.setAttribute("listDivision", employeeService.getAllDivition());
            request.setAttribute("listUser", employeeService.getAllUser());
            request.setAttribute("errMap", errMap);
            request.getRequestDispatcher("employee/employee-form-create.jsp").forward(request, response);
        }
    }
}