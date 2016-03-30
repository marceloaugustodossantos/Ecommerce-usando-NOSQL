/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import org.bson.Document;

/**
 *
 * @author Marcelo Augusto
 */
@Entity
@NamedQuery(name = "produtos.todos", query = "SELECT p FROM Produto p")
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descricao;
    private double valor;
    private int quantidadeVenda;
    @Transient
    private double valorComQuantidade;
    @Lob
    private byte [] foto;   
    
    public Produto (){
    }
    
    public Document toDocument(){
       Document doc = new Document ("id", id).append("descricao", descricao);
       return doc;
   }
   
   public Produto fromDocument(Document doc){
       id = doc.getLong("id");
      
       return this;
   }     
    
    public double calcularValorComQuantidade(){
        valorComQuantidade = valor * quantidadeVenda;
        return valorComQuantidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(int quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public double getValorComQuantidade() {
        return valorComQuantidade;
    }

    public void setValorComQuantidade(double valorComQuantidade) {
        this.valorComQuantidade = valorComQuantidade;
    }
    
    
    
}
