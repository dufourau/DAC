<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <jsp:include page="/jspf/header.jspf" />
    <%@ include file="/jspf/nav.jspf" %>
    <%@ include file="/jspf/messages.jspf" %>
    <head>
        <title>E-Caco</title>
    </head>
    <body>
    
    <div class="col-md-4">

        <%@ include file="/jspf/user.jspf" %>

        <!-- Search box -->
        <div class="well">
            <h4>Recherche</h4>
            <form class="form-horizontal" action="SearchEvent" method="get">
            <div class="form-group">
                <label for="inputNom" class="col-sm-3 control-label">Nom</label>
                <div class="col-sm-6">
                  <input type="text" name="nom" class="form-control" id="inputEmail3" placeholder="Nom">
                </div>
             </div>
             <div class="form-group">
                <label for="inputDate" class="col-sm-3 control-label">Date</label>
                <div class="col-sm-6">
                  <input type="date" name="date" class="form-control" id="inputDate" placeholder="Date">
                </div>
             </div>

             <div class="form-group">
                <label for="inputVille" class="col-sm-3 control-label">Ville</label>
                <div class="col-sm-6">
                  <input type="text" name="ville" class="form-control" id="inputVille" placeholder="Ville">
                </div>
             </div>

             <div class="form-group">
                <label for="inputPrixMin" class="col-sm-3 control-label">PrixMin</label>
                <div class="col-sm-6">
                  <input type="text" name="prixMin" class="form-control" id="inputEmail3" value="0.00" >
                </div>
             </div>
             <div class="form-group">
                <label for="inputPrixMax" class="col-sm-3 control-label">PrixMax</label>
                <div class="col-sm-6">
                  <input type="text" name="prixMax" class="form-control" id="inputEmail3" value="3000.00" >
                </div>
             </div> 
             <div class="form-group">
                <label for="inputCategorie" class="col-sm-3 control-label">Categorie</label>
                <div class="col-sm-6">
                    <select id="divisionInput" name="categorie" type="text" required="" class="form-control input-md">
                        <option value="SPORT">Sport</option>
                        <option value="CONCERT">Concert</option>
                        <option value="SPECTACLE">Spectacle</option>
                        <option value="DIVERS">Divers</option>
                        <option value="TOUTES" selected="">Toute catégorie</option>
                    </select>
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
                        <td>Categorie</td>
                        <td></td>
                      </tr>
                      
                      <c:forEach var="evenement" items="${evenements}">
                        <tr>
                        <form action="DetailsEvent" method="get">
                          <input type="hidden" name="id" value="${evenement.id}">
                          <td>${evenement.nom}</td>
                          <td><fmt:formatDate value="${evenement.date}" pattern="dd/mm/yyyy" /></td>
                          <td>${evenement.lieu}</td>
                          <td>${evenement.prix}</td>
                          <td>${evenement.categorie}</td>
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