/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.command;

import com.bdnc.ecommercebdnc.entidades.CarrinhoDeCompras;
import com.bdnc.ecommercebdnc.entidades.Cliente;
import com.bdnc.ecommercebdnc.entidades.Compra;
import com.bdnc.ecommercebdnc.entidades.Pagamento;
import com.bdnc.ecommercebdnc.entidades.Produto;
import com.bdnc.ecommercebdnc.service.LojaService;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class FecharCompra implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            CarrinhoDeCompras carrinhoDeCompras = null;
            String idSessao = request.getSession().getId();
            LojaService lojaService = new LojaService();

            if (lojaService.buscarIdSessao().equals(idSessao)) {
                carrinhoDeCompras = lojaService.buscarCarrinhoDeCompras();
            }

            if (carrinhoDeCompras != null) {
                Compra compra = new Compra();
                compra.setCarrinho(carrinhoDeCompras);
                compra.setCliente((Cliente)request.getSession().getAttribute("cliente"));
                compra.setData(new Date(System.currentTimeMillis()));
                compra.setEnderecoEntrega(compra.getCliente().getEndereco());
                Pagamento pagamento = new Pagamento();
                pagamento.setPrestadora(request.getParameter("prestadora"));
                pagamento.setTitular(request.getParameter("titular"));
                pagamento.setNumero(Integer.parseInt(request.getParameter("numero")));
                pagamento.setCodigoSeguranca(request.getParameter("codigo"));
                compra.setPagamento(pagamento);
                lojaService.salvarCompra(compra);
                lojaService.limparCarrinho(carrinhoDeCompras);
                request.getSession().removeAttribute("carrinho");
                response.sendRedirect("index.jsp");
            }
            
            response.sendRedirect("fecharpedido.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
