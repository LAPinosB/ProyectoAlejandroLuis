
package proyectoalejandroluis;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BuscarLibro {
    
    public void buscarLibro(String title,Document doc)
    {
        boolean find = false;
        NodeList nlist = doc.getElementsByTagName("book");
        for (int i=0;i<nlist.getLength();++i)
        {
            Node libro = nlist.item(i);
            if (libro.getNodeType() == Node.ELEMENT_NODE)
            {
                Element elementoLibro = (Element) libro;
                if (elementoLibro.getElementsByTagName("title").item(0).getTextContent().equals(title) || elementoLibro.getAttribute("id").equals(title))
                {
                System.out.println("Autor: " + elementoLibro.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Título: " + elementoLibro.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Genero: " + elementoLibro.getElementsByTagName("genre").item(0).getTextContent());
                System.out.println("Precio: " + elementoLibro.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("Publicado: " + elementoLibro.getElementsByTagName("publish_date").item(0).getTextContent());
                System.out.println("Descripcion: " + elementoLibro.getElementsByTagName("description").item(0).getTextContent());
                System.out.println("Id: " + elementoLibro.getAttribute("id"));
                System.out.println("------");
                find = true;
                }
            }
        }
        if (find == false)
        {
            System.out.println("El libro no se ha encontrado");
        }
        
    }
}
