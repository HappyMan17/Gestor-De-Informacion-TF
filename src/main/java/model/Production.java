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
    public Production(){}

    public Production(String productName){
        this.productName = productName;
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
    
    public void createNewProduct(int productAmount){
        switch (productName){
            case "Papa Rellena":
                if (createPapaRellena(productAmount)){
                    newProduct = new Product( productAmount, 2000.0, "Papa Rellena" );
                    newProduct.setIngredients(this.getIngredientsUsed());
                    resetIngredients();
                    setDate();
                }else{
                    JOptionPane.showMessageDialog(null, "Ni tiene los ingredientes "
                        + "necesarios para la papa");
                }
            case "Empanada":
                if (createEmpanada(productAmount)){
                    newProduct = new Product( productAmount, 1500.0, "Empanada" );
                    newProduct.setIngredients(this.getIngredientsUsed());
                    resetIngredients();
                    setDate();
                }else{
                    JOptionPane.showMessageDialog(null, "Ni tiene los ingredientes "
                        + "necesarios para la empanada");
                }
            case "Pastel de Pollo":
                if (createPastelDePollo(productAmount)){
                    newProduct = new Product( productAmount, 3000.0, "Pastel De Pollo" );
                    newProduct.setIngredients(this.getIngredientsUsed());
                    resetIngredients();
                    setDate();
                }else{
                    JOptionPane.showMessageDialog(null, "Ni tiene los ingredientes "
                        + "necesarios para el pastel de pollo");
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
