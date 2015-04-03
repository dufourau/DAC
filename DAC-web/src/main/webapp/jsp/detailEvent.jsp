<%-- 
    Document   : detailEvent
    Created on : 8 mars 2015, 14:44:36
    Author     : andreiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        
        <div class="col-md-4">
            <%@ include file="/jspf/user.jspf" %>
        </div>
    
        <div class="col-md-8">
            <div class="panel panel-info">
                   <div class="panel-heading">
                       ${evenement.nom}
                   </div>
                   <div class="panel-body">
                       <div class="col-md-8 container">
                            <div class="margin col-md-5">
                                <span class="glyphicon glyphicon-map-marker"> Lieu : ${evenement.lieu}<a target="_blank" href="http://maps.google.fr/?q=${evenement.lieu}" class="pull-right"><span class="glyphicon glyphicon-map-marker"></span></a></span> 
                            </div>
                            <div class="margin col-md-5">
                                <span class="glyphicon glyphicon-calendar"> Date : <fmt:formatDate value="${evenement.date}" pattern="dd/mm/yyyy" /></span> 
                            </div>
                            <div class="margin col-md-5">
                                <span class="glyphicon glyphicon-euro"> Prix : ${evenement.prix} &euro;</span> 
                            </div>
                            <div class="margin col-md-5">
                                <span class="glyphicon glyphicon-tag"> Catégorie : ${evenement.categorie}</span> 
                            </div>
                        </div>
                       
                        <div class="col-md-4 alert alert-info">
                           <div class="container">
                                <form class="form-horizontal" action="AjouterPanier" method="get">
                                    <input type="hidden" name="id" value="${evenement.id}"/>
                                    <div class="form-group">
                                       <div class="col-sm-2">
                                           <label for="number">Nombre de tickets</label>
                                           <input class="form-control" id="number" name="number" type="number" value="1" min="1" required/>
                                       </div>
                                    </div>
                                    <div class="form-group">
                                       <div class="col-sm-2">
                                         <button type="submit" class="btn btn-default">Ajouter au panier</button>
                                       </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <hr>
                        <div class="col-md-12">
                            <h4 class="glyphicon glyphicon-list-alt"> Description</h4> 
                            <p>${evenement.description}</p>
                        </div>
                    </div>
           </div> 
    </div>
    </body>
</html>
