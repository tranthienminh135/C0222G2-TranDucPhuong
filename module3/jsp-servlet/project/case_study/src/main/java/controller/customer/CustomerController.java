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
import java.util.Map;

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
            case "showCustomerUsingService":
                showListCustomerUsingService(request, response);
                break;
            default:
                showListCustomerIsActive(request, response);
                break;
        }
    }

    private void showListCustomerUsingService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomerUsingService", customerService.getAllCustomerUsingServiceDTO());
        request.getRequestDispatcher("customer/customer-using-service.jsp").forward(request, response);
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

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        int customerTypeId = 0;
        String errCustomerTypeId = null;
        try {
            customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        } catch (NumberFormatException e) {
            errCustomerTypeId = "Ôi bạn ơi! đừng f12";
        }
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");

        int customerGender = 0;
        String errCustomerGender = null;
        try {
            customerGender = Integer.parseInt(request.getParameter("customerGender"));
        } catch (NumberFormatException e) {
            errCustomerGender = "Ôi bạn ơi! đừng f12";
        }
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        int status = 0;
        String errStatus = null;
        try {
            status = Integer.parseInt(request.getParameter("status"));
        } catch (NumberFormatException e) {
            errStatus = "Ôi bạn ơi! đừng f12";
        }
        Customer customer = new Customer(idEdit, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress, status);
        Map<String, String> errMap = customerService.updateCustomer(customer);
        if (errCustomerTypeId != null) {
            errMap.put("errCustomerTypeId", errCustomerTypeId);
        }
        if (errCustomerGender != null) {
            errMap.put("errCustomerGender", errCustomerGender);
        }
        if (errStatus != null) {
            errMap.put("errStatus", errStatus);
        }
        if (errMap.isEmpty()) {
            response.sendRedirect("/customer");
        } else {
            request.setAttribute("errMap", errMap);
            request.setAttribute("listCustomerType", customerService.getAllCustomerType());
            request.setAttribute("customerTypeId", customerTypeId);
            request.setAttribute("customerName", customerName);
            request.setAttribute("customerBirthday", customerBirthday);
            request.setAttribute("customerGender", customerGender);
            request.setAttribute("customerIdCard", customerIdCard);
            request.setAttribute("customerPhone", customerPhone);
            request.setAttribute("customerEmail", customerEmail);
            request.setAttribute("customerAddress", customerAddress);
            request.setAttribute("status", status);
            request.getRequestDispatcher("customer/customer-form-edit.jsp").forward(request,response);
        }

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