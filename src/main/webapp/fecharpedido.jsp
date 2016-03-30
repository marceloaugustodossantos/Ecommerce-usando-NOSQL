<%-- 
    Document   : fecharpedido
    Created on : 24/03/2016, 15:31:27
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
            <div class="col-md-8">
                <label class="h2">Revisão da sua compra<span class="glyphicon glyphicon-search" aria-hidden="true"></span></label><br>

                <label class="h3">Endereço de entrega</label>
                <a href="#" class="btn btn-default" style="margin-left: 15px">Alterar endereço de entrega</a><br>
                <label class="h4" style="font-weight: bold">${cliente.nome}</label><br>
                <label class="h5">${cliente.endereco.rua} ${cliente.endereco.numero}</label><br>
                <label class="h5">${cliente.endereco.cidade}</label><br>

                <label class="h3">Sua compra</label><br>

                <c:forEach var="produto" items="${carrinho.produtos}">
                    <div class="col-md-10">
                        <div class="col-md-1"><img src="Controller?command=Imagem&idProduto=${produto.id}" height="40" width="40"> </div>
                        <div class="col-md-11"> 
                            <b>${produto.quantidadeVenda}</b>${produto.descricao} 
                            <b>R$ ${produto.valor}</b>
                        </div>                 
                    </div>
                </c:forEach>
                <label class="h3">Total da compra: R$ ${carrinho.valorParcial}</label><br>
            </div>

            <div class="col-md-4" style="margin-top:40px">
                <label class="h3">Dados do pagamento<span class="glyphicon glyphicon-usd" aria-hidden="true"></span></label><br><br>
                <form class="form-horizontal" action="Controller" method="get">
                    <input type="hidden" name="command" value="FecharCompra"/> 
                    <label for="prestadora">Prestadora do cartão</label>
                    <select name="prestadora" class="form-control input-sm">
                        <option value="visa">Visa</option>
                        <option value="master">Master-Card</option>
                        <option value="hiper">Hiper-Card</option>
                    </select>
                    <label for="nome">Nome do titular do cartão</label>
                    <div class="form-group" id="nome">
                        <div class="col-md-12">
                            <input type="text" name="nome" class="form-control input-sm" id="inputEmail" placeholder="Nome">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6">
                            <label for="numero">Número do cartão</label>
                            <input type="text" name="numero" class="form-control input-sm" id="numero" placeholder="Número do cartão">
                        </div>
                        <div class="col-md-6">
                            <label for="codigo">Código de segurança</label>
                            <input type="password" name="codigo" class="form-control input-sm" id="codigo" placeholder="Código de segurança">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 30px">
                        <div class="col-md-6">
                            <button type="submit" class="btn btn-lg btn-success">Finalizar compra</button>
                        </div>
                    </div>
                </form>
            </div>        
        </div>
    </body>
</html>
