<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="servlet.dao.SondageDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="test.testjpa.domain.*" %>
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
        height:80%;
        padding:100px 80px;
        background:#EFEFEF;
        position:relative;
        }
        #head{
        margin-top:0px;
        height:20%;
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
<% String id = request.getParameter("id");
    SondageDao sondageDao = new SondageDao();
    //String nomSondage=sondageDao.getSondage(Long.parseLong(id)).getIntitule_son();
    Date dateDuSondage=sondageDao.getSondage(Long.parseLong(id)).getDate_sondage();
    String nomEmployee=sondageDao.getSondage(Long.parseLong(id)).getEmployee().getName();
    Sondage sondage = sondageDao.getSondage(Long.parseLong(id));
    String nomSondage= sondage.getIntitule_son();

    Long idEmployee=sondageDao.getSondage(Long.parseLong(id)).getEmployee().getId();

%>
<div id="largeur" class="container">
     <div class="card-body">
        <div class="container">
            <form method="post" action="/updateSondage">
                <div class="form-group row">
                <input type="hidden" value="<%=id%>" name="idSondage">
                    <label for="name" class="col-sm-4 col-form-label">Nom sondage</label>
                    <div class="col-sm-8">
                        <input type="text" id="name" name="nomSondage" required class="form-control"
                               placeholder="nom sondage" >
                    </div>
                </div>

                <div class="form-group row">
                    <label for="dateSondage" class="col-sm-4 col-form-label">Date création de sondage</label>
                    <div class="col-sm-8">
                        <input type="date" id="dateSondage" name="dateSondage"  class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nomEmploye" class="col-sm-4 col-form-label">Nom employe</label>
                    <div class="col-sm-8">
                        <select name="idEmployee" class="form-control " id="nomEmploye">
                            <option>----------choisir</option>
                            <% ArrayList<Employee> emp = (ArrayList<Employee>) request.getAttribute("employees");
                            if(emp.size() != 0){
                                for (int i = 0; i < emp.size(); i++) {%>
                                    <option value="<%=emp.get(i).getId()%>"><%=emp.get(i).getName()%></option>

                            <%}}%>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                   <%if(sondage instanceof Sondage_date){
                    Long idDateSondage = ((Sondage_date) sondage).getDateSondage().getDateSondageId();%>
                    <input value="<%=idDateSondage%>" type="hidden" name="idDateSondage">
                   <% }
                    else if(sondage instanceof Sondage_lieu_date){
                    Long idDateSondage = ((Sondage_lieu_date) sondage).getDateSondage().getDateSondageId();%>
                    <input value="<%=idDateSondage%>" type="hidden" name="idDateSondage">
                    <%}%>

                    <label class="col-sm-3 col-form-label">Date voulu</label>
                    <div class="col-sm-3">
                        <input type="date" name="date1"  class="form-control">
                    </div>
                    <div class="col-sm-3">
                        <input type="date" name="date2"  class="form-control">
                    </div>
                    <div class="col-sm-3">
                        <input type="date" name="date3"  class="form-control">
                    </div>
                </div>
                <div class="form-group row">
                    <% if(sondage instanceof Sondage_lieu){
                        Long idLieuSondage = ((Sondage_lieu) sondage).getLieuSondage().getLieuSondageId();%>
                         <input value="<%=idLieuSondage%>" type="hidden" name="idLieuSondage">
                   <% }
                    else if(sondage instanceof Sondage_lieu_date){
                        Long idLieuSondage = ((Sondage_lieu_date) sondage).getLieuSondage().getLieuSondageId();%>
                        <input value="<%=idLieuSondage%>" type="hidden" name="idLieuSondage">
                    <%}%>

                    <label class="col-sm-3 col-form-label">Lieu voulu</label>
                    <div class="col-sm-3">
                        <input type="text" name="lieu1"  class="form-control" placeholder="lieu1">
                    </div>
                    <div class="col-sm-3">
                        <input type="text" name="lieu2"  class="form-control" placeholder="lieu2">
                    </div>
                    <div class="col-sm-3">
                        <input type="text" name="lieu3"  class="form-control" placeholder="lieu3">
                    </div>
                </div>
                <div class="form-group row">
                    <center>
                        <div class="col-sm-8">
                            <input type="submit" class="btn btn-primary" VALUE="MODIFIER SONDAGE">
                        </div>
                    </center>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>