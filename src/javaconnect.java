/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gwen
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class javaconnect {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private static String chemin_serveur = null;
    private static String admin_serveur = null;
    private static String mdp_admin_serveur = null;

    //lecture du fichier texte	
    public static void Param_connect_init(){
        try{
            String fichier = new File("src/Param_connect.txt").getAbsolutePath();
            InputStream ips=new FileInputStream(fichier); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            int i = 0;
            while ((ligne=br.readLine())!=null){
                    if (i == 3){
                        chemin_serveur = ligne;
                    }
                    if (i == 5){
                        admin_serveur = ligne;
                    }
                    if (i == 7){
                        mdp_admin_serveur = ligne;
                    }
                    i = i + 1;
            }
            br.close(); 
        }		
        catch (Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                System.exit(0); 
        }
    }
    public static Connection ConnectDb(){
        try{
            Param_connect_init();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(chemin_serveur,admin_serveur,mdp_admin_serveur);
            return conn;
        }
        catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
            return null;
        }         
    }
}
