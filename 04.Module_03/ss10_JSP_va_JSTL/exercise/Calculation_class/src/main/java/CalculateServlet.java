import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(request.getParameter("firstOperand"));
        float secondOperand = Float.parseFloat(request.getParameter("secondOperand"));
        String cal = request.getParameter("cal");


        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result: </h1>");
        try {
            float result = Calculator.calculate(firstOperand, secondOperand, cal);
            cal = cal(cal);
            writer.println("<p>" + firstOperand + cal + secondOperand + " = " + result + " </p> ");
        } catch (Exception ex){
            writer.println("Error: " +ex.getMessage());
        }
        writer.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected String cal(String cal) {
        switch (cal) {
            case "Add":
                return "+";
            case "Sub":
                return "-";
            case "Mul":
                return "*";
            case "Div":
                return "/";
            default:
                return "Không có giá trị";
        }
    }
}
