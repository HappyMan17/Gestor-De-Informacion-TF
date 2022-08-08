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

    public ArrayList<ProductPackage> getPackage(int packageCode) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<ProductPackage> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (packageCode == 0) {
                sql = "SELECT * FROM application.package ORDER BY package_id";
            } else {
                sql = "SELECT * FROM application.package where package_id = ? "
                        + "ORDER BY package_id";
            }

            pstm = con.prepareStatement(sql);

            if (packageCode != 0) {
                pstm.setInt(1, packageCode);
            }

            rs = pstm.executeQuery();
            ProductPackage productPackage = null;

            while (rs.next()) {
                Product product = productDAO.getProducts(
                    rs.getInt("product_id")).get(0);
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
            int idProduct = productPackage.getProductDbId();

            sql = "INSERT INTO application.package (sales_price, product_amount, package_code, product_id) values (?,?,?,?)";

            pstm = con.prepareStatement(sql);
            pstm.setDouble(1, productPackagePrice);
            pstm.setInt(2, productPackageAmount);
            pstm.setInt(3, productPackageCode);
            pstm.setInt(4, idProduct);

            int inserted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows inserted: " + inserted);

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

    /**
     *
     * @param productPackage
     */
    public void updateProductPackage(ProductPackage productPackage) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int productPackageCode = productPackage.getPackageCode();
            int productPackageId = productPackage.getDbID();
            int productPackageAmount = productPackage.getProductAmount();
            Double productPackagePrice = productPackage.getSalePrice();

            sql = "update application.package set (sales_price, product_amount, package_code) = (?, ?, ?) where package_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setDouble(1, productPackagePrice);
            pstm.setInt(2, productPackageAmount);
            pstm.setInt(3, productPackageCode);
            pstm.setInt(4, productPackageId);

            int updated = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows updated: " + updated);

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

    public void deleteClient(ProductPackage productPackage) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int productPackageCode = productPackage.getPackageCode();
            int productPackageId = productPackage.getDbID();

            sql = "delete from application.package where package_code = ? and package_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, productPackageCode);
            pstm.setInt(2, productPackageId);

            int deleted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows deleted :" + deleted);

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
