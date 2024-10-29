package vista;
import  modelo.Usuario;
import  modelo.UsuarioDAO;
import  java.util.List;

public class UsuarioVista {
    public  void  mostrarUsuario(List<Usuario>usuarios){
        System.out.println("\n*** Lista de usuarios  ***");
        if(usuarios.isEmpty()){
            System.out.println("No hay usuarios registrados");
        }else {
          System.out.printf("%5s %15s %25s\n","ID","nombre","email");
            for (Usuario usuario : usuarios){
                System.out.printf("%5s %15s %25s\n",usuario.getId(),usuario.getNombre(),usuario.getEmail());
            }
        }
    }

}
