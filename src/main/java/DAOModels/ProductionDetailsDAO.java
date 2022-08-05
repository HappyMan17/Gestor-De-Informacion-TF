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
import model.RawMaterial;

/**
 *
 * @author happy
 */
public class ProductionDetailsDAO {
    
    public ProductionDetailsDAO() {}

    public ArrayList<ProductionDetails> getProductionDetails(int productionDetailId) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<ProductionDetails> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (productionDetailId == 0) {
                sql = "SELECT * FROM application.production_details ORDER BY details_id";
            } else {
                sql = "SELECT * FROM application.production_details where details_id = ? "
                        + "ORDER BY details_id";
            }

            pstm = con.prepareStatement(sql);

            if (productionDetailId != 0) {
                pstm.setInt(1, productionDetailId);
            }

            rs = pstm.executeQuery();
            ProductionDetails productionDetails = null;

            while (rs.next()) {
                productionDetails = new ProductionDetails();
                productionDetails.setRawMaterial_id(rs.getInt("raw_material_id"));
                productionDetails.setAmountUsed(rs.getInt("amount_used"));
                productionDetails.setProductionId(rs.getInt("production_id"));
                productionDetails.setDetailsId(rs.getInt("details_id"));

                listado.add(productionDetails);
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

    public void setProductionDetails(ProductionDetails productionDetails) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int productionDetailsId = productionDetails.getDetailsId();
            int productionDetailsRMId = productionDetails.getRawMaterial_id();
            int productionDetailsAmount = productionDetails.getAmountUsed();
            int productionDetailsProductionId = productionDetails.getProductionId();

            sql = "INSERT INTO application.production_details (details_id, raw_material_id, amount_used, production_id) values (?,?,?,?)";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, productionDetailsId);
            pstm.setInt(2, productionDetailsRMId);
            pstm.setInt(3, productionDetailsAmount);
            pstm.setInt(4, productionDetailsProductionId);

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
    public void updateProductionDetails(ProductionDetails productionDetails) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int productionDetailsId = productionDetails.getDetailsId();
            int productionDetailsRMId = productionDetails.getRawMaterial_id();
            int productionDetailsAmount = productionDetails.getAmountUsed();
            int productionDetailsProductionId = productionDetails.getProductionId();

            sql = "update application.production_details set (raw_material_id, amount_used, production_id) = (?, ?, ?) where details_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, productionDetailsRMId);
            pstm.setInt(2, productionDetailsAmount);
            pstm.setInt(3, productionDetailsProductionId);
            pstm.setInt(4, productionDetailsId);

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

    public void deleteProductionDetails(ProductionDetails productionDetails) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int productionDetailsId = productionDetails.getDetailsId();
            int productionDetailsProductionId = productionDetails.getProductionId();

            sql = "delete from application.production_details where details_id = ? and production_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, productionDetailsId);
            pstm.setInt(2, productionDetailsProductionId);

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
