<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <jsp:include page="/header.jspf" />
    <jsp:include page="/nav.jspf" />
    <%@ include file="/messages.jspf" %>
    <head>
        <title>E-Caco</title>
    </head>
    <body>
    
    <div class="col-md-4">

        <!-- Login box -->
        <c:choose> 
            <c:when test="${sessionScope.user eq null}">
                <div class="well">
                    <form class="form-horizontal" action="Login" method="POST">  
                     <div class="form-group">
                         <label for="inputEmail" class="col-sm-2 control-label">Email</label>
                         <div class="col-sm-6">
                           <input type="email" class="form-control" name="email" placeholder="Email">
                         </div>
                      </div>
                      <div class="form-group">
                         <label for="inputPassword" class="col-sm-2 control-label">Mot de passe</label>
                         <div class="col-sm-6">
                           <input type="password" class="form-control" name="password" placeholder="Mot de passe">
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
            </c:when>
            <c:otherwise>
                <div class="well">
                    <h4>${sessionScope.user.email}</h4>
                    <a href="./Logout"><button type="button" class="btn btn-default pull-right">Déconnexion</button></a>
                    
                </div>
            </c:otherwise>
        </c:choose>

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
                  <input type="date" name="date" class="form-control" id="inputDate" placeholder="Date">
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
                  <input type="text" name="prixMin" class="form-control" id="inputEmail3" value="0.00" >
                </div>
             </div>
             <div class="form-group">
                <label for="inputPrixMax" class="col-sm-2 control-label">PrixMax</label>
                <div class="col-sm-6">
                  <input type="text" name="prixMax" class="form-control" id="inputEmail3" value="3000.00" >
                </div>
             </div>   
             <div class="form-group">
                <div class="col-sm-offset-2 col-sm-2">
                  <button type="submit" class="btn btn-default">Rechercher</button>
                </div>
             </div>

           </form>
        </div>
    </div>            

        
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
                      
                      <c:forEach var="evenement" items="${evenements}">
                        <tr>
                        <form action="DetailsEvent" method="get">
                          <input type="hidden" name="id" value="${evenement.id}">
                          <td>${evenement.nom}</td>
                          <td><fmt:formatDate value="${evenement.date}" pattern="dd/mm/yyyy" /></td>
                          <td>${evenement.ville}</td>
                          <td>${evenement.prix}</td>
                          <td><button type="submit" class="btn btn-default">Sélectionner</button></td>
                        </form>
                        </tr>                      
                      </c:forEach>
                        
                    </table>
                </div>
              
            </div>
           
        </div>  
       
    </div>
    </body>
</html>
