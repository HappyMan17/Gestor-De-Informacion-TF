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
import model.Seller;

/**
 *
 * @author happy
 */
public class SellerDAO {

    public SellerDAO() {
    }

    public ArrayList<Seller> getSeller(int dbId) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<Seller> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (dbId == 0) {
                sql = "SELECT * FROM application.seller ORDER BY seller_id";
            } else {
                sql = "SELECT * FROM application.seller where seller_id = ? "
                        + "ORDER BY seller_id";
            }

            pstm = con.prepareStatement(sql);

            if (dbId != 0) {
                pstm.setInt(1, dbId);
            }

            rs = pstm.executeQuery();

            Seller seller = null;

            while (rs.next()) {
                seller = new Seller();
                seller.setDatabaseId(rs.getInt("seller_id"));
                seller.setSellerId(rs.getInt("seller_code"));
                seller.setSellerName(rs.getString("name"));

                listado.add(seller);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError clase SellerDAO, método get: " + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError clase SellerDAO, método get: " + ex.getMessage());
            }
        }
        return listado;
    }

    public void setSeller(Seller seller) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            String sellerName = seller.getSellerName();
            int sellerCode = seller.getSellerId();

            sql = "INSERT INTO application.seller (sellerName,sellerCode) values (?,?)";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, sellerName);
            pstm.setInt(2, sellerCode);

            pstm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError clase SellerDAO, método set: " + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError clase SellerDAO, método set: " + ex.getMessage());
            }
        }
    }

    public void updateSeller(Seller seller) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";
            String sellerName = seller.getSellerName();

            sql = "UPDATE aplication.seller SET name = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, sellerName);

            int updated = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows updated: " + updated
                    + "\n was updated " + sellerName);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError clase SellerDAO, método update: " + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError clase SellerDAO, método update: " + ex.getMessage());
            }
        }
    }

    public void deleteSeller(Seller seller) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";
            String sellerName = seller.getSellerName();
            int sellerCode = seller.getSellerId();

            sql = "delete from application.seller where name = ? and seller_code = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, sellerName);
            pstm.setInt(2, sellerCode);

            int deleted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows deleted: " + deleted
                    + "\n was deleted " + sellerName);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError clase SellerDAO, método delete: " + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError clase SellerDAO, método delete: " + ex.getMessage());
            }
        }
    }
}
