<nav class="navbar navbar-inverse">
    <div class="container-fluid" style="margin-left: 10%; margin-right: 10%" >
        <div class="navbar-header" id="brand" style="margin-top: 10px;margin-bottom: 6px">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" style="margin-top: 12px" href="index.jsp">
                <b style="font-size: 25px; color: white">marceloeletro.com</b>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="margin-top: 10px;margin-bottom: 5px">
            <form class="navbar-form navbar-left" role="search"style="margin-left: 10%; margin-top: 20px">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="O que você procura?">
                </div>
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
            </form>
            <b style="color: white;"> Olá ${cliente.nome}</b>
            <ul class="nav navbar-nav navbar-right">

                <li>
                    <a href="meucarrinho.jsp">
                        <img src="imagens/shopping-cart.png" height="35" width="35">(${carrinho.qtdItens})item<br>Meu carrinho
                    </a>
                </li>
                <li><a href="Controller?command=Logout" style="margin-top:12px">Sair</a></li>
            </ul>
        </div>
    </div>
</nav>