<%-- 
    Document   : cadastroproduto
    Created on : 14/03/2016, 15:12:56
    Author     : marcelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="Content-Language" content="pt-br" />
        <link  href="css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link  href="css/style.css" rel="stylesheet" type="text/css">
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>    
        <meta name="viewport" content="width=device-width, minimum=scale= 1.0, initial=scale=1, user-scalable=yes"/>
    </head>
    <body>

        <header>
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
        </header>

        <div class="container">
            <div style="" class="col-md-10 col-md-offset-1">
                <h2 style=" border-bottom: 1px solid;">Cadastrar produto</h2><br>
                <form  action="Controller?command=CadastraProduto" class="form-horizontal" enctype="multipart/form-data" method="post">
                    <div class="col-md-5" >
                        <div class="row">
                            <div class="col-md-10 col-md-offset-1">
                                <img id="image" src="imagens/product.png" height="250" width="250"/>
                            </div>
                        </div>
                        <div class="row">
                            <label class="">Envie uma foto do produto</label>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <input class="form-control" type="file" required="on" accept="image/*"  name="foto">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-7">
                        <label for="nome" >Descrição</label>
                        <div class="form-group">
                            <div class="col-md-10">
                                <textarea name="descricao" required="on" rows="4" class="form-control" id="nome" placeholder="Descreva o produto"></textarea>
                            </div>
                        </div>
                        <label for="nome" >Valor R$</label>
                        <div class="form-group">
                            <div class="col-md-10">
                                <input type="number" name="valor" required="on" class="form-control" id="nome" placeholder="Valor">
                            </div>
                        </div>
                        <label for="turmas">Departamento</label>
                        <div class="form-group">
                            <div class="col-md-10">
                                <select class="form-control" id="turmas" name="idTurma">
                                    <c:choose>
                                        <c:when test="${turmas != null}">
                                            <c:forEach var="turma" items="${turmas}">                                                
                                                <option value="${turma.id}">${turma.nomeTurma}</option>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="nenhuma">Nenhuma turma cadastrada</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3 col-lg-offset-0" id="btCadastraAluno">
                                <button type="submit" class="btn btn-success btn-lg" >Adicionar produto</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>            
    </body>
</html>
