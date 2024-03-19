package com.franco.supermegaapp.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    public int id;
    public String name;
    public BigDecimal price;
    public Integer stock;
    public String category;

    public Product(int id, String name, BigDecimal price, Integer stock, String category) {
        this.id = id;
        this.name = name;
       // this.price = price;
        // Intentar convertir la cadena de precio a BigDecimal
        try {
            this.price = new BigDecimal(String.valueOf(price)).setScale(2, RoundingMode.DOWN)/*.stripTrailingZeros()*/;
        } catch (NumberFormatException e) {
            // Si hay un error al convertir la cadena de precio a BigDecimal, asignar un valor por defecto de 0
            this.price = BigDecimal.ZERO;
        }
        this.stock = stock;
        this.category = category;
    }
}
