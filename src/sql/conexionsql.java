/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author david
 */
public class conexionsql {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost/restaurado_bd_david_medina_20";
    String usuario = "david_medina_20";
    String clave = "AbcdeUdeC";
            
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url,usuario,clave);
            if(conn != null){
                System.out.println("Conexión exitosa");
            }else{
                System.out.println("Conexión fallida");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    return conn;
    }
}
