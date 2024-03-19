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
        //this.price = price;
        try {
            String priceString = String.format("%.2f", price);
            this.price = new BigDecimal(priceString);
        } catch (NumberFormatException e) {
            // Si hay un error al convertir la cadena de precio a BigDecimal, lanzar una excepción
            throw new IllegalArgumentException("Precio no válido: " + price);
        }
        this.stock = stock;
        this.category = category;
    }
}
