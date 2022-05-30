import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Caculator", value = "/calculate")
public class Caculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstOperand = Integer.parseInt(request.getParameter("first-operand"));
        int secondOperand = Integer.parseInt(request.getParameter("second-operand"));
        String operator = request.getParameter("operator");
        int result = 0;
        try {
            result = operatorNumber(firstOperand, secondOperand, operator);
        } catch (ArithmeticException e) {
            request.setAttribute("alert", "Second Operand is not 0");
        } catch (Exception e) {
            request.setAttribute("alert", "Second Operand is not 0");
        }

        request.setAttribute("first", firstOperand);
        request.setAttribute("second", secondOperand);
        request.setAttribute("result", result);
        request.setAttribute("operator", operator);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private int operatorNumber(int firstOperand, int secondOperand, String operator) throws ArithmeticException {
        int result = 0;
        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand == 0) {
                    throw new ArithmeticException("By zero");
                } else {
                    result = firstOperand / secondOperand;
                }
        }
        return result;
    }

}
