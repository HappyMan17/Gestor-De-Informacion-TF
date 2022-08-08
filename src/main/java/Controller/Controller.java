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
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Seller> sellers = new ArrayList<>();
    private ArrayList<RawMaterial> rawMaterials = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Production> productions = new ArrayList<>();

    //Methods
    public Controller(ViewJFrame view) {

        this.view = view;
        this.clientDAO = new ClientDAO();
        this.productDAO = new ProductDAO();
        this.productPackageDAO = new ProductPackageDAO(productDAO);
        this.productionDAO = new ProductionDAO();
        this.productionDetailsDAO = new ProductionDetailsDAO();
        this.rawMaterialDAO = new RawMaterialDAO();
        this.salesDetailsDAO = new SalesDetailsDAO();
        this.sellerDAO = new SellerDAO();
        this.supplierDAO = new SupplierDAO();

        this.suppliers = supplierDAO.getSuppliers(0);
        addToSuppliers();
        rawMaterials = rawMaterialDAO.getRawMaterial(0);
        view.addToRMTable(rawMaterials);
        setProductsFromDb();
        
        this.view.addListenerJComboBoxChooseSupplier(new CalculateListener());
        this.view.addListenerBtnBuyMP(new CalculateListener());
        this.view.addListenerBtnDeleteMP(new CalculateListener());
        this.view.addListenerBtnEditMP(new CalculateListener());
        this.view.addListenerBtnProduction(new CalculateListener());
        this.view.addListenerBtnDeleteProduct(new CalculateListener());
        this.view.addListenerBtnEditProduct(new CalculateListener());
        this.view.addListenerBtnCreateClient(new CalculateListener());
        this.view.addActionListenerJButtonContratarEmpleado(new CalculateListener());
        
    }

    public void addToSuppliers() {
        ArrayList<RawMaterial> rMSupplierOne = new ArrayList<>();
        ArrayList<RawMaterial> rMSupplierTwo = new ArrayList<>();
        ArrayList<RawMaterial> rMSupplierThree = new ArrayList<>();

        int supOneCode = suppliers.get(0).getSupplierCode();
        int supTwoCode = suppliers.get(1).getSupplierCode();
        int supThreeCode = suppliers.get(2).getSupplierCode();

        int supOneId = suppliers.get(0).getDbId();
        int supTwoId = suppliers.get(1).getDbId();
        int supThreeId = suppliers.get(2).getDbId();

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

        suppliers.get(0).setRawMaterial(rMSupplierOne);
        suppliers.get(1).setRawMaterial(rMSupplierTwo);
        suppliers.get(2).setRawMaterial(rMSupplierThree);

        addToComboboxSupplier();
    }

    public void addToComboboxSupplier() {
        view.addToComboBoxSupplier("Seleccione un proveedor");
        for (Supplier suppli : suppliers) {
            view.addToComboBoxSupplier(suppli.getSupplierName());
        }
    }
    
    public void setProductsFromDb(){
        products = productDAO.getProducts(0);
        view.addToProductTable(products);
    }
    
    public void setClientFromDb(){
        System.out.println(clients = clientDAO.getClients(0));
        view.addToClientTable(clients);
    }
    
    public void setSellerFromDb(){
        sellers = sellerDAO.getSeller(0);
        view.addToSellerTable(sellers);
    }

    public boolean confirmExistence(String rmName, int amount, RawMaterial rawMat) {
        for (RawMaterial raw : rawMaterials) {
            if (rmName.equals(raw.getName())) {
                //Local:
                raw.modifyAmount(amount);
                //DataBase
                rawMaterialDAO.updateRawMaterial(raw);
                //Supplier:
                rawMat.modifyAmount(-amount);
                view.clearJtxt();
                return true;
            }
        }
        return false;
    }
    
    public boolean confirmProductExistence(String productName, int amount) {
        for (Product Localproduct : products) {
            if (productName.equals(Localproduct.getName())) {
                //Local:
                Localproduct.modifyAmount(amount);
                //DataBase
                Localproduct.setIsOnStock(true);
                productDAO.updateProduct(Localproduct);
                products = productDAO.getProducts(0);
                view.clearJtxt();
                return true;
            }
        }
        return false;
    }
    
    public boolean confirmClientExistence(String clientName, int clientId) {
        for (Client client : clients) {
            if (clientId == client.getClientId() && !client.getIsActive()) {
                //Local:
                client.setClientName(clientName);
                //DataBase
                client.setIsActive(true);
                clientDAO.updateClientName(client);
                clients = clientDAO.getClients(0);
                view.clearJtxt();
                return true;
            }
            if (clientId == client.getClientId() && client.getIsActive()) {
                JOptionPane.showMessageDialog(null, "El cliente ya existe.");
                return true;
            }
        }
        return false;
    }
    
    public boolean confirmSellerExistence(String name, int code) {
        for (Seller seller : sellers) {
            if (code == seller.getSellerCode() && !seller.getIsActive()) {
                //Local:
                seller.setSellerName(name);
                //DataBase
                seller.setIsActive(true);
                sellerDAO.updateSeller(seller);
                sellers = sellerDAO.getSeller(0);
                view.clearJtxt();
                return true;
            }
            if (code == seller.getSellerCode() && seller.getIsActive()) {
                JOptionPane.showMessageDialog(null, "El empleado ya existe.");
                return true;
            }
            
        }
        return false;
    }
    
    public void deleteRawMaterialUsed(){
        for( RawMaterial raw: rawMaterials ){
            if( raw.getAmount() == 0 ){
                rawMaterialDAO.deleteRawMaterial(raw);
            }
        }
    }

    class CalculateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //ComboBoxes:
            if (e.getActionCommand().equalsIgnoreCase("comboBoxChanged") && view.comboBoxNumber() == 1) { //Agregar un int a cada cbox || number == 2)

                view.clearRMComboBox();
                try {
                    
                    String supName = view.getFromComboBoxSupplier();
                    for (Supplier sup : suppliers) {
                        if (sup.getSupplierName().equals(supName)) {
                            for (RawMaterial raw : sup.getRawMaterial()) {
                                view.addToComboBoxRawMaterial(raw.getName());
                            }
                            break;
                        }

                    }
                    
                } catch (NullPointerException x) {
                    System.out.println(x.getMessage());
                }
            }

            //Buy MP
            if (e.getActionCommand().equalsIgnoreCase("Comprar MP")) {
                try {
                    
                    String rwName = view.getFromComboBoxRawMaterial();
                    String supName = view.getFromComboBoxSupplier();
                    int JtxtContenido = view.getRawMaterialAmount();

                    for (Supplier sup : suppliers) {

                        if (sup.getSupplierName().equals(supName)) {
                            for (RawMaterial raw : sup.getRawMaterial()) {
                                if (raw.getName().equals(rwName)) {
                                    if (raw.getAmount() >= JtxtContenido) {
                                        if (!confirmExistence(rwName, JtxtContenido, raw)) {
                                            RawMaterial ourRaw = (RawMaterial) raw.clone();

                                            raw.modifyAmount(-JtxtContenido);
                                            ourRaw.setAmount(JtxtContenido);

                                            rawMaterials.add(ourRaw);
                                            //DataBase:
                                            rawMaterialDAO.setRawMaterial(ourRaw);
                                            view.clearJtxt();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                            "El proveedor no cuenta con esa cantidad actualmente");
                                    }
                                }
                            }
                            view.addToRMTable(rawMaterials);
                            break;
                        }
                    }
                    
                } catch (NumberFormatException x) {
                    System.out.println("Error No Lee");
                }
            }

            //Delete MP
            if (e.getActionCommand().equalsIgnoreCase("Borrar MP")) {
                try {

                    int JtxtDeleteRM = view.getRawMaterialId();

                    for (RawMaterial raw : rawMaterials) {

                        if (raw.getDbId() == JtxtDeleteRM) {
                            rawMaterials.remove(raw);
                            //DataBase
                            rawMaterialDAO.deleteRawMaterial(raw);
                            view.addToRMTable(rawMaterials);
                            view.clearJtxt();
                            break;
                        }

                    }
                    
                } catch (NumberFormatException x) {
                    System.out.println("Error No Lee");
                }
            }

            //Update MP
            if (e.getActionCommand().equalsIgnoreCase("Editar MP")) {
                try {

                    int rMId = view.getUpdateSectionId();
                    String newName = view.getUpdateSectionName();

                    for (RawMaterial raw : rawMaterials) {

                        if (raw.getDbId() == rMId) {
                            raw.setName(newName);
                            //DataBase
                            rawMaterialDAO.updateRawMaterial(raw);
                            view.addToRMTable(rawMaterials);
                            view.clearJtxt();
                            break;
                        }

                    }
                    
                } catch (NumberFormatException x) {
                    System.out.println("Error No Lee");
                }
            }

            //Create Product
            if (e.getActionCommand().equalsIgnoreCase("Producción")) {
                try{
                    
                    int cantidadAProducir = view.getFromProductAmount();
                    String comboBoxProduct = view.getFromComboBoxProduct();
                    
                    Production production = new Production(comboBoxProduct);
                    production.setIngredients(rawMaterials);
                    production.createNewProduct(cantidadAProducir);
                    Product product = production.getNewProduct();
                    
                    if(product != null){
                        productionDAO.setProduction(production);
                        productions = productionDAO.getProduction(0);
                        
                        if( !confirmProductExistence(product.getName(), product.getAmount()) ){
                            productDAO.setProduct(product);
                            products = productDAO.getProducts(0);
                        }
                        
                        for( RawMaterial raw : product.getIngredients() ){
                            int rawId, rawAmount, productionId;
                            rawId = raw.getDbId();
                            rawAmount = raw.getAmount();
                            productionId = productions.get(productions.size()-1).getDatabaseId();
                            Product lastProduct = products.get(products.size()-1);

                            ProductionDetails details = new ProductionDetails(rawId, rawAmount, productionId);
                            details.setProductId(lastProduct.getDatabaseId());
                            
                            productionDetailsDAO.setProductionDetails(details);
                        }
                        //deleteRawMaterialUsed();
                        view.clearJtxt();
                        view.addToProductTable(products);
                    }
                    
                }catch(NumberFormatException x) {
                    System.out.println("No se pudo crear el producto");
                }
            }
            //Delete Product
            if (e.getActionCommand().equalsIgnoreCase("Borrar Producto")) {
                try{
                    
                    int productToDeleteId = view.getDeleteProductId();
                    for (Product product : products) {

                        if (product.getDatabaseId()== productToDeleteId) {
                            //DataBase
                            product.setIsOnStock(false);
                            productDAO.deleteProduct(product);
                            setProductsFromDb();
                            view.clearJtxt();
                            break;
                        }

                    }
                    
                }catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número");
                }
            }
            //Update Product
            if (e.getActionCommand().equalsIgnoreCase("Editar Producto")) {
                try{
                    
                    int productToUpdateId = view.getUpdateProductId();
                    Double productToUpdatePrice = view.getUpdateProductPrice();
                    
                    for (Product product : products) {

                        if (product.getDatabaseId()== productToUpdateId) {
                            product.setPrice(productToUpdatePrice);
                            //DataBase
                            productDAO.updateProduct(product);
                            view.clearJtxt();
                            setProductsFromDb();
                            break;
                        }

                    }
                    
                }catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número");
                }
            }
            //Create Client
            if (e.getActionCommand().equalsIgnoreCase("Agregar Cliente")) {
                try{
                    
                    int clientId = view.getIdToCreateClient();
                    String clientName = view.getClientName();
                    
                    if( !confirmClientExistence(clientName, clientId)){
                        Client client = new Client(clientName, clientId);
                        client.setIsActive(true);
                        clientDAO.setClients(client);
                        clients.add(client);
                        System.out.println(clients.get(0).getClientName());
                    }
                    setClientFromDb();
                    
                }catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número");
                }
            }
            //Delete Client
            if (e.getActionCommand().equalsIgnoreCase("Borrar Cliente")){
                try{
                    
                    int clientId = view.getClientIdToDelete();
                    for (Client client : clients) {

                        if (client.getDbId() == clientId) {
                            //DataBase
                            client.setIsActive(false);
                            clientDAO.deleteClient(client);
                            view.clearJtxt();
                            setClientFromDb();
                            break;
                        }

                    }
                    
                }catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número");
                }
            }
            //Update Client
            if (e.getActionCommand().equalsIgnoreCase("Editar Cliente")){
                try{
                    
                    int clientId = view.getIdToUpdateClient();
                    String newClientName = view.getClientNewName();
                    
                    for (Client client : clients) {

                        if (client.getDbId() == clientId) {
                            //DataBase
                            client.setIsActive(true);
                            client.setClientName(newClientName);
                            clientDAO.updateClientName(client);
                            view.clearJtxt();
                            setClientFromDb();
                            break;
                        }

                    }
                    
                }catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número");
                }
            }
            
            //Create Seller
            if (e.getActionCommand().equalsIgnoreCase("Contratar Empleado")) {
                try{
                    
                    int sellerCode = view.getSellerCode();
                    String sellerName = view.getSellerName();
                    
                    if( !confirmSellerExistence(sellerName, sellerCode)){
                        Seller seller = new Seller(sellerCode, sellerName);
                        seller.setIsActive(true);
                        sellerDAO.setSeller(seller);
                    }
                    setSellerFromDb();
                    
                }catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número");
                }
            }
            
            //Delete Seller
            if (e.getActionCommand().equalsIgnoreCase("Borrar Empleado")){
                try{
                    
                    int sellerId = view.getSellerIdToDelete();
                    
                    for (Seller seller : sellers) {

                        if (seller.getDatabaseId() == sellerId) {
                            //DataBase
                            seller.setIsActive(false);
                            sellerDAO.deleteSeller(seller);
                            view.clearJtxt();
                            setSellerFromDb();
                            break;
                        }

                    }
                    
                }catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número");
                }
            }
            
            //Update Seller
            if (e.getActionCommand().equalsIgnoreCase("Editar Empleado")){
                try{
                    
                    int sellerId = view.getSellerIdToUpdate();
                    String newSellerName = view.getSellerNewName();
                    
                    for (Seller seller : sellers) {

                        if (seller.getDatabaseId() == sellerId) {
                            //DataBase
                            seller.setIsActive(true);
                            seller.setSellerName(newSellerName);
                            sellerDAO.updateSeller(seller);
                            view.clearJtxt();
                            setClientFromDb();
                            break;
                        }

                    }
                    
                }catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número");
                }
            }
        }
    }
}
