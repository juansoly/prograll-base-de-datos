package controlador;
import  modelo.Usuario;
import modelo.UsuarioDAO;
import  vista.UsuarioVista;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UsuarioControlador {
    private UsuarioDAO usuarioDAO;
    private  UsuarioVista usuarioVista;
    public UsuarioControlador(UsuarioDAO usuarioDAO, UsuarioVista usuarioVista){
        this.usuarioDAO=usuarioDAO;
        this.usuarioVista= usuarioVista;
    }
    //metodo para mostrar la lista de usuarios
    public  void listarUsuarios(){
      List<Usuario>usuarios= usuarioDAO.obtenerUsuarios();
      usuarioVista.mostrarUsuario(usuarios);
    }
    //metodo para agregar un usuarios
    public  void  agregarUsuario()throws SQLException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el nombre :");
        String nombre =sc.nextLine();
        System.out.println("Ingrese el correo  :" );
        String email = sc.nextLine();
        usuarioDAO.agregarUsuario(nombre,email);
        System.out.println("Usuario agregado con exito");



    }
}
