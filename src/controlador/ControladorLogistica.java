package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Gerente;
import modelo.GerenteDAO;
import modelo.Paquete;
import modelo.PaqueteDAO;
import modelo.Transporte;
import modelo.TransporteDAO;
import vista.FrmIngresoC;
import vista.FrmInicio;
import vista.FrmRegistroCliente;

public class ControladorLogistica implements ActionListener, KeyListener {

    
        //cliente
    ClienteDAO objCDAO = new ClienteDAO();
    Cliente objCliente = new Cliente();
    
        //paquete
    PaqueteDAO objPDAO = new PaqueteDAO();
    Paquete objPaquete = new Paquete();
    
        //empleado
    
    EmpleadoDAO objEDAO = new EmpleadoDAO();
    Empleado objEmpleado = new Empleado();
    
        //transporte
    
    TransporteDAO objTDAO = new TransporteDAO();
    Transporte objTransporte = new Transporte();
    
        //gerente 
    GerenteDAO objGDAO = new GerenteDAO();
    Gerente objGerente = new Gerente();
    
    //INTERFACES FRAMES
    FrmInicio objVistaInicio = new FrmInicio();
    FrmRegistroCliente objVistaRCliente = new FrmRegistroCliente();
    FrmIngresoC objVistaIngresoC = new FrmIngresoC();
    
    
    public ControladorLogistica(FrmInicio inicio, ClienteDAO cdao, FrmIngresoC ingreso){
        objVistaInicio = inicio;
        objCDAO = cdao;
        objVistaIngresoC = ingreso;
        objVistaInicio.btnIngresaC.addActionListener(this);
        objVistaInicio.btnIngresarE.addActionListener(this);
        objVistaInicio.btnRegistro.addActionListener(this);
        objVistaInicio.btnGerencia.addActionListener(this);
        objVistaInicio.btnSalir.addActionListener(this);
    }
    
    //abstract metods
    @Override
    public void actionPerformed(ActionEvent e) {
                
        if(e.getSource()== objVistaInicio.btnIngresaC){ 
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
