package fr.istic.sir.rest;


import com.sun.jersey.api.view.Viewable;
import servlet.dao.UserDao;
import test.testjpa.domain.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/helloo")
@Produces(MediaType.TEXT_HTML)
public class SampleWebService1 {
    UserDao userDao = new UserDao();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }

    // @GET
    //  @Path("/home/{name}")
    // @Produces(MediaType.TEXT_HTML)
    // public String getHome(@PathParam("name") String name) {
    //  return "Hello, how are you?"+name;
    //}

    @GET
    @Path("indexe")
    public Viewable index(@Context HttpServletRequest request) {
        List<Employee> listUser = userDao.getAllUser();
        request.setAttribute("list",listUser);
        request.setAttribute("obj", new String("IT Works"));
        System.out.println("/INDEX fj called");
        return new Viewable("/header.jsp", null);
    }
    @GET
    @Path("indexee/test")
    public Viewable indexe(@Context HttpServletRequest request) {
        List<Employee> listUser = userDao.getAllUser();
        request.setAttribute("list",listUser);
        request.setAttribute("obj", new String("IT Works"));
        System.out.println("/INDEX fj called");
        return new Viewable("/test.jsp", null);
    }

}
