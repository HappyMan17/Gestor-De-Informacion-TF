/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author happy
 */
public class Product {
    //Attribute
    private int amount, accumulator, databaseId;
    private String lotNumber, name;
    private Double price;
    private ArrayList<RawMaterial> ingredients;
    private boolean isOnStock;
    
    //Methods
    public Product(){}
    
    public Product(int amount, Double price, String name){
        this.amount = amount;
        this.price = price;
        this.name = name;
        this.isOnStock = true;
        setLotNumber();
        
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void modifyAmount(int number){
        amount += number;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String newLotNumber){
        this.lotNumber = newLotNumber;
    }
    
    public void setLotNumber() {
        LocalDate date = LocalDate.now();
        lotNumber = date+" - "+accumulator;
        accumulator++;
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

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public boolean getIsOnStock() {
        return isOnStock;
    }

    public void setIsOnStock(boolean isOnStock) {
        this.isOnStock = isOnStock;
    }
    
    
}
