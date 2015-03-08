<%-- 
    Document   : detailEvent
    Created on : 8 mars 2015, 14:44:36
    Author     : andreiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <title>Details de l'évennement</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
     
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                         <a href="#">E-Caco</a>
                    </li>
                    <li>
                        <a href="#">Evenement</a>
                    </li>
                    <li>
                        <a href="#">A Propos</a>
                    </li>
                  
              
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
        
     <!-- Page Content -->
    <div class="container">

        <div class="row">
        <h1>Hello World!</h1>
        Je suis sur la page de détails dévent
        <table>
            <tr>Test</tr>
            <tr>${param.nomEvent}</tr>
            <tr>${param.dateEvent}</tr>
            <tr>${param.lieuEvent}</tr>
            <tr>${param.prixEvent}</tr>
        </table>
        </div>
    </div>
    </body>
</html>
