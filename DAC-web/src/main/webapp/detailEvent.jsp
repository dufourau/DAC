<%-- 
    Document   : detailEvent
    Created on : 8 mars 2015, 14:44:36
    Author     : andreiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="/header.jspf" />
    <jsp:include page="/nav.jspf" />
    <%@ include file="/messages.jspf" %>
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
        Je suis sur la page de détails d'évenement
        <table>
            <tr>
                <td>${evenement.nom}</td>
            </tr>   
            <tr>
                <td>${evenement.date}</td>
            </tr>   
            <tr>
                <td>${evenement.ville}</td>
            </tr>   
            <tr>
                <td>${evenement.prix}</td>                
            </tr>
        </table>
        <form class="form-horizontal" action="AjouterPanier" method="get">
            <input type="hidden" name="id" value="${evenement.id}"/>
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
