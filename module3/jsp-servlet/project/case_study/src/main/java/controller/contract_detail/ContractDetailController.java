package controller.contract_detail;

import model.contract_detail.ContractDetail;
import service.contract.IContractService;
import service.contract_detail.IContractDetailService;
import service.impl.contract.ContractServiceImpl;
import service.impl.contract_detail.ContractDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailController", value = "/contract-detail")
public class ContractDetailController extends HttpServlet {
    private IContractDetailService contractDetailService = new ContractDetailServiceImpl();
    private IContractService contractService = new ContractServiceImpl();

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
                getAllContractDetail(request, response);
                break;
            case "delete":
                deleteContractDetail(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "search":
                searchContractDetail(request, response);
                break;
            default:
                showListContractDetail(request, response);
                break;
        }
    }

    private void searchContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contractDetailSearchValue = request.getParameter("contractDetailSearchValue");
        request.setAttribute("listContractDetail", contractDetailService.searchContractDetail(contractDetailSearchValue));
        request.setAttribute("listAttachService", contractDetailService.getAllAttachService());
        request.getRequestDispatcher("contract_detail/contract-detail-home.jsp").forward(request, response);
    }

    private void getAllContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listContractDetail", contractDetailService.getAllContractDetail());
        request.setAttribute("listAttachService", contractDetailService.getAllAttachService());
        request.getRequestDispatcher("contract_detail/contract-detail-home.jsp").forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        request.setAttribute("listAttachService", contractDetailService.getAllAttachService());
        request.setAttribute("listContract", contractService.getAllContract());
        request.setAttribute("contractDetail", contractDetailService.getContractDetail(idEdit));
        request.getRequestDispatcher("contract_detail/contract-detail-form-edit.jsp").forward(request, response);
    }

    private void deleteContractDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));
        contractDetailService.deleteContractDetail(idDelete);
        response.sendRedirect("/contract-detail");
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listAttachService", contractDetailService.getAllAttachService());
        request.setAttribute("listContract", contractService.getAllContract());
        request.getRequestDispatcher("contract_detail/contract-detail-form-create.jsp").forward(request, response);
    }

    private void showListContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listContractDetail", contractDetailService.getAllContractDetailIdActive());
        request.setAttribute("listAttachService", contractDetailService.getAllAttachService());
        request.getRequestDispatcher("contract_detail/contract-detail-home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContractDetail(request, response);
                break;
            case "edit":
                editContractDetail(request, response);
                break;
            default:
                break;
        }
    }

    private void editContractDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEdit = Integer.parseInt(request.getParameter("idEdit"));
        int attachServiceId = Integer.parseInt(request.getParameter("attachServiceId"));
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int status = Integer.parseInt(request.getParameter("status"));
        ContractDetail contractDetail = new ContractDetail(idEdit, attachServiceId, contractId, quantity, status);
        contractDetailService.editContractDetail(contractDetail);
        response.sendRedirect("/contract-detail");
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int attachServiceId = Integer.parseInt(request.getParameter("attachServiceId"));
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(contractId, attachServiceId, quantity);
        contractDetailService.saveContractDetail(contractDetail);
        response.sendRedirect("/contract-detail");
    }
}