/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author david
 */
public class crudsql {
    conexionsql con = new conexionsql();
    
    public void insertar(String nombre, String direccion, String tipo_actividad, String fecha_registro){
        try{
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "INSERT INTO productor(nombre,dirección,tipoactividad,fecharegistro) values('"+nombre+"','"+direccion+"','"+tipo_actividad+"','"+fecha_registro+"')";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null,"El registro se guardo correctamente ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"El registro no se guardo correctamente "+e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
}
