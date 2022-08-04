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
public class Supplier {
    //Attribute
    private String supplierName;
    private int supplierNit, dbId;
    private ArrayList <RawMaterial> rawMaterial;
    private int supplierCode;

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

    public int getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(int supplierCode) {
        this.supplierCode = supplierCode;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
    
}
