/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import org.bson.Document;

/**
 *
 * @author marcelo
 */
public class Pagamento implements Serializable{

    private long id;
    private String prestadora;
    private String titular;
    private int numero;
    private String codigoSeguranca;

    public String getPrestadora() {
        return prestadora;
    }

    public Document toDocument() {
        Document doc = new Document("id", id).append("prestadora", prestadora).append("titular", titular).
                append("numero", numero).append("codigoDeSeguranca", codigoSeguranca);
        return doc;
    }

    public Pagamento fromDocument(Document doc) {
        id = doc.getLong("id");
        prestadora = doc.getString("prestadora");
        titular = doc.getString("titular");
        numero = doc.getInteger("numero");
        codigoSeguranca = doc.getString("codigoSeguranca");
        return this;
    }

    public Pagamento() {
        this.id = System.currentTimeMillis();
    }

    public void setPrestadora(String prestadora) {
        this.prestadora = prestadora;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", prestadora=" + prestadora + ", titular=" + titular + ", numero=" + numero + ", codigoSeguranca=" + codigoSeguranca + '}';
    }

}
