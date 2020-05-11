package servlet.web;

import servlet.dao.ReunionDao;
import servlet.dao.SondageDao;
import servlet.dao.UserDao;
import test.testjpa.domain.Employee;
import test.testjpa.domain.Reunion;
import test.testjpa.domain.Sondage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SondageController implements IController {


    private UserDao userDao ;
    private SondageDao sondageDao;
    private ReunionDao reunionDao;

    public SondageController() {
        this.userDao = new UserDao();
        this.sondageDao = new SondageDao();
        this.reunionDao = new ReunionDao();
    }

    @Override
    public void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nomSondage = request.getParameter("nomSondage");
        String dateSondage = request.getParameter("dateSondage");

        // String testDate = "29-Apr-2010,13:00:14 PM";
        //DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
        //Date date = formatter.parse(testDate);
        //System.out.println(date);
        System.out.println("********************\n" + dateSondage);
        Long idEmployee = Long.parseLong(request.getParameter("idEmployee"));
        Employee user = userDao.getUser(idEmployee);

        Sondage newSondage = new Sondage(nomSondage, new Date(), user);

        sondageDao.saveSondage(newSondage);
        response.sendRedirect("/sondage");
    }

    @Override
    public void updatee(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {
        System.out.println(request.getParameter("idSondage"));
        Long id = Long.parseLong(request.getParameter("idSondage"));
        String name = request.getParameter("nomSondage");
        String idEmployee = request.getParameter("idEmployee");

        Employee user = userDao.getUser(Long.parseLong(idEmployee));
        Sondage sondage=sondageDao.getSondage(id);
        sondage.setEmployee(user);
        sondage.setIntitule_son(name);
        sondageDao.updateSondage(sondage);
        response.sendRedirect("sondage");
    }

    @Override
    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        long id = Integer.parseInt(request.getParameter("id"));
        List<Employee> existingUser = userDao.getAllUser();
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sondage-form.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    public void deletee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        // Department departement = new Department("fhkj");
        //Employee user = new Employee("gkj", departement);
        sondageDao.deleteSondage(id);
        response.sendRedirect("sondage");
    }

    @Override
    public void home(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Reunion> listReunion = reunionDao.getAllReunion();
        List<Employee> listUser = userDao.getAllUser();
        System.out.println(listReunion.size());
        request.setAttribute("listReunion", listReunion);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reunion.jsp");
        dispatcher.forward(request, response);

    }
}
