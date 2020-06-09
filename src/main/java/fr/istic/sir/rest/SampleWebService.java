package fr.istic.sir.rest;


import com.sun.jersey.api.view.Viewable;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import servlet.dao.ReunionDao;
import servlet.dao.SondageDao;
import servlet.dao.UserDao;
import servlet.dao.rest.*;
import test.testjpa.domain.Employee;
import test.testjpa.domain.Reunion;
import test.testjpa.domain.Sondage;
import test.testjpa.domain.rest.EmployeeRest;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Path("/hello")
@Produces(MediaType.TEXT_HTML)
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }

    @GET
    @Path("employee")
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Employee> listEmployee() {
        //EmployeeRestDao userRestDao= new EmployeeRestDao();
        //List<EmployeeRest> employees=userRestDao.getAllUser();
        UserDao userDao = new UserDao();
        List<Employee> employees= userDao.getAllUser();
        return employees;
    }
    @GET
    @Path("home")
    public Viewable index(@Context HttpServletRequest request) {
        EmployeeRestDao userRestDao= new EmployeeRestDao();
        List<EmployeeRest> listUser = userRestDao.getAllUser();
        request.setAttribute("list",listUser);
       // request.setAttribute("obj", new String("IT Works"));
        System.out.println("/INDEX fj called");
        return new Viewable("/myform", null);
    }

    @GET
    @Path("reunion")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response listReunion() {
        ReunionDao reunionDao = new ReunionDao();
        List<Reunion> reunions = reunionDao.getAllReunion();
       // return reunions;
        return Response
                .ok(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(reunions)
                .build();
    }

    @POST
    @Path("reunion/add/")
    @Consumes({ MediaType.APPLICATION_JSON })
   // @Produces({ MediaType.APPLICATION_JSON })
    public Response ajout(Reunion reunion) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       // Date date = formatter.parse(reunion.getDate_reunion());
        ReunionDao reunionDao = new ReunionDao();
       //@FormParam('name') a;
        System.out.println("ajout de reuunion" + reunion.getDate_reunion());
       // Reunion reunion1= new Reunion(reunion.getIntitule_reunion(),reunion.getResume_reunion(),reunion.getDate_reunion(),reunion.isPause_cafe());
        reunionDao.saveReunion(reunion);
      System.out.println(reunion.getIntitule_reunion());// reunion.setDate_reunion(new Date());
        return Response
                .ok(201)
                .header("Access-Control-Allow-Origin", "*")
                .entity(reunion)
                .build();
    }


/*
    @GET
    @Produces("application/json")
    @Path("/users")
    public EmployeeRest getAllUsers() {

        return userDao.getAllUser().get(2);
    }
    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArticleDetails() {
        EmployeeRestDao userDao= new EmployeeRestDao();
        List<EmployeeRest> list = userDao.getAllUser();
        return Response.ok(list).build();
    }


    @GET @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Book findById(@PathParam("id") String arg0) {
        return books.get(Integer.parseInt(arg0));
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Book deleteById(@PathParam("id") String arg0) {
        return books.remove(Integer.parseInt(arg0));
    }
*/
}
