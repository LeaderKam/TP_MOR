package servlet.web;

import org.hsqldb.rights.User;
import servlet.dao.*;
import test.testjpa.domain.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;
    private LieuDao lieuDao;
    private DateDao dateDao;
    private String name;
    private SondageDao sondageDao;
    private UserSondageDao userSondageDao;
    private DepartmentDao departmentDao;
    private ReunionDao reunionDao;
    private UserReunionDao userReunionDao;
    private SondageController sondageController;

    public void init() throws ServletException{
        userDao = new UserDao();
        lieuDao = new LieuDao();
        dateDao = new DateDao();
        sondageDao = new SondageDao();
        userSondageDao= new UserSondageDao();
        departmentDao = new DepartmentDao();
        reunionDao = new ReunionDao();
        userReunionDao=new UserReunionDao();
        sondageController=new SondageController();

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
            }
            else if ("/edit".equals(action)) {
                showEditUserForm(request, response);
            }
            else if ("/update".equals(action)) {
                updateUser(request, response);
            } else if ("/list-user".equals(action)) {
                listUser(request, response);
            } else if ("/success".equals(action)) {
                success(request, response);
            }



            else if("/sondage".equals(action)) {
                sondage(request, response);
            }
            else if ("/creerSondage".equals(action)) {
                insertSondage(request, response);
            }else if ("/editSondage".equals(action)) {
                showEditSondageForm(request, response);
            }else if ("/updateSondage".equals(action)) {
                updateSondage(request, response);
            }
            else if("/deleteSondage".equals(action)) {
              deleteSondage(request, response);
            } else if("/participerSondage".equals(action)) {
              participerSondage(request, response);
            }

            else if ("/reunion".equals(action)) {
                reunion(request, response);
            }else if ("/creerReunion".equals(action)) {
                insertReunion(request, response);
            }else if ("/editReunion".equals(action)) {
                showEditReunionForm(request, response);
            }else if ("/updateReunion".equals(action)) {
                updateReunion(request, response);
            }
            else if("/deleteReunion".equals(action)) {
                deleteReunion(request, response);
            }


            else {
                home(request, response);
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
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


    //User Controller

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> listUser = userDao.getAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }


 private void showEditUserForm(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {

    long id = Integer.parseInt(request.getParameter("id"));
    List<Employee> existingUser = userDao.getAllUser();
    request.setAttribute("user", existingUser);
    RequestDispatcher dispatcher = request.getRequestDispatcher("sondage-form.jsp");

    dispatcher.forward(request, response);

}

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Department department = new Department("REACT");
        Employee newUser = new Employee(name, department);
        userDao.saveUser(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String departmenta = request.getParameter("department");

        Department department = new Department(departmenta);
        Employee user = new Employee(name, department);
        userDao.updateUser(user);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        long id = Integer.parseInt(request.getParameter("id"));
        Department departement = new Department("fhkj");
        Employee user = new Employee("gkj", departement);
        userDao.deleteUser(id);
        response.sendRedirect("list");
    }

    //Sondage Controller
    private void sondage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Sondage> listSondage = sondageDao.getAllSondage();

        for (Sondage next : listSondage) {
            if (next instanceof Sondage_lieu){
                ((Sondage_lieu) next).getLieuSondage().getLieu1();
                if(next.getSondage_id()==2)
                    System.out.println("kammme: " + ((Sondage_lieu) next).getLieuSondage().getLieu1());
            }

        }
        List<Employee> listUser = userDao.getAllUser();
        System.out.println(listSondage.size());
        request.setAttribute("listSondage", listSondage);
        //request.setAttribute("listSondageLieu", listSondageLieu);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sondage.jsp");
        dispatcher.forward(request, response);

    }

    private void insertSondage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        String nomSondage = request.getParameter("nomSondage");
        String dateSondage = request.getParameter("dateSondage");
        String type = request.getParameter("type");
        String lieu1 = request.getParameter("lieu1");
        String lieu2 = request.getParameter("lieu2");
        String lieu3 = request.getParameter("lieu3");
        String date11 = request.getParameter("date1");
        String date22 = request.getParameter("date2");
        String date33 = request.getParameter("date2");


        // String testDate = "29-Apr-2010,13:00:14 PM";
        System.out.println("********************\n" + dateSondage);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateSondage);
        Date date1 = formatter.parse(date11);
        Date date2 = formatter.parse(date22);
        Date date3 = formatter.parse(date33);

        LieuSondage lieuSondage=new LieuSondage(lieu1,lieu2,lieu3);
        DateSondage dateSondageVoulu=new DateSondage(date1,date2,date3);

        Long idEmployee = Long.parseLong(request.getParameter("idEmployee"));
        Employee user = userDao.getUser(idEmployee);

        if (type.equals("lieu")){
            Sondage_lieu sondage_lieu=new Sondage_lieu(nomSondage,date,user,lieuSondage);
            lieuDao.saveLieuSondage(lieuSondage);
            sondageDao.saveSondage(sondage_lieu);
            response.sendRedirect("/sondage");
        }else if (type.equals("date")){
            Sondage_date sondage_date=new Sondage_date(nomSondage,date,user,dateSondageVoulu);
            dateDao.saveDateSondage(dateSondageVoulu);
            sondageDao.saveSondage(sondage_date);
            response.sendRedirect("/sondage");
        }else if (type.equals("lieuDate")){

            Sondage_lieu_date sondage_lieu_date=new Sondage_lieu_date(nomSondage,date,user,lieuSondage,dateSondageVoulu);
            lieuDao.saveLieuSondage(lieuSondage);
            dateDao.saveDateSondage(dateSondageVoulu);
            sondageDao.saveSondage(sondage_lieu_date);
            response.sendRedirect("/sondage");
        }else {
            response.sendRedirect("/sondage");
        }

    }


    private void showEditSondageForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        long id = Integer.parseInt(request.getParameter("id"));
        List<Employee> existingUser = userDao.getAllUser();
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sondage-form.jsp");

        dispatcher.forward(request, response);

    }


    private void updateSondage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
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

    private void deleteSondage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        // Department departement = new Department("fhkj");
        //Employee user = new Employee("gkj", departement);
        sondageDao.deleteSondage(id);
        response.sendRedirect("sondage");
    }

    private void participerSondage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        String idSondage = request.getParameter("idSondage");
        String idEmployee = request.getParameter("idEmployee");
        String nomSondage = request.getParameter("nomSondage");
        String dateChoisi = request.getParameter("dateChoisi");
        String lieuChoisi = request.getParameter("lieuChoisi");

        // String testDate = "29-Apr-2010,13:00:14 PM";
        System.out.println("********************\n" + dateChoisi);
        System.out.println("********************\n" + lieuChoisi);
        System.out.println("********************\n" + nomSondage);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateChoisi);
        //System.out.println(date);
        System.out.println("********************\n" + date);
        Long idEmployeee = Long.parseLong(request.getParameter("idEmployee"));
        Long idSondagee = Long.parseLong(request.getParameter("idSondage"));
        Employee user = userDao.getUser(idEmployeee);
        Sondage newSondage = sondageDao.getSondage(idSondagee);
        if(newSondage instanceof Sondage_lieu){
            User_sondageLieu user_sondage=new User_sondageLieu(user,newSondage,lieuChoisi);
            userSondageDao.saveUserSondage(user_sondage);
            response.sendRedirect("/sondage");
        }else if(newSondage instanceof Sondage_date){
            User_sondageDate user_sondage=new User_sondageDate(user,newSondage,date);
            userSondageDao.saveUserSondage(user_sondage);
            response.sendRedirect("/sondage");
        } else{
            User_sondageLieuDate user_sondage=new User_sondageLieuDate(user,newSondage,lieuChoisi,date);
            userSondageDao.saveUserSondage(user_sondage);
            response.sendRedirect("/sondage");
        }

    }

    //Reunion controller
    private void reunion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Reunion> listReunion = reunionDao.getAllReunion();
        List<User_reunion> listUserReunion = userReunionDao.getAllUserReunion();
        List<Employee> listUser = userDao.getAllUser();
        System.out.println(listReunion.size());
        request.setAttribute("listReunion", listReunion);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reunion.jsp");
        dispatcher.forward(request, response);

    }

    private void insertReunion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
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


    private void showEditReunionForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        long id = Integer.parseInt(request.getParameter("id"));
        List<Employee> existingUser = userDao.getAllUser();
        request.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reunion-form.jsp");

        dispatcher.forward(request, response);

    }


    private void updateReunion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
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

    private void deleteReunion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        reunionDao.deleteReunion(id);
        response.sendRedirect("reunion");
    }

}