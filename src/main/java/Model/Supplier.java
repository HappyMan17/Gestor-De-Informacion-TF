/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author happy
 */
public class Supplier {
    //Attribute
    private String supplierName;
    private int supplierNit;
    private ArrayList <RawMaterial> rawMaterial;

    //Methods
    public Supplier(String supplierName, int supplierNit){
        this.supplierName = supplierName;
        this.supplierNit = supplierNit;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getSupplierNit() {
        return supplierNit;
    }

    public void setSupplierNit(int supplierNit) {
        this.supplierNit = supplierNit;
    }

    public ArrayList<RawMaterial> getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(ArrayList<RawMaterial> rawMaterial) {
        this.rawMaterial = rawMaterial;
    }
    
    
}
