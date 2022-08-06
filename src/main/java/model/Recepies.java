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
public class Recepies {
    //Attributes
    private ArrayList<RawMaterial> ingredients;
    boolean papa;
    boolean carne;
    boolean pollo;
    boolean arroz;
    boolean huevo;
    boolean harina;
    
    public Recepies(){
        this.papa = false;
        this.carne = false;
        this.pollo = false;
        this.arroz = false;
        this.huevo = false;
        this.harina = false;
    }
    
    //Methods
    public boolean createPapaRellena(int productAmount){
        
        for( RawMaterial ingredient : ingredients ){
            if( "papa".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                papa = true;
            }
            if( "carne".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                carne = true;
            }
            if( "arroz".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                arroz = true;
            }
            if( "huevo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount*2 ){
                huevo = true;
            }
        }

        return papa && carne && arroz && huevo;
    }
    
    public boolean createEmpanada(int productAmount){
        
        for( RawMaterial ingredient : ingredients ){
            if( "papa".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                papa = true;
            }
            if( "carne".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                carne = true;
            }
            if( "harina".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                harina = true;
            }
            if( "huevo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                huevo = true;
            }
        }

        return papa && carne && harina && huevo;
    }
    
    public boolean createPastelDePollo(int productAmount){
        
        for( RawMaterial ingredient : ingredients ){
            if( "pollo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                pollo = true;
            }
            if( "harina".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                harina = true;
            }
        }

        return pollo && harina;
    }
    
    public void setIngredients(ArrayList<RawMaterial> ingredients){
        this.ingredients = ingredients;
    }
    
    public void resetIngredients(){
        this.papa = false;
        this.carne = false;
        this.arroz = false;
        this.huevo = false;
        this.harina = false;
        this.pollo = false;
    }
    
}
