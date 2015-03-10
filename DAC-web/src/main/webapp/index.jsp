<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
    </head>
    <body>
    <!-- Navigation -->
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
    
    <div class="col-md-4">
        
                <!-- Login box -->
                ${param.logger}
                <div class="well">
                   <form class="form-horizontal">  
                    <div class="form-group">
                        <label for="inputEmail" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-6">
                          <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputPassword" class="col-sm-2 control-label">Mot de passe</label>
                        <div class="col-sm-6">
                          <input type="password" class="form-control" id="inputEmail3" placeholder="Mot de passe">
                        </div>
                     </div>
                     <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-2">
                          <button type="submit" class="btn btn-default">Connexion</button>
                        </div>
                     </div>
                    </form>
                    <form action="Inscription" class="form-horizontal">
                     <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-2">
                          <button type="submit" class="btn btn-default">Inscription</button>
                        </div>
                     </div>
                   </form>
                </div>

                <!-- Search box -->
                <div class="well">
                    <h4>Recherche</h4>
                    <form class="form-horizontal" action="SearchEvent" method="get">  
                    <div class="form-group">
                        <label for="inputNom" class="col-sm-2 control-label">Nom</label>
                        <div class="col-sm-6">
                          <input type="text" name="nom" class="form-control" id="inputEmail3" placeholder="Nom">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputDate" class="col-sm-2 control-label">Date</label>
                        <div class="col-sm-6">
                          <input type="date" name="date" class="form-control" id="inputDate" >
                        </div>
                     </div>
                        
                     <div class="form-group">
                        <label for="inputVille" class="col-sm-2 control-label">Ville</label>
                        <div class="col-sm-6">
                          <input type="text" name="ville" class="form-control" id="inputVille" placeholder="Ville">
                        </div>
                     </div>
                        
                     <div class="form-group">
                        <label for="inputPrixMin" class="col-sm-2 control-label">PrixMin</label>
                        <div class="col-sm-6">
                          <input type="text" name="prixMin" class="form-control" id="inputEmail3" placeholder="PrixMin" >
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputPrixMax" class="col-sm-2 control-label">PrixMax</label>
                        <div class="col-sm-6">
                          <input type="text" name="prixMax" class="form-control" id="inputEmail3" placeholder="PrixMax" >
                        </div>
                     </div>   
                     <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-2">
                          <button type="submit" class="btn btn-default">Rechercher</button>
                        </div>
                     </div>
                     
                   </form>
                    <!-- /.row -->
                </div>
    </div>            
                
                 <!-- Page Content -->
    <div class="container">

        <div class="row">

            <!-- Blog Entries Column -->
            <div class="col-md-8">
                <div class="table-responsive">
                    <table class="table">
                      <tr>
                        <td>Nom</td>
                        <td>Date</td>
                        <td>Ville</td>
                        <td>Prix</td>
                        <td></td>
                     
                      </tr>
                      <tr>
                      <form action="DetailsEvent" method="get">
                        <td><input type="hidden" name="nomEvent" value="Festival">Festival</td>
                        <td><input type="hidden" name="dateEvent" value="01/01/01">01/01/01</td>
                        <td><input type="hidden" name="lieuEvent" value="Paris">Paris</td>
                        <td><input type="hidden" name="prixEvent" value="999.9">999.9</td>
                        <td><button type="submit" class="btn btn-default">Selectionner</button></td>
                      </form>
                      </tr>
                    </table>
                </div>
              
            </div>
           
        </div>  
        
        <div class="row">
            <div class="well">
            <sql:query var="result" dataSource="jdbc/__dac">
                SELECT * FROM personne;
            </sql:query>
                
                <table border="1">
                    <!-- column headers -->
                    <tr>
                        <c:forEach var="columnName" items="${result.columnNames}">
                            <th><c:out value="${columnName}"/></th>
                        </c:forEach>
                    </tr>
    
                    <!-- column data -->
                    <c:forEach var="row" items="${result.rowsByIndex}">
                    <tr>
                        <c:forEach var="column" items="${row}">
                            <td><c:out value="${column}"/></td>
                        </c:forEach>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
       
    </div>
    </body>
</html>
