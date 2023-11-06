package proyectoalejandroluis;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.w3c.dom.Document;

/**
 *
 * @author Alejandro , luis
 */

public class ProyectoAlejandroLuis{
    public static void main(String[] args) {
        try { System.setOut(new PrintStream(System.out, true, "UTF-8"));} 
        catch (UnsupportedEncodingException e) {System.out.println(e);}
        Document doc;
        File f = new File("books.xml");
        AbrirDoc abrirDoc = new AbrirDoc();
        LeerAccesoDom leerAccesoDom = new LeerAccesoDom();
        InsertarDatosDOM insertarDatos = new InsertarDatosDOM();        
        doc = abrirDoc.abrirDoc(f);
        doc = insertarDatos.insertarLibroEnDOM("Autor1", "Titulo1", "Genero1", "Precio1", "Fecha1", "Descripcion1", f, doc);
        leerAccesoDom.mostrarLibros(doc);
        
    }
    
}

