<%@ page import="test.testjpa.domain.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="test.testjpa.domain.Sondage" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="test.testjpa.domain.Employee" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %><%--
  Created by IntelliJ IDEA.
  User: sievi
  Date: 18/05/2020
  Time: 01:28
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Management Application</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>

    <style>

        body {
            background-image: url('/images/bg.jpg');
        }

        #largeur {
            background-image: url('/images/bg.jpg');
            border: red;
            border-radius: 10px;
            width: 700px;
            margin-top: -100px;
            height: 300px;
            padding: 100px 80px;
            background: #EFEFEF;
            position: relative;
        }

        #head {
            margin-top: 0px;
            height: 400px;
            background: linear-gradient(darkblue, white);
            position: relative;
        }

        #tout {
            position: absolute;

            width: 100%;
            height: 100vh;
        }

        .top {
            margin: 10vh 0vh 0vh 0vh;
            padding-top: 10vh;
        }
    </style>
</head>
<body id="test">

<jsp:include page="header.jsp"/>


<div id="head">
    <center class="top">
        <h1 class="text-white">Sondage Management</h1>
        <h2>
            <a class="btn btn-success" href="new">Nouveau Sondage</a>
            &nbsp;&nbsp;&nbsp;
            <a class="btn btn-primary" href="list-sondage?page=1">Liste des sondages</a>

        </h2>
    </center>
</div>


