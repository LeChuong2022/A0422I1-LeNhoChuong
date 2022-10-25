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
        customerList.add(new Customer(1, "Mai Văn Hoàng", "1983-08-20", "Hà Nội", "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        customerList.add(new Customer(2, "Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://images.pexels.com/photos/1300402/pexels-photo-1300402.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"));
        customerList.add(new Customer(3, "Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://images.pexels.com/photos/9573700/pexels-photo-9573700.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        customerList.add(new Customer(4, "Trần Đăng Khoa", "1983-08-17", "Hà Tây", "https://images.pexels.com/photos/11805720/pexels-photo-11805720.jpeg?auto=compress&cs=tinysrgb&w=1600"));
        customerList.add(new Customer(5, "NGuyễn Đình Thi", "1983-08-19", "Hà Nội", "https://images.pexels.com/photos/5601616/pexels-photo-5601616.jpeg?auto=compress&cs=tinysrgb&w=1600"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("views/list.jsp").forward(request, response);

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
