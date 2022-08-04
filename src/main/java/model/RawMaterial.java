/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author happy
 */
public class RawMaterial {
    //Attribute
    private String name;
    private int code, supplierCode, amount, dbId;
    private double unitPrice;
    
    //Methods
    public RawMaterial(){}
    
    public RawMaterial(String name, int unitPrice, int code, int supplierCode, 
        int amount){
        this.name = name;
        this.unitPrice = unitPrice;
        this.code = code;
        this.supplierCode = supplierCode;
        this.amount = amount;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getSupplierId() {
        return supplierCode;
    }

    public void setSupplierId(int supplierCode) {
        this.supplierCode = supplierCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void modifyAmount(int number){
        amount += number;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
    
}
