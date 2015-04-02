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
        <title>Panel administrateur</title>
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
                        <h3>Connectez vous pour accéder à la page administrateur</h3>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${!sessionScope.user.isAdmin()}">
                                <h3>Vous devez être administrateur pour accéder à cette section.</h3>
                            </c:when>
                            <c:otherwise>
                                <div class="well">
                                    <form class="form-horizontal" action="Admin" method="POST"> 
                                        <input name="operation" type="hidden" value="add">
                                        <div class="form-group">
                                            <label for="titre" class="col-sm-2 control-label"><span style="color:red">* </span>Titre</label>
                                            <div class="col-sm-6">
                                              <input name="titre" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="date" class="col-sm-2 control-label"><span style="color:red">* </span>Date</label>
                                            <div class="col-sm-6">
                                                <input type="date" name="date" class="form-control" id="inputDate" placeholder="Date">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="lieu" class="col-sm-2 control-label"><span style="color:red">* </span>Lieu</label>
                                            <div class="col-sm-6">
                                                <textarea type="text" class="form-control" name="lieu"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="prix" class="col-sm-2 control-label"><span style="color:red">* </span>Prix</label>
                                            <div class="col-sm-6">
                                              <input type="number" min="0" step="any" name="prix" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="categorieInput" class="col-sm-2 control-label"><span style="color:red">* </span>Categorie</label>
                                            <div class="col-sm-6">
                                                <select id="categorieInput" name="categorie" type="text" required="" class="form-control input-md">
                                                    <option value="SPORT">Sport</option>
                                                    <option value="CONCERT">Concert</option>
                                                    <option value="SPECTACLE">Spectacle</option>
                                                    <option value="DIVERS">Divers</option>
                                                    <option value="TOUTES" selected="">Toute catégorie</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="nombreTickets" class="col-sm-2 control-label"><span style="color:red">* </span>Places disponibles</label>
                                            <div class="col-sm-6">
                                              <input type="number" min="0" step="1" name="nombreTickets" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="description" class="col-sm-2 control-label"><span style="color:red">* </span>Description</label>
                                            <div class="col-sm-6">
                                                <textarea type="text" class="form-control" name="description"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <span style="color:red"> * champs obligatoires</span>
                                            </div>
                                            <div class="pull-right">
                                              <button type="submit" class="btn btn-default">Ajouter l'évenement</button>
                                            </div>
                                        </div>
                                  </form>
                                </div>
                                <div class="well">
                                    <form class="form-horizontal" action="Admin" method="POST"> 
                                        <input name="operation" type="hidden" value="remove">
                                        <div class="form-group">
                                            <label for="titre" class="col-sm-2 control-label"><span style="color:red">* </span>Titre</label>
                                            <div class="col-sm-6">
                                              <input name="titre" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <span style="color:red"> * champs obligatoires</span>
                                            </div>
                                            <div class="pull-right">
                                              <button type="submit" class="btn btn-default">Supprimer les évenement</button>
                                            </div>
                                        </div>
                                  </form>
                               </div>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
    </body>
</html>
