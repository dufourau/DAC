<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/jspf/header.jspf" />
    <%@ include file="/jspf/nav.jspf" %>
    <%@ include file="/jspf/messages.jspf" %>
    <head>
        <title>Inscription</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="well">
                    <form class="form-horizontal" action="Inscription" method="POST">  
                    <div class="form-group">
                        <label for="inputEmail" class="col-sm-2 control-label"><span style="color:red">* </span>Email</label>
                        <div class="col-sm-6">
                          <input name="email" class="form-control" placeholder="Email" required>
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputPassword" class="col-sm-2 control-label"><span style="color:red">* </span>Mot de passe</label>
                        <div class="col-sm-6">
                          <input type="password" name="password" class="form-control" placeholder="Mot de passe" required>
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputPassword2" class="col-sm-2 control-label"><span style="color:red">* </span>Confirmer le mot de passe</label>
                        <div class="col-sm-6">
                          <input type="password" name="password2" class="form-control" placeholder="Mot de passe" required>
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputPrenom" class="col-sm-2 control-label">Prénom</label>
                        <div class="col-sm-6">
                          <input type="text" name="prenom" class="form-control" placeholder="Prénom">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputNom" class="col-sm-2 control-label">Nom</label>
                        <div class="col-sm-6">
                          <input type="text" name="nom" class="form-control" placeholder="Nom">
                        </div>
                     </div>
                       <div class="form-group">
                        <label for="inputAge" class="col-sm-2 control-label">Age</label>
                        <div class="col-sm-6">
                          <input type="number" min="0" step="1" name="age" class="form-control" placeholder="Age">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="inputAdresse" class="col-sm-2 control-label">Adresse</label>
                        <div class="col-sm-6">
                            <textarea type="text" class="form-control" name="adresse"></textarea>
                        </div>
                     </div>
                       
                     <div class="form-group">
                        <div class="col-sm-offset-2 input-group">
                            <input type="checkbox" name="conditonGenerales">
                            <span style="color:red">  * </span>J'ai lu et j'accepte les conditions générales d'utilisation.</br>
                            </br>
                        </div><!-- /input-group -->
                     </div><!-- /.col-lg-6 -->
                     
                    <div class="form-group">
                        <div>
                            <span style="color:red"> * champs obligatoires</span>
                        </div>
                        <div class="col-sm-offset-10 col-sm-2">
                          <button type="submit" class="btn btn-default">S'inscrire</button>
                        </div>
                     </div>
                   </form>
                </div>
            </div>
        </div>
    </body>
</html>
