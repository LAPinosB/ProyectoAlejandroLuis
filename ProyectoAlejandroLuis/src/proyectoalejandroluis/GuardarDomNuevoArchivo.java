package proyectoalejandroluis;


import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luis
 */
public class GuardarDomNuevoArchivo {
    public void guardarDOMcomoArchivo(String nuevoarchivo, Document doc)
    {
        try
        {
            Source src = new DOMSource(doc);
            StreamResult rst = new StreamResult(new File(nuevoarchivo));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(src, (javax.xml.transform.Result) rst);
            System.out.println("Archivo creado del DOM con exito");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
