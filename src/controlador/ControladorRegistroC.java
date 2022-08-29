package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.EnumCiudad;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Paquete;
import vista.FrmInicio;
import vista.FrmRegistroCliente;


public class ControladorRegistroC implements ActionListener{
    
    FrmRegistroCliente objVistaRegistroC = new FrmRegistroCliente();
    FrmInicio objVistaInicio = new FrmInicio();
    ClienteDAO objClienteDAO = new ClienteDAO();
    ArrayList<Paquete> listapVacia = new ArrayList();
    

    public ControladorRegistroC(FrmRegistroCliente registro, FrmInicio inicio, ClienteDAO cdao ) {
        objVistaRegistroC = registro;
        objVistaInicio = inicio;
        objClienteDAO = cdao;
        
        
        objVistaRegistroC.btnRegresarIC.addActionListener(this);
        objVistaRegistroC.btnRegistrarC.addActionListener(this);
        
        //combo box
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.AMBATO.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.AZOGUES.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.CUENCA.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.ESMERALDAS.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.GUARANDA.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.GUAYAQUIL.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.IBARRA.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.LATACUNGA.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.LOJA.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.MACHALA.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.MANTA.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.QUITO.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.RIOBAMBA.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.STO_DOMINGO.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.TENA.name());
        objVistaRegistroC.cmbCiudadC.addItem(EnumCiudad.TULCAN.name());
        
        //otros
         //listapVacia.add(pVacio);
               
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==objVistaRegistroC.btnRegresarIC) {
            objVistaInicio.setVisible(true);
            objVistaRegistroC.setVisible(false);
        }
        
        if(e.getSource()==objVistaRegistroC.btnRegistrarC){
            
          
            String nombre = objVistaRegistroC.txtNombre.getText();
            String apellido = objVistaRegistroC.txtApellido.getText();
            String usuario = objVistaRegistroC.txtUsuario.getText();
            String clave = objVistaRegistroC.txtClave.getText();
            String ciudad = objVistaRegistroC.cmbCiudadC.getSelectedItem().toString();
            String direccion = objVistaRegistroC.txtDireccion.getText();
            String nCedula = objVistaRegistroC.txtCedula.getText();
            String nCelular = objVistaRegistroC.txtTelefono.getText();
            ArrayList paquetesC []= null;
                   
            
            Cliente objCliente = new Cliente(nombre, apellido, usuario, clave, ciudad, 
                    direccion, nCedula, nCelular, paquetesC);
            objClienteDAO.insertarCliente(objCliente);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            limpiarElementos();
        
        }
        
        
    }
    public void limpiarElementos(){
    objVistaRegistroC.txtNombre.setText("");
    objVistaRegistroC.txtApellido.setText("");
    objVistaRegistroC.txtUsuario.setText("");
    objVistaRegistroC.txtDireccion.setText("");
    objVistaRegistroC.txtCedula.setText("");
    objVistaRegistroC.txtTelefono.setText("");
    objVistaRegistroC.txtClave.setText("");
    }
}
