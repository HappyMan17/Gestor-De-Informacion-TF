/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Client;
import model.Seller;
import model.Product;
import model.RawMaterial;

/**
 *
 * @author santi
 */
public class ViewJFrame extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableModel modeloOne = new DefaultTableModel();
    private DefaultTableModel modeloTwo = new DefaultTableModel();
    private DefaultTableModel modeloThree = new DefaultTableModel();
    private int comboBoxNumber;

    /**
     * Creates new form ViewJFrame
     */
    public ViewJFrame() {
        initComponents();
        viewsDisabled(true);

    }

    /**
     * Action Listener y activador de menú de la pestaña MATERIA PRIMA
     *
     * @param listenController
     */
    public void viewsDisabled(boolean abierto) {
        activateRawMaterialPurchaseMenu(abierto);
        activateRawMaterialEditMenu(abierto);
        activateRawMaterialDeleteMenu(abierto);
        activateProductCreationMenu(abierto);
        activateProductEditMenu(abierto);
        activateProductDeleteMenu(abierto);
    }

    public void addListenerBtnBuyMP(ActionListener listenController) {
        jButtonComprarMP.addActionListener(listenController);
    }

    public void addListenerBtnDeleteMP(ActionListener listenController) {
        jButtonBorrarMP.addActionListener(listenController);
    }

    public void addListenerBtnEditMP(ActionListener listenController) {
        jButtonEditarMP.addActionListener(listenController);
    }

    public void addListenerBtnProduction(ActionListener listenController) {
        btnProduction.addActionListener(listenController);
    }

    public void addListenerBtnDeleteProduct(ActionListener listenController) {
        btnBorrrarProducto.addActionListener(listenController);
    }

    public void addListenerBtnEditProduct(ActionListener listenController) {
        btnEditarProducto.addActionListener(listenController);
    }

    public void addListenerJComboBoxChooseSupplier(ActionListener listenController) {
        comboBoxNumber = 1;
        jComboBoxElegirProveedor.addActionListener(listenController);
    }

    public void addListenerJComboBoxChooseMP(ActionListener listenController) {
        jComboBoxElegirMP.addActionListener(listenController);
    }

    public void addListenerRawMaterialPurchaseMenu(ActionListener listenController) {
        //jPanelAgregarMP.addAncestorListener(listenController);
    }

    public void activateRawMaterialPurchaseMenu(boolean activator) {
        jPanelAgregarMP.setVisible(activator);
    }

    public void activateRawMaterialDeleteMenu(boolean activator) {
        jPanelBorrarMP.setVisible(activator);
    }

    public void activateRawMaterialEditMenu(boolean activator) {
        jPanelEditarMP.setVisible(activator);
    }

    /**
     * Añade al comboBox de la vista Materia Prima los nombres de los
     * proveedores
     *
     * @param supplierName
     */
    public void addToComboBoxSupplier(String supplierName) {
        jComboBoxElegirProveedor.addItem(supplierName);
    }

    /**
     * Añade al comboBox de la vista Materia Prima los nombres de las materias
     * primas
     *
     * @param
     */
    public void addToComboBoxRawMaterial(String rawMaterial) {
        jComboBoxElegirMP.addItem(rawMaterial);
    }

    /**
     * Consigue el valor en String de la eleccion del comboBox de supplier
     *
     * @return
     */
    public String getFromComboBoxSupplier() {
        Object content;
        content = jComboBoxElegirProveedor.getSelectedItem();
        return content.toString();
    }

    /**
     * Retorna el número correspondiente al ComboBox
     *
     * @return
     */
    public int comboBoxNumber() {
        return comboBoxNumber;
    }

    /**
     * Limpia los comboBox de MP
     */
    public void clearRMComboBox() {
        jComboBoxElegirMP.removeAllItems();
    }

    /**
     * Limpia los JText utilizados en MP
     */
    public void clearJtxt() {
        jTextFieldCantidadMP.setText("");
        jTextFieldIdABorrarMP.setText("");
        jTextFieldIdAEditarMP.setText("");
        jTextFieldNombreNuevoMP.setText("");
        jTextFieldIdABorrarProducto.setText("");
        jTextFieldCantidadProducto.setText("");
        jTextFieldIdAEditarProducto.setText("");
        jTextFieldPrecioNuevoProducto.setText("");
        jTextFieldNombreCliente.setText("");
        jTextFieldIdCliente.setText("");
        jTextFieldIdABorrarCliente.setText("");
        jTextFieldNombreNuevoCliente.setText("");
        jTextFieldIdAEditarCliente.setText("");
    }

    /**
     * Retorna el contenido del jComboBoxElegirMP
     *
     * @return
     */
    public String getFromComboBoxRawMaterial() {
        Object content;
        content = jComboBoxElegirMP.getSelectedItem();
        return content.toString();
    }

    public String getFromComboBoxProduct() {
        Object content;
        content = jComboBoxProductos.getSelectedItem();
        return content.toString();
    }

    /**
     * Retorna el contenido del jTextFieldCantidadMP
     *
     * @return
     */
    public int getRawMaterialAmount() {
        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(jTextFieldCantidadMP.getText());
        } catch (NumberFormatException x) {
            System.out.println("Error No Lee");
        }

        return cantidad;
    }

    ///////  PESTAÑA PRODUCTOS /////////////
    public void activateProductCreationMenu(boolean activator) {
        jPanelAgregarProducto.setVisible(activator);
    }

    public void activateProductDeleteMenu(boolean activator) {
        jPanelBorrarProducto.setVisible(activator);
    }

    public void activateProductEditMenu(boolean activator) {
        jPanelEditarProducto.setVisible(activator);
    }

    /**
     * Retorna el contenido del JText en productos Update Id
     *
     * @return
     */
    public int getUpdateSectionId() {
        String txt;
        int content = 0;
        try {
            txt = jTextFieldIdAEditarMP.getText();
            content = Integer.parseInt(txt);
        } catch (NumberFormatException x) {
            System.out.println("no es un número");
        }
        return content;
    }

    /**
     * Retorna el contenido del JText en MP Update Name
     *
     * @return
     */
    public String getUpdateSectionName() {
        String txt = jTextFieldNombreNuevoMP.getText();
        return txt;
    }

    public int getDeleteProductId() {
        String txt;
        int number = 0;
        try {
            txt = jTextFieldIdABorrarProducto.getText();
            number = Integer.parseInt(txt);
        } catch (NumberFormatException x) {
            System.out.println("No es un número");
        }
        return number;
    }

    public int getUpdateProductId() {
        String txt;
        int number = 0;
        try {
            txt = jTextFieldIdAEditarProducto.getText();
            number = Integer.parseInt(txt);
        } catch (NumberFormatException x) {
            System.out.println("No es un número");
        }
        return number;
    }

    public double getUpdateProductPrice() {
        String txt;
        double number = 0;
        try {
            txt = jTextFieldPrecioNuevoProducto.getText();
            number = Integer.parseInt(txt);
        } catch (NumberFormatException x) {
            System.out.println("No es un número");
        }
        return number;
    }

    //// PESTAÑA PROVEEDORES ///////
    public void activateSupplierCreationMenu(boolean activator) {
        jPanelAgregarProveedor.setVisible(activator);
    }

    public void activateSupplierDeleteMenu(boolean activator) {
        jPanelBorrarProveedor.setVisible(activator);
    }

    public void activateSupplierEditMenu(boolean activator) {
        jPanelEditarProveedor.setVisible(activator);
    }

    /// PESTAÑA CLIENTES ////
    public void addListenerBtnCreateClient(ActionListener listenController) {
        btnAgregarCliente.addActionListener(listenController);
    }

    public void addActionListenerbtnBorrarCliente(ActionListener listener) {
        btnBorrarCliente.addActionListener(listener);
    }

    public void addActionListenerbtnEditarCliente(ActionListener listener) {
        btnEditarCliente.addActionListener(listener);
    }

    public void activateClientCreationMenu(boolean activator) {
        jPanelAgregarClientes.setVisible(activator);
    }

    public void activateClientDeleteMenu(boolean activator) {
        jPanelBorrarClientes.setVisible(activator);
    }

    public void activateClientEditMenu(boolean activator) {
        jPanelEditarClientes.setVisible(activator);
    }

    public String getClientName() {
        String txt = jTextFieldNombreCliente.getText();
        return txt;
    }

    public String getClientNewName() {
        String txt = jTextFieldNombreNuevoCliente.getText();
        return txt;
    }

    public int getClientIdToDelete() {
        String txt;
        int number = 0;
        try {
            txt = jTextFieldIdABorrarCliente.getText();
            number = Integer.parseInt(txt);
        } catch (NumberFormatException x) {
            JOptionPane.showMessageDialog(null, "Ingrese un número.");
        }
        return number;
    }

    public int getIdToCreateClient() {
        String txt;
        int number = 0;
        try {
            txt = jTextFieldIdCliente.getText();
            number = Integer.parseInt(txt);
        } catch (NumberFormatException x) {
            JOptionPane.showMessageDialog(null, "Ingrese un número.");
        }
        return number;
    }

    public int getIdToUpdateClient() {
        String txt;
        int number = 0;
        try {
            txt = jTextFieldIdAEditarCliente.getText();
            number = Integer.parseInt(txt);
        } catch (NumberFormatException x) {
            JOptionPane.showMessageDialog(null, "Ingrese un número.");
        }
        return number;
    }

    ///// PESTAÑA EMPLEADO //////
    public void addActionListenerJButtonContratarEmpleado(ActionListener A) {
        jButton1.addActionListener(A);
    }

    public void addActionListenerJButtonBorrarEmpleado(ActionListener listener) {
        jButtonBorrarEmpleado.addActionListener(listener);
    }
    
    public void addActionListenerJButtonEditarEmpleado(ActionListener listener) {
        jButtonEditarEmpleado.addActionListener(listener);
    }

    public String getSellerName() {
        String txt = jTextFieldNombreEmpleado.getText();
        return txt;
    }

    public int getSellerCode() {
        String txt;
        int number = 0;
        try {
            txt = jTextFieldIdEmpleado.getText();
            number = Integer.parseInt(txt);
        } catch (NumberFormatException x) {
            JOptionPane.showMessageDialog(null, "Ingrese un número.");
        }
        return number;
    }

    public int getSellerIdToDelete() {
        String txt;
        int number = 0;
        try {
            txt = jTextFieldIdABorrarEmpleado.getText();
            number = Integer.parseInt(txt);
        } catch (NumberFormatException x) {
            JOptionPane.showMessageDialog(null, "Ingrese un número.");
        }
        return number;
    }

    public int getSellerIdToUpdate() {
        String txt;
        int number = 0;
        try {
            txt = jTextFieldIdAEditarEmpleado.getText();
            number = Integer.parseInt(txt);
        } catch (NumberFormatException x) {
            JOptionPane.showMessageDialog(null, "Ingrese un número.");
        }
        return number;
    }

    public String getSellerNewName() {
        String txt = jTextFieldNombreNuevoEmpleado.getText();
        return txt;
    }

    public void activateSellerCreationMenu(boolean activator) {
        jPanelAgregarEmpleado.setVisible(activator);
    }

    public void activateSellerDeleteMenu(boolean activator) {
        jPanelBorrarEmpleado.setVisible(activator);
    }

    public void activateSellerEditMenu(boolean activator) {
        jPanelEditarEmpleado.setVisible(activator);
    }

    /**
     * Retorna el contenido del JText en productos
     *
     * @return
     */
    public int getFromProductAmount() {
        String txt = jTextFieldCantidadProducto.getText();
        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(txt);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ingrese un numero");
        }
        return cantidad;
    }

    /**
     * Retorna el contenido del jTextFieldIdABorrarMP
     *
     * @return
     */
    public int getRawMaterialId() {
        String jTxt = jTextFieldIdABorrarMP.getText();
        int id = 0;
        try {
            id = Integer.parseInt(jTxt);
        } catch (NumberFormatException x) {
            System.out.println("Error No Lee");
        }

        return id;
    }

    //----------------------------------Tablas
    public void addToRMTable(ArrayList<RawMaterial> raw) {
        removeRowsTable(jTableMateriaP, modelo);
        for (RawMaterial rawM : raw) {
            Object[] fila = {rawM.getDbId(), rawM.getName(), rawM.getAmount(), rawM.getUnitPrice()};
            modelo.addRow(fila);
        }
    }

    public void addToProductTable(ArrayList<Product> products) {
        removeRowsTable(jTableProductos, modeloOne);
        for (Product product : products) {
            if (product.getIsOnStock()) {
                Object[] fila = {product.getDatabaseId(), product.getName(),
                    product.getAmount(), product.getPrice(), product.getLotNumber()};
                modeloOne.addRow(fila);
            }
        }
    }

    public void addToClientTable(ArrayList<Client> clients) {
        removeRowsTable(jTableClientes, modeloTwo);
        for (Client client : clients) {
            if (client.getIsActive()) {
                Object[] fila = {client.getDbId(), client.getClientName(), client.getClientId()};
                modeloTwo.addRow(fila);
            }
        }
    }

    public void addToSellerTable(ArrayList<Seller> sellers) {
        removeRowsTable(jTableEmpleados, modeloThree);
        for (Seller seller : sellers) {
            if (seller.getIsActive()) {
                Object[] fila = {seller.getDatabaseId(), seller.getSellerName(), seller.getSellerCode()};
                modeloThree.addRow(fila);
            }
        }
    }

    /**
     * Elimina las filas de la tabla.
     */
    public void removeRowsTable(JTable table, DefaultTableModel model) {
        int filas = table.getRowCount();
        for (int fila = 0; fila < filas; fila++) {
            model.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBarraSuperior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelBarraLateral = new javax.swing.JPanel();
        jLabelLogoBarra = new javax.swing.JLabel();
        jPanelProductos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanelProveedores = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanelClientes = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanelEmpleados = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanelSalir = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanelVentas = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelMateriaPrima = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPaneVentasTabbed = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        barraBotonesVentas = new javax.swing.JPanel();
        btnComprar = new javax.swing.JButton();
        btnDevolver = new javax.swing.JButton();
        btnHistoricoDeVentas = new javax.swing.JButton();
        jScrollPaneVentas = new javax.swing.JScrollPane();
        jTableMateriaP1 = new javax.swing.JTable();
        jPanelComprar = new javax.swing.JPanel();
        jPanelEligeProductoAComprar = new javax.swing.JPanel();
        jComboBoxElegirProductoAComprar = new javax.swing.JComboBox<>();
        jPanelCantidadAComprar = new javax.swing.JPanel();
        jTextFieldCantidadAComprar = new javax.swing.JTextField();
        jPanelEligeVendedor = new javax.swing.JPanel();
        jComboBoxElegirVendedor = new javax.swing.JComboBox<>();
        jPanelEligeProveedor3 = new javax.swing.JPanel();
        jComboBoxElegirCliente = new javax.swing.JComboBox<>();
        btnComprarProducto = new javax.swing.JButton();
        jPanelBorrarVenta = new javax.swing.JPanel();
        jTextFieldIdProductoADevolver = new javax.swing.JTextField();
        btnDevolverProducto = new javax.swing.JButton();
        jPaneMateriaPrimaTabbed = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        barraBotonesMP = new javax.swing.JPanel();
        btnAgregarMp = new javax.swing.JButton();
        btnEliminarMp = new javax.swing.JButton();
        btnActualizarMp = new javax.swing.JButton();
        jScrollPaneMateriaPrima = new javax.swing.JScrollPane();
        jTableMateriaP = new javax.swing.JTable();
        jPanelAgregarMP = new javax.swing.JPanel();
        jPanelEligeProveedor = new javax.swing.JPanel();
        jComboBoxElegirProveedor = new javax.swing.JComboBox<>();
        jPanelEligeMP = new javax.swing.JPanel();
        jComboBoxElegirMP = new javax.swing.JComboBox<>();
        jPanelCantidad = new javax.swing.JPanel();
        jTextFieldCantidadMP = new javax.swing.JTextField();
        jButtonComprarMP = new javax.swing.JButton();
        jPanelBorrarMP = new javax.swing.JPanel();
        jTextFieldIdABorrarMP = new javax.swing.JTextField();
        jButtonBorrarMP = new javax.swing.JButton();
        jPanelEditarMP = new javax.swing.JPanel();
        jPanelIdEditarMP = new javax.swing.JPanel();
        jTextFieldIdAEditarMP = new javax.swing.JTextField();
        jPanelNombreNuevoMP = new javax.swing.JPanel();
        jTextFieldNombreNuevoMP = new javax.swing.JTextField();
        jButtonEditarMP = new javax.swing.JButton();
        jPaneProductosTabbed = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        barraBotonesProductos = new javax.swing.JPanel();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnActualizarProducto = new javax.swing.JButton();
        jScrollPaneProductos = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jPanelAgregarProducto = new javax.swing.JPanel();
        jPanelEligeProducto = new javax.swing.JPanel();
        jComboBoxProductos = new javax.swing.JComboBox<>();
        jPanelCantidadProducto = new javax.swing.JPanel();
        jTextFieldCantidadProducto = new javax.swing.JTextField();
        btnProduction = new javax.swing.JButton();
        jPanelBorrarProducto = new javax.swing.JPanel();
        jTextFieldIdABorrarProducto = new javax.swing.JTextField();
        btnBorrrarProducto = new javax.swing.JButton();
        jPanelEditarProducto = new javax.swing.JPanel();
        jPanelIdEditarProducto = new javax.swing.JPanel();
        jTextFieldIdAEditarProducto = new javax.swing.JTextField();
        jPanelPrecioNuevoProducto = new javax.swing.JPanel();
        jTextFieldPrecioNuevoProducto = new javax.swing.JTextField();
        btnEditarProducto = new javax.swing.JButton();
        jPaneProveedoresTabbed = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        barraBotonesProveedores = new javax.swing.JPanel();
        btnAgregarProveedores = new javax.swing.JButton();
        btnEliminarProveedores = new javax.swing.JButton();
        btnActualizarProveedores = new javax.swing.JButton();
        jScrollPaneProveedores = new javax.swing.JScrollPane();
        jTableProveedores = new javax.swing.JTable();
        jPanelAgregarProveedor = new javax.swing.JPanel();
        jPanelNombreProveedor = new javax.swing.JPanel();
        jTextFieldNombreProveedor = new javax.swing.JTextField();
        jPanelNitProveedor = new javax.swing.JPanel();
        jTextFieldNitProveedor = new javax.swing.JTextField();
        btnContratar = new javax.swing.JButton();
        jPanelBorrarProveedor = new javax.swing.JPanel();
        jTextFieldIdABorrarProveedor = new javax.swing.JTextField();
        btnBorrarProveedor = new javax.swing.JButton();
        jPanelEditarProveedor = new javax.swing.JPanel();
        jPanelIdAEditarProveedor = new javax.swing.JPanel();
        jTextFieldIdAEditarProveedor = new javax.swing.JTextField();
        jPanelNombreNuevoProveedor = new javax.swing.JPanel();
        jTextFieldNombreNuevoProveedor = new javax.swing.JTextField();
        btnEditarProveedor = new javax.swing.JButton();
        jPaneClientesTabbed = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        barraBotonesClientes = new javax.swing.JPanel();
        btnAgregarClientes = new javax.swing.JButton();
        btnEliminarClientes = new javax.swing.JButton();
        btnActualizarClientes = new javax.swing.JButton();
        jScrollPaneClientes = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jPanelAgregarClientes = new javax.swing.JPanel();
        jPanelNombreCliente = new javax.swing.JPanel();
        jTextFieldNombreCliente = new javax.swing.JTextField();
        jPanelIdCliente = new javax.swing.JPanel();
        jTextFieldIdCliente = new javax.swing.JTextField();
        btnAgregarCliente = new javax.swing.JButton();
        jPanelBorrarClientes = new javax.swing.JPanel();
        jTextFieldIdABorrarCliente = new javax.swing.JTextField();
        btnBorrarCliente = new javax.swing.JButton();
        jPanelEditarClientes = new javax.swing.JPanel();
        jPanelIdAEditarCliente = new javax.swing.JPanel();
        jTextFieldIdAEditarCliente = new javax.swing.JTextField();
        jPanelNombreNuevoCliente = new javax.swing.JPanel();
        jTextFieldNombreNuevoCliente = new javax.swing.JTextField();
        btnEditarCliente = new javax.swing.JButton();
        jPaneEmpleadosTabbed = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        barraBotonesEmpleados = new javax.swing.JPanel();
        btnAgregarEmpleados = new javax.swing.JButton();
        btnEliminarEmpleados = new javax.swing.JButton();
        btnActualizarEmpleados = new javax.swing.JButton();
        jScrollPaneEmpleados = new javax.swing.JScrollPane();
        jTableEmpleados = new javax.swing.JTable();
        jPanelAgregarEmpleado = new javax.swing.JPanel();
        jPanelNombreEmpleado = new javax.swing.JPanel();
        jTextFieldNombreEmpleado = new javax.swing.JTextField();
        jPanelIdEmpleado = new javax.swing.JPanel();
        jTextFieldIdEmpleado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanelBorrarEmpleado = new javax.swing.JPanel();
        jTextFieldIdABorrarEmpleado = new javax.swing.JTextField();
        jButtonBorrarEmpleado = new javax.swing.JButton();
        jPanelEditarEmpleado = new javax.swing.JPanel();
        jPanelIdAEditarEmpleado = new javax.swing.JPanel();
        jTextFieldIdAEditarEmpleado = new javax.swing.JTextField();
        jPanelNombreNuevoEmpleado = new javax.swing.JPanel();
        jTextFieldNombreNuevoEmpleado = new javax.swing.JTextField();
        jButtonEditarEmpleado = new javax.swing.JButton();
        jPaneHistoricoVentas = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(java.awt.Color.gray);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBarraSuperior.setBackground(new java.awt.Color(40, 70, 85));
        jPanelBarraSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(187, 187, 187));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel1.setText("G E S T I O N   D E   L A   E M P R E S A");
        jPanelBarraSuperior.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, 20));

        getContentPane().add(jPanelBarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 620, 20));

        jPanelBarraLateral.setBackground(new java.awt.Color(40, 70, 85));
        jPanelBarraLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogoBarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo_peque.png"))); // NOI18N
        jPanelBarraLateral.add(jLabelLogoBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 100));

        jPanelProductos.setBackground(new java.awt.Color(209, 209, 185));
        jPanelProductos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelProductosMouseMoved(evt);
            }
        });
        jPanelProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelProductosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelProductosMouseExited(evt);
            }
        });
        jPanelProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(127, 119, 119));
        jLabel6.setText("PRODUCTOS");
        jPanelProductos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/d0e057c0f1324dffe016a4ec4ef1e928-icono-de-golpe-de-empanada.png"))); // NOI18N
        jPanelProductos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        jPanelBarraLateral.add(jPanelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 200, 40));
        jPanelProductos.getAccessibleContext().setAccessibleName("");

        jPanelProveedores.setBackground(new java.awt.Color(209, 209, 185));
        jPanelProveedores.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelProveedoresMouseMoved(evt);
            }
        });
        jPanelProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelProveedoresMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelProveedoresMouseExited(evt);
            }
        });
        jPanelProveedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(127, 119, 119));
        jLabel8.setText("PROVEEDORES");
        jPanelProveedores.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor.png"))); // NOI18N
        jPanelProveedores.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        jPanelBarraLateral.add(jPanelProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, 40));

        jPanelClientes.setBackground(new java.awt.Color(209, 209, 185));
        jPanelClientes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelClientesMouseMoved(evt);
            }
        });
        jPanelClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelClientesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelClientesMouseExited(evt);
            }
        });
        jPanelClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(127, 119, 119));
        jLabel10.setText("CLIENTES");
        jPanelClientes.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/male3_85205.png"))); // NOI18N
        jPanelClientes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        jPanelBarraLateral.add(jPanelClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, 40));

        jPanelEmpleados.setBackground(new java.awt.Color(209, 209, 185));
        jPanelEmpleados.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelEmpleadosMouseMoved(evt);
            }
        });
        jPanelEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelEmpleadosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelEmpleadosMouseExited(evt);
            }
        });
        jPanelEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/empleado.png"))); // NOI18N
        jPanelEmpleados.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(127, 119, 119));
        jLabel12.setText("EMPLEADOS");
        jPanelEmpleados.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanelBarraLateral.add(jPanelEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 200, 40));

        jPanelSalir.setBackground(new java.awt.Color(209, 209, 185));
        jPanelSalir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelSalirMouseMoved(evt);
            }
        });
        jPanelSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelSalirMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelSalirMouseExited(evt);
            }
        });
        jPanelSalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salir.png"))); // NOI18N
        jPanelSalir.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 30));

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(127, 119, 119));
        jLabel14.setText("SALIR");
        jPanelSalir.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 30));

        jPanelBarraLateral.add(jPanelSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 200, 60));

        jPanelVentas.setBackground(new java.awt.Color(209, 209, 185));
        jPanelVentas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelVentasMouseMoved(evt);
            }
        });
        jPanelVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelVentasMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelVentasMouseExited(evt);
            }
        });
        jPanelVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sell.png"))); // NOI18N
        jPanelVentas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(127, 119, 119));
        jLabel9.setText("VENTAS");
        jPanelVentas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 20));

        jPanelBarraLateral.add(jPanelVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, 40));

        jPanelMateriaPrima.setBackground(new java.awt.Color(209, 209, 185));
        jPanelMateriaPrima.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelMateriaPrimaMouseMoved(evt);
            }
        });
        jPanelMateriaPrima.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMateriaPrimaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMateriaPrimaMouseExited(evt);
            }
        });
        jPanelMateriaPrima.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seeds_122867 (1).png"))); // NOI18N
        jPanelMateriaPrima.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 119, 119));
        jLabel4.setText("MATERIA PRIMA");
        jPanelMateriaPrima.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 20));

        jPanelBarraLateral.add(jPanelMateriaPrima, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, 40));

        getContentPane().add(jPanelBarraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 490));

        jPaneVentasTabbed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(187, 187, 187));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        jLabel21.setText("V E N T A S");
        jPaneVentasTabbed.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 6, -1, -1));

        barraBotonesVentas.setBackground(new java.awt.Color(209, 209, 185));
        barraBotonesVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnComprar.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create2.png"))); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.setBorderPainted(false);
        btnComprar.setContentAreaFilled(false);
        btnComprar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnComprar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraBotonesVentas.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, 59));

        btnDevolver.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnDevolver.setText("Devolución");
        btnDevolver.setBorderPainted(false);
        btnDevolver.setContentAreaFilled(false);
        btnDevolver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDevolver.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraBotonesVentas.add(btnDevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 59));

        btnHistoricoDeVentas.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnHistoricoDeVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/historicoVentas.png"))); // NOI18N
        btnHistoricoDeVentas.setText("Historico de Ventas");
        btnHistoricoDeVentas.setBorderPainted(false);
        btnHistoricoDeVentas.setContentAreaFilled(false);
        btnHistoricoDeVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHistoricoDeVentas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHistoricoDeVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistoricoDeVentasMouseClicked(evt);
            }
        });
        barraBotonesVentas.add(btnHistoricoDeVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, 59));

        jPaneVentasTabbed.add(barraBotonesVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 375, 608, -1));

        jTableMateriaP1.setToolTipText("");
        jScrollPaneVentas.setViewportView(jTableMateriaP1);
        if (jTableMateriaP1.getColumnModel().getColumnCount() > 0) {
            jTableMateriaP1.getColumnModel().getColumn(0).setResizable(false);
            jTableMateriaP1.getColumnModel().getColumn(1).setResizable(false);
            jTableMateriaP1.getColumnModel().getColumn(2).setResizable(false);
            jTableMateriaP1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPaneVentasTabbed.add(jScrollPaneVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 24, 574, 110));

        jPanelComprar.setBorder(javax.swing.BorderFactory.createTitledBorder("Comprar "));
        jPanelComprar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelEligeProductoAComprar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elige el producto a comprar", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jComboBoxElegirProductoAComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxElegirProductoAComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEligeProductoAComprarLayout = new javax.swing.GroupLayout(jPanelEligeProductoAComprar);
        jPanelEligeProductoAComprar.setLayout(jPanelEligeProductoAComprarLayout);
        jPanelEligeProductoAComprarLayout.setHorizontalGroup(
            jPanelEligeProductoAComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEligeProductoAComprarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxElegirProductoAComprar, 0, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelEligeProductoAComprarLayout.setVerticalGroup(
            jPanelEligeProductoAComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEligeProductoAComprarLayout.createSequentialGroup()
                .addComponent(jComboBoxElegirProductoAComprar)
                .addGap(62, 62, 62))
        );

        jPanelComprar.add(jPanelEligeProductoAComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 260, 50));

        jPanelCantidadAComprar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elige la Cantidad", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelCantidadAComprarLayout = new javax.swing.GroupLayout(jPanelCantidadAComprar);
        jPanelCantidadAComprar.setLayout(jPanelCantidadAComprarLayout);
        jPanelCantidadAComprarLayout.setHorizontalGroup(
            jPanelCantidadAComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCantidadAComprarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldCantidadAComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanelCantidadAComprarLayout.setVerticalGroup(
            jPanelCantidadAComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCantidadAComprarLayout.createSequentialGroup()
                .addComponent(jTextFieldCantidadAComprar)
                .addContainerGap())
        );

        jPanelComprar.add(jPanelCantidadAComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 130, 50));

        jPanelEligeVendedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elige el vendedor", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jComboBoxElegirVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxElegirVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEligeVendedorLayout = new javax.swing.GroupLayout(jPanelEligeVendedor);
        jPanelEligeVendedor.setLayout(jPanelEligeVendedorLayout);
        jPanelEligeVendedorLayout.setHorizontalGroup(
            jPanelEligeVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEligeVendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxElegirVendedor, 0, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelEligeVendedorLayout.setVerticalGroup(
            jPanelEligeVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEligeVendedorLayout.createSequentialGroup()
                .addComponent(jComboBoxElegirVendedor)
                .addContainerGap())
        );

        jPanelComprar.add(jPanelEligeVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 260, 50));

        jPanelEligeProveedor3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "¿Quién sos?", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jComboBoxElegirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxElegirClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEligeProveedor3Layout = new javax.swing.GroupLayout(jPanelEligeProveedor3);
        jPanelEligeProveedor3.setLayout(jPanelEligeProveedor3Layout);
        jPanelEligeProveedor3Layout.setHorizontalGroup(
            jPanelEligeProveedor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEligeProveedor3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxElegirCliente, 0, 238, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelEligeProveedor3Layout.setVerticalGroup(
            jPanelEligeProveedor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEligeProveedor3Layout.createSequentialGroup()
                .addComponent(jComboBoxElegirCliente)
                .addContainerGap())
        );

        jPanelComprar.add(jPanelEligeProveedor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 50));

        btnComprarProducto.setText("Comprar Producto");
        jPanelComprar.add(btnComprarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jPaneVentasTabbed.add(jPanelComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 330, 230));

        jPanelBorrarVenta.setBorder(javax.swing.BorderFactory.createTitledBorder("ID de producto a devolver"));
        jPanelBorrarVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldIdProductoADevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdProductoADevolverActionPerformed(evt);
            }
        });
        jPanelBorrarVenta.add(jTextFieldIdProductoADevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 24, 121, -1));

        btnDevolverProducto.setText("Devolver");
        jPanelBorrarVenta.add(btnDevolverProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jPaneVentasTabbed.add(jPanelBorrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 169, 100));

        jTabbedPane1.addTab("Ventas", jPaneVentasTabbed);

        jPaneMateriaPrimaTabbed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(187, 187, 187));
        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        jLabel19.setText("M A T E R I A   P R I M A");
        jPaneMateriaPrimaTabbed.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 6, -1, -1));

        barraBotonesMP.setBackground(new java.awt.Color(209, 209, 185));
        barraBotonesMP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarMp.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnAgregarMp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create2.png"))); // NOI18N
        btnAgregarMp.setText("Agregar MP");
        btnAgregarMp.setBorderPainted(false);
        btnAgregarMp.setContentAreaFilled(false);
        btnAgregarMp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarMp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarMp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMpMouseClicked(evt);
            }
        });
        barraBotonesMP.add(btnAgregarMp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 59));

        btnEliminarMp.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnEliminarMp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnEliminarMp.setText("Eliminar MP");
        btnEliminarMp.setBorderPainted(false);
        btnEliminarMp.setContentAreaFilled(false);
        btnEliminarMp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarMp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarMp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMpMouseClicked(evt);
            }
        });
        barraBotonesMP.add(btnEliminarMp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 59));

        btnActualizarMp.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnActualizarMp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update2.png"))); // NOI18N
        btnActualizarMp.setText("Actualizar MP");
        btnActualizarMp.setBorderPainted(false);
        btnActualizarMp.setContentAreaFilled(false);
        btnActualizarMp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarMp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizarMp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMpMouseClicked(evt);
            }
        });
        barraBotonesMP.add(btnActualizarMp, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, 59));

        jPaneMateriaPrimaTabbed.add(barraBotonesMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 375, 608, -1));

        jTableMateriaP.setToolTipText("");
        jScrollPaneMateriaPrima.setViewportView(jTableMateriaP);
        if (jTableMateriaP.getColumnModel().getColumnCount() > 0) {
            jTableMateriaP.getColumnModel().getColumn(0).setResizable(false);
            jTableMateriaP.getColumnModel().getColumn(1).setResizable(false);
            jTableMateriaP.getColumnModel().getColumn(2).setResizable(false);
            jTableMateriaP.getColumnModel().getColumn(3).setResizable(false);
        }
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO/U");
        jTableMateriaP.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);
        jTableMateriaP.getAccessibleContext().setAccessibleName("");

        jPaneMateriaPrimaTabbed.add(jScrollPaneMateriaPrima, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 24, 574, 122));

        jPanelAgregarMP.setBorder(javax.swing.BorderFactory.createTitledBorder("Comprar Materia Prima"));
        jPanelAgregarMP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelEligeProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elige Proveedor", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jComboBoxElegirProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxElegirProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEligeProveedorLayout = new javax.swing.GroupLayout(jPanelEligeProveedor);
        jPanelEligeProveedor.setLayout(jPanelEligeProveedorLayout);
        jPanelEligeProveedorLayout.setHorizontalGroup(
            jPanelEligeProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEligeProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxElegirProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEligeProveedorLayout.setVerticalGroup(
            jPanelEligeProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEligeProveedorLayout.createSequentialGroup()
                .addComponent(jComboBoxElegirProveedor)
                .addContainerGap())
        );

        jPanelAgregarMP.add(jPanelEligeProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 50));

        jPanelEligeMP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elige la Materia Prima", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelEligeMPLayout = new javax.swing.GroupLayout(jPanelEligeMP);
        jPanelEligeMP.setLayout(jPanelEligeMPLayout);
        jPanelEligeMPLayout.setHorizontalGroup(
            jPanelEligeMPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEligeMPLayout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addComponent(jComboBoxElegirMP, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelEligeMPLayout.setVerticalGroup(
            jPanelEligeMPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEligeMPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxElegirMP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelAgregarMP.add(jPanelEligeMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 50));

        jPanelCantidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elige la Cantidad", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTextFieldCantidadMP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldCantidadMPMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelCantidadLayout = new javax.swing.GroupLayout(jPanelCantidad);
        jPanelCantidad.setLayout(jPanelCantidadLayout);
        jPanelCantidadLayout.setHorizontalGroup(
            jPanelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCantidadLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jTextFieldCantidadMP, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelCantidadLayout.setVerticalGroup(
            jPanelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldCantidadMP, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanelAgregarMP.add(jPanelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 40));

        jButtonComprarMP.setText("Comprar MP");
        jPanelAgregarMP.add(jButtonComprarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jPaneMateriaPrimaTabbed.add(jPanelAgregarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 152, 200, 220));

        jPanelBorrarMP.setBorder(javax.swing.BorderFactory.createTitledBorder("ID a Borrar"));
        jPanelBorrarMP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldIdABorrarMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdABorrarMPActionPerformed(evt);
            }
        });
        jPanelBorrarMP.add(jTextFieldIdABorrarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 24, 121, -1));

        jButtonBorrarMP.setText("Borrar MP");
        jButtonBorrarMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarMPActionPerformed(evt);
            }
        });
        jPanelBorrarMP.add(jButtonBorrarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jPaneMateriaPrimaTabbed.add(jPanelBorrarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 220, 143, 100));

        jPanelEditarMP.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Materia Prima"));
        jPanelEditarMP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelIdEditarMP.setBorder(javax.swing.BorderFactory.createTitledBorder("ID a Editar"));

        javax.swing.GroupLayout jPanelIdEditarMPLayout = new javax.swing.GroupLayout(jPanelIdEditarMP);
        jPanelIdEditarMP.setLayout(jPanelIdEditarMPLayout);
        jPanelIdEditarMPLayout.setHorizontalGroup(
            jPanelIdEditarMPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdEditarMPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdAEditarMP)
                .addContainerGap())
        );
        jPanelIdEditarMPLayout.setVerticalGroup(
            jPanelIdEditarMPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdEditarMPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdAEditarMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanelEditarMP.add(jPanelIdEditarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 34, 172, -1));

        jPanelNombreNuevoMP.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre nuevo"));

        jTextFieldNombreNuevoMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreNuevoMPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNombreNuevoMPLayout = new javax.swing.GroupLayout(jPanelNombreNuevoMP);
        jPanelNombreNuevoMP.setLayout(jPanelNombreNuevoMPLayout);
        jPanelNombreNuevoMPLayout.setHorizontalGroup(
            jPanelNombreNuevoMPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreNuevoMPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreNuevoMP, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNombreNuevoMPLayout.setVerticalGroup(
            jPanelNombreNuevoMPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreNuevoMPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreNuevoMP)
                .addContainerGap())
        );

        jPanelEditarMP.add(jPanelNombreNuevoMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 102, -1, -1));

        jButtonEditarMP.setText("Editar MP");
        jPanelEditarMP.add(jButtonEditarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jPaneMateriaPrimaTabbed.add(jPanelEditarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 152, -1, 210));

        jTabbedPane1.addTab("Materia Prima", jPaneMateriaPrimaTabbed);

        jLabel20.setBackground(new java.awt.Color(187, 187, 187));
        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        jLabel20.setText("P R O D U C T O S");

        barraBotonesProductos.setBackground(new java.awt.Color(209, 209, 185));
        barraBotonesProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarProducto.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create2.png"))); // NOI18N
        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.setBorderPainted(false);
        btnAgregarProducto.setContentAreaFilled(false);
        btnAgregarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        barraBotonesProductos.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 59));

        btnEliminarProducto.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnEliminarProducto.setText("Eliminar Producto");
        btnEliminarProducto.setBorderPainted(false);
        btnEliminarProducto.setContentAreaFilled(false);
        btnEliminarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraBotonesProductos.add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 59));

        btnActualizarProducto.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnActualizarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update2.png"))); // NOI18N
        btnActualizarProducto.setText("Actualizar Producto");
        btnActualizarProducto.setBorderPainted(false);
        btnActualizarProducto.setContentAreaFilled(false);
        btnActualizarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraBotonesProductos.add(btnActualizarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, 59));

        jTableProductos.setToolTipText("");
        jScrollPaneProductos.setViewportView(jTableProductos);
        if (jTableProductos.getColumnModel().getColumnCount() > 0) {
            jTableProductos.getColumnModel().getColumn(0).setResizable(false);
            jTableProductos.getColumnModel().getColumn(1).setResizable(false);
            jTableProductos.getColumnModel().getColumn(2).setResizable(false);
            jTableProductos.getColumnModel().getColumn(3).setResizable(false);
        }
        modeloOne.addColumn("ID");
        modeloOne.addColumn("Nombre");
        modeloOne.addColumn("CANTIDAD");
        modeloOne.addColumn("PRECIO/U");
        modeloOne.addColumn("Numero de Lote");
        jTableProductos.setModel(modeloOne);

        jPanelAgregarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Crear Producto"));
        jPanelAgregarProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelEligeProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elige el Producto", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jComboBoxProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Papa Rellena", "Empanada", "Pastel de Pollo" }));

        javax.swing.GroupLayout jPanelEligeProductoLayout = new javax.swing.GroupLayout(jPanelEligeProducto);
        jPanelEligeProducto.setLayout(jPanelEligeProductoLayout);
        jPanelEligeProductoLayout.setHorizontalGroup(
            jPanelEligeProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEligeProductoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEligeProductoLayout.setVerticalGroup(
            jPanelEligeProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEligeProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelAgregarProducto.add(jPanelEligeProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, -1));

        jPanelCantidadProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elige la Cantidad", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelCantidadProductoLayout = new javax.swing.GroupLayout(jPanelCantidadProducto);
        jPanelCantidadProducto.setLayout(jPanelCantidadProductoLayout);
        jPanelCantidadProductoLayout.setHorizontalGroup(
            jPanelCantidadProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCantidadProductoLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jTextFieldCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelCantidadProductoLayout.setVerticalGroup(
            jPanelCantidadProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCantidadProductoLayout.createSequentialGroup()
                .addComponent(jTextFieldCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanelAgregarProducto.add(jPanelCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 50));

        btnProduction.setText("Producción");
        btnProduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductionActionPerformed(evt);
            }
        });
        jPanelAgregarProducto.add(btnProduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jPanelBorrarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("ID a Borrar"));
        jPanelBorrarProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldIdABorrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdABorrarProductoActionPerformed(evt);
            }
        });
        jPanelBorrarProducto.add(jTextFieldIdABorrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 24, 121, -1));

        btnBorrrarProducto.setText("Borrar Producto");
        jPanelBorrarProducto.add(btnBorrrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanelEditarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Producto"));
        jPanelEditarProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelIdEditarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("ID a Editar"));

        javax.swing.GroupLayout jPanelIdEditarProductoLayout = new javax.swing.GroupLayout(jPanelIdEditarProducto);
        jPanelIdEditarProducto.setLayout(jPanelIdEditarProductoLayout);
        jPanelIdEditarProductoLayout.setHorizontalGroup(
            jPanelIdEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdEditarProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdAEditarProducto)
                .addContainerGap())
        );
        jPanelIdEditarProductoLayout.setVerticalGroup(
            jPanelIdEditarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdEditarProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdAEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelEditarProducto.add(jPanelIdEditarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 36, 172, 60));

        jPanelPrecioNuevoProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio nuevo"));

        jTextFieldPrecioNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecioNuevoProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrecioNuevoProductoLayout = new javax.swing.GroupLayout(jPanelPrecioNuevoProducto);
        jPanelPrecioNuevoProducto.setLayout(jPanelPrecioNuevoProductoLayout);
        jPanelPrecioNuevoProductoLayout.setHorizontalGroup(
            jPanelPrecioNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrecioNuevoProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldPrecioNuevoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelPrecioNuevoProductoLayout.setVerticalGroup(
            jPanelPrecioNuevoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrecioNuevoProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldPrecioNuevoProducto)
                .addContainerGap())
        );

        jPanelEditarProducto.add(jPanelPrecioNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 102, -1, -1));

        btnEditarProducto.setText("Editar Producto");
        jPanelEditarProducto.add(btnEditarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 120, -1));

        javax.swing.GroupLayout jPaneProductosTabbedLayout = new javax.swing.GroupLayout(jPaneProductosTabbed);
        jPaneProductosTabbed.setLayout(jPaneProductosTabbedLayout);
        jPaneProductosTabbedLayout.setHorizontalGroup(
            jPaneProductosTabbedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraBotonesProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPaneProductosTabbedLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPaneProductosTabbedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPaneProductosTabbedLayout.createSequentialGroup()
                        .addComponent(jPanelAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPaneProductosTabbedLayout.setVerticalGroup(
            jPaneProductosTabbedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneProductosTabbedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPaneProductosTabbedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPaneProductosTabbedLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPaneProductosTabbedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPaneProductosTabbedLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jPanelBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPaneProductosTabbedLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelEditarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(barraBotonesProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Productos", jPaneProductosTabbed);

        jPaneProveedoresTabbed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(187, 187, 187));
        jLabel24.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        jLabel24.setText("P R O V E E D O R E S");
        jPaneProveedoresTabbed.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 6, -1, -1));

        barraBotonesProveedores.setBackground(new java.awt.Color(209, 209, 185));
        barraBotonesProveedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarProveedores.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnAgregarProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create2.png"))); // NOI18N
        btnAgregarProveedores.setText("Agregar Proveedor");
        btnAgregarProveedores.setBorderPainted(false);
        btnAgregarProveedores.setContentAreaFilled(false);
        btnAgregarProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedoresActionPerformed(evt);
            }
        });
        barraBotonesProveedores.add(btnAgregarProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 59));

        btnEliminarProveedores.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnEliminarProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnEliminarProveedores.setText("Eliminar Proveedor");
        btnEliminarProveedores.setBorderPainted(false);
        btnEliminarProveedores.setContentAreaFilled(false);
        btnEliminarProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraBotonesProveedores.add(btnEliminarProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 59));

        btnActualizarProveedores.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnActualizarProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update2.png"))); // NOI18N
        btnActualizarProveedores.setText("Actualizar Proveedor");
        btnActualizarProveedores.setBorderPainted(false);
        btnActualizarProveedores.setContentAreaFilled(false);
        btnActualizarProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraBotonesProveedores.add(btnActualizarProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, 59));

        jPaneProveedoresTabbed.add(barraBotonesProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 375, 608, -1));

        jTableProveedores.setToolTipText("");
        jScrollPaneProveedores.setViewportView(jTableProveedores);
        if (jTableProveedores.getColumnModel().getColumnCount() > 0) {
            jTableProveedores.getColumnModel().getColumn(0).setResizable(false);
            jTableProveedores.getColumnModel().getColumn(1).setResizable(false);
            jTableProveedores.getColumnModel().getColumn(2).setResizable(false);
            jTableProveedores.getColumnModel().getColumn(3).setResizable(false);
        }

        jPaneProveedoresTabbed.add(jScrollPaneProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 24, 574, 122));

        jPanelAgregarProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Contratar Proveedor"));
        jPanelAgregarProveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelNombreProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del Proveedor", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelNombreProveedorLayout = new javax.swing.GroupLayout(jPanelNombreProveedor);
        jPanelNombreProveedor.setLayout(jPanelNombreProveedorLayout);
        jPanelNombreProveedorLayout.setHorizontalGroup(
            jPanelNombreProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNombreProveedorLayout.setVerticalGroup(
            jPanelNombreProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreProveedorLayout.createSequentialGroup()
                .addComponent(jTextFieldNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelAgregarProveedor.add(jPanelNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, -1));

        jPanelNitProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NIT del Proveedor", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelNitProveedorLayout = new javax.swing.GroupLayout(jPanelNitProveedor);
        jPanelNitProveedor.setLayout(jPanelNitProveedorLayout);
        jPanelNitProveedorLayout.setHorizontalGroup(
            jPanelNitProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNitProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNitProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNitProveedorLayout.setVerticalGroup(
            jPanelNitProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNitProveedorLayout.createSequentialGroup()
                .addComponent(jTextFieldNitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelAgregarProveedor.add(jPanelNitProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 50));

        btnContratar.setText("Contratar Proveedor");
        jPanelAgregarProveedor.add(btnContratar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 160, 30));

        jPaneProveedoresTabbed.add(jPanelAgregarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 190, 220));

        jPanelBorrarProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("ID a Borrar"));
        jPanelBorrarProveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldIdABorrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdABorrarProveedorActionPerformed(evt);
            }
        });
        jPanelBorrarProveedor.add(jTextFieldIdABorrarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 24, 121, -1));

        btnBorrarProveedor.setText("Borrar Proveedor");
        jPanelBorrarProveedor.add(btnBorrarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jPaneProveedoresTabbed.add(jPanelBorrarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 143, 110));

        jPanelEditarProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Proveedor"));
        jPanelEditarProveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelIdAEditarProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("ID a Editar"));

        javax.swing.GroupLayout jPanelIdAEditarProveedorLayout = new javax.swing.GroupLayout(jPanelIdAEditarProveedor);
        jPanelIdAEditarProveedor.setLayout(jPanelIdAEditarProveedorLayout);
        jPanelIdAEditarProveedorLayout.setHorizontalGroup(
            jPanelIdAEditarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdAEditarProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdAEditarProveedor)
                .addContainerGap())
        );
        jPanelIdAEditarProveedorLayout.setVerticalGroup(
            jPanelIdAEditarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdAEditarProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdAEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanelEditarProveedor.add(jPanelIdAEditarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 34, 172, -1));

        jPanelNombreNuevoProveedor.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre nuevo"));

        jTextFieldNombreNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreNuevoProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNombreNuevoProveedorLayout = new javax.swing.GroupLayout(jPanelNombreNuevoProveedor);
        jPanelNombreNuevoProveedor.setLayout(jPanelNombreNuevoProveedorLayout);
        jPanelNombreNuevoProveedorLayout.setHorizontalGroup(
            jPanelNombreNuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreNuevoProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreNuevoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNombreNuevoProveedorLayout.setVerticalGroup(
            jPanelNombreNuevoProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreNuevoProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreNuevoProveedor)
                .addContainerGap())
        );

        jPanelEditarProveedor.add(jPanelNombreNuevoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 102, -1, -1));

        btnEditarProveedor.setText("Editar Proveedor");
        jPanelEditarProveedor.add(btnEditarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jPaneProveedoresTabbed.add(jPanelEditarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 190, 210));

        jTabbedPane1.addTab("Proveedores", jPaneProveedoresTabbed);

        jPaneClientesTabbed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(187, 187, 187));
        jLabel25.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        jLabel25.setText("C L I E N T E S");
        jPaneClientesTabbed.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 6, -1, -1));

        barraBotonesClientes.setBackground(new java.awt.Color(209, 209, 185));
        barraBotonesClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarClientes.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnAgregarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create2.png"))); // NOI18N
        btnAgregarClientes.setText("Agregar Clientes");
        btnAgregarClientes.setBorderPainted(false);
        btnAgregarClientes.setContentAreaFilled(false);
        btnAgregarClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClientesActionPerformed(evt);
            }
        });
        barraBotonesClientes.add(btnAgregarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 59));

        btnEliminarClientes.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnEliminarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnEliminarClientes.setText("Eliminar Clientes");
        btnEliminarClientes.setBorderPainted(false);
        btnEliminarClientes.setContentAreaFilled(false);
        btnEliminarClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraBotonesClientes.add(btnEliminarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 59));

        btnActualizarClientes.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnActualizarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update2.png"))); // NOI18N
        btnActualizarClientes.setText("Actualizar Clientes");
        btnActualizarClientes.setBorderPainted(false);
        btnActualizarClientes.setContentAreaFilled(false);
        btnActualizarClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraBotonesClientes.add(btnActualizarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, 59));

        jPaneClientesTabbed.add(barraBotonesClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 375, 608, -1));

        jTableClientes.setToolTipText("");
        jScrollPaneClientes.setViewportView(jTableClientes);
        if (jTableClientes.getColumnModel().getColumnCount() > 0) {
            jTableClientes.getColumnModel().getColumn(0).setResizable(false);
            jTableClientes.getColumnModel().getColumn(1).setResizable(false);
            jTableClientes.getColumnModel().getColumn(2).setResizable(false);
            jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        }
        modeloTwo.addColumn("ID");
        modeloTwo.addColumn("Nombre");
        modeloTwo.addColumn("Código del Cliente");
        jTableClientes.setModel(modeloTwo);

        jPaneClientesTabbed.add(jScrollPaneClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 24, 574, 122));

        jPanelAgregarClientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Cliente"));
        jPanelAgregarClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelNombreCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del Cliente", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelNombreClienteLayout = new javax.swing.GroupLayout(jPanelNombreCliente);
        jPanelNombreCliente.setLayout(jPanelNombreClienteLayout);
        jPanelNombreClienteLayout.setHorizontalGroup(
            jPanelNombreClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNombreClienteLayout.setVerticalGroup(
            jPanelNombreClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreClienteLayout.createSequentialGroup()
                .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanelAgregarClientes.add(jPanelNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, -1));

        jPanelIdCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID del Cliente", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelIdClienteLayout = new javax.swing.GroupLayout(jPanelIdCliente);
        jPanelIdCliente.setLayout(jPanelIdClienteLayout);
        jPanelIdClienteLayout.setHorizontalGroup(
            jPanelIdClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIdClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelIdClienteLayout.setVerticalGroup(
            jPanelIdClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdClienteLayout.createSequentialGroup()
                .addComponent(jTextFieldIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanelAgregarClientes.add(jPanelIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 170, 50));

        btnAgregarCliente.setText("Agregar Cliente");
        jPanelAgregarClientes.add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jPaneClientesTabbed.add(jPanelAgregarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 190, 180));

        jPanelBorrarClientes.setBorder(javax.swing.BorderFactory.createTitledBorder("ID a Borrar"));
        jPanelBorrarClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldIdABorrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdABorrarClienteActionPerformed(evt);
            }
        });
        jPanelBorrarClientes.add(jTextFieldIdABorrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 24, 121, -1));

        btnBorrarCliente.setText("Borrar Cliente");
        jPanelBorrarClientes.add(btnBorrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPaneClientesTabbed.add(jPanelBorrarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 234, 143, 100));

        jPanelEditarClientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Cliente"));
        jPanelEditarClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelIdAEditarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("ID a Editar"));

        javax.swing.GroupLayout jPanelIdAEditarClienteLayout = new javax.swing.GroupLayout(jPanelIdAEditarCliente);
        jPanelIdAEditarCliente.setLayout(jPanelIdAEditarClienteLayout);
        jPanelIdAEditarClienteLayout.setHorizontalGroup(
            jPanelIdAEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdAEditarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdAEditarCliente)
                .addContainerGap())
        );
        jPanelIdAEditarClienteLayout.setVerticalGroup(
            jPanelIdAEditarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdAEditarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdAEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanelEditarClientes.add(jPanelIdAEditarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 34, 172, -1));

        jPanelNombreNuevoCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre nuevo"));

        jTextFieldNombreNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreNuevoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNombreNuevoClienteLayout = new javax.swing.GroupLayout(jPanelNombreNuevoCliente);
        jPanelNombreNuevoCliente.setLayout(jPanelNombreNuevoClienteLayout);
        jPanelNombreNuevoClienteLayout.setHorizontalGroup(
            jPanelNombreNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreNuevoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreNuevoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNombreNuevoClienteLayout.setVerticalGroup(
            jPanelNombreNuevoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreNuevoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreNuevoCliente)
                .addContainerGap())
        );

        jPanelEditarClientes.add(jPanelNombreNuevoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 102, -1, -1));

        btnEditarCliente.setText("Editar Cliente");
        jPanelEditarClientes.add(btnEditarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jPaneClientesTabbed.add(jPanelEditarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, 200));

        jTabbedPane1.addTab("Clientes", jPaneClientesTabbed);

        jPaneEmpleadosTabbed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(187, 187, 187));
        jLabel26.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        jLabel26.setText("E M P L E A D O S");
        jPaneEmpleadosTabbed.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 6, -1, -1));

        barraBotonesEmpleados.setBackground(new java.awt.Color(209, 209, 185));
        barraBotonesEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarEmpleados.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnAgregarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create2.png"))); // NOI18N
        btnAgregarEmpleados.setText("Agregar Empleado");
        btnAgregarEmpleados.setBorderPainted(false);
        btnAgregarEmpleados.setContentAreaFilled(false);
        btnAgregarEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpleadosActionPerformed(evt);
            }
        });
        barraBotonesEmpleados.add(btnAgregarEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 59));

        btnEliminarEmpleados.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnEliminarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnEliminarEmpleados.setText("Eliminar Empleado");
        btnEliminarEmpleados.setBorderPainted(false);
        btnEliminarEmpleados.setContentAreaFilled(false);
        btnEliminarEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraBotonesEmpleados.add(btnEliminarEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 59));

        btnActualizarEmpleados.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnActualizarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update2.png"))); // NOI18N
        btnActualizarEmpleados.setText("Actualizar Empleado");
        btnActualizarEmpleados.setBorderPainted(false);
        btnActualizarEmpleados.setContentAreaFilled(false);
        btnActualizarEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEmpleadosActionPerformed(evt);
            }
        });
        barraBotonesEmpleados.add(btnActualizarEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, 59));

        jPaneEmpleadosTabbed.add(barraBotonesEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 375, 608, -1));

        jTableEmpleados.setToolTipText("");
        jScrollPaneEmpleados.setViewportView(jTableEmpleados);
        if (jTableEmpleados.getColumnModel().getColumnCount() > 0) {
            jTableEmpleados.getColumnModel().getColumn(0).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(1).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(2).setResizable(false);
            jTableEmpleados.getColumnModel().getColumn(3).setResizable(false);
        }
        modeloThree.addColumn("ID");
        modeloThree.addColumn("Nombre");
        modeloThree.addColumn("Código del Empleado");
        jTableEmpleados.setModel(modeloThree);

        jPaneEmpleadosTabbed.add(jScrollPaneEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 24, 574, 122));

        jPanelAgregarEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Empleado"));
        jPanelAgregarEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelNombreEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre del Empleado", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelNombreEmpleadoLayout = new javax.swing.GroupLayout(jPanelNombreEmpleado);
        jPanelNombreEmpleado.setLayout(jPanelNombreEmpleadoLayout);
        jPanelNombreEmpleadoLayout.setHorizontalGroup(
            jPanelNombreEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNombreEmpleadoLayout.setVerticalGroup(
            jPanelNombreEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreEmpleadoLayout.createSequentialGroup()
                .addComponent(jTextFieldNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanelAgregarEmpleado.add(jPanelNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, -1));

        jPanelIdEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID del Empleado", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanelIdEmpleadoLayout = new javax.swing.GroupLayout(jPanelIdEmpleado);
        jPanelIdEmpleado.setLayout(jPanelIdEmpleadoLayout);
        jPanelIdEmpleadoLayout.setHorizontalGroup(
            jPanelIdEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIdEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelIdEmpleadoLayout.setVerticalGroup(
            jPanelIdEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdEmpleadoLayout.createSequentialGroup()
                .addComponent(jTextFieldIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanelAgregarEmpleado.add(jPanelIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, 50));

        jButton1.setText("Contratar Empleado");
        jPanelAgregarEmpleado.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jPaneEmpleadosTabbed.add(jPanelAgregarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 190, 190));

        jPanelBorrarEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("ID a Borrar"));
        jPanelBorrarEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldIdABorrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdABorrarEmpleadoActionPerformed(evt);
            }
        });
        jPanelBorrarEmpleado.add(jTextFieldIdABorrarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 24, 121, -1));

        jButtonBorrarEmpleado.setText("Borrar Empleado");
        jPanelBorrarEmpleado.add(jButtonBorrarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jPaneEmpleadosTabbed.add(jPanelBorrarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 234, 143, 100));

        jPanelEditarEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Empleado"));
        jPanelEditarEmpleado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelIdAEditarEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("ID a Editar"));

        javax.swing.GroupLayout jPanelIdAEditarEmpleadoLayout = new javax.swing.GroupLayout(jPanelIdAEditarEmpleado);
        jPanelIdAEditarEmpleado.setLayout(jPanelIdAEditarEmpleadoLayout);
        jPanelIdAEditarEmpleadoLayout.setHorizontalGroup(
            jPanelIdAEditarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdAEditarEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdAEditarEmpleado)
                .addContainerGap())
        );
        jPanelIdAEditarEmpleadoLayout.setVerticalGroup(
            jPanelIdAEditarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIdAEditarEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldIdAEditarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanelEditarEmpleado.add(jPanelIdAEditarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 34, 172, -1));

        jPanelNombreNuevoEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre nuevo"));

        jTextFieldNombreNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreNuevoEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNombreNuevoEmpleadoLayout = new javax.swing.GroupLayout(jPanelNombreNuevoEmpleado);
        jPanelNombreNuevoEmpleado.setLayout(jPanelNombreNuevoEmpleadoLayout);
        jPanelNombreNuevoEmpleadoLayout.setHorizontalGroup(
            jPanelNombreNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreNuevoEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreNuevoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelNombreNuevoEmpleadoLayout.setVerticalGroup(
            jPanelNombreNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNombreNuevoEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldNombreNuevoEmpleado)
                .addContainerGap())
        );

        jPanelEditarEmpleado.add(jPanelNombreNuevoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jButtonEditarEmpleado.setText("Editar Empleado");
        jPanelEditarEmpleado.add(jButtonEditarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 40));

        jPaneEmpleadosTabbed.add(jPanelEditarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, 210));

        jTabbedPane1.addTab("Empleados", jPaneEmpleadosTabbed);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Histórico de Ventas"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 490, 370));

        javax.swing.GroupLayout jPaneHistoricoVentasLayout = new javax.swing.GroupLayout(jPaneHistoricoVentas);
        jPaneHistoricoVentas.setLayout(jPaneHistoricoVentasLayout);
        jPaneHistoricoVentasLayout.setHorizontalGroup(
            jPaneHistoricoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneHistoricoVentasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPaneHistoricoVentasLayout.setVerticalGroup(
            jPaneHistoricoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneHistoricoVentasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("HdV", jPaneHistoricoVentas);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 610, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelMateriaPrimaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMateriaPrimaMouseClicked
        activateRawMaterialPurchaseMenu(false);
        activateRawMaterialEditMenu(false);
        activateRawMaterialDeleteMenu(false);
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jPanelMateriaPrimaMouseClicked

    private void jPanelMateriaPrimaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMateriaPrimaMouseMoved
        jPanelMateriaPrima.setBackground(new Color(216, 200, 232));
    }//GEN-LAST:event_jPanelMateriaPrimaMouseMoved

    private void jPanelMateriaPrimaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMateriaPrimaMouseExited
        jPanelMateriaPrima.setBackground(new Color(231, 231, 216));
    }//GEN-LAST:event_jPanelMateriaPrimaMouseExited

    private void jPanelProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProductosMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jPanelProductosMouseClicked

    private void jPanelProductosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProductosMouseMoved
        jPanelProductos.setBackground(new Color(216, 200, 232));
    }//GEN-LAST:event_jPanelProductosMouseMoved

    private void jPanelProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProductosMouseExited
        jPanelProductos.setBackground(new Color(231, 231, 216));
    }//GEN-LAST:event_jPanelProductosMouseExited

    private void jPanelProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProveedoresMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jPanelProveedoresMouseClicked

    private void jPanelProveedoresMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProveedoresMouseMoved
        jPanelProveedores.setBackground(new Color(216, 200, 232));
    }//GEN-LAST:event_jPanelProveedoresMouseMoved

    private void jPanelClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelClientesMouseClicked
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jPanelClientesMouseClicked

    private void jPanelClientesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelClientesMouseMoved
        jPanelClientes.setBackground(new Color(216, 200, 232));
    }//GEN-LAST:event_jPanelClientesMouseMoved

    private void jPanelClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelClientesMouseExited
        jPanelClientes.setBackground(new Color(231, 231, 216));
    }//GEN-LAST:event_jPanelClientesMouseExited

    private void jPanelEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEmpleadosMouseClicked
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jPanelEmpleadosMouseClicked

    private void jPanelEmpleadosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEmpleadosMouseMoved
        jPanelEmpleados.setBackground(new Color(216, 200, 232));
    }//GEN-LAST:event_jPanelEmpleadosMouseMoved

    private void jPanelEmpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEmpleadosMouseExited
        jPanelEmpleados.setBackground(new Color(231, 231, 216));
    }//GEN-LAST:event_jPanelEmpleadosMouseExited

    private void jPanelSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSalirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelSalirMouseClicked

    private void jPanelSalirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSalirMouseMoved
        jPanelSalir.setBackground(new Color(216, 200, 232));
    }//GEN-LAST:event_jPanelSalirMouseMoved

    private void jPanelSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelSalirMouseExited
        jPanelSalir.setBackground(new Color(231, 231, 216));
    }//GEN-LAST:event_jPanelSalirMouseExited

    private void jPanelProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelProveedoresMouseExited
        jPanelProveedores.setBackground(new Color(231, 231, 216));
    }//GEN-LAST:event_jPanelProveedoresMouseExited

    private void jPanelVentasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVentasMouseMoved
        jPanelVentas.setBackground(new Color(216, 200, 232));
    }//GEN-LAST:event_jPanelVentasMouseMoved

    private void jPanelVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVentasMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jPanelVentasMouseClicked

    private void jPanelVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVentasMouseExited
        jPanelVentas.setBackground(new Color(231, 231, 216));
    }//GEN-LAST:event_jPanelVentasMouseExited

    private void jTextFieldNombreNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreNuevoEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreNuevoEmpleadoActionPerformed

    private void jTextFieldIdABorrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdABorrarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdABorrarEmpleadoActionPerformed

    private void btnActualizarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarEmpleadosActionPerformed

    private void btnAgregarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarEmpleadosActionPerformed

    private void jTextFieldNombreNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreNuevoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreNuevoClienteActionPerformed

    private void jTextFieldIdABorrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdABorrarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdABorrarClienteActionPerformed

    private void btnAgregarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarClientesActionPerformed

    private void jTextFieldNombreNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreNuevoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreNuevoProveedorActionPerformed

    private void jTextFieldIdABorrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdABorrarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdABorrarProveedorActionPerformed

    private void btnAgregarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarProveedoresActionPerformed

    private void jTextFieldPrecioNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecioNuevoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecioNuevoProductoActionPerformed

    private void jTextFieldIdABorrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdABorrarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdABorrarProductoActionPerformed

    private void btnProductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductionActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void jTextFieldNombreNuevoMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreNuevoMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreNuevoMPActionPerformed

    private void jButtonBorrarMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBorrarMPActionPerformed

    private void jTextFieldIdABorrarMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdABorrarMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdABorrarMPActionPerformed

    private void jTextFieldCantidadMPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCantidadMPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadMPMouseClicked

    private void jComboBoxElegirProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxElegirProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxElegirProveedorActionPerformed

    private void btnActualizarMpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMpMouseClicked
        activateRawMaterialEditMenu(true);
    }//GEN-LAST:event_btnActualizarMpMouseClicked

    private void btnEliminarMpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMpMouseClicked
        activateRawMaterialDeleteMenu(true);
    }//GEN-LAST:event_btnEliminarMpMouseClicked

    private void btnAgregarMpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMpMouseClicked
        activateRawMaterialPurchaseMenu(true);
        jTextFieldCantidadMP.requestFocusInWindow();
    }//GEN-LAST:event_btnAgregarMpMouseClicked

    private void jTextFieldIdProductoADevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdProductoADevolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdProductoADevolverActionPerformed

    private void jComboBoxElegirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxElegirClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxElegirClienteActionPerformed

    private void jComboBoxElegirVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxElegirVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxElegirVendedorActionPerformed

    private void jComboBoxElegirProductoAComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxElegirProductoAComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxElegirProductoAComprarActionPerformed

    private void btnHistoricoDeVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoricoDeVentasMouseClicked
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_btnHistoricoDeVentasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraBotonesClientes;
    private javax.swing.JPanel barraBotonesEmpleados;
    private javax.swing.JPanel barraBotonesMP;
    private javax.swing.JPanel barraBotonesProductos;
    private javax.swing.JPanel barraBotonesProveedores;
    private javax.swing.JPanel barraBotonesVentas;
    private javax.swing.JButton btnActualizarClientes;
    private javax.swing.JButton btnActualizarEmpleados;
    private javax.swing.JButton btnActualizarMp;
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnActualizarProveedores;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnAgregarClientes;
    private javax.swing.JButton btnAgregarEmpleados;
    private javax.swing.JButton btnAgregarMp;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnAgregarProveedores;
    private javax.swing.JButton btnBorrarCliente;
    private javax.swing.JButton btnBorrarProveedor;
    private javax.swing.JButton btnBorrrarProducto;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnComprarProducto;
    private javax.swing.JButton btnContratar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnDevolverProducto;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEliminarClientes;
    private javax.swing.JButton btnEliminarEmpleados;
    private javax.swing.JButton btnEliminarMp;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnEliminarProveedores;
    private javax.swing.JButton btnHistoricoDeVentas;
    private javax.swing.JButton btnProduction;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBorrarEmpleado;
    private javax.swing.JButton jButtonBorrarMP;
    private javax.swing.JButton jButtonComprarMP;
    private javax.swing.JButton jButtonEditarEmpleado;
    private javax.swing.JButton jButtonEditarMP;
    private javax.swing.JComboBox<String> jComboBoxElegirCliente;
    private javax.swing.JComboBox<String> jComboBoxElegirMP;
    private javax.swing.JComboBox<String> jComboBoxElegirProductoAComprar;
    private javax.swing.JComboBox<String> jComboBoxElegirProveedor;
    private javax.swing.JComboBox<String> jComboBoxElegirVendedor;
    private javax.swing.JComboBox<String> jComboBoxProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLogoBarra;
    private javax.swing.JPanel jPaneClientesTabbed;
    private javax.swing.JPanel jPaneEmpleadosTabbed;
    private javax.swing.JPanel jPaneHistoricoVentas;
    private javax.swing.JPanel jPaneMateriaPrimaTabbed;
    private javax.swing.JPanel jPaneProductosTabbed;
    private javax.swing.JPanel jPaneProveedoresTabbed;
    private javax.swing.JPanel jPaneVentasTabbed;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAgregarClientes;
    private javax.swing.JPanel jPanelAgregarEmpleado;
    private javax.swing.JPanel jPanelAgregarMP;
    private javax.swing.JPanel jPanelAgregarProducto;
    private javax.swing.JPanel jPanelAgregarProveedor;
    private javax.swing.JPanel jPanelBarraLateral;
    private javax.swing.JPanel jPanelBarraSuperior;
    private javax.swing.JPanel jPanelBorrarClientes;
    private javax.swing.JPanel jPanelBorrarEmpleado;
    private javax.swing.JPanel jPanelBorrarMP;
    private javax.swing.JPanel jPanelBorrarProducto;
    private javax.swing.JPanel jPanelBorrarProveedor;
    private javax.swing.JPanel jPanelBorrarVenta;
    private javax.swing.JPanel jPanelCantidad;
    private javax.swing.JPanel jPanelCantidadAComprar;
    private javax.swing.JPanel jPanelCantidadProducto;
    private javax.swing.JPanel jPanelClientes;
    private javax.swing.JPanel jPanelComprar;
    private javax.swing.JPanel jPanelEditarClientes;
    private javax.swing.JPanel jPanelEditarEmpleado;
    private javax.swing.JPanel jPanelEditarMP;
    private javax.swing.JPanel jPanelEditarProducto;
    private javax.swing.JPanel jPanelEditarProveedor;
    private javax.swing.JPanel jPanelEligeMP;
    private javax.swing.JPanel jPanelEligeProducto;
    private javax.swing.JPanel jPanelEligeProductoAComprar;
    private javax.swing.JPanel jPanelEligeProveedor;
    private javax.swing.JPanel jPanelEligeProveedor3;
    private javax.swing.JPanel jPanelEligeVendedor;
    private javax.swing.JPanel jPanelEmpleados;
    private javax.swing.JPanel jPanelIdAEditarCliente;
    private javax.swing.JPanel jPanelIdAEditarEmpleado;
    private javax.swing.JPanel jPanelIdAEditarProveedor;
    private javax.swing.JPanel jPanelIdCliente;
    private javax.swing.JPanel jPanelIdEditarMP;
    private javax.swing.JPanel jPanelIdEditarProducto;
    private javax.swing.JPanel jPanelIdEmpleado;
    private javax.swing.JPanel jPanelMateriaPrima;
    private javax.swing.JPanel jPanelNitProveedor;
    private javax.swing.JPanel jPanelNombreCliente;
    private javax.swing.JPanel jPanelNombreEmpleado;
    private javax.swing.JPanel jPanelNombreNuevoCliente;
    private javax.swing.JPanel jPanelNombreNuevoEmpleado;
    private javax.swing.JPanel jPanelNombreNuevoMP;
    private javax.swing.JPanel jPanelNombreNuevoProveedor;
    private javax.swing.JPanel jPanelNombreProveedor;
    private javax.swing.JPanel jPanelPrecioNuevoProducto;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JPanel jPanelProveedores;
    private javax.swing.JPanel jPanelSalir;
    private javax.swing.JPanel jPanelVentas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneClientes;
    private javax.swing.JScrollPane jScrollPaneEmpleados;
    private javax.swing.JScrollPane jScrollPaneMateriaPrima;
    private javax.swing.JScrollPane jScrollPaneProductos;
    private javax.swing.JScrollPane jScrollPaneProveedores;
    private javax.swing.JScrollPane jScrollPaneVentas;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTable jTableEmpleados;
    private javax.swing.JTable jTableMateriaP;
    private javax.swing.JTable jTableMateriaP1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTable jTableProveedores;
    private javax.swing.JTextField jTextFieldCantidadAComprar;
    private javax.swing.JTextField jTextFieldCantidadMP;
    private javax.swing.JTextField jTextFieldCantidadProducto;
    private javax.swing.JTextField jTextFieldIdABorrarCliente;
    private javax.swing.JTextField jTextFieldIdABorrarEmpleado;
    private javax.swing.JTextField jTextFieldIdABorrarMP;
    private javax.swing.JTextField jTextFieldIdABorrarProducto;
    private javax.swing.JTextField jTextFieldIdABorrarProveedor;
    private javax.swing.JTextField jTextFieldIdAEditarCliente;
    private javax.swing.JTextField jTextFieldIdAEditarEmpleado;
    private javax.swing.JTextField jTextFieldIdAEditarMP;
    private javax.swing.JTextField jTextFieldIdAEditarProducto;
    private javax.swing.JTextField jTextFieldIdAEditarProveedor;
    private javax.swing.JTextField jTextFieldIdCliente;
    private javax.swing.JTextField jTextFieldIdEmpleado;
    private javax.swing.JTextField jTextFieldIdProductoADevolver;
    private javax.swing.JTextField jTextFieldNitProveedor;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldNombreEmpleado;
    private javax.swing.JTextField jTextFieldNombreNuevoCliente;
    private javax.swing.JTextField jTextFieldNombreNuevoEmpleado;
    private javax.swing.JTextField jTextFieldNombreNuevoMP;
    private javax.swing.JTextField jTextFieldNombreNuevoProveedor;
    private javax.swing.JTextField jTextFieldNombreProveedor;
    private javax.swing.JTextField jTextFieldPrecioNuevoProducto;
    // End of variables declaration//GEN-END:variables
}
