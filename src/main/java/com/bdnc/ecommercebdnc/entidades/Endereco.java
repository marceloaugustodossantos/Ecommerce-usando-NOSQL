/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.bson.Document;

/**
 *
 * @author Marcelo Augusto
 */
@Entity
public class Endereco implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Document toDocument(){
       Document doc = new Document("id", id).append("rua", rua).append("numero", numero).
               append("bairro", bairro).append("cidade", cidade).
               append("estado", estado);
       return doc;
   }
   
   public Endereco fromDocument(Document doc){
       id = doc.getLong("id");
       rua = doc.getString("rua");
       numero = doc.getString("numero");
       bairro = doc.getString("bairro");
       cidade= doc.getString("cidade");
       estado = doc.getString("estado");
       return this;
   }    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + '}';
    }
    
}
