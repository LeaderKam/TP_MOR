<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="servlet.dao.SondageDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="test.testjpa.domain.*" %>
<%@ page import="servlet.dao.ReunionDao" %>
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
        height:400px;
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
    ReunionDao reunionDao= new ReunionDao();
%>
<div id="largeur" class="container">
    <form method="post" action="/updateReunion">
        <div class="form-group row">
            <label for="name" class="col-sm-4 col-form-label">Nom reunion</label>
            <div class="col-sm-8">
                <input type="hidden" id="idReunion" name="idReunion" value="<%=id%>" class="form-control"
                       placeholder="nom reunion" value="">
                <input type="text" id="name" name="nomReunion" required class="form-control"
                       placeholder="nom reunion" value="">
            </div>
        </div>

        <div class="form-group row">
            <label for="name1" class="col-sm-4 col-form-label">Résumé reunion</label>
            <div class="col-sm-8">
                <input type="text" id="name1" name="resumeReunion" required class="form-control"
                       placeholder="résumé de la reunion" value="">
            </div>
        </div>
        <div class="form-groupe row">
            <label for="pauseCafe" class="col-sm-4 col-form-label">Paufe cafe</label>
            <div class="form-check col-sm-4">
                <input class="form-check-input" type="radio" name="pauseCafe" required placeholder="Pause cafe" value="oui" id="pauseCafe1">
                <label class="form-check-label" for="pauseCafe1">
                    Oui
                </label>
            </div>
            <div class="form-check col-sm-4">
                <input class="form-check-input" type="radio" name="pauseCafe" required placeholder="Pause cafe" value="non" id="pauseCafe">
                <label class="form-check-label" for="pauseCafe">
                    non
                </label>
            </div>
        </div>
        <div class="form-group row">
            <label for="dateReunion" class="col-sm-4 col-form-label">Date de la réunion</label>
            <div class="col-sm-8">
                <select name="dateReunion" class="form-control inputstl" id="dateReunion">
                    <option>-------choisir------</option>
                    <% ArrayList<User_sondage> user_sondages = (ArrayList<User_sondage>) request.getAttribute("listUserSondage");
                        if(user_sondages.size()!=0){  for (int i = 0; i < user_sondages.size(); i++) {
                            if(user_sondages.get(i) instanceof User_sondageDate){%>
                    <option value="<%=((User_sondageDate) user_sondages.get(i)).getDateChoisi()%>"><%=((User_sondageDate) user_sondages.get(i)).getDateChoisi()%></option>
                    <% }else if (user_sondages.get(i) instanceof User_sondageLieuDate){%>
                    <option value="<%=((User_sondageLieuDate) user_sondages.get(i)).getDateChoisi()%>"><%=((User_sondageLieuDate) user_sondages.get(i)).getDateChoisi()%></option>

                    <%}}}%>

                </select>
            </div>
        </div>
        <div class="form-group row">
            <center>
                <div class="col-sm-8">
                    <input type="submit" class="btn btn-primary" VALUE="MODIFIER REUNION">
                </div>
            </center>
        </div>
    </form>
</div>
</div>
</body>
</html>