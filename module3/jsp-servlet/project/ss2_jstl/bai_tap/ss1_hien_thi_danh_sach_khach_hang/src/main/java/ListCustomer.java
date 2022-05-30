import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListCustomer", value = "/ListCustomer")
public class ListCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Le Thi Tai","06-01-1969","Trung Quoc", "https://mcdn.coolmate.me/image/October2021/meme-cheems-1.png"));
        customers.add(new Customer("Le Thi Luan","07-02-1919","Chau Phi", "https://mcdn.coolmate.me/image/October2021/meme-cheems-1.png"));
        customers.add(new Customer("Le Thi Hau","08-03-1939","A Rap", "https://mcdn.coolmate.me/image/October2021/meme-cheems-1.png"));
        customers.add(new Customer("Le Thi Tri","09-04-1949","An Do", "https://mcdn.coolmate.me/image/October2021/meme-cheems-1.png"));
        customers.add(new Customer("Le Thi Hoan","00-05-1959","Lao", "https://mcdn.coolmate.me/image/October2021/meme-cheems-1.png"));

        request.setAttribute("listCustomer",customers);
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
