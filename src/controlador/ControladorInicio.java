package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.FrmGerencia;
import vista.FrmIngresarPaquete;
import vista.FrmIngresoC;
import vista.FrmIngresoE;
import vista.FrmInicio;
import vista.FrmInterfazEmpleado;
import vista.FrmRegistroCliente;

public class ControladorInicio implements ActionListener, KeyListener {

    

    //INTERFACES FRAMES
    FrmInicio objVistaInicio = new FrmInicio();
    FrmRegistroCliente objVistaRCliente = new FrmRegistroCliente();
    FrmIngresoC objVistaIngresoC = new FrmIngresoC();
    FrmIngresoE objVistaIngresoE = new FrmIngresoE();
    FrmInterfazEmpleado objVistaEmpleadoP = new FrmInterfazEmpleado();
    FrmIngresarPaquete objVistaIngresarPaquete = new FrmIngresarPaquete();
    FrmGerencia objVistaGerencia = new FrmGerencia();
    
    
    public ControladorInicio(FrmInicio inicio,FrmIngresoC ingreso, FrmRegistroCliente registro, 
            FrmIngresoE ingresoe, FrmInterfazEmpleado empleadoP, FrmIngresarPaquete ingresarPaquete, FrmGerencia gerencia){
        
        objVistaInicio = inicio;
        objVistaIngresoC = ingreso;
        objVistaRCliente = registro;
        objVistaIngresoE = ingresoe;
        objVistaEmpleadoP = empleadoP;
        objVistaIngresarPaquete  = ingresarPaquete; 
        objVistaGerencia = gerencia;
        
        
        //BOTONES JFRAME (INTERFAZ) INICIO
        objVistaInicio.btnIngresaC.addActionListener(this);
        objVistaInicio.btnIngresarE.addActionListener(this);
        objVistaInicio.btnRegistroIC.addActionListener(this);
        objVistaInicio.btnGerencia.addActionListener(this);
        objVistaInicio.btnSalir.addActionListener(this);  
        
        //BOTON INGRESAR PAQUETE
        objVistaIngresoE.btnContinuarE.addActionListener(this);
        
        objVistaEmpleadoP.btnIngresarPaquete.addActionListener(this);
    }

    
    //abstract metods
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== objVistaInicio.btnIngresaC){ 
            objVistaIngresoC.setVisible(true);
            objVistaInicio.setVisible(false);
        }
        if(e.getSource()==objVistaInicio.btnRegistroIC){
            objVistaRCliente.setVisible(true);
            objVistaInicio.setVisible(false);
        }
        if(e.getSource()==objVistaInicio.btnIngresarE){
            objVistaIngresoE.setVisible(true);
            objVistaInicio.setVisible(false);
        }
        if(e.getSource()==objVistaIngresoE.btnContinuarE){
            objVistaEmpleadoP.setVisible(true);
            objVistaIngresoE.setVisible(false);
        }
        if(e.getSource()==objVistaEmpleadoP.btnIngresarPaquete){
            objVistaIngresarPaquete.setVisible(true);
            objVistaEmpleadoP.setVisible(false);
        }
        
        if(e.getSource()==objVistaInicio.btnGerencia){
            objVistaGerencia.setVisible(true);
            objVistaInicio.setVisible(false);
        }
        
        if(e.getSource() == objVistaInicio.btnSalir){
            System.exit(0);
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
