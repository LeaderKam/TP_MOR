<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@page import="test.testjpa.domain.*"%>
  <%@page import="java.util.ArrayList"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>User Management Application</title>
	 <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
                crossorigin="anonymous"></script>
<style>
.top{
    margin: 10vh 0vh 0vh 0vh;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
	<center class="top">
		<h1 >User Management</h1>
        <h2>
        	<a class="btn btn-outline-success" href="new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a class="btn btn-primary" href="list-user">List All Users</a>

        </h2>
	</center>

<div style="width:500px;margin-left:700px;">
         <table class="table table-striped" width="500px;" align="center">
              <thead class="table-dark">
                 <tr>
                   <th scope="col"><b>ID</b></th>
                   <th scope="col"><b>Employee Name</b></th>
                   <th scope="col"><b>Actions</b></th>
                 </tr>
              </thead>
              <tbody>

              <%-- Fetching the attributes of the request object which was previously set by the servlet "StudentServlet.java" --%>
              <%ArrayList<Employee> emp =(ArrayList<Employee>)request.getAttribute("listUser");


              for(int i=0;i<emp.size();i++){%>
              <%-- Arranging data in tabular form--%>
                    <tr>
                    <th scope="row"><%=emp.get(i).getId()%></th>
                        <td><%=emp.get(i).getName()%></td>
                        <td>
                            <a class="btn btn-primary" href="edit?id=<%=emp.get(i).getId()%>">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="btn btn-danger " href="delete?id=<%=emp.get(i).getId()%>">Delete</a>
                        </td>
                    </tr>
              <%}%>

          </table>

          <a href="list-user?page=1">1</a>
          <a href="list-user?page=2">2</a>
          <a href="list-user?page=3">3</a>
          <a href="list-user?page=4">4</a>
          <a href="list-user?page=5">5</a>
          <a href="list-user?page=6">6</a>
          <a href="list-user?page=7">7</a>
          <a href="list-user?page=8">8</a>
          <a href="list-user?page=9">9</a>
          <a href="list-user?page=10">10</a>
          <nav aria-label="...">
            <ul class="pagination">
              <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Previous</a>
              </li>
              <li class="page-item"><a class="page-link" href="list-user?page=1">1</a></li>
              <li class="page-item active">
                <a class="page-link" href="list-user?page=2">2 <span class="sr-only">(current)</span></a>
              </li>
              <li class="page-item"><a class="page-link" href="list-user?page=3">3</a></li>
              <li class="page-item">
                <a class="page-link" href="#">Next</a>
              </li>
            </ul>
          </nav>
    </div>
     <!-- Bootstrap core JS-->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
            <!-- Third party plugin JS-->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
            <!-- Core theme JS-->
            <script src="js/scripts.js"></script>
</body>
</html>