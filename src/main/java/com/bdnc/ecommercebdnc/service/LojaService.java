/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.service;

import com.bdnc.ecommercebdnc.dao.DAO;
import com.bdnc.ecommercebdnc.dao.DAODocumentos;
import com.bdnc.ecommercebdnc.dao.DAOGrafo;
import com.bdnc.ecommercebdnc.dao.DAOJPA;
import com.bdnc.ecommercebdnc.entidades.CarrinhoDeCompras;
import com.bdnc.ecommercebdnc.entidades.Compra;
import com.bdnc.ecommercebdnc.entidades.Produto;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import redis.clients.jedis.Jedis;

/**
 *
 * @author marcelo
 */
public class LojaService {

    private DAO<Produto> daoProduto = new DAOJPA<>();
    private DAODocumentos daoCompra = new DAODocumentos();
    private DAOGrafo daoGrafo = new DAOGrafo();

    public boolean salvarProduto(Produto produto) {
        return daoProduto.salvar(produto);
    }

    public List<Produto> listarProdutos() {
        return daoProduto.consultaLista("produtos.todos", null);
    }

    public Produto buscarProduto(long id) {
        return daoProduto.buscar(id, Produto.class);
    }

    public boolean salvarCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras) {
        Gson gson = new Gson();
        String aux = gson.toJson(carrinhoDeCompras);
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.setex("carrinho", 43200, aux);
        jedis.close();
        return true;
    }

    public CarrinhoDeCompras buscarCarrinhoDeCompras() {
        Gson gson = new Gson();
        Jedis jedis = new Jedis("localhost", 6379);
        String aux = jedis.get("carrinho");
        CarrinhoDeCompras carrinho = gson.fromJson(aux, CarrinhoDeCompras.class);
        jedis.close();
        return carrinho;
    }

    public CarrinhoDeCompras removerProdutoCarrinho(CarrinhoDeCompras carrinhoDeCompras, Produto produto) {
        List<Produto> produtos = carrinhoDeCompras.getProdutos();
        for (Produto p : produtos) {
            if (p.getId() == produto.getId()) {
                produtos.remove(p);
            }
        }
        carrinhoDeCompras.setProdutos(produtos);
        return carrinhoDeCompras;
    }

    public void limparCarrinho(CarrinhoDeCompras carrinhoDeCompras) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.expire("carrinho", 0);
        jedis.close();
    }

    public boolean salvarIdSessao(String id) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.setex("idSessao", 43200, id);
        jedis.close();
        return true;
    }

    public String buscarIdSessao() {
        Jedis jedis = new Jedis("localhost", 6379);
        String aux = jedis.get("idSessao");
        jedis.close();
        return aux;
    }

    public void salvarCompra(Compra compra) {
        daoGrafo.salvarRelacionamentos(compra);
        daoCompra.salvarCompra(compra);
    }

    public List<Produto> buscarProdutosSugeridos(Produto produto) {
        List<Produto> produtos = new ArrayList<>();
        Map<Long, Integer> idProdutos = daoGrafo.buscarRelacionamentos(produto);
        if (idProdutos != null) {
            long id1 = 0, id2 = 0, id3 = 0, id4 = 0;
            int p = 0, s = 0, t = 0, q = 0;
            for (Long id : idProdutos.keySet()) {
                int qtd = idProdutos.get(id);
                if (qtd > p) {
                    p = qtd;
                    id1 = id;
                } else if (qtd <= p && qtd > s) {
                    s = qtd;
                    id2 = id;
                } else if (qtd <= s && qtd > t) {
                    t = qtd;
                    id3 = id;
                } else if (qtd <= t && qtd > q) {
                    q = qtd;
                    id4 = id;
                }
            }
            if (p != 0) {
                produtos.add(daoProduto.buscar(id1, Produto.class));
            }
            if (s != 0) {
                produtos.add(daoProduto.buscar(id2, Produto.class));
            }
            if (t != 0) {
                produtos.add(daoProduto.buscar(id3, Produto.class));
            }
            if (q != 0) {
                produtos.add(daoProduto.buscar(id4, Produto.class));
            }
        } else {
            List<Produto> produtosLoja = listarProdutos();
            try {
                for (int i = 0; i < 4; i++) {
                    produtos.add(produtosLoja.get(i));
                }
            } catch (IndexOutOfBoundsException e) {
                return produtos;
            }

        }
        return produtos;
    }

}
