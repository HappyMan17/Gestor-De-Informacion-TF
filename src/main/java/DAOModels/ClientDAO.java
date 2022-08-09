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

    public ClientDAO() {}

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
                if(rs.getBoolean("is_store")){
                    client.setIsStore(true);
                    client.setNIT(rs.getInt("nit"));
                }
                client.setClientName(rs.getString("name"));
                client.setClientId(rs.getInt("client_code"));
                client.setDbId(rs.getInt("client_id"));
                client.setIsActive(rs.getBoolean("is_active"));

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
            int clientNIT = client.getNIT();
            int clientId = client.getDbId();
            boolean clientisActive = client.getIsActive();
            boolean clientisStore = client.getIsIsStore();
            System.err.println("1");
            
            if( client.getIsIsStore() ){
                sql = "INSERT INTO application.client (name, client_code, nit, is_active, is_store) values (?,?,?,?,?)";
            }if( client.getDbId() == 0 ){
                sql = "INSERT INTO application.client (name, client_code, nit, is_active, is_store) values (?,?,?,?,?)";
            }else{
                sql = "INSERT INTO application.client (client_id, name, client_code, is_active, is_store) values (?,?,?,?,?)";
            }

            pstm = con.prepareStatement(sql);
            if(client.getIsIsStore()){
                pstm.setString(1, clientName);
                pstm.setInt(2, clientCode);
                pstm.setInt(3, clientNIT);
                pstm.setBoolean(4, clientisActive);
                pstm.setBoolean(5, clientisStore);
            }if(client.getDbId() == 0){
                pstm.setString(1, clientName);
                pstm.setInt(2, clientCode);
                pstm.setInt(3, clientNIT);
                pstm.setBoolean(4, clientisActive);
                pstm.setBoolean(5, clientisStore);
            }
            else{
                pstm.setInt(1, clientId);
                pstm.setString(2, clientName);
                pstm.setInt(3, clientCode);
                pstm.setBoolean(4, clientisActive);
                pstm.setBoolean(5, clientisStore);
            }

            int inserted = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Rows inserted: "+inserted);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError en ClientDAO metodo set:" + ex.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código : "
                        + ex.getErrorCode() + "\nError en ClientDAO metodo set2:" + ex.getMessage());
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
            int clientId = client.getDbId();
            int clientNIT = client.getNIT();
            
            sql = "update application.client set name = ?, nit = ? where client_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, clientNewName);
            pstm.setInt(2, clientNIT);
            pstm.setInt(3, clientId);

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
            int clientId = client.getDbId();
            boolean clientActive = client.getIsActive();
            
            sql = "update application.client set name = ?, is_active = ? where client_id = ?";
            //sql = "delete from application.client where name = ? and client_id = ?";

            pstm = con.prepareStatement(sql);
            pstm.setString(1, clientNewName);
            pstm.setBoolean(2, clientActive);
            pstm.setInt(3, clientId);

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
