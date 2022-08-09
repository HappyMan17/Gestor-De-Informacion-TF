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
import model.RawMaterial;

/**
 *
 * @author happy
 */
public class RawMaterialDAO {

    public RawMaterialDAO() {}

    public ArrayList<RawMaterial> getRawMaterial(int rawMaterialId) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<RawMaterial> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (rawMaterialId == 0) {
                sql = "SELECT * FROM application.rm_inventory ORDER BY raw_material_id";
            } else {
                sql = "SELECT * FROM application.rm_inventory where code = ? "
                        + "ORDER BY raw_material_id";
            }

            pstm = con.prepareStatement(sql);

            if (rawMaterialId != 0) {
                pstm.setInt(1, rawMaterialId);
            }

            rs = pstm.executeQuery();
            RawMaterial rawMaterial = null;

            while (rs.next()) {
                rawMaterial = new RawMaterial();
                rawMaterial.setName(rs.getString("name"));
                rawMaterial.setUnitPrice(rs.getDouble("price"));
                rawMaterial.setAmount(rs.getInt("amount"));
                rawMaterial.setSupplierId(rs.getInt("supplier_id"));
                rawMaterial.setCode(rs.getInt("code"));
                rawMaterial.setDbId(rs.getInt("raw_material_id"));

                listado.add(rawMaterial);
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

    public void setRawMaterial(RawMaterial rawMaterial) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            String rawMaterialName = rawMaterial.getName();
            Double rawMaterialPrice = rawMaterial.getUnitPrice();
            int rawMaterialAmount = rawMaterial.getAmount();
            int rawMaterialSupplierId = rawMaterial.getSupplierId();
            int rawMaterialCode = rawMaterial.getCode();
            int rawMaterialId = rawMaterial.getDbId();

            sql = "INSERT INTO application.rm_inventory (raw_material_id, name, price, amount, supplier_id, code) values (?,?,?,?,?,?)";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, rawMaterialId);
            pstm.setString(2, rawMaterialName);
            pstm.setDouble(3, rawMaterialPrice);
            pstm.setInt(4, rawMaterialAmount);
            pstm.setInt(5, rawMaterialSupplierId);
            pstm.setInt(6, rawMaterialCode);

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
    public void updateRawMaterial(RawMaterial rawMaterial) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            String rawMaterialName = rawMaterial.getName();
            Double rawMaterialPrice = rawMaterial.getUnitPrice();
            int rawMaterialAmount = rawMaterial.getAmount();
            int rawMaterialSupplierId = rawMaterial.getSupplierId();
            int rawMaterialCode = rawMaterial.getCode();
            int rawMaterialDbId = rawMaterial.getDbId();

            sql = "update application.rm_inventory set (name, price, amount, supplier_id, code) = (?, ?, ?, ?, ?) where raw_material_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, rawMaterialName);
            pstm.setDouble(2, rawMaterialPrice);
            pstm.setInt(3, rawMaterialAmount);
            pstm.setInt(4, rawMaterialSupplierId);
            pstm.setInt(5, rawMaterialCode);
            pstm.setInt(6, rawMaterialDbId);

            int updated = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows updated: " + updated);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código RM: "
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

    public void deleteRawMaterial(RawMaterial rawMaterial) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int rawMaterialCode = rawMaterial.getCode();
            int rawMaterialId = rawMaterial.getDbId();

            sql = "delete from application.rm_inventory where code = ? and raw_material_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, rawMaterialCode);
            pstm.setInt(2, rawMaterialId);

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
