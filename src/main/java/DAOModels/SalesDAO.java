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
import model.Sales;

/**
 *
 * @author happy
 */
public class SalesDAO {

    public SalesDAO() {
    }

    public ArrayList<Sales> getSales(int salesDbId) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<Sales> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (salesDbId == 0) {
                sql = "SELECT * FROM application.sales ORDER BY sales_id";
            } else {
                sql = "SELECT * FROM application.sales where sales_id = ? "
                        + "ORDER BY sales_id";
            }

            pstm = con.prepareStatement(sql);

            if (salesDbId != 0) {
                pstm.setInt(1, salesDbId);
            }

            rs = pstm.executeQuery();

            Sales sales = null;

            while (rs.next()) {
                sales = new Sales();
                sales.setDatabaseId(rs.getInt("sales_id"));
                sales.setSalesDetailsId(rs.getInt("details_id"));
                sales.getClient().setClientId(rs.getInt("client_id"));
                sales.getSeller().setDatabaseId(rs.getInt("seller_id"));
                sales.setTotalSold(rs.getDouble("total_sell"));
                sales.setIsActive(rs.getBoolean("is_active"));
                sales.setDate(rs.getString("date"));

                listado.add(sales);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError en SalesDAO método get:" + ex.getMessage());
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
                        + ex.getErrorCode() + "\nError en SalesDAO método get:" + ex.getMessage());
            }
        }
        return listado;
    }

    public void setProduct(Sales sales) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int dbIdSales = sales.getDatabaseId();
            int salesDetailsId = sales.getSalesDetailsId();
            int clientId = sales.getClient().getClientId();
            int sellerId = sales.getSeller().getDatabaseId();
            double totalSold = sales.getTotalSold();
            boolean isActive = sales.getIsActive();
            String date = sales.getDate();

            if (dbIdSales == 0) {
                sql = "INSERT INTO application.sales (client_id, seller_id, total_sell, details_id, date, is_active) values (?,?,?,?,?,?)";
            } else {
                sql = "INSERT INTO application.sales (sales_id, client_id, seller_id, total_sell, details_id, date, is_active) values (?,?,?,?,?,?,?)";
            }

            pstm = con.prepareStatement(sql);
            if (dbIdSales == 0) {
                pstm.setInt(1, clientId);
                pstm.setInt(2, sellerId);
                pstm.setDouble(3, totalSold);
                pstm.setInt(4, salesDetailsId);
                pstm.setString(5, date);
                pstm.setBoolean(6, isActive);
            } else {
                pstm.setInt(1, dbIdSales);
                pstm.setInt(2, clientId);
                pstm.setInt(3, sellerId);
                pstm.setDouble(4, totalSold);
                pstm.setInt(5, salesDetailsId);
                pstm.setString(6, date);
                pstm.setBoolean(7, isActive);
            }
            pstm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError en SalesDAO método set1: " + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError en SalesDAO método set2: " + ex.getMessage());
            }
        }
    }

    public void deleteSupplier(Sales sales) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int dbIdSales = sales.getDatabaseId();
            boolean isActive = sales.getIsActive();

            sql = "update application.sales SET is_active = ? where details_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setBoolean(1, isActive);
            pstm.setInt(2, dbIdSales);

            int deleted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows deleted :" + deleted);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError en SalesDAO método delete1: " + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError en SalesDAO método delete2: " + ex.getMessage());
            }
        }
    }

    public void updateProduct(Sales sales) {
        /**
         * Connection con = null; PreparedStatement pstm = null;
         *
         * try { con = ServiceConnection.getConnection(); String sql = "";
         *
         * int dbIdSales = sales.getDatabaseId(); int salesDetailsId =
         * sales.getSalesDetailsId(); int clientId =
         * sales.getClient().getClientId(); int sellerId =
         * sales.getSeller().getDatabaseId(); double totalSold =
         * sales.getTotalSold(); boolean isActive = sales.getIsActive(); String
         * date = sales.getDate();
         *
         * sql = "update application.sales set (nit, name, code, is_active) =
         * (?, ?, ?,?) where details_id = ?";
         *
         * pstm = con.prepareStatement(sql); pstm.setString(1, productName);
         * pstm.setString(2, productLote);
         *
         * int updated = pstm.executeUpdate();
         * JOptionPane.showMessageDialog(null, "Rows updated: " + updated + "\n
         * was updated " + productName);
         *
         * } catch (SQLException ex) { JOptionPane.showMessageDialog(null,
         * "Código : " + ex.getErrorCode() + "\nError clase ProductDAO, método
         * update: " + ex.getMessage()); } finally { try { if (pstm != null) {
         * pstm.close(); } } catch (SQLException ex) {
         * JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() +
         * "\nError clase ProductDAO, método update: " + ex.getMessage()); } }
    }
         */
    }
}
