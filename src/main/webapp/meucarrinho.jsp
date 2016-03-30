<%-- 
    Document   : produto
    Created on : 14/03/2016, 17:11:23
    Author     : marcelo
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
                                    <li><a href="#"style="margin-top:12px">Olá ${cliente.nome}</a></li>
                                    <li><a href="Controller?command=Logout" style="margin-top:12px">Sair</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </c:when>
            </c:choose> 
        </header>

        <div class="container" >
            <div class="col-md-10 col-md-offset-1">
                <label class="h2">Meu carrinho</label>
                <table class="table">
                    <tr class="active">
                        <td><b>Produto</b></td>
                        <td><b>Quantidade</b></td>
                        <td><b>Preço Unitário</b></td>
                        <td><b>Preço Total</b></td>
                    </tr>
                    <c:forEach var="produto" items="${carrinho.produtos}">
                        <tr>
                            <td>
                                <div class="col-md-2"><img src="Controller?command=Imagem&idProduto=${produto.id}" height="80" width="80"> </div>
                                <div class="col-md-10"> ${produto.descricao}</div>
                            </td>
                            <td>
                                <div>
                                    <form action="Controller?command=AlterarQuantidadeProduto&idProduto=${produto.id}">
                                        <input  style="width: 40px" type="number" min="0" max="10" name="quantidade" value="${produto.quantidadeVenda}">
                                        <button type="submit"> <span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></button>
                                    </form>
                                        <a href="Controller?command=AlterarQuantidadeProduto&idProduto=${produto.id}&quantidade=1">+1</a>
                                </div>
                            </td>

                            <td>${produto.valor}</td>
                            <td>${produto.valorComQuantidade}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="3"><b class="h3">Total</b></td>
                        <td>${carrinho.valorParcial}</td>
                    </tr>
                </table>
                <div class="col-md-3">
                    <a href="index.jsp" class="btn btn-info">Comprar mais produtos</a>
                </div>
                <div class="col-md-2 col-md-offset-7">
                    <a href="fecharpedido.jsp" class="btn btn-lg btn-success">Finalizar pedido</a>
                </div>
            </div>
        </div>
    </body>
</html>
