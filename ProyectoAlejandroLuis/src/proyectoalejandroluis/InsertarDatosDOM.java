
package proyectoalejandroluis;

import java.io.File;
import static java.lang.Integer.parseInt;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class InsertarDatosDOM {
    
    public Document insertarLibroEnDOM(String author,String title,String genre,String price,String date,String description,Document doc)
    {
        String id = sacarID(doc);
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
            ((Element)nodeBook).setAttribute("id", id);
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
    
    //Crea un ID autoincremental
    public String sacarID(Document doc)
    {
        NodeList nlist = doc.getElementsByTagName("book");
        //Coge el ultimo libro para sacar su ID
        int pos = nlist.getLength() -1;
        Node n = nlist.item(pos);
        Element e = (Element) n;
        String aux = e.getAttribute("id");
        //Separa solo los numeros del ID
        String id = aux.substring(2,aux.length());
        //Suma 1 al ID
        int nid = parseInt(id) + 1;
        //Vuelve a estructurar el ID
        id = "bk" + nid;
        return id;
    }
}
