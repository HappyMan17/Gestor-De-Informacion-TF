/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAOModels.*;
import model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.ViewJFrame;

/**
 *
 * @author happy
 */
public class Controller {
    //Attributes
    private ViewJFrame view;
    private ClientDAO clientDAO;
    private ProductDAO productDAO;
    private ProductPackageDAO productPackageDAO;
    private ProductionDAO productionDAO;
    private ProductionDetailsDAO productionDetailsDAO;
    private RawMaterialDAO rawMaterialDAO;
    private SalesDetailsDAO salesDetailsDAO;
    private SellerDAO sellerDAO;
    private SupplierDAO supplierDAO;
    private ArrayList<Supplier> suppliers = new ArrayList<>();
    private ArrayList<RawMaterial> rawMaterials = new ArrayList<>();

    //Methods
    public Controller(ViewJFrame view){
    /*
    public Controller(ViewJFrame view, ClientDAO clientDAO, ProductDAO productDAO, 
            ProductPackageDAO productPackageDAO, ProductionDAO productionDAO, 
            ProductionDetailsDAO productionDetailsDAO, RawMaterialDAO rawMaterialDAO, 
            SalesDetailsDAO salesDetailsDAO, SellerDAO sellerDAO, 
            SupplierDAO supplierDAO) {
    */
        
        this.view = view;
        this.clientDAO = clientDAO;
        this.productDAO = new ProductDAO();
        this.productPackageDAO = new ProductPackageDAO(productDAO);
        this.productionDAO = new ProductionDAO();
        this.productionDetailsDAO = new ProductionDetailsDAO();
        this.rawMaterialDAO = new RawMaterialDAO();
        this.salesDetailsDAO = new SalesDetailsDAO();
        this.sellerDAO = new SellerDAO();
        this.supplierDAO = new SupplierDAO();
        
        createSuppliers();
        
        this.view.addListenerJComboBoxChooseSupplier(new CalculateListener());
        this.view.addListenerBtnBuyMP(new CalculateListener());
        this.view.addListenerBtnDeleteMP(new CalculateListener());
        this.view.addListenerBtnEditMP(new CalculateListener());
        
        
    }
    
    public void createSuppliers(){
        ArrayList<RawMaterial> rMSupplierOne = new ArrayList<>();
        ArrayList<RawMaterial> rMSupplierTwo = new ArrayList<>();
        ArrayList<RawMaterial> rMSupplierThree = new ArrayList<>();
        
        Supplier supOne = new Supplier("La miseria SAS", 10001, 001, 1);
        Supplier supTwo = new Supplier("Enrico SAS", 10011, 002, 2);
        Supplier supThree = new Supplier("Quesitos LTDA", 10010, 003, 3);
        
        int supOneCode = supOne.getSupplierCode();
        int supTwoCode = supTwo.getSupplierCode();
        int supThreeCode = supThree.getSupplierCode();
        
        int supOneId = supOne.getDbId();
        int supTwoId = supTwo.getDbId();
        int supThreeId = supThree.getDbId();
        
        
        RawMaterial papa = new RawMaterial("Papa", 800.0, 1, 1, supOneCode, 100);
        papa.setSupplierId(supOneId);
        RawMaterial arroz = new RawMaterial("Arroz", 1500.0, 2, 2, supOneCode, 100);
        arroz.setSupplierId(supOneId);
        
        rMSupplierOne.add(papa);
        rMSupplierOne.add(arroz);
        
        RawMaterial carne = new RawMaterial("Carne", 12500.0, 3, 3, supTwoCode, 100);
        carne.setSupplierId(supTwoId);
        RawMaterial pollo = new RawMaterial("Pollo", 9600.0, 4, 4, supTwoCode, 100);
        pollo.setSupplierId(supTwoId);
        
        rMSupplierTwo.add(carne);
        rMSupplierTwo.add(pollo);
        
        RawMaterial huevo = new RawMaterial("Huevo", 600.0, 5, 5, supThreeCode, 100);
        huevo.setSupplierId(supThreeId);
        RawMaterial harina = new RawMaterial("Harina", 1800.0, 6, 6, supThreeCode, 100);
        harina.setSupplierId(supThreeId);
        
        rMSupplierThree.add(huevo);
        rMSupplierThree.add(harina);
        
        supOne.setRawMaterial(rMSupplierOne);
        supTwo.setRawMaterial(rMSupplierTwo);
        supThree.setRawMaterial(rMSupplierThree);

        suppliers.add(supOne);
        suppliers.add(supTwo);
        suppliers.add(supThree);
        
        addToComboboxSupplier();
    }
    
    public void addToComboboxSupplier(){
        view.addToComboBoxSupplier("Seleccione un proveedor");
        for( Supplier supli : suppliers ){
            view.addToComboBoxSupplier(supli.getSupplierName());
        }
    }
    
