/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.command;

import com.bdnc.ecommercebdnc.entidades.CarrinhoDeCompras;
import com.bdnc.ecommercebdnc.entidades.Produto;
import com.bdnc.ecommercebdnc.service.LojaService;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class AdicionarProdutoNoCarrinho implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            CarrinhoDeCompras carrinhoDeCompras = null;
            String idSessao = request.getSession().getId();
            LojaService lojaService = new LojaService();

            String idSalvo = lojaService.buscarIdSessao();
            if (idSalvo != null && idSalvo.equals(idSessao)) {
                carrinhoDeCompras = lojaService.buscarCarrinhoDeCompras();
            }

            if (carrinhoDeCompras == null) {
                carrinhoDeCompras = new CarrinhoDeCompras();
            }

            List<Produto> produtos = carrinhoDeCompras.getProdutos();
            long idProduto = Long.parseLong(request.getParameter("idProduto"));
            Produto produto = null;
            for (Produto p : produtos) {
                if (p.getId() == idProduto) {
                    p.setQuantidadeVenda(p.getQuantidadeVenda() + 1);
                    produto = p;
                    break;
                }

            }
            if (produto == null) {
                produto = lojaService.buscarProduto(idProduto);
                produto.setQuantidadeVenda(1);
                carrinhoDeCompras.adicionarProduto(produto);
            }
            
            lojaService.salvarCarrinhoDeCompras(carrinhoDeCompras);

            request.getSession().setAttribute("carrinho", carrinhoDeCompras);
            RequestDispatcher dispatcher = request.getRequestDispatcher("meucarrinho.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
