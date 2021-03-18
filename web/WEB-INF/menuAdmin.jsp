<%-- 
    Document   : menu
    Created on : 26 févr. 2021, 10:40:18
    Author     : polnareff
--%>

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

        <br>
        <div class="container mt-2">
            <ul class="nav navbar-nav w-100 justify-content-between">

                <ul class="nav nav-tabs">
                    <li class="nav-item">
                        <a class="nav-link " style ="color:blue; " href="InscriptionConseillerServlet">Créer un compte conseiller</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " style ="color:green;"href="ActiverConseiller">Activer/Désactiver compte conseiller</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link "style ="color:purple;" href="ModifProfilCons">Modifier profil conseiller</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style ="color:red;" href="formHistoriqueCons">Historique</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " style ="color:brown;" href="inscriptionAdmin">Ajouter un compte admin</a>
                    </li>



                    <li class="nav-item">
                        <a class="nav-link  font-weight-bold px-3 fas fa-power-off fa-2x material-icons" style ="color:blue; " href="DeconnexionServlet">  <span> <h6>

                                    ${user.person.nom}
                                </h6>
                            </span>
                        </a> 
                    </li>
                    
                    
                </ul>

            </ul>

        </div>

        <div class="row"> 
            <div class="col-md-3">

            </div>
            <div class="col-md-5">

                <img src="img/admin.jpg" alt="Votre Carte bancaire">
            </div>
        </div>
    </body>
</html>
