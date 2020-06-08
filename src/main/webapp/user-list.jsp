<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@page import="test.testjpa.domain.*"%>
  <%@page import="java.util.ArrayList"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
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
        <h1 class="text-white">User Management</h1>
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
                            Créer departement
                        </button>
                    </h5>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                    <div class="card-body">
                        <div class="container">
                            <form method="post" action="creerReunion">
                                <div class="form-group row">
                                    <label for="nomDepartement" class="col-sm-4 col-form-label">Nom departement</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="nomDepartement" name="nomDepartement" required class="form-control"
                                               placeholder="nom reunion" value="">
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <center>
                                        <div class="col-sm-8">
                                            <input type="submit" class="btn btn-primary" VALUE="CREER DEPARTEMENT">
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
                        <button class="btn btn-primary text-uppercase" data-toggle="collapse" data-target="#collapseTwo"
                                aria-expanded="true" aria-controls="collapseOne">
                            Créer employee
                        </button>
                    </h5>
                </div>

                <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo" data-parent="#accordion">
                    <div class="card-body">
                        <div class="container">
                            <form method="post" action="creerReunion">
                                <div class="form-group row">
                                    <label for="nomEmploye" class="col-sm-4 col-form-label">Nom employee</label>
                                    <div class="col-sm-8">
                                        <input type="text" id="nomEmploye" name="nomEmploye" required class="form-control"
                                               placeholder="nom reunion" value="">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="dateReunion" class="col-sm-4 col-form-label">Date de la réunion</label>
                                    <div class="col-sm-8">
                                        <select name="dateReunion" class="form-control inputstl" id="dateReunion">
                                            <% ArrayList<Department> departments = (ArrayList<Department>) request.getAttribute("listDepartement");
                                                if(departments.size()!=0){  for (int i = 0; i < departments.size(); i++) {%>
                                            <option value="<%=departments.get(i).getId()%>"><%=departments.get(i).getId()%></option>

                                            <%}}%>

                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <center>
                                        <div class="col-sm-8">
                                            <input type="submit" class="btn btn-primary" VALUE="CREER EMPLOYEE">
                                        </div>
                                    </center>
                                </div>
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
                <th scope="col"><b>ID</b></th>
                <th scope="col"><b>Nom</b></th>
                <th scope="col"><b>Departement</b></th>
                <th scope="col"><b>Actions</b></th>
            </tr>
            </thead>
            <tbody>


            <%-- Fetching the attributes of the request object which was previously set by the servlet "StudentServlet.java" --%>
                <%ArrayList<Employee> employees = (ArrayList<Employee>) request.getAttribute("listUser");
                if (employees.size()!=0){
                    for(int i=0;i<employees.size();i++){%>
            <%-- Arranging data in tabular form--%>
            <tr>
                <td scope="row"><%=employees.get(i).getId()%>
                </td>
                <td><%=employees.get(i).getName()%>
                </td>
                <td><%=employees.get(i).getDepartment().getName()%>
                </td>
                <td>
                    <a class="btn btn-primary" href="editUser?id=<%=employees.get(i).getId()%>">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="btn btn-danger " href="deleteUser?id=<%=employees.get(i).getId()%>">Delete</a>
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