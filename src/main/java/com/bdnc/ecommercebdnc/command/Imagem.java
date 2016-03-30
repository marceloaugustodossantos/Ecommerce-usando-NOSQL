/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.command;

import com.bdnc.ecommercebdnc.entidades.Produto;
import com.bdnc.ecommercebdnc.service.LojaService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcelo Augusto
 */
public class Imagem implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            service(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte[] foto = null;

        long id = Long.parseLong(request.getParameter("idProduto"));
        
        LojaService lojaService = new LojaService();

        Produto produto = lojaService.buscarProduto(id);

        if (produto != null) {
            foto = produto.getFoto();
        }

        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        ServletOutputStream out = response.getOutputStream();
        out.write(foto);
        out.flush();
        out.close();
    }

}
