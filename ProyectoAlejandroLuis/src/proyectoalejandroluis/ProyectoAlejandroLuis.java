package proyectoalejandroluis;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import org.w3c.dom.Document;

/**
 *
 * @author Alejandro , luis
 */

public class ProyectoAlejandroLuis{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
            
            String author,title,genre,price,date,description;
            int opc;
            boolean guardado = true;
            do
            {
                System.out.println("Que quieres hacer con el XML");
                System.out.println(" - 1 - Leer XML");
                System.out.println(" - 2 - Añadir datos");
                System.out.println(" - 3 - Eliminar datos");
                System.out.println(" - 4 - Guardar");
                System.out.println(" - 0 - Cerrar");
                opc = sc.nextInt();
                
                switch (opc)
                {
                    case 1:
                        leerAccesoDom.mostrarLibros(doc);
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.print("Introduce el titulo: ");
                        title = sc.nextLine();
                        System.out.print("Introduce el autor: ");
                        author = sc.nextLine();
                        System.out.print("Introduce el genero: ");
                        genre = sc.nextLine();
                        System.out.print("Introduce el precio: [0.0] ");
                        price = sc.nextLine();
                        System.out.print("Introduce la fecha de publicacion: [YYYY-MM-DD] ");
                        date = sc.nextLine();
                        System.out.print("Introduce una descripcion: ");
                        description = sc.nextLine();
                        insertarDatos.insertarLibroEnDOM(author, title, genre, price, date, description, doc);
                        guardado = false;
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.print("Introduce el titulo del libro a eliminar: ");
                        title = sc.nextLine();
                        eliminarNodo.deleteNode(title, doc);
                        guardado = false;
                        break;
                    case 4:
                        //Sobreescribir el mismo archivo para ver los cambios
                        guardarDomNuevoArchivo.guardarDOMcomoArchivo("books.xml", doc);
                        guardado = true;
                        break;
                    case 0:
                        if (guardado == false)
                        {
                            System.out.println("Tienes cambios sin guardar, seguro que quieres salir? [0 - Si / 1 - No]");
                            opc = sc.nextInt();
                        }
                        
                }
            }
            while (opc != 0);
        } 
        catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }     
    }
    
}

