/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.command;

import com.bdnc.ecommercebdnc.entidades.Cliente;
import com.bdnc.ecommercebdnc.entidades.Endereco;
import com.bdnc.ecommercebdnc.service.ClienteService;
import com.bdnc.ecommercebdnc.service.LojaService;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcelo Augusto
 */
public class CarregaLoja implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            LojaService lojaService = new LojaService();
            request.getSession().setAttribute("produtos", lojaService.listarProdutos());
            RequestDispatcher dispather = request.getRequestDispatcher("index.jsp");
            dispather.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
