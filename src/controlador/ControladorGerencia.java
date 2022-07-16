package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.FrmGerencia;
import vista.FrmInicio;
import vista.FrmInterfazGerencia;

public class ControladorGerencia implements ActionListener, KeyListener{
    
        FrmGerencia objVistaGerencia = new FrmGerencia();
        FrmInicio objVistaInicio = new FrmInicio();
        FrmInterfazGerencia objVistaInterfazGerencia = new FrmInterfazGerencia();
        
        
    public ControladorGerencia(FrmGerencia gerencia, FrmInicio inicio, FrmInterfazGerencia interfazgerencia){
        objVistaGerencia = gerencia;
        objVistaInicio = inicio;
        objVistaInterfazGerencia = interfazgerencia;
        
        objVistaGerencia.btnRegresar.addActionListener(this);
        objVistaGerencia.btnIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==objVistaGerencia.btnRegresar){
        objVistaInicio.setVisible(true);
        objVistaGerencia.setVisible(false);
        }
        if(e.getSource()==objVistaGerencia.btnIngresar){
            if(objVistaGerencia.txtCodigoGerente==objVistaGerencia.txtCodigoGerente){ //CAMBIAR
                objVistaInterfazGerencia.setVisible(true);
                objVistaGerencia.setVisible(false);
            }
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
