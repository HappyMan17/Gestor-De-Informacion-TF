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

/**
 *
 * @author happy
 */
public class ProductDAO {

    public ProductDAO() {
    }

    public ArrayList<Product> getProducts(String productName) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<Product> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (productName == null) {
                sql = "SELECT * FROM application.products ORDER BY name";
            } else {
                sql = "SELECT * FROM application.products where name = ? "
                        + "ORDER BY name";
            }

            pstm = con.prepareStatement(sql);

            if (productName != null) {
                pstm.setString(1, productName);
            }

            rs = pstm.executeQuery();

            Product product = null;

            while (rs.next()) {
                product = new Product();
                product.setName(rs.getString("name"));
                product.setAmount(rs.getInt("amount"));
                product.setPrice(rs.getDouble("price"));
                product.setLotNumber(rs.getString("lot_number"));

                listado.add(product);
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

    public void setClients(Client cliente) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            String clientName = cliente.getClientName();
            int clientCode = cliente.getClientId();

            if (clientCode == 0) {
                sql = "SELECT * FROM application.client ORDER BY client_id";
            } else {
                sql = "INSERT INTO application.client (name,client_code) values (?,?)";
            }

            pstm = con.prepareStatement(sql);
            pstm.setString(1, clientName);
            pstm.setInt(1, clientCode);

            rs = pstm.executeQuery();

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
    }
}
