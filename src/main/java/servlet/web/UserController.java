package servlet.web;

import servlet.dao.SondageDao;
import servlet.dao.UserDao;
import test.testjpa.domain.Department;
import test.testjpa.domain.Employee;
import test.testjpa.domain.Sondage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController implements IController {


    private UserDao userDao;
    private SondageDao sondageDao;

    public UserController() {
        this.userDao = new UserDao();
        this.sondageDao = new SondageDao();
    }

    @Override
    public void insert(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Department department = new Department("REACT");
        Employee newUser = new Employee(name, department);
        userDao.saveUser(newUser);
        response.sendRedirect("list");
    }

    @Override
    public void updatee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String departmenta = request.getParameter("department");

        Department department = new Department(departmenta);
        Employee user = new Employee(name, department);
        userDao.updateUser(user);
        response.sendRedirect("list");
    }

    @Override
    public void showEditForm(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
        long id = Integer.parseInt(request.getParameter("id"));
        List<Employee> existingUser = userDao.getAllUser();
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sondage-form.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void deletee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        long id = Integer.parseInt(request.getParameter("id"));

        userDao.deleteUser(id);
        response.sendRedirect("list");
    }

    @Override
    public void home(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
            List<Sondage> listSondage = sondageDao.getAllSondage();
            List<Employee> listUser = userDao.getAllUser();
            System.out.println(listSondage.size());
            request.setAttribute("listSondage", listSondage);
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("sondage.jsp");
            dispatcher.forward(request, response);
    }
}
