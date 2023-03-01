package mongojava;

/**
 * @author MegaGold
 */
public class MongoJava {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Objeto para conectarse a Mongo e inizialisar las operaciones desde Java a una base de datos.
         */
        Conexion conexion = new Conexion();
        
//        conexion.mostrar();
//        conexion.insertar("Nadar");
//         System.out.println("------------------");
//        conexion.mostrar();
         System.out.println("------------------");
//        conexion.actualizar("Nadar","Brincar");
        conexion.mostrar();
        System.out.println("------------------");
        conexion.eliminar("Brincar");
        conexion.mostrar();
    }
    
}
