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
public class LoginCliente implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            ClienteService clienteService = new ClienteService();
            LojaService lojaService = new LojaService();
            Cliente cliente = clienteService.logar(request.getParameter("email"), request.getParameter("senha"));
            
            if (cliente != null) {
                request.getSession().setAttribute("cliente", cliente);
                lojaService.salvarIdSessao(request.getSession().getId());
                RequestDispatcher dispather = request.getRequestDispatcher("Controller?command=CarregaLoja");
                dispather.forward(request, response);
            }
            
            RequestDispatcher dispather = request.getRequestDispatcher("login.jsp");
            dispather.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
