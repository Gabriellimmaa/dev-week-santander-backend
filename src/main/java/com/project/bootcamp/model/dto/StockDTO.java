package com.project.bootcamp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat; //Trabalha formatando informações em JSON

import javax.validation.constraints.DecimalMin; //Valor minimo que pode receber
import javax.validation.constraints.Digits; //Define quantos digitos antes(integer) e depois(fraction) da virgula pode receber
import javax.validation.constraints.NotNull; //Campo obrigatorio, nao pode receber NULL
import java.time.LocalDate;

public class StockDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    @DecimalMin(value = "0.00")
    @Digits(integer = 6, fraction = 2)
    private Double price;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    //Faz com que seja obrigatorio receber a data neste formato
    private LocalDate date;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private Double variation;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }

}
