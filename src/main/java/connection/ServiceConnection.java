/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

/**
 *
 * @author happy
 */

public class ServiceConnection {
    private static Connection con = null;
    
    public static Connection getConnection(){
        try
        {
            if(con == null || con.isClosed()){
                
                Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
                
                ResourceBundle rb = ResourceBundle.getBundle("jdbc");
                String driver = rb.getString("driver");
                String url = rb.getString("url");
                String pwd = rb.getString("pwd");
                String usr = rb.getString("usr");
                
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
            }
                         
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Error : " + 
                ex.getMessage());
        }
        return con;
    }
    
    static class MiShDwnHook extends Thread{
        
        @Override
        public void run(){
            try{
                Connection con = ServiceConnection.getConnection();
                con.close();                     
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,"Error : " + 
                    ex.getMessage());
            }
        }
    }
}
