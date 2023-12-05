
package proyectoalejandroluis;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BuscarLibro {
    
    public void buscarLibro(String title,Document doc)
    {
        //Variable booleana para comprobar que se haya encontrado el libro
        boolean find = false;
        //Crea una lista de nodos con los nodos 'book'
        NodeList nlist = doc.getElementsByTagName("book");
        //Recorremos la lista de nodos
        for (int i=0;i<nlist.getLength();++i)
        {
            //Se crea el nodo con el libro para comprobarlo
            Node libro = nlist.item(i);
            //Se ejecutara el codigo si el nodo es un elemento
            if (libro.getNodeType() == Node.ELEMENT_NODE)
            {
                //Se convierte en elemento el nodo
                Element elementoLibro = (Element) libro;
                //Se ejecutara el codigo si el 'id' o el 'title' es igual al que le hemos enviado al metodo para buscar el libro
                if (elementoLibro.getElementsByTagName("title").item(0).getTextContent().equals(title) || elementoLibro.getAttribute("id").equals(title))
                {
                    //Se muestran todos los datos del libro indicado
                System.out.println("Autor: " + elementoLibro.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Título: " + elementoLibro.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Genero: " + elementoLibro.getElementsByTagName("genre").item(0).getTextContent());
                System.out.println("Precio: " + elementoLibro.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("Publicado: " + elementoLibro.getElementsByTagName("publish_date").item(0).getTextContent());
                System.out.println("Descripcion: " + elementoLibro.getElementsByTagName("description").item(0).getTextContent());
                System.out.println("Id: " + elementoLibro.getAttribute("id"));
                System.out.println("------");
                //Se indica que el libro se ha encontrado
                find = true;
                }
            }
        }
        //En caso que el libro no existiese se mostrara el mensaje de que no se ha encontrado
        if (find == false)
        {
            System.out.println("El libro no se ha encontrado");
        }
        
    }
}
