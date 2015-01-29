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
    
    <div class="col-md-4">
        
                <!-- Login box -->
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
                    <form class="form-horizontal">  
                    <div class="form-group">
                        <label for="inputNom" class="col-sm-2 control-label">Nom</label>
                        <div class="col-sm-6">
                          <input type="text" class="form-control" id="inputEmail3" placeholder="Nom">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputDate" class="col-sm-2 control-label">Date</label>
                        <div class="col-sm-6">
                          <input type="date" class="form-control" id="inputDate" >
                        </div>
                     </div>
                        
                     <div class="form-group">
                        <label for="inputVille" class="col-sm-2 control-label">Ville</label>
                        <div class="col-sm-6">
                          <input type="text" class="form-control" id="inputVille" placeholder="Ville">
                        </div>
                     </div>
                        
                     <div class="form-group">
                        <label for="inputPrixMin" class="col-sm-2 control-label">PrixMin</label>
                        <div class="col-sm-6">
                          <input type="text" class="form-control" id="inputEmail3" placeholder="PrixMin" >
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputPrixMax" class="col-sm-2 control-label">PrixMax</label>
                        <div class="col-sm-6">
                          <input type="text" class="form-control" id="inputEmail3" placeholder="PrixMax" >
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
                     
                      </tr>
                    </table>
                </div>
              
            </div>
                
        </div>      
    </div>
    </body>
</html>
