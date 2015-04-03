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
    <jsp:include page="/jspf/header.jspf" />
    <%@ include file="/jspf/nav.jspf" %>
    <%@ include file="/jspf/messages.jspf" %>
    <head>
        <title>Recherche d'évennement</title>
    </head>
    <body>
        <div class="col-md-4">
            <%@ include file="/jspf/user.jspf" %>
        </div>

        <!-- Blog Entries Column -->
        <div class="col-md-8">
            <div class="table-responsive">
                <table class="table">
                  <tr>
                    <th>Nom</th>
                    <th>Date</th>
                    <th>Lieu</th>
                    <th>Prix</th>
                    <th>Catégorie</th>
                    <th></th>
                  </tr>

                  <c:forEach var="evenement" items="${evenements}">
                    <tr>
                    <form action="DetailsEvent" method="get">
                      <input type="hidden" name="id" value="${evenement.id}">
                      <td>${evenement.nom}</td>
                      <td><fmt:formatDate value="${evenement.date}" pattern="dd/mm/yyyy" /></td>
                      <td>${evenement.lieu} <a target="_blank" href="http://maps.google.fr/?q=${evenement.lieu}" class="pull-right"><span class="glyphicon glyphicon-map-marker"></span></a></td>
                      <td>${evenement.prix} &euro;</td>
                      <td>${evenement.categorie}</td>
                      <td><button type="submit" class="btn btn-default btn-info btn-sm">Sélectionner</button></td>
                    </form>
                    </tr>
                  </c:forEach>

                </table>    
            </div>

        </div>
    </body>
</html>
