/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.service;

import com.bdnc.ecommercebdnc.dao.DAO;
import com.bdnc.ecommercebdnc.dao.DAOJPA;
import com.bdnc.ecommercebdnc.entidades.Cliente;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Marcelo Augusto
 */
public class ClienteService {

    private DAO<Cliente> daoCliente = new DAOJPA<>();

    public boolean salvar(Cliente cliente) {
        return daoCliente.salvar(cliente);
    }

    public Cliente logar(String email, String senha) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("email", email);
        try {
            Cliente cliente = daoCliente.consultaSimples("cliente.buscar", parametros);
            if (cliente != null && cliente.getSenha().equals(senha)) {
                return cliente;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Cliente buscarPorEmail(String email){
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("email", email);
        return daoCliente.consultaSimples("cliente.buscar", parametros);
    } 

}
