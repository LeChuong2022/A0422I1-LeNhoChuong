package controller;

import model.DivisionModel;
import model.EducationDegreeModel;
import model.EmployeeModel;
import model.PositionModel;
import service.IDivisionService;
import service.IEducationDegreeService;
import service.IEmployeeService;
import service.IPositionService;
import service.impl.DivisionServiceImpl;
import service.impl.EducationDegreeServiceImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.PositionServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeServiceImpl();
    private IPositionService positionService = new PositionServiceImpl();
    private IEducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();
    private IDivisionService divisionService = new DivisionServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    request.getRequestDispatcher("/view/home.jsp").forward(request,response);
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "save":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "sort":
                sort(request, response);
            default:
                showEmployeeList(request, response);
                break;


        }


    }

    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortType = request.getParameter("sortType");
        List<EmployeeModel> employeeModelList = employeeService.sort(sortType);
        request.setAttribute("employeeList", employeeModelList);
        request.setAttribute("sortType", sortType);

        List<PositionModel> positionList = positionService.findAll();
        List<EducationDegreeModel> educationDegreeModelList = educationDegreeService.findAll();
        List<DivisionModel> divisionModelList = divisionService.findAll();

        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeModelList", educationDegreeModelList);
        request.setAttribute("divisionModelList", divisionModelList);

        request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchUser = request.getParameter("searchUser");
        String searchPositionId = request.getParameter("searchPositionId");
        String searchEducationDegreeId = request.getParameter("searchEducationDegreeId");

        List<EmployeeModel> employeeModelList = employeeService.search(searchName, searchUser, searchPositionId, searchEducationDegreeId);
        request.setAttribute("employeeList", employeeModelList);

        List<PositionModel> positionModelList = positionService.findAll();
        request.setAttribute("positionList", positionModelList);


        List<EducationDegreeModel> educationDegreeModelList = educationDegreeService.findAll();
        List<DivisionModel> divisionModelList = divisionService.findAll();

        request.setAttribute("educationDegreeModelList", educationDegreeModelList);
        request.setAttribute("divisionModelList", divisionModelList);

        request.setAttribute("searchName", searchName);
        request.setAttribute("searchUser", searchUser);
        request.setAttribute("searchPositionId", searchPositionId);
        request.setAttribute("searchEducationDegreeId", searchEducationDegreeId);

        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lấy list qua
        List<PositionModel> positionModelList = positionService.findAll();
        List<EducationDegreeModel> educationDegreeModelList = educationDegreeService.findAll();
        List<DivisionModel> divisionModelList = divisionService.findAll();
        request.setAttribute("positionList", positionModelList);
        request.setAttribute("educationDegreeList", educationDegreeModelList);
        request.setAttribute("divisionList", divisionModelList);
        // \\lấy list qua

        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeModel existingEmployee = employeeService.getEmployee(id);
        request.setAttribute("employee", existingEmployee);
        request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);


    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PositionModel> positionModelList = positionService.findAll();
        List<EducationDegreeModel> educationDegreeModelList = educationDegreeService.findAll();
        List<DivisionModel> divisionModelList = divisionService.findAll();
        request.setAttribute("positionList", positionModelList);
        request.setAttribute("educationDegreeList", educationDegreeModelList);
        request.setAttribute("divisionList", divisionModelList);
        request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int deleteId = Integer.parseInt(request.getParameter("deleteId"));
        employeeService.delete(deleteId);
        request.setAttribute("mess", "xóa thành công");
        showEmployeeList(request, response);
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        List<EmployeeModel> employeeList = employeeService.findAll();
        List<PositionModel> positionList = positionService.findAll();
        List<EducationDegreeModel> educationDegreeModelList = educationDegreeService.findAll();
        List<DivisionModel> divisionModelList = divisionService.findAll();

        request.setAttribute("employeeList", employeeList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeModelList", educationDegreeModelList);
        request.setAttribute("divisionModelList", divisionModelList);

//        Test thử phân trang
        String pageString = request.getParameter("page");
        int page = 0;
        if (!(pageString == null)){
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("page", page);

//        Test thử phân trang
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "save":
                save(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
//            case "delete":
//                deleteUser(request, response);
//                break;
//            case "search":
//                showUserByCoutry(request, response);
//                break;
            default:
                showEmployeeList(request, response);
                break;


        }

    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String user = request.getParameter("user");
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));

        EmployeeModel employee = new EmployeeModel(id, name, birthday, idCard, phone, email, address, salary, positionId, educationDegreeId, divisionId, user);

        boolean check = employeeService.edit(employee);
        String mess = "Sửa không thành công";
        if (check) {
            mess = "Sửa thành công";
        }
        request.setAttribute("mess", mess);
        try {
            // để get lại dữ liệu cho selection
            List<PositionModel> positionModelList = positionService.findAll();
            List<EducationDegreeModel> educationDegreeModelList = educationDegreeService.findAll();
            List<DivisionModel> divisionModelList = divisionService.findAll();
            request.setAttribute("positionList", positionModelList);
            request.setAttribute("educationDegreeList", educationDegreeModelList);
            request.setAttribute("divisionList", divisionModelList);
            // \\để get lại dữ liệu cho selection

            request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        //        int id = Integer.parseInt(request.getParameter("id"));
        String user = request.getParameter("user");
        String name = request.getParameter("name");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String idCard = request.getParameter("idCard");
        Double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));

        EmployeeModel employee = new EmployeeModel(name, birthday, idCard, phone, email, address, salary, positionId, educationDegreeId, divisionId, user);

        /* nếu k làm validate
        boolean check = employeeService.save(employee);
        String mess = "Thêm mới không thành công";
        if (check) {
            mess = "Thêm mới thành công";
        }
        request.setAttribute("mess", mess);
         */

        // làm validate
        Map<String, String> errorMap = employeeService.save(employee);
        String mess = "Thêm mới thành công";
        if (!errorMap.isEmpty()) {
            request.setAttribute("email", email);
            request.setAttribute("salary", salary);
            request.setAttribute("phone", phone);
            request.setAttribute("idCard", idCard);
            request.setAttribute("errorMap", errorMap);
            mess = "Them moi không thanh cong";
        }
        request.setAttribute("mess", mess);
        // làm validate

        try {
            // để get lại dữ liệu cho selection
            List<PositionModel> positionModelList = positionService.findAll();
            List<EducationDegreeModel> educationDegreeModelList = educationDegreeService.findAll();
            List<DivisionModel> divisionModelList = divisionService.findAll();
            request.setAttribute("positionList", positionModelList);
            request.setAttribute("educationDegreeList", educationDegreeModelList);
            request.setAttribute("divisionList", divisionModelList);
            // \\để get lại dữ liệu cho selection

            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
