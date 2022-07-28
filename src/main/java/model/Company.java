/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author happy
 */
public class Company {
    //Atribute
    private ArrayList<Supplier> suppliers;
    private final ArrayList<RawMaterial> rawMaterials = new ArrayList<>();
    private Production production;
    private ArrayList<Product> products = new ArrayList<>();
    
    //Methods
    public Company(ArrayList<Supplier> suppliers){
        this.suppliers = suppliers;
        this.production = new Production();
    }
    
    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void addSupplier(Supplier supplier) {
        this.suppliers.add(supplier);
    }

    public ArrayList<RawMaterial> getRawMaterials() {
        return rawMaterials;
    }

    public void addRawMaterials(RawMaterial rawMaterial) {
        this.rawMaterials.add(rawMaterial);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    
    //public void processRawMaterial(){}
    
}
