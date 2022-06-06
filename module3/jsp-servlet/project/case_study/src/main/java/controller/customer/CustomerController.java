package controller.customer;

import model.customer.Customer;
import service.customer.ICustomerService;
import service.impl.customer.CustomerServiceImpl;

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
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
                searchCustomerByName(request, response);
                break;
            default:
                showListCustomerIsActive(request, response);
                break;
        }
    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerSearchValue = request.getParameter("customerSearchValue");
        request.setAttribute("listCustomerType", customerService.getAllCustomerType());
        request.setAttribute("listCustomer", customerService.searchCustomerByName(customerSearchValue));
        request.setAttribute("customerSearchValue", customerSearchValue);
        request.getRequestDispatcher("customer/customer-home.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("idEdit"));
        Customer customer = customerService.getCustomerForEdit(customerId);
        request.setAttribute("cTypeId", customer.getCustomerTypeId());
        request.setAttribute("customerName", customer.getCustomerName());
        request.setAttribute("customerBirthday", customer.getCustomerBirthday());
        request.setAttribute("customerGender", customer.getCustomerGender());
        request.setAttribute("customerIdCard", customer.getCustomerIdCard());
        request.setAttribute("customerPhone", customer.getCustomerPhone());
        request.setAttribute("customerEmail", customer.getCustomerEmail());
        request.setAttribute("customerAddress", customer.getCustomerAddress());
        request.setAttribute("status", customer.getStatus());
        request.setAttribute("listCustomerType", customerService.getAllCustomerType());
        request.getRequestDispatcher("customer/customer-form-edit.jsp").forward(request, response);
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
            case "edit":
                updateCustomer(request, response);
                break;
            default:
                showListCustomerIsActive(request, response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        int status = Integer.parseInt(request.getParameter("status"));
        Customer customer = new Customer(idEdit,customerTypeId,customerName,customerBirthday,customerGender,customerIdCard,customerPhone,customerEmail,customerAddress,status);
        customerService.updateCustomer(customer);
        response.sendRedirect("/customer");
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));

        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        customerService.saveCustomer(customer);
        response.sendRedirect("/customer");
    }
}