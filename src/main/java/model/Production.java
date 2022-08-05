/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author happy
 */
public class Production extends Recepies{
    //Attribute
    private String productName;
    private Product newProduct;
    private int databaseId;
    private String date;
    
    //Methods
    public Production(){
        
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }
    
    public void createNewProduct(int productNumber){
        switch (productNumber){
            case 0:
                if (createPapaRellena()){
                    newProduct = new Product( 1, 2000.0, "papaRellena" );
                    resetIngredients();
                    setDate();
                }
            case 1:
                if (createEmpanada()){
                    newProduct = new Product( 1, 1500.0, "empanada" );
                    resetIngredients();
                    setDate();
                }
            case 2:
                if (createPastelDePollo()){
                    newProduct = new Product( 1, 3000.0, "pastelDePollo" );
                    resetIngredients();
                    setDate();
                }
        }
    }

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public void setDate(){
        date = LocalDate.now()+"";
    }
    
    public String getDate(){
        return date;
    }
}
