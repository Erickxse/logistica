package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.FrmIngresoC;
import vista.FrmInicio;
import vista.FrmRegistroCliente;

public class ControladorInicio implements ActionListener, KeyListener {

    

    //INTERFACES FRAMES
    FrmInicio objVistaInicio = new FrmInicio();
    FrmRegistroCliente objVistaRCliente = new FrmRegistroCliente();
    FrmIngresoC objVistaIngresoC = new FrmIngresoC();
    
    
    public ControladorInicio(FrmInicio inicio,FrmIngresoC ingreso){
        objVistaInicio = inicio;
        objVistaIngresoC = ingreso;
        
        //BOTONES JFRAME (INTERFAZ) INICIO
        inicio.btnIngresaC.addActionListener(this);
        objVistaInicio.btnIngresarE.addActionListener(this);
        objVistaInicio.btnRegistro.addActionListener(this);
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
