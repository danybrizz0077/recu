package Controlador;

import Modelo.ClienteRecu;
import Vista.frmRegistro;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlRegistro implements MouseListener{
    
    //1-Llamar a las otras capas
    ClienteRecu modelo;
    frmRegistro vista;
    
    //2-Constructor 
    public ctrlRegistro(ClienteRecu Modelo, frmRegistro Vista){
        this.modelo = Modelo;
        this.vista = Vista;
        
        vista.btnRegistro.addMouseListener(this);
        vista.btnCuenta.addMouseListener(this);
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vista.btnRegistro){
            modelo.setNomber_User(vista.txtnombre.getText());
            modelo.setEdad_User(Integer.parseInt(vista.txtEdad.getText()));
            modelo.setCorreo_User(vista.txtCorreo.getText());
            modelo.setContraseña(modelo.convertirSHA256(vista.txtContra.getText()));
            
            modelo.GuardarUsuario();
            
            //Muestro una alerta que el usuario se ha guardado
            JOptionPane.showMessageDialog(vista, "Usuario Guardado");
        }
        
         //Clic al botón de Ir Al Login
        if(e.getSource() == vista.btnCuenta){
            Vista.frmLogin.initFrmLogin();
            vista.dispose();
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
