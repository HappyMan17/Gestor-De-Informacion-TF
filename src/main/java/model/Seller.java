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
    private int sellerId;
    private ArrayList<Sales> salesMade;
    private String sellerName;
    private int databaseId;

    //Methods
    public Seller(int sellerId, String sellerName) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
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

}
