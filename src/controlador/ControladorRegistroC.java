package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.FrmInicio;
import vista.FrmRegistroCliente;


public class ControladorRegistroC implements ActionListener, KeyListener{
    
    FrmRegistroCliente objVistaRegistroC = new FrmRegistroCliente();
    FrmInicio objVistaInicio = new FrmInicio();

    public ControladorRegistroC(FrmRegistroCliente registro, FrmInicio inicio ) {
        objVistaRegistroC = registro;
        objVistaInicio = inicio;    
               
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==objVistaRegistroC.btnRegresarIC) {
            objVistaInicio.setVisible(true);
            objVistaRegistroC.setVisible(false);
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
