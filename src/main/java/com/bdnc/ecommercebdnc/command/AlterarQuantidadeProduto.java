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

/**
 *
 * @author marcelo
 */
public class AlterarQuantidadeProduto implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            CarrinhoDeCompras carrinhoDeCompras;
            String idSessao = request.getSession().getId();
            LojaService lojaService = new LojaService();

            if (lojaService.buscarIdSessao().equals(idSessao)) {
                carrinhoDeCompras = lojaService.buscarCarrinhoDeCompras();
                if (carrinhoDeCompras == null) {
                    carrinhoDeCompras = new CarrinhoDeCompras();
                }
            } else {
                carrinhoDeCompras = new CarrinhoDeCompras();
            }

            Produto produto = lojaService.buscarProduto(Long.parseLong(request.getParameter("idProduto")));
            carrinhoDeCompras.getProdutos().remove(produto);
            int qtd = Integer.parseInt(request.getParameter("quantidade"));
            if (qtd == 0) {
                carrinhoDeCompras = lojaService.removerProdutoCarrinho(carrinhoDeCompras, produto);
            } else {
                produto.setQuantidadeVenda(qtd);
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
