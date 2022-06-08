package controller.contract;

import model.contract.Contract;
import service.contract.IContractService;
import service.customer.ICustomerService;
import service.employee.IEmployeeService;
import service.furama_service.IFuramaServiceService;
import service.impl.contract.ContractServiceImpl;
import service.impl.customer.CustomerServiceImpl;
import service.impl.employee.EmployeeServiceImpl;
import service.impl.furama_service.FuramaServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractController", value = "/contract")
public class ContractController extends HttpServlet {
    IContractService contractService = new ContractServiceImpl();
    IEmployeeService employeeService = new EmployeeServiceImpl();
    ICustomerService customerService = new CustomerServiceImpl();
    IFuramaServiceService furamaServiceService = new FuramaServiceServiceImpl();

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
                showAllContract(request, response);
                break;
            case "delete":
                deleteContract(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "search":
                searchById(request, response);
                break;
            default:
                showListContract(request, response);
                break;
        }
    }

    private void showAllContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listEmployee", employeeService.getAllEmployee());
        request.setAttribute("listCustomer", customerService.getAllCustomer());
        request.setAttribute("listService", furamaServiceService.getAllService());
        request.setAttribute("listContract", contractService.getAllContract());
        request.getRequestDispatcher("contract/contract-home.jsp").forward(request, response);
    }

    private void searchById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contractSearchValue = request.getParameter("contractSearchValue");
        request.setAttribute("listEmployee", employeeService.getAllEmployee());
        request.setAttribute("listCustomer", customerService.getAllCustomer());
        request.setAttribute("listService", furamaServiceService.getAllService());
        request.setAttribute("listContract", contractService.searchContractById(contractSearchValue));
        request.getRequestDispatcher("contract/contract-home.jsp").forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        request.setAttribute("listEmployee", employeeService.getAllEmployee());
        request.setAttribute("listCustomer", customerService.getAllCustomer());
        request.setAttribute("listService", furamaServiceService.getAllService());
        request.setAttribute("contract", contractService.getContractById(idEdit));
        request.getRequestDispatcher("contract/contract-form-edit.jsp").forward(request, response);
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));
        contractService.deleteContract(idDelete);
        response.sendRedirect("/contract");
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listEmployee", employeeService.getAllEmployee());
        request.setAttribute("listCustomer", customerService.getAllCustomer());
        request.setAttribute("listService", furamaServiceService.getAllService());
        request.getRequestDispatcher("contract/contract-detail-form-create.jsp").forward(request, response);
    }

    private void showListContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listEmployee", employeeService.getAllEmployee());
        request.setAttribute("listCustomer", customerService.getAllCustomer());
        request.setAttribute("listService", furamaServiceService.getAllService());
        request.setAttribute("listContract", contractService.getAllContractIsActive());
        request.getRequestDispatcher("contract/contract-home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                saveContract(request, response);
                break;
            case "edit":
                editContract(request, response);
                break;
            default:
                break;
        }
    }

    private void editContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        String contractStartDate = request.getParameter("contractStartDate");
        String contractEndDate = request.getParameter("contractEndDate");
        Double deposit = Double.valueOf(request.getParameter("contractDeposit"));
        Double contractTotalMoney = Double.valueOf(request.getParameter("contractTotalMoney"));
        Integer employeeId = Integer.valueOf(request.getParameter("employeeId"));
        Integer customerId = Integer.valueOf(request.getParameter("customerId"));
        Integer serviceId = Integer.valueOf(request.getParameter("serviceId"));
        Integer status = Integer.valueOf(request.getParameter("status"));
        Contract contract = new Contract(idEdit, contractStartDate, contractEndDate, deposit, contractTotalMoney, employeeId, customerId, serviceId, status);
        contractService.updateContract(contract);
        response.sendRedirect("/contract");
    }

    private void saveContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String contractStartDate = request.getParameter("contractStartDate");
        String contractEndDate = request.getParameter("contractEndDate");
        Double deposit = Double.valueOf(request.getParameter("contractDeposit"));
        Double contractTotalMoney = Double.valueOf(request.getParameter("contractTotalMoney"));
        Integer employeeId = Integer.valueOf(request.getParameter("employeeId"));
        Integer customerId = Integer.valueOf(request.getParameter("customerId"));
        Integer serviceId = Integer.valueOf(request.getParameter("serviceId"));
        Contract contract = new Contract(contractStartDate, contractEndDate, deposit, contractTotalMoney, employeeId, customerId, serviceId);
        contractService.saveContract(contract);
        response.sendRedirect("/contract");
    }
}