
package proyectoalejandroluis;

import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class InsertarDatosDOM {
    
    public Document insertarLibroEnDOM(String author,String title,String genre,String price,String date,String description,File f,Document doc)
    {
        try
        {
            //Crear el Autor
            Node nodeAuthor = doc.createElement("author");
            Node nodeAuthorContent = doc.createTextNode(author);
            nodeAuthor.appendChild(nodeAuthorContent);

            //Crear el Titulo
            Node nodeTitle = doc.createElement("title");
            Node nodeTitleContent = doc.createTextNode(title);
            nodeTitle.appendChild(nodeTitleContent);
            
            //Crear el Genero
            Node nodeGenre = doc.createElement("genre");
            Node nodeGenreContent = doc.createTextNode(genre);
            nodeGenre.appendChild(nodeGenreContent);
            
            //Crear el Precio
            Node nodePrice = doc.createElement("price");
            Node nodePriceContent = doc.createTextNode(price);
            nodePrice.appendChild(nodePriceContent);
            
            //Crear la Fecha
            Node nodeDate = doc.createElement("publish_date");
            Node nodeDateContent = doc.createTextNode(date);
            nodeDate.appendChild(nodeDateContent);
            
            //Crear la Descripcion
            Node nodeDesc = doc.createElement("description");
            Node nodeDescContent = doc.createTextNode(description);
            nodeDesc.appendChild(nodeDescContent);
            
            //Crear el Libro
            Node nodeBook = doc.createElement("book");
            //Modificar despues para hacer autoincremental
            ((Element)nodeBook).setAttribute("id", "bk000");
            nodeBook.appendChild(nodeAuthor);
            nodeBook.appendChild(nodeTitle);
            nodeBook.appendChild(nodeGenre);
            nodeBook.appendChild(nodePrice);
            nodeBook.appendChild(nodeDate);
            nodeBook.appendChild(nodeDesc);
            
            nodeBook.appendChild(doc.createTextNode("\n"));
            Node root = doc.getFirstChild();
            root.appendChild(nodeBook);
            System.out.println("Libro insertado en el DOM");
            return doc;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}