package servlet.web;
import fr.istic.sir.rest.SampleWebService;
import servlet.dao.DepartmentDao;
import servlet.dao.ReunionDao;
import servlet.dao.SondageDao;
import servlet.dao.UserDao;
import test.testjpa.domain.Department;
import test.testjpa.domain.Employee;
import test.testjpa.domain.Sondage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;
    private String name;
    private SondageDao sondageDao;
    private DepartmentDao departmentDao;
    private ReunionDao reunionDao;

    public void init() {
        userDao = new UserDao();
        sondageDao=new SondageDao();
        departmentDao= new DepartmentDao();
        reunionDao= new ReunionDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            if ("/new".equals(action)) {
                showNewForm(request, response);
            } else if ("/insert".equals(action)) {
                insertUser(request, response);
            } else if ("/delete".equals(action)) {
                deleteUser(request, response);
            } else if ("/edit".equals(action)) {
                showEditForm(request, response);
            } else if ("/update".equals(action)) {
                updateUser(request, response);
            }else if ("/list-user".equals(action)){
                listUser(request, response);
            }else if("/success".equals(action)){
                success(request, response);
            }else if("/sondage".equals(action)) {
                sondage(request, response);
            }else if("/reunion".equals(action)){
                reunion(request, response);
            }else if("/my".equals(action)){
                my(request, response);
            }
            else {
                home(request,response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void my(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("myform.html");
        dispatcher.forward(request, response);
    }

    private void reunion(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("reunion.jsp");
        dispatcher.forward(request, response);
    }

    private void sondage(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException, ServletException {
        List<Sondage> listSondage = sondageDao.getAllSondage();
        request.setAttribute("listSondage", listSondage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sondage.jsp");
        dispatcher.forward(request, response);
           // RequestDispatcher dispatcher = request.getRequestDispatcher("sondage.jsp");
          //  dispatcher.forward(request, response);
    }

    private void success(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
    }

    private void home(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> listUser = userDao.getAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void listSondage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

    }

  private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

      int id=0;  //int id = Integer.parseInt(request.getParameter("id"));
        Employee existingUser = userDao.getUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Department department=new Department("REACT");
        Employee newUser = new Employee(name, department);
        userDao.saveUser(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String departmenta = request.getParameter("department");

        Department department=new Department(departmenta);
        Employee user = new Employee(name, department);
        userDao.updateUser(user);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Department departement=new Department("fhkj");
        Employee user=new Employee("gkj",departement);
        userDao.deleteUser(user);
        response.sendRedirect("list");
    }

}