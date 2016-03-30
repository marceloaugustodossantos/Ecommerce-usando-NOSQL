/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.dao;

import com.bdnc.ecommercebdnc.entidades.Compra;
import com.bdnc.ecommercebdnc.entidades.Produto;
import com.bdnc.ecommercebdnc.entidades.RelTypes;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import java.util.List;
import java.util.Map;
import org.neo4j.graphdb.Direction;

/**
 *
 * @author marcelo
 */
public class DAOGrafo {

    public void salvarRelacionamentos(Compra compra) {

        String path = "/home/marcelo/Downloads/neo4j-community-2.3.2/data/graph2.db";
        File file = new File(path);
        GraphDatabaseService graph = new GraphDatabaseFactory().newEmbeddedDatabase(file);

        try (Transaction tx = graph.beginTx()) {
            Node noCliente = graph.findNode(DynamicLabel.label("Cliente"), "idc", compra.getCliente().getId());
            if (noCliente == null) {
                noCliente = graph.createNode(DynamicLabel.label("Cliente"));
                noCliente.setProperty("idc", compra.getCliente().getId());
            }

            List<Produto> produtos = compra.getCarrinho().getProdutos();
            for (Produto produto : produtos) {
                Node noProduto = graph.findNode(DynamicLabel.label("Produto"), "idp", produto.getId());
                if (noProduto == null) {
                    noProduto = graph.createNode(DynamicLabel.label("Produto"));
                    noProduto.setProperty("idp", produto.getId());
                }
                Relationship relCliPro = noCliente.createRelationshipTo(noProduto, RelTypes.COMPROU);
            }
            tx.success();
        }
        graph.shutdown();
    }

    public Map<Long, Integer> buscarRelacionamentos(Produto produto) {

        String path = "/home/marcelo/Downloads/neo4j-community-2.3.2/data/graph2.db";
        File file = new File(path);
        GraphDatabaseService graph = new GraphDatabaseFactory().newEmbeddedDatabase(file);
        Map<Long, Integer> produtos = null;

        try (Transaction tx = graph.beginTx()) {
            Node noProduto = graph.findNode(DynamicLabel.label("Produto"), "idp", produto.getId());
            if (noProduto != null) {
                Iterator<Relationship> relacionamentosProdutoCliente = noProduto.getRelationships(RelTypes.COMPROU).iterator();
                produtos = new HashMap<>();
                while (relacionamentosProdutoCliente.hasNext()) {
                    //cada cliente que comprou este produto 
                    Node nodeCliente = relacionamentosProdutoCliente.next().getStartNode();
                    //cada produto comprado por o cliente desta iteraçao
                    Iterable<Relationship> relacionamentosClienteProdutos = nodeCliente.getRelationships();
                    for (Relationship r : relacionamentosClienteProdutos) {
                        Node nodeProduto = r.getEndNode();
                        long id = (Long) nodeProduto.getProperty("idp");
                        if (!produtos.containsKey(id)) {
                            produtos.put(id, 1);
                        } else {
                            produtos.put(id, produtos.get(id) + 1);
                        }
                    }
                }
            } 
            tx.success();
        }
        graph.shutdown();
        return produtos;
    }

}
