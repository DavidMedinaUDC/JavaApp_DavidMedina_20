package sql;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import getset.variables;

/**
 *
 * @author david
 */
public class crudsql extends conexionsql{
    
    java.sql.Statement st;
    ResultSet rs;
    variables var = new variables();
    
    public void insertar(String nombre, String direccion, String tipo_actividad, String fecha_registro){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "INSERT INTO productor(nombre,dirección,tipoactividad,fecharegistro) values('"+nombre+"','"+direccion+"','"+tipo_actividad+"','"+fecha_registro+"')";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null,"El registro se guardo correctamente ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"El registro no se guardo correctamente "+e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrar(String productorid){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "SELECT * FROM productor WHERE productorid='"+productorid+"';";
            rs = st.executeQuery(sql);
            if(rs.next()){
                var.setProductorid(rs.getString("productorid"));
                var.setNombre(rs.getString("nombre"));
                var.setDirección(rs.getString("dirección"));
                var.setTipoactividad(rs.getString("tipoactividad"));
                var.setFecharegistro(rs.getString("fecharegistro"));
            }else{
                var.setProductorid("");
                var.setNombre("");
                var.setDirección("");
                var.setTipoactividad("");
                var.setFecharegistro("");
                JOptionPane.showMessageDialog(null, "no se encontró registro","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda","Error busqueda",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizar(String productorid, String nombre, String direccion, String tipo_actividad, String fecha_registro){
        try{
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update productor set nombre='"+nombre+"',dirección='"+direccion+"',tipoactividad='"+tipo_actividad+"',fecharegistro='"+fecha_registro+"' where productorid='"+productorid+"';";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se actualizó","Exito",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}





