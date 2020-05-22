package fr.istic.sir.rest;


import com.sun.jersey.api.view.Viewable;
import test.testjpa.domain.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
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

    // @GET
    //  @Path("/home/{name}")
    // @Produces(MediaType.TEXT_HTML)
    // public String getHome(@PathParam("name") String name) {
    //  return "Hello, how are you?"+name;
    //}

    @GET
    @Path("index")
    public Viewable index(@Context HttpServletRequest request) {
        request.setAttribute("obj", new String("IT Works"));
        System.out.println("/INDEX called");
        return new Viewable("/header.jsp", null);
    }
    private List<Book> books = new ArrayList<Book>();

    public SampleWebService() {
        for (int i = 0; i < 10; i++) {
            books.add(new Book(i, "Title " + i, "Author " + i, new Double(Math.random()*20).intValue()));
        }
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Book> list() {
        return books;
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

}
