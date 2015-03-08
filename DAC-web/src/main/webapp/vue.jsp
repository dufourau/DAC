<%-- 
    Document   : vue
    Created on : 27 févr. 2015, 16:20:19
    Author     : andreiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <title>Recherche d'évennement</title>
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
                        <a href="About">A Propos</a>
                    </li>
                  
              
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
        
     <!-- Page Content -->
    <div class="container">
        <h1>Résultat de la recherche</h1>
        Résultat de la recherche  <br/>
        Nom = ${param.nom} </br>
        Date = ${param.date} </br>
        Ville = ${param.ville} </br>
        Prix minimum = ${param.prixMin} </br>
        Prix maximum = ${param.prixMax} </br>
    </div>
    </body>
</html>
