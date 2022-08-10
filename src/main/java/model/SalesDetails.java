/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author santi
 */
public class SalesDetails {

    private int salesDetailId, amount, packageId, productId;
    private double price;
    private boolean isActive;

    public SalesDetails(Product product){
        this.productId = product.getDatabaseId();
        this.price = product.getPrice();
        this.amount = product.getAmount();
        this.isActive = true;
    }
    
    public SalesDetails(int productId, double price, int amount) {
        this.productId = productId;
        this.price = price;
        this.amount = amount;
    }

    public SalesDetails(double price, int packageId, int amount) {
        this.packageId = packageId;
        this.price = price;
        this.amount = amount;
    }

    public SalesDetails() {

    }

    public int getSalesDetailId() {
        return salesDetailId;
    }

    public void setSalesDetailId(int salesDetailId) {
        this.salesDetailId = salesDetailId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    
}
