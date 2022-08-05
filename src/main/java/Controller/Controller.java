/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAOModels.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        this.view.addListenerBtnAgregarRawMaterial(new CalculateListener());
        this.view.addListenerBtnEliminarRawMaterial(new CalculateListener());
        this.view.addListenerBtnAgregarProducto(new CalculateListener());
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
        }
    }
}
