<%-- 
    Document   : subscribe
    Created on : 8 mars 2015, 17:28:11
    Author     : andreiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <title>Subscribe Page</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
     
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                         <a href="Home">E-Caco</a>
                    </li>
                    <li>
                        <a href="#">Evenement</a>
                    </li>
                    <li>
                        <a href="About">A propos</a>
                    </li>
                  
              
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
        <div class="container">
            <div class="row">
                <div class="well">
                   <form class="form-horizontal" action="Inscription2">  
                    <div class="form-group">
                        <label for="inputEmail" class="col-sm-2 control-label"><span style="color:red">* </span>Email</label>
                        <div class="col-sm-6">
                          <input name="email" class="form-control" id="inputEmail3" placeholder="Email">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputPassword" class="col-sm-2 control-label"><span style="color:red">* </span>Mot de passe</label>
                        <div class="col-sm-6">
                          <input name="password" class="form-control" id="inputEmail3" placeholder="Mot de passe">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputPassword2" class="col-sm-2 control-label"><span style="color:red">* </span>Confirmer le mot de passe</label>
                        <div class="col-sm-6">
                          <input name="password2" class="form-control" id="inputEmail3" placeholder="Mot de passe">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputPrenom" class="col-sm-2 control-label">Prénom</label>
                        <div class="col-sm-6">
                          <input type="text" name="prenom" class="form-control" id="inputEmail3" placeholder="Prénom">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputNom" class="col-sm-2 control-label">Nom</label>
                        <div class="col-sm-6">
                          <input type="text" name="nom" class="form-control" id="inputEmail3" placeholder="Nom">
                        </div>
                     </div>
                       <div class="form-group">
                        <label for="inputAge" class="col-sm-2 control-label">Age</label>
                        <div class="col-sm-6">
                          <input type="number" name="age" class="form-control" id="inputEmail3" placeholder="Age">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputAdresse" class="col-sm-2 control-label">Adresse</label>
                        <div class="col-sm-6">
                          <input type="text" name="adresse" class="form-control" id="inputEmail3" placeholder="Adresse">
                        </div>
                     </div>
                       
                     <div class="form-group">
                        <div class="col-sm-offset-2 input-group">
                            <input type="checkbox" aria-label="...">
                            <span style="color:red">  * </span>J'ai lu et j'accepte les conditions générales d'utilisation.</br>
                            </br>
                        </div><!-- /input-group -->
                     </div><!-- /.col-lg-6 -->
                     
                    <div class="form-group">
                        <div>
                            <span style="color:red"> * champs obligatoires</span>
                        </div>
                        <div class="col-sm-offset-10 col-sm-2">
                          <button type="submit" class="btn btn-default">Enregistrer</button>
                        </div>
                     </div>
                   </form>
                </div>
            </div>
        </div>
    </body>
</html>
