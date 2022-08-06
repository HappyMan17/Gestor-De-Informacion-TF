/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package main;

import Controller.Controller;
import DAOModels.*;
//import DAOModels.ClientDAO;
//import DAOModels.ProductDAO;
//import DAOModels.ProductPackageDAO;
import view.ViewJFrame;

/**
 *
 * @author happy
 */
public class TFPI {

    public static void main(String[] args) {
        //DAOS
        ClientDAO clientDAO = new ClientDAO();
        ProductDAO productDAO = new ProductDAO();
        ProductPackageDAO productPackageDAO = new ProductPackageDAO(productDAO);
        ProductionDAO productionDAO = new ProductionDAO();
        ProductionDetailsDAO productionDetailsDAO = new ProductionDetailsDAO();
        RawMaterialDAO rawMaterialDAO = new RawMaterialDAO();
        SalesDetailsDAO salesDetailsDAO = new SalesDetailsDAO();
        SellerDAO sellerDAO = new SellerDAO();
        SupplierDAO supplierDAO = new SupplierDAO();
        
        //View and controller
        ViewJFrame view = new ViewJFrame();
        view.setVisible(true);
        Controller controller = new Controller(view);
        /*
        Controller controller = new Controller(view, clientDAO, productDAO, 
            productPackageDAO, productionDAO, productionDetailsDAO, 
                rawMaterialDAO, salesDetailsDAO, sellerDAO, supplierDAO);
        */
    }
}
