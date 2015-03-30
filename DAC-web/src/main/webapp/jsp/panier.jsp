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
        <title>Votre Panier</title>
    </head>
    <body>
    
    <div class="col-md-4">
        <%@ include file="/jspf/user.jspf" %>
    </div>
    
    <div class="container">

        <c:choose> 
            <c:when test="${sessionScope.user eq null}">
                <h3> Connectez vous pour accéder à votre panier </h3>
            </c:when>
            <c:otherwise>
                <div class="row">
                    <div class="col-md-8">
                        <div class="table-responsive">
                                <c:forEach var="reservation" items="${sessionScope.user.getPanier().getReservations()}">
                                    <div class="panel event">
                                        <div class="panel-heading">
                                            ${reservation.getEvenement().nom}
                                        </div>
                                        <div class="panel-body">
                                            <p>Nombre de places réservées : ${reservation.getNumberOfTickets()}</p>
                                            <p>Lieu: ${reservation.getEvenement().getLieu()}</p>
                                            <p>Date ${reservation.getEvenement().getDate()}</p>
                                            <p>Categorie: ${reservation.getEvenement().getCategorie()}</p>
                                        </div>
                                        <form action="DetailsEvent" method="get">
                                            <input type="hidden" name="id" value="${reservation.getEvenement().getId()}">
                                            <button type="submit" class="btn btn-default">Selectionner</button>
                                         </form>
                                         <!--Add a remove event servlet-->
                                         <form action="RetirerPanier" method="get">
                                             <input type="hidden" name="id" value="${reservation.getEvenement().getId()}">
                                            <button type="submit" class="btn btn-default">Retirer</button>
                                        </form>
                                    </div>                    
                              </c:forEach>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>     
    </div>
    </body>
</html>
