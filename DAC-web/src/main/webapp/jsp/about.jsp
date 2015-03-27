<%-- 
    Document   : about
    Created on : 8 mars 2015, 16:26:21
    Author     : andreiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/jspf/header.jspf" />
    <%@ include file="/jspf/nav.jspf" %>
    <%@ include file="/jspf/messages.jspf" %>
    <head>
        <title>About Us</title>
    </head>
    <body>
        <div class="col-md-4">
            <%@ include file="/jspf/user.jspf" %>
        </div>
        <div class="container">
            <div class="row">
                <h1>A bunch of geek :</h1>
                ANDREI Yannick </br>
                BATON Francois </br>
                CARIVEN Mathieu </br>
                DUFOUR Aurélien </br>
                LEMAIRE Thomas</br>
                LINARES Clément </br>
                POUZAUD Romain </br>
            </div>
        </div>
    </body>
</html>
