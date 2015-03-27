<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <jsp:include page="/nav.jspf" />
    <jsp:include page="/header.jspf" />
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
                        <td>Categorie</td>
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
