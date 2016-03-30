/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.entidades;

import com.mongodb.BasicDBList;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author Marcelo Augusto
 */
public class Compra implements Serializable {

    private long id;
    private long valor;
    private Date data;
    private Cliente cliente;
    private CarrinhoDeCompras carrinho;
    private Endereco enderecoEntrega;
    private Pagamento pagamento;

    public Compra() {
        this.id = System.currentTimeMillis();
    }

    public Document toDocument() {
        Document doc = new Document("id", id).append("valor", valor).append("data", data);
        doc.append("cliente", cliente.toDocument());
        doc.append("carrinho", carrinho.toDocument());        
        return doc;
    }

    public Compra fromDocument(Document doc) {
        id = doc.getLong("id");
        valor = doc.getLong("valor");
        data = doc.getDate("data");
        cliente = doc.get("cliente", Cliente.class);
        carrinho = doc.get("carrinho", CarrinhoDeCompras.class);
        enderecoEntrega = doc.get("enderecoEntrega", Endereco.class);
        pagamento = doc.get("pagamento", Pagamento.class);
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoDeCompras carrinho) {
        this.carrinho = carrinho;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", valor=" + valor + ", data=" + data
                + ", cliente=" + cliente + ", carrinho=" + carrinho + ", enderecoEntrega="
                + enderecoEntrega + ", pagamento=" + pagamento + '}';
    }

}
