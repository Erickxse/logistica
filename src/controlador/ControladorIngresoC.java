package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.FrmIngresoC;
import vista.FrmInicio;

/**
 *
 * @author SR. MORA
 */
public class ControladorIngresoC implements ActionListener, KeyListener{

    FrmIngresoC objVistaIngresoC = new FrmIngresoC();
    FrmInicio objVistaInicio = new FrmInicio();
    
    
    public ControladorIngresoC(FrmIngresoC ingreso, FrmInicio inicio){
        objVistaIngresoC = ingreso;
        objVistaInicio = inicio;
        
        objVistaIngresoC.btnIngresarC.addActionListener(this);
        ingreso.btnRegresar.addActionListener(this);
        
    }
    //ABSTRACT METODS
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==objVistaIngresoC.btnRegresar){
            objVistaInicio.setVisible(true);
            objVistaIngresoC.setVisible(false);
            
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
