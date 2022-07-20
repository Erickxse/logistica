package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.EmpleadoDAO;
import modelo.Ciudad;
import modelo.Empleado;
import vista.FrmInterfazGerencia;
import vista.FrmRegistrarE;

public class ControladorRegistroE implements ActionListener, KeyListener{

        FrmRegistrarE objVistaRegistroE = new FrmRegistrarE();
        FrmInterfazGerencia objVistaInterfazG = new FrmInterfazGerencia();
        EmpleadoDAO objEmpleadoDAO = new EmpleadoDAO();
    
    public ControladorRegistroE(FrmRegistrarE registroe, FrmInterfazGerencia interfazg, EmpleadoDAO empdao){
    
            objVistaRegistroE = registroe;
            objVistaInterfazG = interfazg;
            objEmpleadoDAO = empdao;
            
            
            objVistaRegistroE.btnRegistrarE.addActionListener(this);
            objVistaRegistroE.btnRegresar.addActionListener(this);
            
            //combo box
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.AMBATO.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.AZOGUES.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.CUENCA.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.ESMERALDAS.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.GUARANDA.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.GUAYAQUIL.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.IBARRA.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.LATACUNGA.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.LOJA.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.MACHALA.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.MANTA.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.QUITO.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.RIOBAMBA.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.STO_DOMINGO.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.TENA.name());
            objVistaRegistroE.cmbCiudadE.addItem(Ciudad.TULCAN.name());
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==objVistaRegistroE.btnRegresar){
        objVistaInterfazG.setVisible(true);
        objVistaRegistroE.setVisible(false);
        }
        
        if (e.getSource()==objVistaRegistroE.btnRegistrarE){
        
            String nombre = objVistaRegistroE.txtNombre.getText();
            String apellido = objVistaRegistroE.txtApellido.getText();
            String ncedula = objVistaRegistroE.txtNcedula.getText();
            String ciudad = objVistaRegistroE.cmbCiudadE.getSelectedItem().toString();
            String direccion = objVistaRegistroE.txtDireccion.getText();
            String codigoE = objVistaRegistroE.txtCodigoEmp.getText();
            String claveE = objVistaRegistroE.txtClave.getText();
            ArrayList paquetesE [] = null;
            
            Empleado objEmpleado = new Empleado(nombre, apellido, ncedula, ciudad, 
                    direccion, codigoE, claveE, paquetesE);
            
            objEmpleadoDAO.insertarEmpleado(objEmpleado);
            JOptionPane.showMessageDialog(null, "Empleado Agregado");
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
    objVistaRegistroE.txtNombre.setText("");
    objVistaRegistroE.txtApellido.setText("");
    objVistaRegistroE.txtDireccion.setText("");
    objVistaRegistroE.txtNcedula.setText("");
    objVistaRegistroE.txtCodigoEmp.setText("");
    objVistaRegistroE.txtClave.setText("");
    }
}
