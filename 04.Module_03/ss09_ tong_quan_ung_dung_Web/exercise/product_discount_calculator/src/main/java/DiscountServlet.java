import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("productDescription");
        float price = Float.parseFloat(request.getParameter("listPrice"));
        float discount = Float.parseFloat(request.getParameter("discountPercent"));

        double discountAmount = price * discount * 0.01;
        double discountPrice = price - discountAmount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h4>Product description: " + productDescription + "</h4>");
        writer.println("<p>Discount amount: " + discountAmount + "<p>");
        writer.println("<p>Discount price: " + discountPrice + "<p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