<div class="row">
    <div class="col-sm-8">
        <div id="accordion">
            <div class="card">
                <div class="card-header" id="headingOne">
                    <h5 class="mb-0">
                        <button class="btn btn-primary text-uppercase" data-toggle="collapse" data-target="#collapseOne"
                                aria-expanded="true" aria-controls="collapseOne">
                            Créer sondage
                        </button>
                    </h5>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                    <div class="card-body">
                        <div class="container">
                            <form method="post" action="creerSondage">
                                <div class="form-group row">
                                    <label for="name" class="col-sm-4 col-form-label">Nom sondage</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="name" name="nomSondage" required class="form-control"
                                               placeholder="nom sondage" value="">
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
                                        <select name="idEmployee" class="form-control inputstl" id="nomEmploye">
                                            <% ArrayList<Employee> emp = (ArrayList<Employee>) request.getAttribute("listUser");
                                                for (int i = 0; i < 5; i++) {%>
                                            <option value="<%=emp.get(i).getId()%>"><%=emp.get(i).getName()%></option>

                                            <%}%>

                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <center>
                                        <div class="col-sm-8">
                                            <input type="submit" class="btn btn-primary" VALUE="CREER SONDAGE">
                                        </div>
                                    </center>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="headingTwo">
                    <h5 class="mb-0">
                        <button class="btn btn-primary collapsed text-uppercase" data-toggle="collapse"
                                data-target="#collapseTwo"
                                aria-expanded="false" aria-controls="collapseTwo">
                            Participer à un sondage
                        </button>
                    </h5>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                    <div class="card-body">
                        <div class="container">
                            <form method="post" action="/participerSondage">

                                <div class="form-group row">
                                    <label for="nomSondage" class="col-sm-4 col-form-label">Nom sondage</label>
                                    <div class="col-sm-8">
                                        <select name="nomSondage" class="form-control " id="nomSondage">
                                            <% ArrayList<Sondage> sondages=(ArrayList<Sondage>) request.getAttribute("listSondage");
                                                for (int i = 0; i < sondages.size(); i++) {%>
                                            <option value="<%=sondages.get(i).getSondage_id()%>"><%=sondages.get(i).getIntitule_son()%></option>

                                            <%}%>

                                        </select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="nomEmploye" class="col-sm-4 col-form-label">Nom employe</label>
                                    <div class="col-sm-8">
                                        <select name="idEmployee" class="form-control inputstl" id="nomEmploye">
                                            <%
                                                for (int i = 0; i < emp.size(); i++) {%>
                                            <option value="<%=emp.get(i).getId()%>"><%=emp.get(i).getName()%></option>

                                            <%}%>

                                        </select>
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <label for="dateChoisi" class="col-sm-4 col-form-label">Choix de la date</label>
                                    <div class="col-sm-8">
                                        <input type="date" id="dateChoisi" required name="dateChoisi"
                                               class="form-control"
                                               placeholder="Date Choisi">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <center>
                                        <div class="col-sm-8">
                                            <input type="submit" class="btn btn-outline-primary" VALUE="ENREGISTRER">

                                        </div>
                                    </center>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header" id="headingThree">
                    <h5 class="mb-0">
                        <button class="btn btn-primary collapsed text-uppercase" data-toggle="collapse"
                                data-target="#collapseThree"
                                aria-expanded="false" aria-controls="collapseThree">
                            Voir mes sondages ou d'autres sondages
                        </button>
                    </h5>
                </div>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                    <div class="card-body">
                        <div class="container">
                            <form method="post" action="/sondage/search">
                                <div class="form-inline">
                                    <input class="form-control mr-sm-2" type="search" placeholder="Search"
                                           aria-label="Search">
                                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">RECHERCHER
                                    </button>
                                </div>
                                <table class="table table-striped" width="500px;" align="center">
                                    <thead class="table-dark">
                                    <tr>
                                        <th scope="col"><b>Nom</b></th>
                                        <th scope="col"><b>Date</b></th>
                                        <th scope="col"><b>Actions</b></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%-- Fetching the attributes of the request object which was previously set by the servlet "StudentServlet.java" --%>
                                        <%ArrayList<Sondage> std =(ArrayList<Sondage>)request.getAttribute("listSondage");
              String spageid=request.getParameter("page");
              if(spageid!=null){
                  System.out.println("***********************\n"+spageid+"**********************\n");
                  int pageid=Integer.parseInt(spageid);
                  int total=(int)(std.size()/10);
                  int end=0;
              if(pageid==1){end=total;}
              else{
                  pageid=pageid-1;
                  pageid=pageid*total;
                  end=pageid+total;
              }}
             // for(int i=pageid;i<end;i++){
              for(int i=0;i<2;i++){%>
                                    <%-- Arranging data in tabular form--%>
                                    <tr>
                                        <th scope="row"><%=std.get(i).getIntitule_son()%>
                                        </th>
                                        <td><%=std.get(i).getDate_sondage()%>
                                        </td>
                                        <td>
                                            <a class="btn btn-primary" href="editSondage?id=<%=std.get(i).getSondage_id()%>">Edit</a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a class="btn btn-danger " href="deleteSondage?id=<%=std.get(i).getSondage_id()%>">Delete</a>
                                        </td>
                                    </tr>
                                        <%}%>


                                </table>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <table class="table table-striped" width="500px;" align="center">
            <thead class="table-dark">
            <tr>
                <th scope="col"><b>Nom</b></th>P
                <th scope="col"><b>Date</b></th>
                <th scope="col"><b>Actions</b></th>
            </tr>
            </thead>
            <tbody>


            <%-- Fetching the attributes of the request object which was previously set by the servlet "StudentServlet.java" --%>
                <%ArrayList<Sondage> stdd =(ArrayList<Sondage>)request.getAttribute("listSondage");
            String spageidd=request.getParameter("page");
            if(spageid!=null){
            System.out.println("***********************\n"+spageid+"**********************\n");
            int pageid=Integer.parseInt(spageid);
            int total=(int)(std.size()/10);
            int end=0;
            if(pageid==1){end=total;}
            else{
            pageid=pageid-1;
            pageid=pageid*total;
            end=pageid+total;
            }}
            // for(int i=pageid;i<end;i++){
            for(int i=0;i<std.size();i++){%>
            <%-- Arranging data in tabular form--%>
            <tr>
                <th scope="row"><%=std.get(i).getIntitule_son()%>
                </th>
                <td><%=std.get(i).getDate_sondage()%>
                </td>
                <td>
                    <a class="btn btn-primary" href="editSondage?id=<%=std.get(i).getSondage_id()%>">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="btn btn-danger " href="deleteSondage?id=<%=std.get(i).getSondage_id()%>">Delete</a>
                </td>
            </tr>
                <%}
            %>
        </table>
    </div>
</div>

</body>
</html>