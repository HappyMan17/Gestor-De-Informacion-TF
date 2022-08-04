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
public class Sales {
    //Attributes
    private int quantitySold;
    private Client client;
    private Store storeClient;
    private ArrayList<ProductPackage> packageSell;
    private ArrayList<Product> productSell;
    private Double totalSold;
    private Seller seller;
    private int databaseId;
    
    //Methods
    public Sales(int quantitySold, Client client, Seller seller){
        this.quantitySold = quantitySold;
        this.client = client;
        this.seller = seller;
        this.totalSold = 0.0;
    }
    
    public Sales(int quantitySold, Store storeClient, Seller seller){
        this.quantitySold = quantitySold;
        this.storeClient = storeClient;
        this.seller = seller;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
    
    public void calculateQuantitySold(){
        for(ProductPackage productPackage: packageSell){
            productPackage.calculateSalePrice();
            totalSold += productPackage.getSalePrice();
        }
        
        for(Product product: productSell){
            totalSold += product.getPrice();
        }
    }
    
    public Double getTotalSold(){
        return totalSold;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Store getStoreClient() {
        return storeClient;
    }

    public void setStoreClient(Store storeClient) {
        this.storeClient = storeClient;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public ArrayList<ProductPackage> getPackageSell() {
        return packageSell;
    }

    public void setPackageSell(ArrayList<ProductPackage> packageSell) {
        this.packageSell = packageSell;
    }

    public void addPackageSell(ProductPackage packageToSell) {
        this.packageSell.add(packageToSell);
    }
    
    public ArrayList<Product> getProductSell() {
        return productSell;
    }

    public void setProductToSell(ArrayList<Product> productSell) {
        this.productSell = productSell;
    }
    
    public void addProductToSell(Product product){
        this.productSell.add(product);
    }

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }
    
}
