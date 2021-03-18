<%-- 
    Document   : modifProfilConseiller
    Created on : 4 mars 2021, 20:58:18
    Author     : Nathan Ghozlan
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="style_1.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/c441cb6851.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="style_1.css">

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>

    </head>
    <body>
        <div>

           <nav class="navbar navbar-expand-lg navbar-white bg-white">
            <div class="collapse navbar-collapse " id="navbarNav">
                <ul class="navbar-nav nav-fill w-100">
                    <li class="nav-item active">
                        <a class="nav-link active font-weight-bold px-3 fas fa-home fa-2x material-icons "style ="color:blue; "href="AccueilServlet" ></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link  font-weight-bold px-3 fas fa-power-off fa-2x material-icons" style ="color:blue; " href="DeconnexionServlet">  <span> <h6>
                                    ${user.person.nom}
                                </h6>
                            </span>
                        </a> 
                    </li>
                </ul>
            </div>
        </nav>

                                <br>
  
            <h5 style ="color:#B14797; ">Listes des clients</h5>
            <table class="table">
                <thead>
                    <tr class="table-info">
                        <!--<th>ID</th>-->
                        <th>Nom</th>                    
                        <th>Prenom</th>
                        <th>Sexe</th>
                        <th>Naissance</th>
                        <th>Téléphone</th>
                        <th>Mail</th>
                        <th>Adresse</th> 
                        <th>LOGIN</th>
                        <th>PASSWORD</th>
                        <th>MODIFICATIONS PROFILS</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${users}" var="u">

                        <tr style="border: 1px solid black;">
                            <!--<td>${u.person.id}</td>-->
                            <td>${u.person.nom}</td>
                            <td>${u.person.prenom}</td>
                            <td>${u.person.sexe}</td>
                            <td>${u.person.dateNaissance}</td>
                            <td>${u.person.telephone}</td>
                            <td>${u.person.email}</td>
                            <td>${u.person.address}</td>
                            <td>${u.login}</td>
                            <td>${u.mdp}</td>
                    <form action="ModifProfilClient" method="POST">
                        <input type="hidden" value="${u.id}" name="iduser">
                        <input type="hidden" value="${u.person.id}" name="idperson">

                        <td><button  type="submit" class="btn btn-outline-success" >Modifier Infos Profil</button> </td>
                    </form>
                    </tr>

                </c:forEach>

                </tbody>
            </table>
            
            <div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <img src="img/modifprofilconsei.jpg"alt="Votre Carte bancaire">
    </div></div>
        </div>
    </body>
</html>




