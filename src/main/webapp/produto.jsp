<%-- 
    Document   : produto
    Created on : 14/03/2016, 17:11:23
    Author     : marcelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Commerce BDNC</title>
        <link  href="css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link  href="css/style.css" rel="stylesheet" type="text/css">
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>    
        <meta name="viewport" content="width=device-width, minimum=scale= 1.0, initial=scale=1, user-scalable=yes"/> 
    </head>
    <body>        
        <header>
            <c:choose>
                <c:when test="${cliente == null}">
                    <nav class="navbar navbar-inverse">
                        <div class="container-fluid" style="margin-left: 10%; margin-right: 10%" >
                            <div class="navbar-header" id="brand" style="margin-top: 10px;margin-bottom: 6px">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="index.jsp">
                                    <b style="font-size: 22px; color: white">marceloeletro.com</b>
                                </a>
                            </div>
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="margin-top: 10px;margin-bottom: 5px">
                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <a href="meucarrinho.jsp">
                                            <img src="imagens/shopping-cart.png" height="35" width="35">(${carrinho.qtdItens})item              
                                        </a>
                                    </li>
                                    <li><a href="login.jsp">Login</a></li>
                                    <li><a href="cadastro.jsp">Cadastre-se</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </c:when>
                <c:when test="${cliente != null}">
                    <nav class="navbar navbar-inverse">
                        <div class="container-fluid" style="margin-left: 10%; margin-right: 10%" >
                            <div class="navbar-header" id="brand" style="margin-top: 10px;margin-bottom: 6px">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="index.jsp">
                                    <b style="font-size: 22px; color: white">marceloeletro.com</b>
                                </a>
                            </div>
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="margin-top: 10px;margin-bottom: 5px">
                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <a href="meucarrinho.jsp">
                                            <img src="imagens/shopping-cart.png" height="35" width="35">(${carrinho.qtdItens})item              
                                        </a>
                                    </li>
                                    <li><a href="Controller?command=Logout" style="margin-top:12px">Sair</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </c:when>
            </c:choose> 
        </header>

        <div class="container" >
            <div class="col-md-8" style="margin-left: 16%; margin-right: 16%;">
                <h2 class="h2" style="text-align: left">${produto.descricao}</h2>
                <div class="col-md-6">
                    <img src="Controller?command=Imagem&idProduto=${produto.id}" height="350" width="350">                    
                </div>
                <div class="col-md-6" style="padding-top: 12%">
                    <div style="padding: 20px; background-color: #e4e4e4">
                        <b style="color: red; font-size: 40px">R$ ${produto.valor}</b><br>
                        <a href="Controller?command=AdicionarProdutoNoCarrinho&idProduto=${produto.id}" class="btn btn-success" style="font-size: 22px">Adicionar ao carrinho</a>
                    </div>
                </div>
            </div>

            <div class="col-md-10" style="margin-left: 10%; margin-right: 10%;margin-top: 30px">
                <b class="h1">Quem comprou esse produto também comprou</b><br><br>
                <c:forEach var="p" items="${produtosSugeridos}">
                    <div class="col-sm-6 col-md-3">
                        <a href="Controller?command=PerfilProduto&idProduto=${p.id}">
                            <div class="thumbnail"style="text-align: center">
                                <img src="Controller?command=Imagem&idProduto=${p.id}" alt="...">
                                <div class="caption">
                                    <p>${p.descricao}</p>
                                    <h3>R$ ${p.valor}</h3>
                                </div>
                            </div>
                        </a>
                    </div>                    
                </c:forEach>
            </div>
        </div>

        <footer>
            <div style="width: 100%; background-color: #e00000; padding: 15px; margin-top: 25px">
                <p style="text-align: center; font-size: 22px; color:white">marceloeletro.com &copy; 2016</p>
            </div>
        </footer>                            

    </body>
</html>
