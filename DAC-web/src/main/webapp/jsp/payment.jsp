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
        <title>Paiement </title>
    </head>
    <body>
    
    <div class="col-md-4">
        <%@ include file="/jspf/user.jspf" %>
    </div>
    
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <c:choose>
                    <c:when test="${sessionScope.user eq null}">
                        <h3>Connectez vous pour accéder à cette page.</h3>
                    </c:when>
                    <c:otherwise>

                                                 
         
                    <div class="well">
                        <label for="total">Total</label>
                        <input class="form-control" id="total" name="id" value="${sessionScope.user.getPanier().getValeur()} &euro;" readonly="true">                           
                        
                        <form class="form-horizontal" action="Payment" method="POST">
                            <h3>Références de facturation</h3>
                            <div class="form-group">
                                <label for="inputEmail" class="col-sm-2 control-label">  <span style="color:red">* </span>Prénom</label>
                                <div class="col-sm-6">
                                  <input name="prenom" class="form-control" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword" class="col-sm-2 control-label">  <span style="color:red">* </span>Nom</label>
                                <div class="col-sm-6">
                                  <input type="text" name="nom" class="form-control" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputAdresse" class="col-sm-2 control-label">  <span style="color:red">* </span>Adresse</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="adresse" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPrenom" class="col-sm-2 control-label">  <span style="color:red">* </span>Code Postal</label>
                                <div class="col-sm-6">
                                  <input type="text" name="codepostal" class="form-control" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputCategorie" class="col-sm-2 control-label">  <span style="color:red">* </span>Ville</label>
                                <div class="col-sm-6">
                                   <input type="text" name="ville" class="form-control" required>
                                </div>
                            </div>
                            <h3>Carte Bancaire</h3>
                            <div class="form-group">
                                <label for="inputAge" class="col-sm-2 control-label" required>  <span style="color:red">* </span>Type de carte</label>
                                <div class="col-sm-6">
                                  <input type="radio" name="gender" value="1"> CB
                                  <input type="radio" name="gender" value="2"> Visa
                                  <input type="radio" name="gender" value="3"> Mastercard
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputAdresse" class="col-sm-2 control-label" required>  <span style="color:red">* </span>Propriétaire</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="proprietaire"> 
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputAdresse" class="col-sm-2 control-label" required>  <span style="color:red">* </span>Numéro de carte</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="numerodecarte"> 
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputAdresse" class="col-sm-2 control-label" required>  <span style="color:red">* </span>Cryptogramme de sécurité</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" name="crypto"> 
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputAdresse" class="col-sm-2 control-label" required>  <span style="color:red">* </span>Date d'expiration</label>
                                <div class="col-sm-6">
                                    <input type="date" class="form-control" name="date"> 
                                </div>
                            </div>
                            
                            <div class="form-group">                                
                                <div class="col-sm-12"> 
                                  <button type="submit" class="btn btn-success pull-right">Payer</button>
                                  <a href="Panier" class="btn btn-danger pull-left">Annuler</a>
                                </div>
                            </div>
                      </form>
                   </div>
                    </c:otherwise>                                     
                </c:choose>                      
            </div>
        </div>
    </div>
    </body>
</html>
