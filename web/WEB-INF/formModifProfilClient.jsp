<%-- 
    Document   : formModifProfilConseiller
    Created on : 4 mars 2021, 23:27:22
    Author     : Nathan Ghozlan
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

        <!--    FORMULAIRE MODIF PROFIL -->
        <br><br><br>
        <div class="container">
            <form action="FormModifClient" method="POST">

                <div class="row">
                    <div class="col-md-6">
                        <img src="img/modifconseill.jpg" alt="Votre Carte bancaire">


                    </div>
                    <div class="col-md-6">
                        <div class="card shadow-card">
                            <div class="card-header card-header-back text-center bg-white">
                                <h5 style ="color:#B1476D;"> Modifier profil client</h5>
                            </div>
                            <div>
                                <div class="card-body">

                                    <div class="row "> 
                                        <div class="col-md-6">
                                            <label for="nom" class="my-label">Nom</label>
                                            <input type="text" class="form-control" value="${user.person.nom}" name="nom">

                                        </div>
                                        <div class="col-md-6">
                                            <label for="prenom" class="my-label">Prenom</label>
                                            <input type="text" class="form-control mb-2" value="${user.person.prenom}" name="prenom">
                                        </div>
                                    </div>


                                    <div class="row "> 
                                        <div class="col-md-6">
                                                <label for="login" class="my-label">Login</label>
                                        <input type="text" class="form-control" value="${user.login}" name="login">

                                        </div>
                                        <div class="col-md-6">
                                               <label for="mdp" class="my-label">Password</label>
                                        <input type="password" class="form-control" value="${user.mdp}" name="mdp">
                                        </div>
                                    </div>
                                        
                                             <div class="row "> 
                                        <div class="col-md-6">
                                             <label for="telephone" class="my-label">Téléphone</label>
                                        <input type="text" class="form-control" value="${user.person.telephone}" name="telephone">

                                        </div>
                                        <div class="col-md-6">
                                               <label for="sexe" class="my-label">Sexe</label>
                                        <input type="text" class="form-control" value="${user.person.sexe}" name="sexe">
                                        </div>
                                    </div>
                                        
                                          
                                             <div class="row "> 
                                        <div class="col-md-6">
                                         <label for="dateNaissance" class="my-label">Date de naissance</label>
                                        <input type="date" class="form-control" value="${user.person.dateNaissance}" name="dateNaissance">

                                        </div>
                                        <div class="col-md-6">
                                               <label for="email" class="my-label">Email</label>
                                        <input type="mail" class="form-control" value="${user.person.email}" name="email">
                                        </div>
                                    </div>
                                        
                                        

                                
                                    <div class="mb-3">
                                        <label for="adresse" class="my-label">Adresse</label>
                                        <input type="text" class="form-control" value="${user.person.address}" name="adresse">
                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary btn-block">Modifier profil</button>
                                        <button type="reset" class="btn btn-danger btn-block">Annuler</button>

                                    </div>
                                    <input type="hidden" name="idperson" value="${user.person.id}">
                                    <p class="text-center text-danger" id="msg"> ${msg} </p>
                                </div>
                            </div>
                        </div>
                    </div>          
                </div>
            </form>      
        </div> 
    </body>
</html>
