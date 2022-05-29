import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculateDiscount", value = "/display-discount")
public class CalculateDiscount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("pd");
        float price = Float.parseFloat(request.getParameter("lp"));
        int discount = Integer.parseInt(request.getParameter("dp"));

        double discountAmount = price * discount * 0.01;

        request.setAttribute("pd", productDescription);
        request.setAttribute("lp", price);
        request.setAttribute("dp", discount);
        request.setAttribute("da", discountAmount);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
