package controller;

import model.Users;
import service.IUsersService;
import service.impl.UsersServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserControl", value = "/home")
public class UsersController extends HttpServlet {
    private IUsersService usersService = new UsersServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("create-form.jsp").forward(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("idEdit"));
                for (Users users : usersService.getAllUsers()) {
                    if (users.getId() == id) {
                        request.setAttribute("id1", id);
                        request.setAttribute("name1", users.getName());
                        request.setAttribute("country1", users.getCountry());
                        break;
                    }
                }
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("listUsers", usersService.getAllUsers());
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        usersService.deleteUser(id);
        response.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "edit":
                editUser(request, response);
                break;
            case "search":
                searchByCountry(request, response);
                break;
            default:
                request.setAttribute("listUsers", usersService.getAllUsers());
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idEdit"));
        String name = request.getParameter("nameEdit");
        String country = request.getParameter("countryEdit");
        usersService.editUser(id, name, country);
        response.sendRedirect("/home");
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        Users users = new Users();
        users.setName(name);
        users.setCountry(country);
        usersService.saveUsers(users);
        response.sendRedirect("/home");
    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String searchValue = request.getParameter("searchValue");
        request.setAttribute("txtSearch", searchValue);
        request.setAttribute("listUsers", usersService.searchByCountry(searchValue));
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
