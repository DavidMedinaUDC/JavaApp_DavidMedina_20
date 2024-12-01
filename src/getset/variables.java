package getset;

/**
 *
 * @author david
 */
public class variables {

    private static String productorid;
    private static String nombre;
    private static String dirección;
    private static String tipoactividad;
    private static String fecharegistro;
    
    public String getProductorid() {
        return productorid;
    }

    public void setProductorid(String productorid) {
        this.productorid = productorid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(String tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    
}
