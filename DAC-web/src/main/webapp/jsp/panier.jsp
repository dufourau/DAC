<%@page import="com.caco.Entity.stateless.PersonneFacadeLocal"%>
<%@page import="com.caco.Entity.stateless.PersonneFacade"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="com.caco.Entity.Personne"%>
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
    
    <div class="col-md-8">

        <c:choose> 
            <c:when test="${sessionScope.user eq null}">
                <h3> Connectez vous pour accéder à votre panier </h3>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${sessionScope.user.getPanier().getNbReservation() eq 0}">
                        <div class="alert alert-danger">
                            <h3>
                                Votre panier est vide
                            </h3>
                        </div>
                    </c:when>
                     <c:otherwise>
                        <div class="alert alert-danger clearfix">
                            <span class="glyphicon glyphicon-dollar">Total:</span> 
                            <font size="5"> ${sessionScope.user.getPanier().getValeur()}</font> &euro;
                            <a href="Payment" class="btn btn-default pull-right">Payer</a>
                        </div>
                        <c:forEach var="reservation" items="${sessionScope.user.getPanier().getReservations()}">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    ${reservation.getEvenement().nom}
                                </div>
                                <div class="panel-body">
                                    <div class="col-md-12 container">
                                        <div class="margin col-md-12">
                                            <span class="glyphicon glyphicon-chevron-right"> Nombre de places réservées : <big>${reservation.getNumberOfTickets()}</big></span>
                                        </div>
                                         <div class="margin col-md-5">
                                            <span class="glyphicon glyphicon-map-marker"> Lieu : ${reservation.getEvenement().getLieu()}<a target="_blank" href="http://maps.google.fr/?q=${evenement.lieu}" class="pull-right"><span class="glyphicon glyphicon-map-marker"></span></a></span> 
                                        </div>
                                        <div class="margin col-md-5">
                                            <span class="glyphicon glyphicon-calendar"> Date : <fmt:formatDate value="${reservation.getEvenement().getDate()}" pattern="dd/mm/yyyy" /></span> 
                                        </div>
                                        <div class="margin col-md-5">
                                            <span class="glyphicon glyphicon-euro"> Prix : ${reservation.getEvenement().getPrix()} &euro;</span> 
                                        </div>
                                        <div class="margin col-md-5">
                                            <span class="glyphicon glyphicon-tag"> Catégorie : ${reservation.getEvenement().getCategorie()}</span> 
                                        </div>
                                        <div class="margin col-md-5">
                                            <span class="glyphicon glyphicon-time"> Expire à : <fmt:formatDate value="${reservation.getExpirationDate()}" pattern="HH:mm:ss" /></span> 
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-footer clearfix">
                                    <form action="DetailsEvent" method="get">
                                        <input type="hidden" name="id" value="${reservation.getEvenement().getId()}">
                                        <button type="submit" class="pull-left btn btn-default btn-sm">Selectionner</button>
                                     </form>
                                     <!--Add a remove event servlet-->
                                     <form action="RetirerPanier" method="get">
                                         <input type="hidden" name="id" value="${reservation.getId()}">
                                         <button type="submit" class="pull-right btn btn-danger btn-sm">Retirer</button>
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="alert alert-danger clearfix">
                            <span class="glyphicon glyphicon-dollar">Total:</span> 
                            <font size="5"> ${sessionScope.user.getPanier().getValeur()}</font> &euro;
                            <a href="Payment" class="btn btn-default pull-right">Payer</a>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>     
    </div>
    </body>
</html>
