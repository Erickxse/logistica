package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.FrmIngresoC;
import vista.FrmInicio;
import vista.FrmInterfazCliente;

/**
 *
 * @author SR. MORA
 */
public class ControladorIngresoC implements ActionListener, KeyListener{

    FrmIngresoC objVistaIngresoC = new FrmIngresoC();
    FrmInicio objVistaInicio = new FrmInicio();
    FrmInterfazCliente objVistaInterfazC = new FrmInterfazCliente();
    ClienteDAO objClienteDAO = new ClienteDAO();
    
    
    public ControladorIngresoC(FrmIngresoC ingreso, FrmInicio inicio, FrmInterfazCliente interfazC, ClienteDAO cdao){
        objVistaIngresoC = ingreso;
        objVistaInicio = inicio;
        objVistaInterfazC = interfazC;
        objClienteDAO = cdao;
        
        
        objVistaIngresoC.btnIngresarC.addActionListener(this);
        ingreso.btnRegresar.addActionListener(this);
        interfazC.btnCerrarSesion.addActionListener(this);
        
    }
    //ABSTRACT METODS
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==objVistaIngresoC.btnRegresar){
            objVistaInicio.setVisible(true);
            objVistaIngresoC.setVisible(false);
            
        }
        
        if(e.getSource()==objVistaIngresoC.btnIngresarC){
        
            Cliente clientevr = new Cliente(objVistaIngresoC.txtUsuarioC.getText(),
            objVistaIngresoC.jPwClaveC.getText());
            
            //ArrayList clientecheck = objClienteDAO.buscarCliente(clientevr);
            Cliente clientecheck = objClienteDAO.buscarCliente(clientevr);
            //System.out.println(clientecheck.get(0).toString());
            if(clientecheck.getUsuario().equals(objVistaIngresoC.txtUsuarioC.getText())
                    &&clientecheck.getClave().equals(objVistaIngresoC.jPwClaveC.getText())){
                JOptionPane.showMessageDialog(null, "Datos Correctos en la BD");
                System.out.println(clientecheck.getUsuario());
                System.out.println(objVistaIngresoC.txtUsuarioC.getText()); 
                
                objVistaInterfazC.setVisible(true);
                objVistaIngresoC.setVisible(false);
                }else{
                JOptionPane.showMessageDialog(null, "ERROR, clave incorrecta");
                }  
            
            limpiarElementos();
            
        }
        
        if(e.getSource()==objVistaInterfazC.btnCerrarSesion){
            objVistaInterfazC.setVisible(false);
            objVistaIngresoC.setVisible(true);
            System.out.println("SESION CERRADA");
            JOptionPane.showMessageDialog(null, "SESION FINALIZADA!");
        }
    }
    
    public void limpiarElementos(){
    objVistaIngresoC.txtUsuarioC.setText("");
    objVistaIngresoC.jPwClaveC.setText("");
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
    


