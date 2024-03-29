<%@ page import="java.util.ArrayList" %>
<%@ page import="servlet.dao.LieuDao" %>
<%@ page import="test.testjpa.domain.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#nomSondage").change( function(){
            let text='';
           text=document.getElementById("nomSondage").value;
            let res = text.split(";");
            document.getElementById("idSondage").value=res[1];


                document.getElementById("lieuChoisi1").value=res[2];
                document.getElementById("lieuChoisi2").value=res[3];
                document.getElementById("lieuChoisi3").value=res[4];
                document.getElementById("dateChoisi1").value = res[5];
                document.getElementById("dateChoisi2").value = res[6];
                document.getElementById("dateChoisi3").value = res[7];


        });
    });
</script>
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
                                    <label for="name" class="col-sm-4 col-form-label">type sondage</label>

                                    <div class="btn-group btn-group-toggle col-sm-8" data-toggle="buttons">
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="type" value="date" id="option1" autocomplete="off"> type date
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="type" value="lieu" id="option2" autocomplete="off"> type lieu
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="radio" name="type" value="lieuDate" id="option3" autocomplete="off"> type lieu et date
                                        </label>
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
                                        <input type="hidden" name="idSondage" value="idSondage" id="idSondage" autocomplete="off">
                                        <select name="nomSondage" class="form-control " id="nomSondage">
                                            <% ArrayList<Sondage> sondages=(ArrayList<Sondage>) request.getAttribute("listSondage");

                                                if(sondages.size()!=0){
                                                    for (int i = 0; i < sondages.size(); i++) {
                                                        if (sondages.get(i) instanceof Sondage_lieu){%>
                                                            <option value="1;<%=sondages.get(i).getSondage_id()%>;<%=((Sondage_lieu) sondages.get(i)).getLieuSondage().getLieu1()%>;<%=((Sondage_lieu) sondages.get(i)).getLieuSondage().getLieu2()%>;<%=((Sondage_lieu) sondages.get(i)).getLieuSondage().getLieu3()%>"><%=sondages.get(i).getIntitule_son()%></option>
                                                        <%}else if(sondages.get(i) instanceof Sondage_date){%>
                                                            <option value="2;<%=sondages.get(i).getSondage_id()%>;<%=((Sondage_date) sondages.get(i)).getDateSondage().getDate1()%>;<%=((Sondage_date) sondages.get(i)).getDateSondage().getDate2()%>;<%=((Sondage_date) sondages.get(i)).getDateSondage().getDate3()%>"><%=sondages.get(i).getIntitule_son()%></option>
                                                        <%}else if (sondages.get(i) instanceof Sondage_lieu_date){%>
                                                             <option value="3;<%=sondages.get(i).getSondage_id()%>;<%=((Sondage_lieu_date) sondages.get(i)).getLieuSondage().getLieu1()%>;<%=((Sondage_lieu_date) sondages.get(i)).getLieuSondage().getLieu2()%>;<%=((Sondage_lieu_date) sondages.get(i)).getLieuSondage().getLieu3()%>;<%=((Sondage_lieu_date) sondages.get(i)).getDateSondage().getDate1()%>;<%=((Sondage_lieu_date) sondages.get(i)).getDateSondage().getDate2()%>;<%=((Sondage_lieu_date) sondages.get(i)).getDateSondage().getDate2()%>"><%=sondages.get(i).getIntitule_son()%></option>
                                            <%}}}%>

                                        </select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="nomEmploye" class="col-sm-4 col-form-label">Nom employe</label>
                                    <div class="col-sm-8">
                                        <select name="idEmployee" class="form-control inputstl" id="nomEmploye1">
                                            <%  for (int i = 0; i < emp.size(); i++) {%>
                                            <option value="<%=emp.get(i).getId()%>"><%=emp.get(i).getName()%></option>

                                            <%}%>

                                        </select>
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <label for="dateChoisi" class="col-sm-3 col-form-label">Choix de la date</label>
                                    <div class="col-sm-3">
                                        <input type="date" id="dateChoisi" name="dateChoisi"
                                               class="form-control"
                                               placeholder="Date Choisi">
                                    </div>
                                    <label for="dateChoisi" class="col-sm-3 col-form-label">Choix du lieu</label>
                                    <div class="col-sm-3">
                                        <input type="text" id="lieuChoisi" name="lieuChoisi"
                                               class="form-control"
                                               placeholder="Choisir le lieu">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Lieu choisi</label>
                                    <div class="btn-group btn-group-toggle col-sm-8" data-toggle="buttons">
                                        <label class="btn btn-secondary">

                                            <input type="text" readonly id="lieuChoisi1"  name="lieuChosi" value="date">
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="text" readonly id="lieuChoisi2" name="lieuChosi" value="lieu">
                                        </label>
                                        <label class="btn btn-secondary">
                                            <input type="text" readonly id="lieuChoisi3" name="lieuChosi" value="lieuDate">
                                        </label>
                                    </div>

                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Date choisi</label>
                                    <div class="btn-group btn-group-toggle col-sm-8" data-toggle="buttons">
                                        <label class="btn btn-secondary">
                                            <input type="text" readonly id="dateChoisi1"  name="dateChoisi1" value="date">
                                        </label>
                                        <label class="btn btn-secondary">

                                            <input type="text"readonly id="dateChoisi2" name="dateChoisi2" value="lieu">
                                        </label>
                                        <label class="btn btn-secondary">

                                            <input readonly type="text" id="dateChoisi3" name="dateChoisi3" value="dateChosi">
                                        </label>
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
                            Voir les participants au sondages
                        </button>
                    </h5>
                </div>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                    <div class="card-body">
                        <div class="container">
                          <table class="table table-striped" width="500px;" align="center">
                                    <thead class="table-dark">
                                    <tr>
                                        <th scope="col"><b>Nom employee</b></th>
                                        <th scope="col"><b>Nom sondage</b></th>
                                        <th scope="col"><b>Actions</b></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%-- Fetching the attributes of the request object which was previously set by the servlet "StudentServlet.java" --%>
                                        <%ArrayList<User_sondage> user_sondages =(ArrayList<User_sondage>)request.getAttribute("listUserSondage");
                                     if(user_sondages.size()!=0){
                                      for(int i=0;i<user_sondages.size();i++){%>
                                                            <%-- Arranging data in tabular form--%>
                                    <tr>
                                        <th scope="row"><%=user_sondages.get(i).getEmployee().getName()%>
                                        </th>
                                        <td><%=user_sondages.get(i).getSondage().getIntitule_son()%>
                                        </td>
                                        <td>
                                            <a class="btn btn-primary" href="editUserSondage?id=<%=user_sondages.get(i).getUser_sondage_id()%>">Edit</a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a class="btn btn-danger " href="deleteUserSondage?id=<%=user_sondages.get(i).getUser_sondage_id()%>">Delete</a>
                                        </td>
                                    </tr>
                                        <%}}%>
                                </table>
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
                <th scope="col"><b>Nom</b></th>
                <th scope="col"><b>Date</b></th>
                <th scope="col"><b>Actions</b></th>
            </tr>
            </thead>
            <tbody>

            <%-- Fetching the attributes of the request object which was previously set by the servlet "StudentServlet.java" --%>
                <%ArrayList<Sondage> listSondage =(ArrayList<Sondage>)request.getAttribute("listSondage");
            if(listSondage.size()!=0){
            for(int i=0;i<listSondage.size();i++){%>
            <%-- Arranging data in tabular form--%>
            <tr>
                <th scope="row"><%=listSondage.get(i).getIntitule_son()%>
                </th>
                <td><%=listSondage.get(i).getDate_sondage()%>
                </td>
                <td>
                    <a class="btn btn-primary" href="editSondage?id=<%=listSondage.get(i).getSondage_id()%>">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="btn btn-danger " href="deleteSondage?id=<%=listSondage.get(i).getSondage_id()%>">Delete</a>
                </td>
            </tr>
                <%}}
            %>
        </table>
    </div>
</div>

</body>
</html>