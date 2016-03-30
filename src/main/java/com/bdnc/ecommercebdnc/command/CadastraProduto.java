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
public class CadastraProduto implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = null;
            try {
                items = (List<FileItem>) upload.parseRequest(request);
                
                Produto produto = new Produto();
                produto.setFoto(items.get(0).get());
                produto.setDescricao(items.get(1).getString("UTF-8"));
                produto.setValor(Double.parseDouble(items.get(2).getString("UTF-8")));
                
                LojaService lojaService = new LojaService();
                lojaService.salvarProduto(produto);
                
                request.getSession().setAttribute("produtos", lojaService.listarProdutos());
                
                RequestDispatcher dispather = request.getRequestDispatcher("cadastroproduto.jsp");
                dispather.forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
