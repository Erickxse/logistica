package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.Gerente;
import modelo.GerenteDAO;
import vista.FrmGerencia;
import vista.FrmInicio;
import vista.FrmInterfazGerencia;

public class ControladorGerencia implements ActionListener, KeyListener{
    
        FrmGerencia objVistaGerencia = new FrmGerencia();
        FrmInicio objVistaInicio = new FrmInicio();
        FrmInterfazGerencia objVistaInterfazGerencia = new FrmInterfazGerencia();
        GerenteDAO objGerenteDAO = new GerenteDAO();
        String codeGerente;
        
        
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
            Gerente codigGerente = new Gerente(objVistaGerencia.txtCodigoGerente.getText());
            Gerente gerenteCode = objGerenteDAO.codigoGerente(codigGerente);
            if(gerenteCode.getCodeGerente().equals(objVistaGerencia.txtCodigoGerente.getText())){
                JOptionPane.showMessageDialog(null, "Datos Correctos en la BD");
                codeGerente = objVistaGerencia.txtCodigoGerente.getText();
                objVistaInterfazGerencia.setVisible(true);
                insertarNombre();
                objVistaGerencia.setVisible(false);
                
            }else{
               JOptionPane.showMessageDialog(null, "ERROR, Clave incorrecta"); 
            }
            limpiarElementos();
                         
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
    public void limpiarElementos(){
    objVistaGerencia.txtCodigoGerente.setText("");
    
    }
    
    public void insertarNombre(){
        objVistaInterfazGerencia.lblAdmiGerente.setText(codeGerente);
       
    }
    
    
}
