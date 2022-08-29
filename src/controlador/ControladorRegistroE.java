package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.EmpleadoDAO;
import modelo.EnumCiudad;
import modelo.Empleado;
import modelo.GerenteDAO;
import vista.FrmInterfazGerencia;
import vista.FrmRegistrarE;

public class ControladorRegistroE implements ActionListener{

        FrmRegistrarE objVistaRegistroE = new FrmRegistrarE();
        FrmInterfazGerencia objVistaInterfazG = new FrmInterfazGerencia();
        EmpleadoDAO objEmpleadoDAO = new EmpleadoDAO();
        GerenteDAO objGerenteDAO = new GerenteDAO();
    
    public ControladorRegistroE(FrmRegistrarE registroe, FrmInterfazGerencia interfazg, EmpleadoDAO empdao){
    
            objVistaRegistroE = registroe;
            objVistaInterfazG = interfazg;
            objEmpleadoDAO = empdao;
            
            
            objVistaRegistroE.btnRegistrarE.addActionListener(this);
            objVistaRegistroE.btnRegresar.addActionListener(this);
            
            //combo box
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.AMBATO.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.AZOGUES.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.CUENCA.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.ESMERALDAS.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.GUARANDA.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.GUAYAQUIL.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.IBARRA.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.LATACUNGA.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.LOJA.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.MACHALA.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.MANTA.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.QUITO.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.RIOBAMBA.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.STO_DOMINGO.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.TENA.name());
            objVistaRegistroE.cmbCiudadE.addItem(EnumCiudad.TULCAN.name());
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
            objGerenteDAO.obtenerCodigoG(objVistaInterfazG.lblAdmiGerente.getText());
            objGerenteDAO.insertarEmpleado(objEmpleado);
            JOptionPane.showMessageDialog(null, "Empleado Agregado");
            limpiarElementos();
        }
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
