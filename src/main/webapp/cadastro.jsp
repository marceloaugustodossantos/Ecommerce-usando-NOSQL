<%-- 
    Document   : cadastro
    Created on : 07/03/2016, 17:17:23
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
            <form class="form-horizontal" action="Controller?command=CadastraCliente" method="post">
                <div class="col-md-7" id="formCadastroCliente">
                    <h3 style="text-align: center;">Dados cadastrais</h3>
                    <label for="nome">Nome completo</label>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" name="nome" required="on" class="form-control input-sm" id="nome" placeholder="Nome completo">
                        </div>
                    </div>
                    <div class="form-group" id="cpf">
                        <div class="col-md-6">
                            <label for="inputCpf">CPF</label>
                            <input type="text" name="cpf" required="on" class="form-control input-sm" id="inputCpf"placeholder="CPF">
                        </div>
                        <div class="col-md-6">
                            <label for="inputTelefone">Telefone</label>
                            <input type="text" name="telefone" class="form-control input-sm" id="inputTelefone" placeholder="Telefone">
                        </div>
                    </div>
                    <label for="inputEmail">Email</label>
                    <div class="form-group" id="email">
                        <div class="col-md-12">
                            <input type="text" name="email" class="form-control input-sm" id="inputEmail" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group" id="rua">
                        <div class="col-md-9">
                            <label for="inputRua">Rua</label>
                            <input type="text" name="rua" class="form-control input-sm" id="inputRua" placeholder="Rua">
                        </div>
                        <div class="col-md-3">
                            <label for="inputNumero">Número</label>
                            <input type="number" name="numero" class="form-control input-sm" id="inputNumero" placeholder="Número">
                        </div>
                    </div>
                    <div class="form-group"id="logradouro">
                        <div class="col-md-12">
                            <label for="inputLogradouro">Logradouro</label>
                            <input type="text" name="bairro" class="form-control input-sm" id="inputLogradouro" placeholder="Logradouro">
                        </div>
                    </div>
                    <div class="form-group"id="cidade">
                        <div class="col-md-7">
                            <label for="inputCidade" >Cidade</label>
                            <input type="text" name="cidade" class="form-control input-sm" id="inputCidade" placeholder="Cidade">
                        </div>
                        <div class="col-md-5">
                            <label for="inputEstado">Estado</label>
                            <input type="text" name="estado" class="form-control input-sm" id="inputEstado" placeholder="Estado">
                        </div>
                    </div>
                    <div class="form-group" id="senhaEscola">
                        <div class="col-md-6">
                            <label for="inputSenhaEscola">Senha</label>
                            <input type="password" name="senha1" class="form-control input-sm" id="inputSenhaEscola" placeholder="Senha">
                        </div>
                        <div class="col-sm-6">
                            <label for="inputConfirmarSenhaEscola">Confirmar senha</label>                                
                            <input type="password" name="senha2" class="form-control input-sm" id="inputConfirmarSenhaEscola" placeholder="Confirmar Senha" >
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-4">
                            <input type="submit" class="btn btn-success btn-lg" value="Solicitar cadastro">
                        </div>
                    </div>
                </div>
            </form>
            <div class="col-md-8" style="margin-left: 18%; margin-right: 18%"> 
                <p style="margin: 15px">
                    Cadastre-se na maior loja online do Brasil (não se preocupe, seus dados serão protegidos), 
                    aproveite promoções, ofertas exclusivas e agilize suas compras com o "caixa expresso".
                </p>                
            </div>
        </div> 

        <footer>
            <div style="width: 100%; background-color: #e00000; padding: 15px; margin-top: 25px">
                <p style="text-align: center; font-size: 22px; color:white">marceloeletro.com &copy; 2016</p>
            </div>
        </footer> 
    </body>
</html>
