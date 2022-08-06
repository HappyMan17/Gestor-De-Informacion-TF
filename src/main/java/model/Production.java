/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import javax.swing.JOptionPane;

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
    
    public void createNewProduct(String productName, int productAmount){
        switch (productName){
            case "Papa Rellena":
                if (createPapaRellena(productAmount)){
                    newProduct = new Product( productAmount, 2000.0, "papaRellena" );
                    resetIngredients();
                    setDate();
                }
                JOptionPane.showMessageDialog(null, "Ni tiene los ingredientes necesarios");
            case "Empanada":
                if (createEmpanada(productAmount)){
                    newProduct = new Product( productAmount, 1500.0, "empanada" );
                    resetIngredients();
                    setDate();
                }
                JOptionPane.showMessageDialog(null, "Ni tiene los ingredientes necesarios");
            case "Pastel de pollo":
                if (createPastelDePollo(productAmount)){
                    newProduct = new Product( productAmount, 3000.0, "pastelDePollo" );
                    resetIngredients();
                    setDate();
                }
                JOptionPane.showMessageDialog(null, "Ni tiene los ingredientes necesarios");
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
