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
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "edit":

                break;
            case "search":
                break;
            default:
                showListEmployee(request, response);
                break;
        }
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
                break;
            default:
                break;
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        Double employeeSalary = Double.valueOf(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        Integer positionId = Integer.valueOf(request.getParameter("positionId"));
        Integer educationDegreeId = Integer.valueOf(request.getParameter("educationDegreeId"));
        Integer divisionId = Integer.valueOf(request.getParameter("divisionId"));
        String username = request.getParameter("username");
        Employee employee = new Employee(employeeName,employeeBirthday,employeeIdCard,employeeSalary,employeePhone,employeeEmail,employeeAddress,positionId,educationDegreeId,divisionId,username);
        employeeService.saveEmployee(employee);
        response.sendRedirect("/employee");
    }
}