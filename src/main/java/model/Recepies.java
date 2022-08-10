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

    public Recepies() {
        this.papa = false;
        this.carne = false;
        this.pollo = false;
        this.arroz = false;
        this.huevo = false;
        this.harina = false;
    }

    //Methods
    public boolean createPapaRellena(int productAmount) {
        ingredientsUsed.clear();
        ArrayList<RawMaterial> ingredientsConfirmation = new ArrayList<>();
        for (RawMaterial ingredient : ingredients) {
            if ("Papa".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount) {
                this.papa = true;
                ingredientsConfirmation.add(ingredient);
            }
            if ("Carne".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount) {
                this.carne = true;
                ingredientsConfirmation.add(ingredient);
            }
            if ("Arroz".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount) {
                this.arroz = true;
                ingredientsConfirmation.add(ingredient);
            }
            if ("Huevo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount) {
                this.huevo = true;
                ingredientsConfirmation.add(ingredient);
            }
        }
            if (papa && carne && arroz && huevo) {
                updateAmounts(ingredientsConfirmation, productAmount);
            }

        return papa && carne && arroz && huevo;
    }

    public boolean createEmpanada(int productAmount) {
        ingredientsUsed.clear();
        ArrayList<RawMaterial> ingredientsConfirmation = new ArrayList<>();

        for (RawMaterial ingredient : ingredients) {
            if ("Papa".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount) {
                this.papa = true;
                ingredientsConfirmation.add(ingredient);
            }
            if ("Carne".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount) {
                this.carne = true;
                ingredientsConfirmation.add(ingredient);
            }
            if ("Harina".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount) {
                this.harina = true;
                ingredientsConfirmation.add(ingredient);
            }
            if ("Huevo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount) {
                this.huevo = true;
                ingredientsConfirmation.add(ingredient);
            }
        }
        if (papa && carne && harina && huevo) {
            updateAmounts(ingredientsConfirmation, productAmount);
        }
        
        return papa && carne && harina && huevo;
    }

    public boolean createPastelDePollo(int productAmount) {
        ingredientsUsed.clear();

        ArrayList<RawMaterial> ingredientsConfirmation = new ArrayList<>();

        for (RawMaterial ingredient : ingredients) {
            if ("Pollo".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount) {
                this.pollo = true;
                ingredientsConfirmation.add(ingredient);
            }
            if ("Harina".equals(ingredient.getName()) && ingredient.getAmount() >= productAmount) {
                this.harina = true;
                ingredientsConfirmation.add(ingredient);
            }
        }
        if (pollo && harina) {
            updateAmounts(ingredientsConfirmation, productAmount);
        }

        return pollo && harina;
    }

    public void updateAmounts(ArrayList<RawMaterial> ingridients, int productAmount) {
        ArrayList<RawMaterial> ingridientsFinal = new ArrayList<>();
        ingridientsFinal.clear();
        
        for (RawMaterial raw : ingridients) {
            raw.modifyAmount(-productAmount);
            rawMaterialDAO.updateRawMaterial(raw);
            RawMaterial ourRaw = (RawMaterial) raw.clone();
            ourRaw.setAmount(productAmount);
            ingridientsFinal.add(ourRaw);
        }
        
        ingredientsUsed = ingridientsFinal;
    }

    public void setIngredients(ArrayList<RawMaterial> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<RawMaterial> getIngredientsUsed() {
        return ingredientsUsed;
    }

    public void setIngredientsUsed(ArrayList<RawMaterial> ingredientsUsed) {
        this.ingredientsUsed = ingredientsUsed;
    }

    public void resetIngredients() {
        this.papa = false;
        this.carne = false;
        this.arroz = false;
        this.huevo = false;
        this.harina = false;
        this.pollo = false;
    }

}
