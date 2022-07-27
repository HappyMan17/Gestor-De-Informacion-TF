/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author sebastian grisales
 */
public class Store {
    //Attributes
    private String storeName;
    private int NIT;
    private ArrayList<ProductPackage> productsPackages;
    private ArrayList<Product> products;
    
    //Methods
    public Store(String storeName, int NIT){
        this.storeName = storeName;
        this.NIT = NIT;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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
    
    public void addProductsPackages(ProductPackage productPackage) {
        this.productsPackages.add(productPackage);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    public void addProducts(Product product) {
        this.products.add(product);
    }
}
