/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bdnc.ecommercebdnc.dao;

import com.bdnc.ecommercebdnc.entidades.Compra;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author marcelo
 */
public class DAODocumentos {

    public boolean salvarCompra(Compra compra) {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase dataBase = client.getDatabase("ecommerce-bdnc");
        MongoCollection<Document> collection = dataBase.getCollection("vendas");
        collection.insertOne(compra.toDocument());
        client.close();
        return true;
    }

    public List<Compra> buscarCompras() {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase dataBase = client.getDatabase("ecommerce-bdnc");
        MongoCollection<Document> collection = dataBase.getCollection("vendas");
        List<Compra> compras = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            Compra compra = new Compra();
            compras.add(compra.fromDocument(cursor.next()));
        }
        client.close();
        return compras;
    }

}
