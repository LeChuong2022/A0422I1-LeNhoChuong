import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1, "Mai Văn Hoàng", "1983-08-20", "Hà Nội", "111"));
        customerList.add(new Customer(2, "Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "111"));
        customerList.add(new Customer(3, "Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "111"));
        customerList.add(new Customer(4, "Trần Đăng Khoa", "1983-08-17", "Hà Tây", "111"));
        customerList.add(new Customer(1, "NGuyễn Đình Thi", "1983-08-19", "Hà Nội", "111"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("views/lít.jsp").forward(request, response);

    }
}
