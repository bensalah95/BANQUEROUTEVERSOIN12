<%-- 
    Document   : formHistoriqueConseiller
    Created on : 18 mars 2021, 15:49:35
    Author     : Nathan Ghozlan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4 style ="color:#9376BD; ">Historique des conseillers:</h4>
        <table class="table">
            <thead>
                <tr  class="table-primary">
                    <th>Label</th>
                </tr>
            </thead>


            <tbody>

                <c:forEach items="${hist}" var="h">

                    <tr style="border: 1px solid black;">
                        <td>${h.nom}</td>
                    </tr>

                </c:forEach>

            </tbody>
        </table>
    </body>
</html>
