<%-- 
    Document   : EnteteClient
    Created on : Mar 5, 2021, 9:57:18 AM
    Author     : marye
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

        <title>Client</title>
    </head>
    <body>
  
        
      <div class="container center mt-2">
            <h6 class="titre text-danger">
                <span class="name">  </span> </h6>

            <div class="container-fluid">
                <nav class="navbar navbar-expand-md  navbar-white bg-white">
                    <div class="collapse navbar-collapse  justify-content-between" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active font-weight-bold px-3 px-3" aria-current="page" href="MenuClient">Comptes et cartes</a>
                            </li>
                            
                            <li class="nav-item">
                                <a class="nav-link active font-weight-bold px-3" href="MesCartes">Mes cartes</a>
                            </li>  
                            <li class="nav-item">
                                <a class="nav-link active font-weight-bold px-3" href="HistoriqueServlet">Historiques</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active font-weight-bold px-3" href="EpargneServlet">Epargne</a>
                            </li>
                        </ul> 
        
        


                        <ul class="navbar-nav"><li class="nav-item">
                                <a class="nav-link active font-weight-bold px-3 fas fas fa-store fa-2x material-icons "style ="color:purple; "href="Achat" ></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active font-weight-bold px-3 fas fa-bell fa-2x material-icons "style ="color:orange; "href="#" title="Pas de Notification" data-toggle="popover" data-trigger="hover" data-content="pas de notifications"></a>
                           
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active font-weight-bold px-3 fas fa-comments fa-2x material-icons " style ="color:blue;"href=MessageServlet></a>
                            </li>
                           
                            <li class="nav-item">
                                <a class="nav-link active font-weight-bold px-3 fas fa-user-edit fa-2x material-icons " style ="color:green;"href=majClient></a>
                            </li>
                             <li class="nav-item">
                                <a class="nav-link active font-weight-bold px-3 fas fa-power-off fa-2x material-icons" style ="color:red; " href="DeconnexionServlet">  <span> <h6>

                                                ${user.person.nom}
                                        </h6>
                                    </span>
                                </a>
                            </li>
                           
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </body>
</html>
