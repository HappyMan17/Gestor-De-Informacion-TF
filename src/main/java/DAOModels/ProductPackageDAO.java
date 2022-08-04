/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOModels;

import connection.ServiceConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Client;
import model.Product;
import model.ProductPackage;

/**
 *
 * @author happy
 */
public class ProductPackageDAO {
    private ProductDAO productDAO;
    
    public ProductPackageDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public ArrayList<ProductPackage> getClients(int packageCode) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<ProductPackage> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (packageCode == 0) {
                sql = "SELECT * FROM application.package ORDER BY package_code";
            } else {
                sql = "SELECT * FROM application.package where package_code = ? "
                        + "ORDER BY package_id";
            }

            pstm = con.prepareStatement(sql);

            if (packageCode != 0) {
                pstm.setInt(1, packageCode);
            }

            rs = pstm.executeQuery();
            ProductPackage productPackage = null;

            while (rs.next()) {
                Product product = productDAO.getProducts(rs.getInt("product_id")+"").get(0);
                productPackage = new ProductPackage(product);

                listado.add(productPackage);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
    
    public void setProductPackage(ProductPackage productPackage) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int productPackageCode = productPackage.getPackageCode();
            int productPackageAmount = productPackage.getProductAmount();
            Double productPackagePrice = productPackage.getSalePrice();
            //int idProduct = productPackage.getProductDbId();
            
            sql = "INSERT INTO application.package (sales_price, client_code) values (?,?)";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, clientName);
            pstm.setInt(1, clientCode);

            int inserted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows inserted: "+inserted);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
    }
    
    public void updateClientName(Client client){
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";
            
            String clientNewName = client.getClientName();
            int clientCode = client.getClientId();
            
            sql = "update application.client set name = ? where client_code = ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, clientNewName);
            pstm.setInt(2, clientCode);

            int updated = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows updated: "+updated);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
    }
    
    public void deleteClient(Client client){
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";
            
            String clientNewName = client.getClientName();
            int clientCode = client.getClientId();
            
            sql = "delete from application.client where name = ? and client_code = ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, clientNewName);
            pstm.setInt(2, clientCode);

            int deleted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows deleted :"+deleted);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
    }
}
