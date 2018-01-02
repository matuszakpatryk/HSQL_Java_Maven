package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "flower.all", query = "Select f from Flower f"),
})
public class Flower {

    public Long id;
    public String name;
    public double priceNetto;
    public int vat;
    public Type type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPriceNetto() {
        return priceNetto;
    }
    public void setPriceNetto(double priceNetto) {
        this.priceNetto = priceNetto;
    }
    public int getVat() {
        return vat;
    }
    public void setVat(int vat) {
        this.vat = vat;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

}