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
import model.Production;
import model.Supplier;

/**
 *
 * @author happy
 */
public class ProductionDAO {
    
    public ProductionDAO() {}

    public ArrayList<Production> getProduction(int productionId) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<Production> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (productionId == 0) {
                sql = "SELECT * FROM application.production ORDER BY production_id";
            } else {
                sql = "SELECT * FROM application.production where production_id = ? "
                        + "ORDER BY production_id";
            }

            pstm = con.prepareStatement(sql);

            if (productionId != 0) {
                pstm.setInt(1, productionId);
            }

            rs = pstm.executeQuery();
            
            Production production = null;

            while (rs.next()) {
                production = new Production();
                production.setDatabaseId(rs.getInt("production_id"));
                production.setDate(rs.getString("creation_date"));
                
                listado.add(production);
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

    public void setProduction(Production production) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            String creationDate = production.getDate();

            sql = "INSERT INTO application.production (creation_date) values (?)";

            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, creationDate);

            int inserted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Production Row inserted: " + inserted);

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

    
    public void updateProduction(Production production) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            String creationDate = production.getDate();
            int productionId = production.getDatabaseId();

            sql = "update application.production set (creation_date) = (?) where production_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, creationDate);
            pstm.setInt(2, productionId);
            
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

    public void deleteProduction(Production production) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            String creationDate = production.getDate();
            int productionId = production.getDatabaseId();

            sql = "delete from application.production where production_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setInt(1, productionId);

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
