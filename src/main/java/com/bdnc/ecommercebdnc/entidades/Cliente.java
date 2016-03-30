/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.bson.Document;

/**
 *
 * @author Marcelo Augusto
 */
@Entity
@NamedQuery(name = "cliente.buscar", query = "SELECT c FROM Cliente c WHERE c.email = :email")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    
    public Document toDocument(){
       Document doc = new Document("id", id).append("nome", nome).append("cpf", cpf).
               append("email", email).append("senha", senha).
               append("endereco", endereco.toDocument());
       return doc;
   }
   
   public Cliente fromDocument(Document doc){
       id = doc.getLong("id");
       nome = doc.getString("nome");       
       cpf = doc.getString("cpf");
       email = doc.getString("email");
       senha = doc.getString("senha");
       endereco = doc.get("endereco", Endereco.class);
       return this;
   }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha + ", endereco=" + endereco + '}';
    }
    

}
