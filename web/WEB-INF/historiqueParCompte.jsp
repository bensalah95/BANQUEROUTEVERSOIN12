<%-- 
    Document   : voirClient
    Created on : 7 mars 2021, 17:25:59
    Author     : dylan55
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menuConseiller.jsp" %>

        <div class="container">
            <h1>Bonjour ${user.person.nom} !</h1>
            <br>
            <h4>Liste des opérations</h4>
            <br>
            <table class="table">
                <thead>
                    <tr class="table-active">
                        <th>Titulaire du compte</th>  
                        <th>Numéro de compte</th>
                        <th>Opération</th>
                        <th>Date d'opéartion</th>                    
                        <th>Montant de l'opération</th> 
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${historiques}" var="h">
                        <tr style="border: 1px solid black;">
                            <td>${h.person.prenom} ${h.person.nom}</td>  
                            <td>${h.compte.numcompte}</td>
                            <td>${h.typeOperations}</td>
                            <td>${h.dateOperations}</td>
                            <td>${h.montantOperations}</td>                         
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
