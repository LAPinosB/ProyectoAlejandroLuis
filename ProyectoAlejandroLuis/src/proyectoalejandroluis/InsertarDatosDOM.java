
package proyectoalejandroluis;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class InsertarDatosDOM {
    
    public int insertarLibroEnDOM(String author,String title,String genre,String price,String date,String description,File f,Document doc)
    {
        try
        {
            //Crear el Autor
            Node nodeAuthor = doc.createElement("author");
            Node nodeAuthorContent = doc.createTextNode(author);
            nodeAuthor.appendChild(nodeAuthor);

            //Crear el Titulo
            Node nodeTitle = doc.createElement("title");
            Node nodeTitleContent = doc.createTextNode(title);
            nodeTitle.appendChild(nodeTitle);
            
            //Crear el Genero
            Node nodeGenre = doc.createElement("genre");
            Node nodeGenreContent = doc.createTextNode(genre);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
