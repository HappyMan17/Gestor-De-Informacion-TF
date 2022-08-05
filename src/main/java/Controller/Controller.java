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
    public Controller(ViewJFrame view, ClientDAO clientDAO, ProductDAO productDAO, 
            ProductPackageDAO productPackageDAO, ProductionDAO productionDAO, 
            ProductionDetailsDAO productionDetailsDAO, RawMaterialDAO rawMaterialDAO, 
            SalesDetailsDAO salesDetailsDAO, SellerDAO sellerDAO, 
            SupplierDAO supplierDAO) {
        
        this.view = view;
        this.clientDAO = clientDAO;
        this.productDAO = productDAO;
        this.productPackageDAO = productPackageDAO;
        this.productionDAO = productionDAO;
        this.productionDetailsDAO = productionDetailsDAO;
        this.rawMaterialDAO = rawMaterialDAO;
        this.salesDetailsDAO = salesDetailsDAO;
        this.sellerDAO = sellerDAO;
        this.supplierDAO = supplierDAO;
        
        createSuppliers();
        
        this.view.addListenerJComboBoxChooseSupplier(new CalculateListener());
        //this.view.addListenerJComboBoxChooseMP(new CalculateListener());
        this.view.addListenerBtnBuyMP(new CalculateListener());
    }
    
    public void createSuppliers(){
        ArrayList<RawMaterial> rMSupplierOne = new ArrayList<>();
        ArrayList<RawMaterial> rMSupplierTwo = new ArrayList<>();
        ArrayList<RawMaterial> rMSupplierThree = new ArrayList<>();
        
        RawMaterial papa = new RawMaterial("Papa", 800.0, 1, 001, 100);
        RawMaterial arroz = new RawMaterial("Arroz", 1500.0, 2, 001, 100);
        rMSupplierOne.add(papa);
        rMSupplierOne.add(arroz);
        RawMaterial carne = new RawMaterial("Carne", 12500.0, 3, 002, 100);
        RawMaterial pollo = new RawMaterial("Pollo", 9600.0, 4, 002, 100);
        rMSupplierTwo.add(carne);
        rMSupplierTwo.add(pollo);
        RawMaterial huevo = new RawMaterial("Huevo", 600.0, 5, 003, 100);
        RawMaterial harina = new RawMaterial("Harina", 1800.0, 6, 003, 100);
        rMSupplierThree.add(huevo);
        rMSupplierThree.add(harina);
        
        Supplier supOne = new Supplier("La miseria SAS", 10001, 001, 1);
        supOne.setRawMaterial(rMSupplierOne);
        Supplier supTwo = new Supplier("Enrico SAS", 10011, 002, 2);
        supTwo.setRawMaterial(rMSupplierTwo);
        Supplier supThree = new Supplier("Quesitos LTDA", 10010, 003, 3);
        supThree.setRawMaterial(rMSupplierThree);

        suppliers.add(supOne);
        suppliers.add(supTwo);
        suppliers.add(supThree);
        
        addToComboboxSupplier();
    }
    
    public void addToComboboxSupplier(){
        for( Supplier supli : suppliers ){
            view.addToComboBoxSupplier(supli.getSupplierName());
        }
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
                    System.out.println(suppliers.get(0).getRawMaterial());
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
            //JText
            if (e.getActionCommand().equalsIgnoreCase("Comprar MP")){
                try{
                    String rwName = view.getFromComboBoxRawMaterial();
                    String supName = view.getFromComboBoxSupplier();
                    int JtxtContenido = view.getRawMaterialAmount();
                    
                    for( Supplier sup : suppliers ){
                    
                        if(sup.getSupplierName().equals(supName)){
                            for( RawMaterial raw : sup.getRawMaterial() ){
                                if( raw.getName().equals(rwName) ){
                                    if( raw.getAmount() > JtxtContenido ){
                                        System.out.println(raw.getName()+" Size:"+
                                            rawMaterials.size());
                                        rawMaterials.add(raw);
                                    }else {
                                        JOptionPane.showMessageDialog(null, 
                                            "El proveedor no cuenta con esa cantidad actualmente");
                                    }
                                }
                            }
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
