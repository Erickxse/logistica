package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.FrmIngresoC;
import vista.FrmIngresoE;
import vista.FrmInicio;
import vista.FrmRegistroCliente;

public class ControladorInicio implements ActionListener, KeyListener {

    

    //INTERFACES FRAMES
    FrmInicio objVistaInicio = new FrmInicio();
    FrmRegistroCliente objVistaRCliente = new FrmRegistroCliente();
    FrmIngresoC objVistaIngresoC = new FrmIngresoC();
    FrmIngresoE objVistaIngresoE = new FrmIngresoE();
    
    
    public ControladorInicio(FrmInicio inicio,FrmIngresoC ingreso, FrmRegistroCliente registro, FrmIngresoE ingresoe){
        objVistaInicio = inicio;
        objVistaIngresoC = ingreso;
        objVistaRCliente = registro;
        objVistaIngresoE = ingresoe;
        
        //BOTONES JFRAME (INTERFAZ) INICIO
        objVistaInicio.btnIngresaC.addActionListener(this);
        objVistaInicio.btnIngresarE.addActionListener(this);
        objVistaInicio.btnRegistroIC.addActionListener(this);
        objVistaInicio.btnGerencia.addActionListener(this);
        objVistaInicio.btnSalir.addActionListener(this);  
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
