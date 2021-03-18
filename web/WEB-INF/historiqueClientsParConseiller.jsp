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
            <h4>Listes des comptes</h4>
            <br>
            <table class="table">
                <thead>
                    <tr class="table-active">
                        <th>Titulaire du compte</th>
                        <th>Numéro de compte</th>                    
                        <th>Solde</th> 
                        <th>Numéro de carte</th>                                           
                        <th>Etat de carte</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${comptes}" var="c">
                        <tr style="border: 1px solid black;">
                            <td>${c.person.nom} ${c.person.prenom}</td>
                            <td>${c.numcompte}</td>
                            <td>${c.solde}</td>
                            <td>${c.numcarte}</td>
                            <td>${c.etatcarte == true ? 'Activée': 'Désactivée'}</td>
                            <td><button type="button" onClick="location.href ='historiquesComptes?idcompte=${c.id}'" class="btn btn-success">Voir historique</button></td>                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
