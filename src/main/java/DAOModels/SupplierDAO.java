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
                supplier.setIsActive(rs.getBoolean("is_active"));

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

            int supplierNit = supplier.getSupplierNit();
            String supplierName = supplier.getSupplierName();
            int supplierCode = supplier.getSupplierCode();
            boolean isActive = supplier.isIsActive();
            int supplierId = supplier.getDbId();

            if( supplierId == 0){
                sql = "INSERT INTO application.supplier (nit, name, code, is_active) values (?,?,?,?)";
            }else{
                sql = "INSERT INTO application.supplier (supplier_id, nit, name, code, is_active) values (?,?,?,?,?)";
            }

            pstm = con.prepareStatement(sql);
            
            if( supplierId == 0 ){
                pstm.setInt(1, supplierNit);
                pstm.setString(2, supplierName);
                pstm.setInt(3, supplierCode);
                pstm.setBoolean(4, isActive);
            }else{
                pstm.setInt(1, supplierId);
                pstm.setInt(2, supplierNit);
                pstm.setString(3, supplierName);
                pstm.setInt(4, supplierCode);
                pstm.setBoolean(5, isActive);
            }

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows inserted in Supplier: ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError en SupplierDAO: metodo set1" + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError SupplierDAO: método set2" + ex.getMessage());
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
            boolean supplierIsActive = supplier.isIsActive();

            sql = "update application.supplier set (nit, name, code, is_active) = (?, ?, ?,?) where supplier_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, supplierNit);
            pstm.setString(2, supplierName);
            pstm.setInt(3, supplierCode);
            pstm.setBoolean(4, supplierIsActive);
            pstm.setInt(5, supplierId);

            int updated = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows updated" + updated);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError : Supplier DAO método update" + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError : Supplier DAO método update" + ex.getMessage());
            }
        }
    }

    public void deleteSupplier(Supplier supplier) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";
            
            String supplierName = supplier.getSupplierName();
            int supplierCode = supplier.getSupplierCode();
            int supplierId = supplier.getDbId();
            boolean supplierIsActive = supplier.isIsActive();

            sql = "update application.supplier SET name = ?, is_active = ? where supplier_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, supplierName);
            pstm.setBoolean(2, supplierIsActive);
            pstm.setInt(3, supplierId);
            

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
