/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author happy
 */
public class Product {
    //Attribute
    private int amount, lotNumber;
    private Double price;
    private ArrayList<RawMaterial> ingredients;
    private String name;
    
    //Methods
    public Product(int amount, Double price, String name){
        this.amount = amount;
        this.price = price;
        this.name = name;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public ArrayList<RawMaterial> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<RawMaterial> ingredients) {
        this.ingredients = ingredients;
    }
    
    public void addIngredients(RawMaterial ingredient) {
        ingredients.add(ingredient);
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
    
}
