<%-- 
    Document   : detailEvent
    Created on : 8 mars 2015, 14:44:36
    Author     : andreiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="/jspf/header.jspf" />
    <%@ include file="/jspf/nav.jspf" %>
    <%@ include file="/jspf/messages.jspf" %>
    <head>
        <title>
            <c:choose>
                <c:when test="${evenement.nom ne null}">
                    ${evenement.nom}
                </c:when>
                <c:otherwise>
                    Evenement non trouvé
                </c:otherwise>
            </c:choose>
        </title>
    </head>
    <body>
     <!-- Page Content -->
    <div class="container">

        <div class="row">
         <div class="panel event">
                <div class="panel-heading">
                    ${evenement.nom}
                </div>
                <div class="panel-body">
                    <p>Lieu: ${evenement.lieu}</p>
                    <p>Date: ${evenement.date}</p>
                    <p>Prix: ${evenement.prix}</p>
                    <p>Categorie: ${reservation.getEvenement().getCategorie()}</p>
                </div>          
        </div> 
        <form class="form-horizontal" action="AjouterPanier" method="get">
            <input type="hidden" name="id" value="${evenement.id}"/>
            <div class="form-group">
               <div class="col-sm-offset-2 col-sm-2">
                   <label for="number">Nombre de tickets</label>
                   <input id="number" name="number" type="number" value="1" min="1"/>
               </div>
            </div>
            <div class="form-group">
               <div class="col-sm-offset-2 col-sm-2">
                 <button type="submit" class="btn btn-default">Ajouter au panier</button>
               </div>
            </div>
        </form>
        </div>
    </div>
    </body>
</html>
