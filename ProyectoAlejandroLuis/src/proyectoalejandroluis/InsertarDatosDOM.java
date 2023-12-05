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
            //Crearemos los nodos del libro en orden descendente
            //Crear el Autor
            //Creamos el nodo con el nombre 'author'
            Node nodeAuthor = doc.createElement("author");
            //Creamos el contenido del nodo
            Node nodeAuthorContent = doc.createTextNode(author);
            //Insertamos el contenido en el nodo
            nodeAuthor.appendChild(nodeAuthorContent);

            //Crear el Titulo
            //Creamos el nodo con el nombre 'title'
            Node nodeTitle = doc.createElement("title");
            //Creamos el contenido del nodo
            Node nodeTitleContent = doc.createTextNode(title);
            //Insertamos el contenido en el nodo
            nodeTitle.appendChild(nodeTitleContent);
            
            //Crear el Genero
            //Creamos el nodo con el nombre 'genre'
            Node nodeGenre = doc.createElement("genre");
            //Creamos el contenido del nodo
            Node nodeGenreContent = doc.createTextNode(genre);
            //Insertamos el contenido en el nodo
            nodeGenre.appendChild(nodeGenreContent);
            
            //Crear el Precio
            //Creamos el nodo con el nombre 'price'
            Node nodePrice = doc.createElement("price");
            //Creamos el contenido del nodo
            Node nodePriceContent = doc.createTextNode(price);
            //Insertamos el contenido en el nodo
            nodePrice.appendChild(nodePriceContent);
            
            //Crear la Fecha
            //Creamos el nodo con el nombre 'publish_date'
            Node nodeDate = doc.createElement("publish_date");
            //Creamos el contenido del nodo
            Node nodeDateContent = doc.createTextNode(date);
            //Insertamos el contenido en el nodo
            nodeDate.appendChild(nodeDateContent);
            
            //Crear la Descripcion
            //Creamos el nodo con el nombre 'description'
            Node nodeDesc = doc.createElement("description");
            //Creamos el contenido del nodo
            Node nodeDescContent = doc.createTextNode(description);
            //Insertamos el contenido en el nodo
            nodeDesc.appendChild(nodeDescContent);
            
            //Crear el Libro
            //Creamos el nodo del libro
            Node nodeBook = doc.createElement("book");
            //Añadimos el atributo 'id'
            ((Element)nodeBook).setAttribute("id", id);
            //Añadimmos el nodo 'author'
            nodeBook.appendChild(nodeAuthor);
            //Añadimmos el nodo 'title'
            nodeBook.appendChild(nodeTitle);
            //Añadimos el nodo 'genre'
            nodeBook.appendChild(nodeGenre);
            //Añadimos el nodo 'price'
            nodeBook.appendChild(nodePrice);
            //Añadimos el nodo 'publish_date'
            nodeBook.appendChild(nodeDate);
            //Añadimos el nodo 'description'
            nodeBook.appendChild(nodeDesc);
            
            nodeBook.appendChild(doc.createTextNode("\n"));
            //Creamos el nodo raiz en el que añadiremos el nodo 'book'
            Node root = doc.getFirstChild();
            //Añadimos el nodo 'book'
            root.appendChild(nodeBook);
            System.out.println("Libro insertado en el DOM");
            //Devolvemos el Document con el libro añadido
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
        //Creamos la lista de nodos con los nodos 'book'
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
