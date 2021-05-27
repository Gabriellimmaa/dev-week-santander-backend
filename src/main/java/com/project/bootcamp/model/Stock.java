package com.project.bootcamp.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_stock")
public class Stock {

    @Id //Key primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //Back-end se responsabilizando para auto incrementar o valor de ID
    @Column(name = "id") //Se refêre a coluna de ID do banco de dados
    private Long id;

    @Column(name = "name") //Se refêre a coluna de name do banco de dados
    private String name;

    @Column(name = "price")//Se refêre a coluna de price do banco de dados
    private Double price;

    @Column(name = "variation")//Se refêre a coluna de variation do banco de dados
    private Double variation;

    @Column(name = "date")//Se refêre a coluna de date do banco de dados
    private LocalDate date;

    //ALT + INSERT para criar getter and setter
    public Long getId() {
        return id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
