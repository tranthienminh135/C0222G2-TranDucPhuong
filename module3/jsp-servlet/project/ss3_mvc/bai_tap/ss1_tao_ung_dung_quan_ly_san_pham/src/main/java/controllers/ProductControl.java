package controllers;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductControl", value = "/home")
public class ProductControl extends HttpServlet {
    private static ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAllProduct();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("create-form.jsp");
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                productService.deleteProductById(id);
                response.sendRedirect("/home");
                break;
            case "edit":
                int idEdit = Integer.parseInt(request.getParameter("id"));
                for (Product product : products) {
                    if (product.getId() == idEdit) {
                        request.setAttribute("id", product.getId());
                        request.setAttribute("name", product.getName());
                        request.setAttribute("price", product.getPrice());
                        request.setAttribute("description", product.getDescription());
                        request.getRequestDispatcher("edit-form.jsp").forward(request, response);
                    }
                }
                break;
            case "info":
                int idInfo = Integer.parseInt(request.getParameter("id"));
                for (Product product : products) {
                    if (product.getId() == idInfo) {
                        request.setAttribute("id", product.getId());
                        request.setAttribute("name", product.getName());
                        request.setAttribute("price", product.getPrice());
                        request.setAttribute("description", product.getDescription());
                        request.getRequestDispatcher("info-product.jsp").forward(request, response);
                        break;
                    }
                }
                break;
            default:
                request.setAttribute("listProduct", products);
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product>
                products = productService.getAllProduct();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                int idCreate = Integer.parseInt(request.getParameter("id"));
                String nameCreate = request.getParameter("name");
                double priceCreate = Double.parseDouble(request.getParameter("price"));
                String descriptionCreate = request.getParameter("description");
                productService.addNewProduct(idCreate, nameCreate, priceCreate, descriptionCreate);
                response.sendRedirect("/home");
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                String nameEdit = request.getParameter("name");
                double priceEdit = Double.parseDouble(request.getParameter("price"));
                String descriptionEdit = request.getParameter("description");
                productService.editProductById(id, nameEdit, priceEdit, descriptionEdit);
                response.sendRedirect("/home");
                break;
            case "search":
                String searchValue = request.getParameter("searchValue");
                for (Product product : products) {
                    if (product.getName().contains(searchValue)) {
                        request.setAttribute("listProduct", products);
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                    }
                }
                break;
            default:
                request.setAttribute("listProduct", products);
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
        }
    }
}
