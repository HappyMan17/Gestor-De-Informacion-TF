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
import model.Supplier;

/**
 *
 * @author happy
 */
public class SupplierDAO {
    public SupplierDAO() {}

    public ArrayList<Supplier> getSuppliers(int supplierCode) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<Supplier> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (supplierCode == 0) {
                sql = "SELECT * FROM application.supplier ORDER BY supplier_id";
            } else {
                sql = "SELECT * FROM application.supplier where supplier_id = ? "
                        + "ORDER BY supplier_id";
            }

            pstm = con.prepareStatement(sql);

            if (supplierCode != 0) {
                pstm.setInt(1, supplierCode);
            }

            rs = pstm.executeQuery();
            Supplier supplier = null;

            while (rs.next()) {
                supplier = new Supplier();
                supplier.setSupplierName(rs.getString("name"));
                supplier.setDbId(rs.getInt("supplier_id"));
                supplier.setSupplierNit(rs.getInt("nit"));
                supplier.setSupplierCode(rs.getInt("code"));

                listado.add(supplier);
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

    public void setSupplier(Supplier supplier) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            String supplierName = supplier.getSupplierName();
            int supplierNit = supplier.getSupplierNit();
            int supplierCode = supplier.getSupplierCode();
            int supplierId = supplier.getDbId();

            sql = "INSERT INTO application.supplier (supplier_id, nit, name, code) values (?,?,?,?)";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, supplierId);
            pstm.setInt(2, supplierNit);
            pstm.setString(3, supplierName);
            pstm.setInt(4, supplierCode);

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

    
    public void updateSupplier(Supplier supplier) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            String supplierName = supplier.getSupplierName();
            int supplierNit = supplier.getSupplierNit();
            int supplierCode = supplier.getSupplierCode();
            int supplierId = supplier.getDbId();

            sql = "update application.supplier set (nit, name, code) = (?, ?, ?) where supplier_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, supplierNit);
            pstm.setString(2, supplierName);
            pstm.setInt(3, supplierCode);
            pstm.setInt(4, supplierId);

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

    public void deleteSupplier(Supplier supplier) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int supplierCode = supplier.getSupplierCode();
            int supplierId = supplier.getDbId();

            sql = "delete from application.supplier_id where code = ? and supplier_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, supplierCode);
            pstm.setInt(2, supplierId);

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
