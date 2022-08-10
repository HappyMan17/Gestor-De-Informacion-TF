/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author sebastian grisales
 */
public class Sales {
    //Attributes
    private int clientId;
    private int sellerId;
    private ArrayList<ProductPackage> packageSell = new ArrayList<>();
    private ArrayList<Product> productSell = new ArrayList<>();
    private int salesDetailsId, databaseId;
    private Double totalSold;
    private String date;
    private boolean isActive;
    
    //Methods
    public Sales(){
        
    }
    
    public Sales(int quantitySold, int clientId, int sellerId, int selesDetailsId){
        this.clientId = clientId;
        this.sellerId = sellerId;
        this.salesDetailsId = selesDetailsId;
        this.totalSold = 0.0;
        this.isActive = true;
        setDate();
    }
    
    public void calculateQuantitySold(){
        for(ProductPackage productPackage: packageSell){
            productPackage.calculateSalePrice();
            
            Double price = productPackage.getSalePrice();
            int amount  = productPackage.getProductAmount();
            
            totalSold += price * amount;
        }
        System.out.println(totalSold);
        for(Product product: productSell){
            
            Double price = product.getPrice();
            int amount = product.getAmount();
            
            totalSold += price * amount;
        }
        System.out.println(totalSold);
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
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
        calculateQuantitySold();
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
    
    public void setDate() {
        this.date = LocalDate.now()+"";
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
