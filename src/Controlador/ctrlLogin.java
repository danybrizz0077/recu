
package Controlador;

import Modelo.ClienteRecu;
import Vista.frmLogin;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlLogin implements MouseListener{
    ClienteRecu modelo;
    frmLogin vista;
    
     //2-Constructor 
    public ctrlLogin(ClienteRecu Modelo, frmLogin Vista) {
        this.modelo = Modelo;
        this.vista = Vista;

        vista.btnIniciarSesion.addMouseListener(this);
        vista.btnRegistro.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista .btnRegistro) {
        modelo.setCorreo_User(vista.txtCorreo.getText());
        modelo.setContraseña(modelo.convertirSHA256(vista.txtContra.getText()));
        
        boolean comprobar = modelo.iniciarSesion();
        
        
      
       }
            if (e.getSource()== vista.btnRegistro)
                Vista.frmRegistro.initFrmRegistro();
            vista.dispose();
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
