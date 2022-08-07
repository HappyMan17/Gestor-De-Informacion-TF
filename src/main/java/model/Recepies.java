/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import DAOModels.RawMaterialDAO;
import java.util.ArrayList;

/**
 *
 * @author happy
 */
public class Recepies {
    //Attributes
    private ArrayList<RawMaterial> ingredients = new ArrayList<>();
    private ArrayList<RawMaterial> ingredientsUsed = new ArrayList<>();
    private RawMaterialDAO rawMaterialDAO = new RawMaterialDAO();
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
            if( "Papa".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                papa = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "Carne".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                carne = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "Arroz".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                arroz = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "Huevo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount*2 ){
                huevo = true;
                ingredientsConfirmation.add(ingredient);
            }
            if (papa && carne && arroz && huevo){
                ingredientsConfirmation.get(0).modifyAmount(-productAmount);
                rawMaterialDAO.updateRawMaterial(ingredientsConfirmation.get(0));
                ingredientsConfirmation.get(1).modifyAmount(-productAmount);
                rawMaterialDAO.updateRawMaterial(ingredientsConfirmation.get(1));
                ingredientsConfirmation.get(2).modifyAmount(-productAmount);
                rawMaterialDAO.updateRawMaterial(ingredientsConfirmation.get(2));
                ingredientsConfirmation.get(3).modifyAmount(-productAmount*2);
                rawMaterialDAO.updateRawMaterial(ingredientsConfirmation.get(3));
                ingredientsUsed = ingredientsConfirmation;
            }
            
        }

        return papa && carne && arroz && huevo;
    }
    
    public boolean createEmpanada(int productAmount){
        ingredientsUsed.clear();
        ArrayList<RawMaterial> ingredientsConfirmation = new ArrayList<>();
        
        for( RawMaterial ingredient : ingredients ){
            if( "Papa".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                papa = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "Carne".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                carne = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "Harina".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                harina = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "Huevo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                huevo = true;
                ingredientsConfirmation.add(ingredient);
            }
            if (papa && carne && harina && huevo){
                ingredientsConfirmation.get(0).modifyAmount(-productAmount);
                rawMaterialDAO.updateRawMaterial(ingredientsConfirmation.get(0));
                ingredientsConfirmation.get(1).modifyAmount(-productAmount);
                rawMaterialDAO.updateRawMaterial(ingredientsConfirmation.get(1));
                ingredientsConfirmation.get(2).modifyAmount(-productAmount);
                rawMaterialDAO.updateRawMaterial(ingredientsConfirmation.get(2));
                ingredientsConfirmation.get(3).modifyAmount(-productAmount);
                rawMaterialDAO.updateRawMaterial(ingredientsConfirmation.get(3));
                ingredientsUsed = ingredientsConfirmation;
            }
        }

        return papa && carne && harina && huevo;
    }
    
    public boolean createPastelDePollo(int productAmount){
        ingredientsUsed.clear();
        ArrayList<RawMaterial> ingredientsConfirmation = new ArrayList<>();
        
        for( RawMaterial ingredient : ingredients ){
            System.out.println("Pollo and "+ingredient.getName()+" amount: "+productAmount);
            if( "Pollo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                pollo = true;
                ingredientsConfirmation.add(ingredient);
            }
            if( "Harina".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount){
                harina = true;
                ingredientsConfirmation.add(ingredient);
            }
            if (pollo && harina){
                ingredientsConfirmation.get(0).modifyAmount(-productAmount);
                rawMaterialDAO.updateRawMaterial(ingredientsConfirmation.get(0));
                ingredientsConfirmation.get(1).modifyAmount(-productAmount);
                rawMaterialDAO.updateRawMaterial(ingredientsConfirmation.get(1));
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
