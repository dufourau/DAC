<%-- 
    Document   : detailEvent
    Created on : 8 mars 2015, 14:44:36
    Author     : andreiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="/nav.jspf" />
    <jsp:include page="/header.jspf" />
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
        </div>
    </div>
    </body>
</html>
