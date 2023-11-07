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

        try {
            //Para que funcionen las ñ
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
            // Creacion del doc que usaremos para los metodos.
            Document doc;
            File f = new File("books.xml");
            
            //Instaciamos la clase Abrir Doc
            AbrirDoc abrirDoc = new AbrirDoc();
            //Instaciamos la clase LeearAccesoDom
            LeerAccesoDom leerAccesoDom = new LeerAccesoDom();
            //Instaciamos la clase Eliminar Nodo
            EliminarNodo eliminarNodo = new EliminarNodo();
            //Instaciamos la clase Insertar Nodo
            InsertarDatosDOM insertarDatos = new InsertarDatosDOM();
            //Instanciamos la clase Guardar Archivo
            GuardarDomNuevoArchivo guardarDomNuevoArchivo = new GuardarDomNuevoArchivo();
            doc = abrirDoc.abrirDoc(f);
            leerAccesoDom.mostrarLibros(doc); // Primera Prueba de que lee el acceso dom correctamente.
            doc = eliminarNodo.deleteNode("Midnight Rain", doc);
            doc = insertarDatos.insertarLibroEnDOM("Autor1", "TItulo1", "Genero1", "Precio1", "Fecha1", "Descripcion1", doc);
            doc = insertarDatos.insertarLibroEnDOM("Autor2", "TItulo2", "Genero2", "Precio2", "Fecha2", "Descripcion2", doc);
            //Lectura del DOM con todas las modificaciones realizadas
            leerAccesoDom.mostrarLibros(doc);
            
            //Guardar en el Nuevo archivo
            //guardarDomNuevoArchivo.guardarDOMcomoArchivo("PruebaLuisY_Alejandro.xml", doc);
            //Mostrar el nuevo archivo
        } 
        catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }     
    }
    
}

