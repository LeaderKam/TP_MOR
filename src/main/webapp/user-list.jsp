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
</head>
<body>
	<center>
		<h1 class="card">User Management</h1>
        <h2>
        	<a href="new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list-user?page=1">List All Users</a>

        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>

                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.user_id}" /></td>
                    <td><c:out value="${user.name}" /></td>

                    <td>
                    	<a href="edit?id=<c:out value='${user.user_id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>
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
              <%ArrayList<Employee> std =(ArrayList<Employee>)request.getAttribute("listUser");
              String spageid=request.getParameter("page");
              int pageid=Integer.parseInt(spageid);
              int total=(int)(std.size()/1000);
              int end=0;
              if(pageid==1){end=total;}
              else{
                  pageid=pageid-1;
                  pageid=pageid*total;
                  end=pageid+total;
              }
              for(int i=pageid;i<end;i++){%>
              <%-- Arranging data in tabular form--%>
                    <tr>
                    <th scope="row"><%=std.get(i-1).getId()%></th>
                        <td><%=std.get(i-1).getName()%></td>
                        <td>
                            <a class="btn btn-primary" href="edit?id=<c:out value='${user.user_id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="btn btn-danger " href="delete?id=<c:out value='${user.id}' />">Delete</a>
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
    </div>
</body>
</html>