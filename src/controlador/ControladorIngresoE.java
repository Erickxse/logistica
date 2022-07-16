package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.FrmIngresoE;
import vista.FrmInicio;

public class ControladorIngresoE implements ActionListener, KeyListener{
    FrmIngresoE objVistaIngresoE = new FrmIngresoE();
    FrmInicio objVistaInicio= new FrmInicio();

    public ControladorIngresoE(FrmIngresoE ingresoe, FrmInicio inicio) {
        objVistaIngresoE = ingresoe;
        objVistaInicio = inicio;
        
        objVistaIngresoE.btnIngresarE.addActionListener(this);
        objVistaIngresoE.btnRegresar.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==objVistaIngresoE.btnRegresar){
            objVistaInicio.setVisible(true);
            objVistaIngresoE.setVisible(false);
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
