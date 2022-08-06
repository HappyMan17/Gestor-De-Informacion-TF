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
    private ArrayList<RawMaterial> ingredientsUsed;
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
        ingredientsUsed.clear();
        ArrayList<RawMaterial> ingredientsConfirmation = new ArrayList<>();
        for( RawMaterial ingredient : ingredients ){
            if( "papa".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                papa = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "carne".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                carne = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "arroz".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                arroz = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "huevo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount*2 ){
                huevo = true;
                ingredientsConfirmation.add(ingredient);
            }
            if (papa && carne && arroz && huevo){
                ingredientsConfirmation.get(0).modifyAmount(-productAmount);
                ingredientsConfirmation.get(1).modifyAmount(-productAmount);
                ingredientsConfirmation.get(2).modifyAmount(-productAmount);
                ingredientsConfirmation.get(3).modifyAmount(-productAmount*2);
                ingredientsUsed = ingredientsConfirmation;
            }
            
        }

        return papa && carne && arroz && huevo;
    }
    
    public boolean createEmpanada(int productAmount){
        ingredientsUsed.clear();
        ArrayList<RawMaterial> ingredientsConfirmation = new ArrayList<>();
        
        for( RawMaterial ingredient : ingredients ){
            if( "papa".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                papa = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "carne".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                carne = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "harina".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                harina = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "huevo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                huevo = true;
                ingredientsConfirmation.add(ingredient);
            }
            if (papa && carne && harina && huevo){
                ingredientsConfirmation.get(0).modifyAmount(-productAmount);
                ingredientsConfirmation.get(1).modifyAmount(-productAmount);
                ingredientsConfirmation.get(2).modifyAmount(-productAmount);
                ingredientsConfirmation.get(3).modifyAmount(-productAmount);
                ingredientsUsed = ingredientsConfirmation;
            }
        }

        return papa && carne && harina && huevo;
    }
    
    public boolean createPastelDePollo(int productAmount){
        ingredientsUsed.clear();
        ArrayList<RawMaterial> ingredientsConfirmation = new ArrayList<>();
        
        for( RawMaterial ingredient : ingredients ){
            if( "pollo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                pollo = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "harina".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                harina = true;
                ingredientsConfirmation.add(ingredient);
            }
            if (pollo && harina){
                ingredientsConfirmation.get(0).modifyAmount(-productAmount);
                ingredientsConfirmation.get(1).modifyAmount(-productAmount);
                ingredientsUsed = ingredientsConfirmation;
            }
        }

        return pollo && harina;
    }
    
    public void setIngredients(ArrayList<RawMaterial> ingredients){
        this.ingredients = ingredients;
    }

    public ArrayList<RawMaterial> getIngredientsUsed() {
        return ingredientsUsed;
    }

    public void setIngredientsUsed(ArrayList<RawMaterial> ingredientsUsed) {
        this.ingredientsUsed = ingredientsUsed;
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
