/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author santi
 */
public class ProductionDetails {
    //Attributes
    private int detailsId;
    private int rawMaterial_id;
    private int amountUsed;
    private int productionId, productId;
    
    //Methods
    public ProductionDetails(){}
    
    public ProductionDetails(int rawMaterial_id, int amountUsed, int productionId){
        this.rawMaterial_id = rawMaterial_id;
        this.amountUsed = amountUsed;
        this.productionId = productionId;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public int getRawMaterial_id() {
        return rawMaterial_id;
    }

    public void setRawMaterial_id(int rawMaterial_id) {
        this.rawMaterial_id = rawMaterial_id;
    }

    public int getAmountUsed() {
        return amountUsed;
    }

    public void setAmountUsed(int amountUsed) {
        this.amountUsed = amountUsed;
    }

    public int getProductionId() {
        return productionId;
    }

    public void setProductionId(int productionId) {
        this.productionId = productionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    
}
