import  controlador.UsuarioControlador;
import  database.ConexionDB;
import modelo.UsuarioDAO;
import  vista.UsuarioVista;
import  java.sql.Connection;
import  java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            //conectar a ka db desde CONEXIONdb
            Connection conexion = ConexionDB.getConnection();
            //crear las instancias del Mvc
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            UsuarioVista usuarioVista = new UsuarioVista();
            UsuarioControlador usuarioControlador = new UsuarioControlador(usuarioDAO, usuarioVista);


            //menu de opciones
            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("\n === Menu de Gestion de Ususario===");
                System.out.println("1. Mostrar usuarios");
                System.out.println("2. Agregar usuario");
                System.out.println("0. salir");
                System.out.println("Selecciona una opcion");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        usuarioControlador.listarUsuarios();
                        break;
                    case 2:
                        usuarioControlador.agregarUsuario();
                        break;
                    case 0:
                        System.out.println("saliendo del sistema..");
                        break;
                    default:
                        System.out.println("Opcion no valida. INTENTE de nuevo");
                        break;
                }


            } while (opcion != 0) ;
            //cerrar la conexion
            ConexionDB.cerrarConexion();

            }catch(SQLException e){
                e.printStackTrace();

        }

    }
}
