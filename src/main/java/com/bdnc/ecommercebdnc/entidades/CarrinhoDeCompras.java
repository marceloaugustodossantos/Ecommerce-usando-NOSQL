/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.entidades;

import com.mongodb.BasicDBList;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.bson.Document;

/**
 *
 * @author marcelo
 */
@Entity
public class CarrinhoDeCompras implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private List<Produto> produtos;
    private double valorParcial;
    @Transient
    private int qtdItens;

    public CarrinhoDeCompras() {
        this.produtos = new ArrayList<>();
        this.qtdItens = 0;
    }
    
    public Document toDocument(){
       Document doc = new Document("id", id).append("produtos", produtos).
               append("valorParcial", valorParcial).append("qtdItens", qtdItens);
       BasicDBList produtoList = new BasicDBList();
        for (Produto produto : produtos) {
            produtoList.add(produto.toDocument());
        }
        doc.append("produtos", produtoList);
       return doc;
   }
   
   public CarrinhoDeCompras fromDocument(Document doc){
       id = doc.getLong("id");
       produtos = doc.get("prestadora", List.class);
       valorParcial = doc.getDouble("valorParcial");
       qtdItens = doc.getInteger("qtdItens");
       return this;
   }    

    public boolean adicionarProduto(Produto produto) {
        if (!produtos.contains(produto)) {
            this.produtos.add(produto);
            this.valorParcial = calculaValorParcial();
            this.qtdItens ++;
            return true;
        }
        return false;
    }

    private double calculaValorParcial() {
        long aux = 0;
        for (Produto produto : produtos) {
            aux += produto.calcularValorComQuantidade();
        }
        return aux;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(double valorParcial) {
        this.valorParcial = valorParcial;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" + "id=" + id + ", produtos=" + produtos + ", valorParcial=" + valorParcial + '}';
    }


}
