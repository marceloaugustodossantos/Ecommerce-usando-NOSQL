<%-- 
    Document   : index
    Created on : 07/03/2016, 15:08:15
    Author     : Marcelo Augusto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <%@include file="navbarNaoLogado.jsp" %>
                </c:when>
                <c:when test="${cliente != null}">
                    <%@include file="navbarLogado.jsp" %>
                </c:when>
            </c:choose>                            
        </header>

        <div class="container">

            <div class="col-md-12" id="banner-saldao">
                <b>SALDÃO até 40% de desconto</b>
            </div>

            <div class="col-md-3">
                <ul style="list-style: none;">
                    <li class="h4" style="margin-top: 10px;"><a href="#"> TVs, áudio e home theater</a></li>
                    <li class="h4" style="margin-top: 20px"><a href="#"> Informática</a></li>
                    <li class="h4" style="margin-top: 20px"><a href="#"> Eletrodomésticos</a></li>
                    <li class="h4" style="margin-top: 20px"><a href="#"> Celulares</a></li>
                </ul>
            </div>

            <div class="col-md-9">
                <c:forEach var="produto" items="${produtos}">
                    <div class="col-sm-6 col-md-4">
                        <a href="Controller?command=PerfilProduto&idProduto=${produto.id}">
                            <div class="thumbnail"style="text-align: center">
                                <img src="Controller?command=Imagem&idProduto=${produto.id}" alt="...">
                                <div class="caption">
                                    <p>${produto.descricao}</p>
                                    <h3>R$ ${produto.valor}</h3>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>

    </body>
</html>
