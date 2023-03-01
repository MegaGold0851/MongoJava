package mongojava;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author MegaGold
 */
public class Conexion {

    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();

    /**
     * Conecta automaticamente a MongoDB en cuanto se crea un objeto de la clase Conexion.
     */
    public Conexion() {
        Mongo mongo = new Mongo("localhost", 27017);
        BaseDatos = mongo.getDB("Act6");
        coleccion = BaseDatos.getCollection("Act_6");
        System.out.println("Conexión exitosa");
    }

    /**
     *Permite insertar documentos nuevos a una coleccion especifica.
     * @param accion
     * @return true
     */
    public boolean insertar(String accion) {
        document.put("accion", accion);
        coleccion.insert(document);
        return true;
    }
    
    /**
     *Permite enseñar los documentos de una coleccion especifica.
     */
    public void mostrar(){
        DBCursor cursor = coleccion.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    /**
     *Actualiza un documento donde la accionVieja sera remplazada por la accionNueva.
     * @param accionVieja
     * @param accionNueva
     * @return true
     */
    public boolean actualizar(String accionVieja, String accionNueva){
        document.put("accion", accionVieja);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("accion", accionNueva);
        coleccion.findAndModify(document, documentoNuevo);
        return true;
    }
    
    /**
     *Permite eliminar un documento especifico de una coleccion.
     * @param accion
     * @return true
     */
    public boolean eliminar(String accion){
        document.put("accion", accion);
        coleccion.remove(document);
        return true;
    }
}
