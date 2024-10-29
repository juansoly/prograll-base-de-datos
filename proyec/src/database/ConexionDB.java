package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionDB {
    private static final String URL="jdbc:mysql://localhost:3306/prueba";

    private static final String USUARIO="root";
    private static final String CONTRASEÑA="";
    private  static Connection conexion =null;


    //obtener conexion
    public static  Connection getConnection()throws  SQLException{
        if(conexion==null || conexion.isClosed()){
            try{
                conexion=DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
                System.out.println("conexion establesida.");
            }catch (SQLException e){
                System.out.println("Error al conectar con la base de datos");
                throw  e;
            }
        }
        return  conexion;
    }
    //Metodo para cerrar la conexion
    public static void  cerrarConexion()throws SQLException{
        if(conexion !=null){
            try{
                conexion.close();
                System.out.println("conexion cerrada");

            }catch (SQLException e){
                System.out.println("error al cerrar la conexion");
                throw  e;
            }
        }
    }

}
