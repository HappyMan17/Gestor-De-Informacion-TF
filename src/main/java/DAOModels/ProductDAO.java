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

/**
 *
 * @author happy
 */
public class ProductDAO {

    public ProductDAO() {
    }

    public ArrayList<Product> getProducts(int dbId){

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<Product> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (dbId == 0){
                sql = "SELECT * FROM application.products ORDER BY name";
            } else {
                sql = "SELECT * FROM application.products where product_id = ? "
                        + "ORDER BY product_id";
            }

            pstm = con.prepareStatement(sql);

            if (dbId != 0) {
                pstm.setInt(1, dbId);
            }

            rs = pstm.executeQuery();

            Product product = null;

            while (rs.next()) {
                product = new Product();
                product.setName(rs.getString("name"));
                product.setAmount(rs.getInt("amount"));
                product.setPrice(rs.getDouble("price"));
                product.setLotNumber(rs.getString("lot_number"));
                product.setDatabaseId(rs.getInt("product_id"));
                //detail
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

    public void setProduct(Product product) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            int productAmount = product.getAmount();
            String productName = product.getName();
            Double productPrice = product.getPrice();
            String lotNumber = product.getLotNumber();

            sql = "INSERT INTO application.products (amount, name, price, lot_number) values (?,?,?,?)";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, productAmount);
            pstm.setString(2, productName);
            pstm.setDouble(3, productPrice);
            pstm.setString(4, lotNumber);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product Row inserted: ");
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

    public void updateProduct(Product product) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";
            String productName = product.getName();
            String productLote = product.getLotNumber();
            int productId = product.getDatabaseId();

            sql = "UPDATE aplication.products SET name = ?, lot_number = ? where product_id = ?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, productName);
            pstm.setString(2, productLote);
            pstm.setInt(3, productId);

            int updated = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows updated: " + updated
                    + "\n was updated " + productName);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError clase ProductDAO, método update: " + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError clase ProductDAO, método update: " + ex.getMessage());
            }
        }
    }

    public void deleteProduct(Product product) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";
            String productName = product.getName();
            String productLote = product.getLotNumber();

            sql = "delete from application.products where name = ? and lot_number = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setString(1, productName);
            pstm.setString(2, productLote);

            int deleted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows deleted: " + deleted
                    + "\n was deleted " + productName);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError clase ProductDAO, método delete: " + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError clase ProductDAO, método delete: " + ex.getMessage());
            }
        }
    }

}
