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

/**
 *
 * @author happy
 */
public class ClientDAO {

    public ClientDAO() {
    }

    public ArrayList<Client> getClients(int clientCode) {

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ArrayList<Client> listado = new ArrayList<>();
        try {

            con = ServiceConnection.getConnection();
            String sql = "";

            if (clientCode == 0) {
                sql = "SELECT * FROM application.client ORDER BY client_id";
            } else {
                sql = "SELECT * FROM application.client where client_code = ? "
                        + "ORDER BY client_id";
            }

            pstm = con.prepareStatement(sql);

            if (clientCode != 0) {
                pstm.setInt(1, clientCode);
            }

            rs = pstm.executeQuery();

            Client client = null;

            while (rs.next()) {
                client = new Client();
                client.setClientName(rs.getString("name"));
                client.setClientId(rs.getInt("client_code"));

                listado.add(client);
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

    public void setClients(Client client) {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";

            String clientName = client.getClientName();
            int clientCode = client.getClientId();
            
            sql = "INSERT INTO application.client (name, client_code) values (?,?)";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, clientName);
            pstm.setInt(1, clientCode);

            int inserted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows inserted: "+inserted);

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
    
    public void updateClientName(Client client){
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";
            
            String clientNewName = client.getClientName();
            int clientCode = client.getClientId();
            
            sql = "update application.client set name = ? where client_code = ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, clientNewName);
            pstm.setInt(2, clientCode);

            int updated = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows updated: "+updated);

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
    
    public void deleteClient(Client client){
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ServiceConnection.getConnection();
            String sql = "";
            
            String clientNewName = client.getClientName();
            int clientCode = client.getClientId();
            
            sql = "delete from application.client where name = ? and client_code = ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, clientNewName);
            pstm.setInt(2, clientCode);

            int deleted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows deleted :"+deleted);

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
