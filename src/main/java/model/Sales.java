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
    private Client client;
    private Seller seller;
    private ArrayList<ProductPackage> packageSell;
    private ArrayList<Product> productSell;
    private int salesDetailsId, databaseId;
    private Double totalSold;
    private String date;
    private boolean isActive;
    
    //Methods
    public Sales(){
        
    }
    
    public Sales(int quantitySold, Client client, Seller seller, int selesDetailsId){
        this.client = client;
        this.seller = seller;
        this.salesDetailsId = selesDetailsId;
        this.totalSold = 0.0;
    }
    
    public void calculateQuantitySold(){
        for(ProductPackage productPackage: packageSell){
            productPackage.calculateSalePrice();
            
            Double price = productPackage.getSalePrice();
            int amount  = productPackage.getProductAmount();
            
            totalSold += price * amount;
        }
        
        for(Product product: productSell){
            
            Double price = product.getPrice();
            int amount = product.getAmount();
            
            totalSold += price * amount;
        }
    }

    public int getSalesDetailsId() {
        return salesDetailsId;
    }

    public void setSalesDetailsId(int selesDetailsId) {
        this.salesDetailsId = selesDetailsId;
    }
    
    public void setTotalSold(Double totalSold){
        this.totalSold = totalSold;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
}
