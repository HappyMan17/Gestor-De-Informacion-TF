/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sebastian grisales
 */
public class ProductPackage {
    //Attributes
    private double salePrice;
    private int productAmount, packageCode;
    private Product product;
    
    //Methods
    public ProductPackage(Product product){
        this.product = product;
        this.productAmount = product.getAmount();
        calculateSalePrice();
    }
    
    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
    
    public final void calculateSalePrice(){
        this.salePrice = productAmount * (product.getPrice());
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public int getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(int packageCode) {
        this.packageCode = packageCode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}
