<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="servlet.dao.SondageDao" %>
<%@ page import="test.testjpa.domain.Sondage" %>
<%@ page import="test.testjpa.domain.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="servlet.dao.DepartmentDao" %>
<%@ page import="test.testjpa.domain.Department" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
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
        #largeur{
        border:red;
       border-radius: 10px;
        width:700px;
        margin-top:-100px;
        height:300px;
        padding:100px 80px;
        background:#EFEFEF;
        position:relative;
        }
        #head{
        margin-top:0px;
        height:400px;
        background:blue;
        position:relative;
        }
        #tout{
        position:absolute;
        width:100%;height:100vh;
        }

    </style>
</head>
<body>


<div id="tout">
<div id="head">
<center>
		<h1 class="card">User Management</h1>
        <h2>
        	<a class="btn btn-success" href="new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a class="btn btn-primary" href="sondage?page=1">List All Users</a>

        </h2>
	</center>
</div>
<% String id=request.getParameter("id");
    DepartmentDao departmentDao= new DepartmentDao();
    Department departement = departmentDao.getDepartment(Long.valueOf(id));
%>
<div id="largeur" class="container">
    <form method="post" action="/updateUser">
        <input type="hidden" name="idEmployee" required class="form-control" value="<%=id%>">
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-8">
                <input type="text" id="name" name="nomEmployee" required class="form-control" >
            </div>
        </div>
        <div class="form-group row">
            <label for="idDepartement" class="col-sm-2 col-form-label">Department</label>
            <div class="col-sm-8">
                <select name="idDepartement" id="idDepartement" class="form-control inputstl" id="idDepartement">
                    <option value="<%=id%>"><%=departement.getName()%></option>
                    <% ArrayList<Department> departments = (ArrayList<Department>) request.getAttribute("departments");
                        for (int i = 0; i < departments.size(); i++) {%>
                    <option value="<%=departments.get(i).getId()%>"><%=departments.get(i).getName()%></option>

                    <%}%>

                </select>            </div>
        </div>
        <div class="form-group row">
            <center>
                <div class="col-sm-8">
                    <input type="submit" class="btn btn-primary" VALUE="Save">
                </div>
            </center>
        </div>
    </form>
</div>
</div>
</body>
</html>