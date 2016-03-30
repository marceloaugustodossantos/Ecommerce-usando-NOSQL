<%-- 
    Document   : login
    Created on : 07/03/2016, 17:17:13
    Author     : Marcelo Augusto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marceloeletro.com</title>
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
            <div class="col-md-6 col-xs-10 col-md-offset-3 col-xs-offset-1" style="margin-top: 25px">
                <div>
                    <h2 style="text-align: center; margin-bottom: 25px">Acesse sua conta</h2>
                </div>
                <form class="form-horizontal" action="Controller?command=LoginCliente" method="post">
                    <div>
                        <label class="col-md-offset-1">Email</label>
                        <div class="form-group">
                            <div class="col-md-10 col-md-offset-1">
                                <input type="email" name="email" class="form-control" id="inputUser" placeholder="email" required="on">
                            </div>
                        </div>
                        <label class="col-md-offset-1">Senha</label>
                        <div class="form-group">
                            <div class="col-md-10 col-md-offset-1">
                                <input type="password" name="senha" class="form-control" id="inputSenhaLogin" placeholder="Senha" required="on">
                            </div>
                        </div>
                        <div class="form-group" id="checkLembrar">
                            <div class="col-md-7 col-md-offset-1">
                                <div class="checkbox">
                                    <label><input type="checkbox">Lembrar-me</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-7 col-md-offset-1">
                            <button type="submit" id="btEntrar" class="btn btn-lg btn-success">Entrar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
