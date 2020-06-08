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
            height: 200px;
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
        <h1 class="text-white">Reunion Management</h1>
    </center>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#nomReunion").change( function(){
            let text='';
            text=document.getElementById("nomReunion").value;
            let res = text.split(";");
            document.getElementById("idReunion").value=res[1];


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
    <div class="col-sm-6">
        <div id="accordion">
            <div class="card">
                <div class="card-header" id="headingOne">
                    <h5 class="mb-0">
                        <button class="btn btn-primary text-uppercase" data-toggle="collapse" data-target="#collapseOne"
                                aria-expanded="true" aria-controls="collapseOne">
                            Créer reunion
                        </button>
                    </h5>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                    <div class="card-body">
                        <div class="container">
                            <form method="post" action="creerReunion">
                                <div class="form-group row">
                                    <label for="name" class="col-sm-4 col-form-label">Nom reunion</label>
                                    <div class="col-sm-8">
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
                                            <input type="submit" class="btn btn-primary" VALUE="CREER REUNION">
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
                            Participer à une reunion
                        </button>
                    </h5>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                    <div class="card-body">
                        <div class="container">
                            <form method="post" action="/participerReunion">

                                <div class="form-group row">
                                    <label for="idReunion" class="col-sm-4 col-form-label">Nom reunion</label>
                                    <div class="col-sm-8">
                                        <select name="idReunion" class="form-control " id="idReunion">
                                            <% ArrayList<Reunion> reunion=(ArrayList<Reunion>) request.getAttribute("listReunion");

                                                for (int i = 0; i < reunion.size(); i++) {%>

                                            <option value="<%=reunion.get(i).getReunion_id()%>"><%=reunion.get(i).getIntitule_reunion()%></option>

                                            <%}%>

                                        </select>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="nomEmploye1" class="col-sm-4 col-form-label">Nom employe</label>
                                    <div class="col-sm-8">
                                        <select name="idEmployee" class="form-control inputstl" id="nomEmploye1">
                                            <%  ArrayList<Employee> employees=(ArrayList<Employee>) request.getAttribute("listUser");
                                            if(employees.size()!=0){
                                                for (int i = 0; i < employees.size(); i++) {%>
                                            <option value="<%=employees.get(i).getId()%>"><%=employees.get(i).getName()%></option>

                                            <%}
                                            }%>

                                        </select>
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <label for="allergieChoisi" class="col-sm-3 col-form-label">Les allergies</label>
                                    <div class="col-sm-3">
                                        <input type="text" id="allergieChoisi" name="allergie"
                                               class="form-control"
                                               placeholder="Dites vos allergies">
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
                            Voir les participants à une réunion
                        </button>
                    </h5>
                </div>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
                    <div class="card-body">
                        <div class="container">
                            <form method="get" action="/participantReunion">
                                <table class="table table-striped" width="500px;" align="center">
                                    <thead class="table-dark">
                                    <tr>
                                        <th scope="col"><b>Nom employee</b></th>
                                        <th scope="col"><b>Nom reunion</b></th>
                                        <th scope="col"><b>Allergies</b></th>
                                        <th scope="col"><b>Actions</b></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%-- Fetching the attributes of the request object which was previously set by the servlet "StudentServlet.java" --%>
                                        <% ArrayList<User_reunion> user_reunions= (ArrayList<User_reunion>) request.getAttribute("listUserReunion");
                                            if (user_reunions!=null){
                                            if(user_reunions.size()!=0){
                                                for(int i=0;i<user_reunions.size();i++){%>
                                    <%-- Arranging data in tabular form--%>
                                    <tr>
                                        <th scope="row"><%=user_reunions.get(i).getEmployee().getName()%>
                                        </th>
                                        <td scope="row"><%=user_reunions.get(i).getReunion().getIntitule_reunion()%>
                                        </td>
                                        <td><%=user_reunions.get(i).getAllergie()%>
                                        </td>
                                        <td>
                                            <a class="btn btn-primary" href="editReunion?id=<%=user_reunions.get(i).getUser_reunion_id()%>">Edit</a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a class="btn btn-danger " href="deleteReunion?id=<%=user_reunions.get(i).getUser_reunion_id()%>">Delete</a>
                                        </td>
                                    </tr>
                                        <%}
                                        }
                                        }%>


                                </table>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <table class="table table-striped" width="500px;" align="center">
            <thead class="table-dark">
            <tr>
                <th scope="col"><b>Nom</b></th>
                <th scope="col">Description</th>
                <th scope="col"><b>Date</b></th>
                <th scope="col"><b>Actions</b></th>
            </tr>
            </thead>
            <tbody>


            <%-- Fetching the attributes of the request object which was previously set by the servlet "StudentServlet.java" --%>
                <% if (reunion.size()!=0){
                    for(int i=0;i<reunion.size();i++){%>
            <%-- Arranging data in tabular form--%>
                    <tr>
                        <th scope="row"><%=reunion.get(i).getIntitule_reunion()%>
                        </th>
                        <td><%=reunion.get(i).getDate_reunion()%>
                        </td>
                        <td><%=reunion.get(i).getResume_reunion()%>
                        </td>
                        <td>
                            <a class="btn btn-primary" href="editReunion?id=<%=reunion.get(i).getReunion_id()%>">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="btn btn-danger " href="deleteReunion?id=<%=reunion.get(i).getReunion_id()%>">Delete</a>
                        </td>
                    </tr>
                <%}
                }
            %>
        </table>
    </div>
</div>

</body>
</html>