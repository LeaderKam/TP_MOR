package fr.istic.sir.rest;


import com.sun.jersey.api.view.Viewable;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import servlet.dao.UserDao;
import servlet.dao.rest.*;
import test.testjpa.domain.Employee;
import test.testjpa.domain.rest.EmployeeRest;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/hello")
@Produces(MediaType.TEXT_HTML)
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }

   private List<Book> books = new ArrayList<Book>();

    public SampleWebService() {
        for (int i = 0; i < 10; i++) {
            books.add(new Book(i, "Title " + i, "Author " + i, new Double(Math.random()*20).intValue()));
        }

    }
    public void test(){
        books.add(new Book(1, "kam test " + 1, "Author " + 1, new Double(Math.random()*20).intValue()));
    }

    @GET
    @Path("test")
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Book> list() {
        test();
        return books;
    }
    @GET
    @Path("employee")
    @Produces({ MediaType.APPLICATION_JSON })
    @CrossOrigin(origins = "http://localhost:4200")
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
    @POST
    @Path("home/ajout/")
    @Produces({ MediaType.APPLICATION_JSON })
    public void ajout(EmployeeRest user) {
        EmployeeRestDao userRestDao= new EmployeeRestDao();
        System.out.println("/INDEX fj called");
        userRestDao.saveUser(user);

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
