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
public class Seller {

    //Attributes
    private int sellerCode;
    private ArrayList<Sales> salesMade;
    private String sellerName;
    private int databaseId;
    private boolean isActive;

    //Methods
    public Seller(int sellerCode, String sellerName) {
        this.sellerCode = sellerCode;
        this.sellerName = sellerName;
    }
    
    public Seller(){
        
    }

    public int getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(int sellerId) {
        this.sellerCode = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public ArrayList<Sales> getSalesMade() {
        return salesMade;
    }

    public void setSalesMade(ArrayList<Sales> salesMade) {
        this.salesMade = salesMade;
    }

    public void addSalesMade(Sales saleMade) {
        this.salesMade.add(saleMade);
    }

    public void salesMade() {

    }

    public void salesToStore() {

    }

    public void salesToClient() {

    }

    public void salesOfProduct() {

    }

    public void salesOfPackeges() {

    }

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    
}
