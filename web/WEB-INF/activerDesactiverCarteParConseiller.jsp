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
            <h4>Liste des comptes</h4>
            <br>
            <table class="table">
                <thead>
                    <tr class="table-active">
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Prénom</th>
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
                            <td>${c.id}</td>
                            <td>${c.person.nom}</td>
                            <td>${c.person.prenom}</td>
                            <td>${c.numcompte}</td>
                            <td>${c.solde}</td>
                            <td>${c.numcarte}</td>
                            <td>${c.etatcarte == true ? 'Activée': 'Désactivée'}</td>
                            <td><button type="submit" onClick="location.href ='activationCarte?idcompte=${c.id}'" class="btn btn-success">${c.etatcarte == true ? 'Désactiver la carte': 'Activer la carte'}</button></td>                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script type="text/javascript" src="app.js"></script>
    </body>
</html>
