/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.command;

import com.bdnc.ecommercebdnc.entidades.Produto;
import com.bdnc.ecommercebdnc.service.LojaService;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Marcelo Augusto
 */
public class PerfilProduto implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            LojaService lojaService = new LojaService();
            Produto produto = lojaService.buscarProduto(Long.parseLong(request.getParameter("idProduto")));
            request.setAttribute("produto", produto);            
            request.setAttribute("produtosSugeridos", lojaService.buscarProdutosSugeridos(produto));

            RequestDispatcher dispather = request.getRequestDispatcher("produto.jsp");
            dispather.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
