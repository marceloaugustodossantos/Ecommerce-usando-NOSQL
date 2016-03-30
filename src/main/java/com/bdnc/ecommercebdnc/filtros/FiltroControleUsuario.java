/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.filtros;

import com.bdnc.ecommercebdnc.service.ClienteService;
import com.bdnc.ecommercebdnc.service.LojaService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marcelo
 */
public class FiltroControleUsuario implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {   
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = ((HttpServletRequest) request).getSession();
//        if(session.getAttribute("cliente" ) != null){
//            
//        }
        if(session.getAttribute("produtos" ) == null){
            LojaService lojaService = new LojaService();
            session.setAttribute("produtos", lojaService.listarProdutos());
        }       
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
