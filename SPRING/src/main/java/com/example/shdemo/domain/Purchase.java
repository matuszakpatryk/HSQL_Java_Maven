package com.example.shdemo.domain;

import javax.persistence.*;
import java.util.Date;

/*@Entity
@NamedQueries({
        @NamedQuery(name = "purchase.all", query = "Select p from Purchase p"),
})*/
public class Purchase {

    public Long id;
    public Date date;
    public Client client;
    public Flower flower;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

}