package servlet.web;

import servlet.dao.DepartmentDao;
import servlet.dao.ReunionDao;
import servlet.dao.SondageDao;
import servlet.dao.UserDao;
import test.testjpa.domain.Employee;
import test.testjpa.domain.Reunion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ReunionController implements IController {

    private final UserDao userDao;
    private SondageDao sondageDao;
    private DepartmentDao departmentDao;
    private ReunionDao reunionDao;

    public ReunionController() {
        this.userDao =  new UserDao();
        this.sondageDao = new SondageDao();
        this.departmentDao = new DepartmentDao();
        this.reunionDao = new ReunionDao();
    }

    @Override
    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nomReunion = request.getParameter("nomReunion");
        String dateReunion = request.getParameter("dateReunion");
        String resumeReunion = request.getParameter("resumeReunion");

        // String testDate = "29-Apr-2010,13:00:14 PM";
        //DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
        //Date date = formatter.parse(testDate);
        //System.out.println(date);
        System.out.println("********************\n" + dateReunion);
        Long idEmployee = Long.parseLong(request.getParameter("idEmployee"));
        Employee user = userDao.getUser(idEmployee);

        Reunion newReunion = new Reunion(nomReunion,resumeReunion, new Date());

        reunionDao.saveReunion(newReunion);
        response.sendRedirect("reunion");
    }

    @Override
    public void updatee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("idReunion"));
        String name = request.getParameter("nomReunion");
        String resume = request.getParameter("resume");
        String idEmployee = request.getParameter("idEmployee");

        Employee user = userDao.getUser(Long.parseLong(idEmployee));
        Reunion reunion=reunionDao.getReunion(id);
        reunion.setIntitule_reunion(name);
        reunion.setResume_reunion(resume);
        reunion.setDate_reunion(new Date());
        reunionDao.updateReunion(reunion);
        response.sendRedirect("reunion");
    }

    @Override
    public void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {

        long id = Integer.parseInt(request.getParameter("id"));
        List<Employee> existingUser = userDao.getAllUser();
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reunion-form.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    public void deletee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        long id = Long.parseLong(request.getParameter("id"));
        reunionDao.deleteReunion(id);
        response.sendRedirect("reunion");
    }

    @Override
    public void home(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Reunion> listReunion = reunionDao.getAllReunion();
        List<Employee> listUser = userDao.getAllUser();

        request.setAttribute("listReunion", listReunion);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reunion.jsp");
        dispatcher.forward(request, response);
    }

}
