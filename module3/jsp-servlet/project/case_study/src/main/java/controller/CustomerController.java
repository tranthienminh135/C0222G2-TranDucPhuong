package controller;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Customer", value = "/customer")
public class CustomerController extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "getAll":
                showAllCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                showListCustomerIsActive(request, response);
                break;
        }
    }

    private void showAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomerType", customerService.getAllCustomerType());
        request.setAttribute("listCustomer", customerService.getAllCustomer());
        request.getRequestDispatcher("customer/customer-home.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerId = Integer.parseInt(request.getParameter("idDelete"));
        customerService.deleteCustomer(customerId);
        response.sendRedirect("/customer");
    }

    private void showListCustomerIsActive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomerType", customerService.getAllCustomerType());
        request.setAttribute("listCustomer", customerService.getAllCustomerIsActive());
        request.getRequestDispatcher("customer/customer-home.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomerType", customerService.getAllCustomerType());
        request.getRequestDispatcher("customer/customer-form-create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            default:
                showListCustomerIsActive(request, response);
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
        ;
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        customerService.saveCustomer(customer);
        response.sendRedirect("/customer");
    }
}
