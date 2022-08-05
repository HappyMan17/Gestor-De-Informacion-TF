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
    public boolean createPapaRellena(){
        
        for( RawMaterial ingredient : ingredients ){
            if( "papa".equals(ingredient.getName()) ){
                papa = true;
            }
            if( "carne".equals(ingredient.getName()) ){
                carne = true;
            }
            if( "arroz".equals(ingredient.getName()) ){
                arroz = true;
            }
            if( "huevo".equals(ingredient.getName()) || ingredient.getAmount() == 2 ){
                huevo = true;
            }
        }

        return papa && carne && arroz && huevo;
    }
    
    public boolean createEmpanada(){
        
        for( RawMaterial ingredient : ingredients ){
            if( "papa".equals(ingredient.getName()) ){
                papa = true;
            }
            if( "carne".equals(ingredient.getName()) ){
                carne = true;
            }
            if( "harina".equals(ingredient.getName()) ){
                harina = true;
            }
            if( "huevo".equals(ingredient.getName()) ){
                huevo = true;
            }
        }

        return papa && carne && harina && huevo;
    }
    
    public boolean createPastelDePollo(){
        
        for( RawMaterial ingredient : ingredients ){
            if( "pollo".equals(ingredient.getName()) ){
                pollo = true;
            }
            if( "harina".equals(ingredient.getName()) ){
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
