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
            NodeList nodeListOne = document.getElementsByTagName("title");
            Node n1;
            for(int i=0; i<nodeListOne.getLength();i++){
                n1=nodeListOne.item(i);
                if(n1.getNodeType()==Node.ELEMENT_NODE){
                    if(n1.getChildNodes().item(0).getNodeValue().equals(title)){
                        System.out.println("Borrando el nodo <Libro> con titulo "+title);
                        n1.getParentNode().getParentNode().removeChild(n1.getParentNode());
                    }
                }
            }
            System.out.println("Nodo Borrado");
            return document;
        }catch(Exception e){
            System.out.println(e);
            e.getMessage();
            return document;
        }
        
    }
}
