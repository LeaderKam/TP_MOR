<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="servlet.dao.SondageDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="test.testjpa.domain.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Doodle Application</title>
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

</div>
<% String id=request.getParameter("id");
    SondageDao sondageDao=new SondageDao();
    Sondage sondage=sondageDao.getSondage(Long.parseLong(id));
    String nomSondage = sondage.getIntitule_son();
    Date dateReunion=sondageDao.getSondage(Long.parseLong(id)).getDate_sondage();
    String nomEmployee=sondageDao.getSondage(Long.parseLong(id)).getEmployee().getName();

    Long idEmployee=sondageDao.getSondage(Long.parseLong(id)).getEmployee().getId();

%>
<div id="largeur" class="container">
    <form method="post" action="/updateSondage">
        <input type="hidden" name="idSondage" required class="form-control" value="<%=id%>">
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-8">
                <input type="text" id="name" name="nomSondage" required class="form-control" value="<%=nomSondage%>">
            </div>
        </div>
        <div class="form-group row">
            <label for="dateReunion" class="col-sm-2 col-form-label">Date reunion</label>
            <div class="col-sm-8">
                <select name="dateReunion" class="form-control inputstl" id="dateReunion">
                        <% ArrayList<User_sondage> user_sondages = (ArrayList<User_sondage>) request.getAttribute("listUserSondage");
                            if(user_sondages.size()!=0){  for (int i = 0; i < user_sondages.size(); i++) {
                            if(user_sondages.get(i) instanceof User_sondageDate){%>
                    <option value="<%=((User_sondageDate) user_sondages.get(i)).getDateChoisi()%>"><%=((User_sondageDate) user_sondages.get(i)).getDateChoisi()%></option>
                        <% }else if (user_sondages.get(i) instanceof User_sondageLieuDate){%>
                    <option value="<%=((User_sondageLieuDate) user_sondages.get(i)).getDateChoisi()%>"><%=((User_sondageLieuDate) user_sondages.get(i)).getDateChoisi()%></option>

                        <%}}}%>
            </div>
        </div>
        <div class="form-group row">
            <label for="idEmployee" class="col-sm-2 col-form-label">Employee</label>
            <div class="col-sm-8">
                <select name="idEmployee" id="idEmployee" class="form-control inputstl" id="nomEmploye">
                    <option value="<%=idEmployee%>"><%=nomEmployee%></option>
                    <% ArrayList<Employee> emp = (ArrayList<Employee>) request.getAttribute("user");
                        for (int i = 0; i < emp.size(); i++) {%>
                    <option value="<%=emp.get(i).getId()%>"><%=emp.get(i).getName()%></option>

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