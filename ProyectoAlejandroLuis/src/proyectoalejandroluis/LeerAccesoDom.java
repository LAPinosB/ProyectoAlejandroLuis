/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalejandroluis;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author luis
 */
public class LeerAccesoDom {
    public void mostrarNodos(Node nodo) {
        mostrarNodosRecursivo(nodo);
    }

    private void mostrarNodosRecursivo(Node nodo) {
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            Element elemento = (Element) nodo;
            String nodoName = nodo.getNodeName();
            //Si el nodo name es igual a cualquiera de nuestros dos nodos de etiquetas
            if (nodoName.equals("catalog") || nodoName.equals("book")) {
                System.out.println(nodoName + ": " + nodo.getTextContent());
            } else {
                System.out.println(nodoName);
            }

            NamedNodeMap atributos = elemento.getAttributes();
            for (int i = 0; i < atributos.getLength(); i++) {
                Node atributo = atributos.item(i);
                System.out.println("  " + atributo.getNodeName() + ": " + atributo.getNodeValue());
            }
        }

        NodeList hijos = nodo.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            mostrarNodosRecursivo(hijos.item(i));
        }
    }

    public void mostrarLibros(Document doc) {
        NodeList libros = doc.getElementsByTagName("book");

        for (int i = 0; i < libros.getLength(); i++) {
            Node libro = libros.item(i);
            if (libro.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoLibro = (Element) libro;
                String autor = elementoLibro.getElementsByTagName("author").item(0).getTextContent();
                String titulo = elementoLibro.getElementsByTagName("title").item(0).getTextContent();
                String genero = elementoLibro.getElementsByTagName("genre").item(0).getTextContent();
                String precio = elementoLibro.getElementsByTagName("price").item(0).getTextContent();
                String publicado = elementoLibro.getElementsByTagName("publish_date").item(0).getTextContent();
                String descripcion = elementoLibro.getElementsByTagName("description").item(0).getTextContent();
                String id = elementoLibro.getAttribute("id");
                System.out.println("Autor: " + autor);
                System.out.println("Título: " + titulo);
                System.out.println("Genero: " + genero);
                System.out.println("Precio: " + precio);
                System.out.println("Publicado: " + publicado);
                System.out.println("Descripcion: " + descripcion);
                System.out.println("Id: " + id);
                System.out.println("------");
            }
        }
    }
}
