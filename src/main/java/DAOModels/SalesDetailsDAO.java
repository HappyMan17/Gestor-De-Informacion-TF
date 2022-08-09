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
import model.ProductionDetails;
import model.SalesDetails;

/**
 *
 * @author happy
 */
public class SalesDetailsDAO {
    
    public SalesDetailsDAO() {}

    public ArrayList<SalesDetails> getSalesDetails(int salesDetailsId) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<SalesDetails> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (salesDetailsId == -1) {
                sql = "SELECT * FROM application.sales_details ORDER BY sales_detail_id";
            } else {
                sql = "SELECT * FROM application.sales_details where sales_detail_id = ? "
                        + "ORDER BY sales_detail_id";
            }

            pstm = con.prepareStatement(sql);

            if (salesDetailsId != -1) {
                pstm.setInt(1, salesDetailsId);
            }

            rs = pstm.executeQuery();
            SalesDetails salesDetails = null;

            while (rs.next()) {
                salesDetails = new SalesDetails();
                salesDetails.setProductId(rs.getInt("product_id"));
                salesDetails.setPackageId(rs.getInt("package_id"));
                salesDetails.setAmount(rs.getInt("amount"));
                salesDetails.setPrice(rs.getDouble("price"));

                listado.add(salesDetails);
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

    public void setSalesDetails(SalesDetails salesDetails) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int salesDetailsId = salesDetails.getSalesDetailId();
            int productId = salesDetails.getProductId();
            int packageId = salesDetails.getPackageId();
            int amount = salesDetails.getAmount();
            Double price = salesDetails.getPrice();

            if( productId == 0 ){
                sql = "INSERT INTO application.sales_details (sales_detail_id, package_id, amount, price) values (?, ?, ?, ?)";
            }
            if( packageId == 0 ){
                sql = "INSERT INTO application.sales_details (sales_detail_id, product_id, amount, price) values (?, ?, ?, ?)";
            }else {
                sql = "INSERT INTO application.sales_details (sales_detail_id, package_id, product_id, amount, price) values (?, ?, ?, ?, ?)";
            }

            pstm = con.prepareStatement(sql);
            if( productId == 0 ){
                pstm.setInt(1, salesDetailsId);
                pstm.setInt(2, packageId);
                pstm.setInt(3, amount);
                pstm.setDouble(4, price);
            }
            if( packageId == 0 ){
                pstm.setInt(1, salesDetailsId);
                pstm.setInt(2, productId);
                pstm.setInt(3, amount);
                pstm.setDouble(4, price);
            }else {
                pstm.setInt(1, salesDetailsId);
                pstm.setInt(2, packageId);
                pstm.setInt(3, productId);
                pstm.setInt(4, amount);
                pstm.setDouble(5, price);
            }
            
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
    public void updateSalesDetails(SalesDetails salesDetails) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int salesDetailsId = salesDetails.getSalesDetailId();
            int productId = salesDetails.getProductId();
            int packageId = salesDetails.getPackageId();
            int amount = salesDetails.getAmount();
            Double price = salesDetails.getPrice();

            sql = "update application.sales_details set (product_id, package_id, amount, price) = (?, ?, ?, ?) where sales_detail_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, productId);
            pstm.setInt(2, packageId);
            pstm.setInt(3, amount);
            pstm.setDouble(4, price);
            pstm.setInt(5, salesDetailsId);

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

    public void deleteSalesDetails(SalesDetails salesDetails) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int salesDetailsId = salesDetails.getSalesDetailId();

            sql = "delete from application.sales_details where sales_detail_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, salesDetailsId);

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
