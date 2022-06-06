package controller.service;

import model.service.Service;
import service.furama_service.IFuramaServiceService;
import service.impl.furama_service.FuramaServiceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceController", value = "/service")
public class ServiceController extends HttpServlet {
    IFuramaServiceService furamaServiceService = new FuramaServiceServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormServiceCreate(request, response);
                break;
            case "delete":
                deleteService(request, response);
                break;
            case "getAll":
                showAllService(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "search":
                String searchValue = request.getParameter("serviceSearchValue");
                request.setAttribute("rentTypes", furamaServiceService.getAllRentType());
                request.setAttribute("serviceTypes", furamaServiceService.getAllServiceType());
                request.setAttribute("services", furamaServiceService.findServiceByName(searchValue));
                request.getRequestDispatcher("service/service-home.jsp").forward(request, response);
                break;
            default:
                showListService(request, response);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        Service service = furamaServiceService.getServiceForEdit(idEdit);
        request.setAttribute("serviceName", service.getServiceName());
        request.setAttribute("serviceArea", service.getServiceArea());
        request.setAttribute("serviceCost", service.getServiceCost());
        request.setAttribute("serviceMaxPeople", service.getServiceMaxPeople());
        request.setAttribute("rentTypeId", service.getRentTypeId());
        request.setAttribute("rentTypes", furamaServiceService.getAllRentType());
        request.setAttribute("serviceTypeId", service.getServiceTypeId());
        request.setAttribute("serviceTypes", furamaServiceService.getAllServiceType());
        request.setAttribute("standardRoom", service.getStandardRoom());
        request.setAttribute("descriptionOtherConvenience", service.getDescriptionOtherConvenience());
        request.setAttribute("poolArea", service.getPoolArea());
        request.setAttribute("numberOfFloors", service.getNumberOfFloors());
        request.setAttribute("status", service.getStatus());
        request.getRequestDispatcher("service/service-form-edit.jsp").forward(request, response);
    }

    private void showAllService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("rentTypes", furamaServiceService.getAllRentType());
        request.setAttribute("serviceTypes", furamaServiceService.getAllServiceType());
        request.setAttribute("services", furamaServiceService.getAllService());
        request.getRequestDispatcher("service/service-home.jsp").forward(request, response);
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));
        furamaServiceService.deleteService(idDelete);
        response.sendRedirect("/service");
    }

    private void showFormServiceCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("rentTypes", furamaServiceService.getAllRentType());
        request.setAttribute("serviceTypes", furamaServiceService.getAllServiceType());
        request.getRequestDispatcher("service/service-form-create.jsp").forward(request, response);
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("rentTypes", furamaServiceService.getAllRentType());
        request.setAttribute("serviceTypes", furamaServiceService.getAllServiceType());
        request.setAttribute("services", furamaServiceService.getAllServiceIsActive());
        request.getRequestDispatcher("service/service-home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
            case "edit":
                int idEdit = Integer.parseInt(request.getParameter("idEdit"));
                String serviceName = request.getParameter("serviceName");
                int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
                double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
                int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
                int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
                int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
                String standardRoom = request.getParameter("standardRoom");
                String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
                Double poolArea = Double.valueOf(request.getParameter("poolArea"));
                int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
                int status = Integer.parseInt(request.getParameter("status"));
                Service service = new Service(idEdit,serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors,status);
                furamaServiceService.editService(service);
                response.sendRedirect("/service");
                break;
            default:
                showListService(request, response);
                break;
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String serviceName = request.getParameter("serviceName");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        Double poolArea = Double.valueOf(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors);
        furamaServiceService.saveService(service);
        response.sendRedirect("/service");
    }
}