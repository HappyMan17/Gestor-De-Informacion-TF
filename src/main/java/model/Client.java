/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author sebastian grisales
 */
public class Client {
    //Attributes
    private String clientName;
    private int clientId, dbId, NIT;
    private ArrayList<ProductPackage> productsPackages;
    private ArrayList<Product> products;
    private boolean isStore, isActive;
    
    //Methods
    public Client(){
        this.isStore = false;
    }
    
    public Client(String clientName, int clientId){
        this.clientName = clientName;
        this.clientId = clientId;
        this.isStore = false;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public ArrayList<ProductPackage> getProductsPackages() {
        return productsPackages;
    }

    public void setProductsPackages(ArrayList<ProductPackage> productsPackages) {
        this.productsPackages = productsPackages;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public boolean getIsIsStore() {
        return isStore;
    }

    public void setIsStore(boolean isStore) {
        this.isStore = isStore;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
    
}
