<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html5/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulaire</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <style>
        #largeur{
        margin-top:0px;
        width:500px;
        margin-left:300px;
        background:white;
        }
        #head{
        margin-top:0px;
        height:100px;
        background:blue;
        }

    </style>
</head>
<body>

<div id="head">

</div>

<div id="largeur">
    <form method="post" action="/UserInfo">
        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-4">
                <input type="text" id="name" name="name" required class="form-control" placeholder="name">
            </div>
        </div>
        <div class="form-group row">
            <label for="firstName" class="col-sm-2 col-form-label">FirstName</label>
            <div class="col-sm-4">
                <input type="text" id="firstName" required name="firstname" class="form-control" placeholder="name">
            </div>
        </div>
        <div class="form-group row">
            <label for="age" id class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-4">
                <input type="number" id="age" required name="age" class="form-control"
                       placeholder="age">
            </div>
        </div>
        <div class="form-group row">

            <div class="col-sm-4">
                <input type="submit" class="btn btn-primary" VALUE="Send">
            </div>
        </div>
    </form>
</div>
<img src="bg.jpg"/>
</body>
</html>