    public boolean confirmExistence(String rmName, int amount, RawMaterial rawMat){
        for( RawMaterial raw : rawMaterials ){
            if( rmName == raw.getName() ){
                raw.modifyAmount(amount);
                rawMat.modifyAmount(-amount);
                view.clearJtxt();
                return true;
            }
        }
        return false;
    }
    
    class CalculateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Agregar")){
                
                try{
                    System.out.println("Agrega RM");
        
                }catch(NumberFormatException x){
                    System.out.println("Error No Agrega");
                }
                
            }
            if (e.getActionCommand().equalsIgnoreCase("Eliminar")){
                
                try{
                    System.out.println("Elimina");
       
                }catch(NumberFormatException x){
                    System.out.println("Error No Elimina");
                }
                
            }
            if (e.getActionCommand().equalsIgnoreCase("Leer")){
                
                try{
                    System.out.println("Lee");
       
                }catch(NumberFormatException x){
                    System.out.println("Error No Lee");
                }
                
            } 
            //Products:
            if (e.getActionCommand().equalsIgnoreCase("Agregar")){
                
                try{
                    System.out.println("Agrega Producto");
       
                }catch(NumberFormatException x){
                    System.out.println("Error No Agrega");
                }
                
            }
            if (e.getActionCommand().equalsIgnoreCase("Eliminar")){
                
                try{
                    System.out.println("Elimina");
       
                }catch(NumberFormatException x){
                    System.out.println("Error No Elimina");
                }
                
            }
            if (e.getActionCommand().equalsIgnoreCase("Leer")){
                
                try{
                    System.out.println("Lee");
       
                }catch(NumberFormatException x){
                    System.out.println("Error No Lee");
                }
                
            }
            
            //ComboBoxes:
            if (e.getActionCommand().equalsIgnoreCase("comboBoxChanged")){
                view.clearRMComboBox();
                try{
                    String supName = view.getFromComboBoxSupplier();
                    
                    for( Supplier sup : suppliers ){
                    
                        if(sup.getSupplierName().equals(supName)){
                            for( RawMaterial raw : sup.getRawMaterial() ){
                                view.addToComboBoxRawMaterial(raw.getName());
                            }
                            break;
                        }
                        
                    }
                }catch(NullPointerException x){
                    System.out.println(x.getMessage());
                }
            }
            
            //Buy MP
            if (e.getActionCommand().equalsIgnoreCase("Comprar MP")){
                try{
                    String rwName = view.getFromComboBoxRawMaterial();
                    String supName = view.getFromComboBoxSupplier();
                    int JtxtContenido = view.getRawMaterialAmount();
                    
                    for( Supplier sup : suppliers ){
                    
                        if(sup.getSupplierName().equals(supName)){
                            for( RawMaterial raw : sup.getRawMaterial() ){
                                if( raw.getName().equals(rwName) ){
                                    if( raw.getAmount() >= JtxtContenido ){
                                        if( !confirmExistence(rwName, JtxtContenido, raw) ){
                                            RawMaterial ourRaw = (RawMaterial) raw.clone();

                                            raw.modifyAmount(-JtxtContenido);
                                            ourRaw.setAmount(JtxtContenido);

                                            rawMaterials.add(ourRaw);
                                            view.clearJtxt();
                                        }
                                    }else {
                                        JOptionPane.showMessageDialog(null, 
                                            "El proveedor no cuenta con esa cantidad actualmente");
                                    }
                                }
                            }
                            view.addToRMTable(rawMaterials);
                            break;
                        }
                    }
                }catch(NumberFormatException x){
                    System.out.println("Error No Lee");
                }
            }

            //Delete MP
            if (e.getActionCommand().equalsIgnoreCase("Borrar MP")){
                try{
                   
                    int JtxtDeleteRM = view.getRawMaterialId();
                    
                    for( RawMaterial raw : rawMaterials ){

                        if(raw.getDbId() == JtxtDeleteRM){
                            rawMaterials.remove(raw);
                            view.addToRMTable(rawMaterials);
                            view.clearJtxt();
                            break;
                        }

                    }
                }catch(NumberFormatException x){
                    System.out.println("Error No Lee");
                }
            }
            
            //Update MP
            if (e.getActionCommand().equalsIgnoreCase("Editar MP")){
                try{
                   
                    int rMId = view.getUpdateSectionId();
                    String newName = view.getUpdateSectionName();
                    
                    for( RawMaterial raw : rawMaterials ){

                        if(raw.getDbId() == rMId){
                            raw.setName(newName);
                            view.addToRMTable(rawMaterials);
                            view.clearJtxt();
                            break;
                        }

                    }
                }catch(NumberFormatException x){
                    System.out.println("Error No Lee");
                }
            }
        }
    }
}
