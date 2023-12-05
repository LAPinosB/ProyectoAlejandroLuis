/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalejandroluis;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author luis
 */
public class EliminarNodo {
    
    public Document deleteNode(String title, Document document){
        System.out.println("Buscando el Libro: "+title+" para borrarlo ...");
        try{
            //Creamos el nodo raiz
            Node raiz = document.getDocumentElement();
            //Creamos una lista de nodos con los nodos 'title'
            NodeList nodeListOne = document.getElementsByTagName("title");
            Node n1;
            //Recorremos la lista de nodos
            for(int i=0; i<nodeListOne.getLength();i++){
                //Se crea el nodo con el titulo para comprobarlo
                n1=nodeListOne.item(i);
                //Se ejecutara el codigo si el nodo es un elemento
                if(n1.getNodeType()==Node.ELEMENT_NODE){
                    //Se ejecutara el codigo si el 'title' es igual que el que le hemos enviado al metodo
                    if(n1.getChildNodes().item(0).getNodeValue().equals(title)){
                        System.out.println("Borrando el nodo <Libro> con titulo "+title);
                        //Se coge el nodo padre para eliminar el nodo que hemos encontrado 
                        n1.getParentNode().getParentNode().removeChild(n1.getParentNode());
                    }
                }
            }
            System.out.println("Nodo Borrado");
            //Devuelve el Document con los cambios hechos
            return document;
        }catch(Exception e){
            System.out.println(e);
            e.getMessage();
            return document;
        }
        
    }
}
