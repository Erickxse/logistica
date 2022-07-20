package modelo;

import java.util.ArrayList;


public class Empleado {
    
    private String nombre;
    private String apellido;
    private String ncedula;
    private String ciudad;
    private String direccion;
    private String codigoemp;
    private String clave;
    private ArrayList [] paquetes;
    

    public Empleado(String nombre, String apellido, String ncedula, String ciudad, String direccion, String codigoemp, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ncedula = ncedula;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.codigoemp = codigoemp;
        this.clave = clave;
        
    }

    public Empleado(String nombre, String apellido, String ncedula, String ciudad, String direccion, String codigoemp, String clave, ArrayList[] paquetes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ncedula = ncedula;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.codigoemp = codigoemp;
        this.clave = clave;
        this.paquetes = paquetes;
    }
    
    

    public Empleado(String codigoemp, String clave) {
        this.codigoemp = codigoemp;
        this.clave = clave;
    }

    public Empleado() {
    }
    
    
    
    //GETS

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNcedula() {
        return ncedula;
    }
    

    public String getCodigoemp() {
        return codigoemp;
    }

    public String getClave() {
        return clave;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList[] getPaquetes() {
        return paquetes;
    }
    
    
    
    
    //SETS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNcedula(String ncedula) {
        this.ncedula = ncedula;
    }

        
    public void setCodigoemp(String codigoemp) {
        this.codigoemp = codigoemp;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPaquetes(ArrayList[] paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", ncedula=" + ncedula + ", ciudad=" + ciudad + ", direccion=" + direccion + ", codigoemp=" + codigoemp + ", clave=" + clave + ", paquetes=" + paquetes + '}';
    }
    
    
    
}
