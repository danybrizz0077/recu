
package Modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ClienteRecu {
    
     //1-Parametros
    private int ID_Usuario;
    private String Nomber_User;
    private String Correo_User;
    private String Contraseña;
    private int Edad_User;
    
    
     //2-Getters y Setters

public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public void setEdad_User(int Edad_User) {
        this.Edad_User = Edad_User;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public int getEdad_User() {
        return Edad_User;
    }

    public void setNomber_User(String Nomber_User) {
        this.Nomber_User = Nomber_User;
    }

    public void setCorreo_User(String Correo_User) {
        this.Correo_User = Correo_User;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }


 

  

    public String getNomber_User() {
        return Nomber_User;
    }

    public String getCorreo_User() {
        return Correo_User;
    }

    public String getContraseña() {
        return Contraseña;
    }


    
    
    //3-Metodos
       public void GuardarUsuario() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addUser = conexion.prepareStatement("INSERT INTO UsuarioRecu(ID_Usuario, Nombre_User, Correo_User, Contrasena, Edad_User) VALUES (?,?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addUser.setInt(1, getID_Usuario());
            addUser.setString(2, getNomber_User());
            addUser.setString(3, getCorreo_User());
            addUser.setString(4, getContraseña());
            addUser.setInt(5, getEdad_User());
            //Ejecutar la consulta
            addUser.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
       
       //El método devuelve un valor booleano (verdadero o falso)
       //Verdadero si existe el usuario y Falso si no existe
       public boolean iniciarSesion() {
        //Obtenemos la conexión a la base de datos
        Connection conexion = ClaseConexion.getConexion();
        boolean resultado = false;

        try {
            //Preparamos la consulta SQL para verificar el usuario
            String sql = "SELECT * FROM UsuarioRecu WHERE Correo_User = ? AND Contrasena = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, getCorreo_User());
            statement.setString(2, getContraseña());

            //Ejecutamos la consulta
            ResultSet resultSet = statement.executeQuery();

            //Si hay un resultado, significa que el usuario existe y la contraseña es correcta
            if (resultSet.next()) {
                resultado = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }

        return resultado;
    }
       
       public String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	}
	catch (NoSuchAlgorithmException e) {
		System.out.println(e.toString());
		return null;
	}
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
 
	for(byte b : hash) {
		sb.append(String.format("%02x", b));
	}
 
	return sb.toString();
}
       
    
    
}

    

