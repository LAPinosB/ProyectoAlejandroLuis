package proyectoalejandroluis;
import java.io.File;
import org.w3c.dom.Document;

/**
 *
 * @author Alejandro , luis
 */

public class ProyectoAlejandroLuis{
    public static void main(String[] args) {
        Document doc;
        File f = new File("books.xml");
        AbrirDoc abrirDoc = new AbrirDoc();
        LeerAccesoDom leerAccesoDom = new LeerAccesoDom();
        doc = abrirDoc.abrirDoc(f);
        leerAccesoDom.mostrarLibros(doc);
        
    }
    
}

