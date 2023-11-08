package proyectoalejandroluis;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AbrirDoc extends AttributesController{
    
    public Document abrirDoc(File f)
    {
        if(f.exists()){ 
            try {
                factory.setIgnoringComments(true);
                factory.setIgnoringElementContentWhitespace(true);
                doc = (Document) builder.parse(f);
                
                //Este sout se podria ahorrar visualmente en el cmd
                System.out.println("DOM creado correctamente en Memoria ");
                
                return doc;
            } catch (SAXException | IOException e) {
                Logger.getLogger(AbrirDoc.class.getName()).log(Level.SEVERE, null, e);
                return doc;
            }
        }else{
            System.out.println("No se Abrio correctamente el document revisa si has puesto bien el nombre");
            return doc;
        }
    }
    public int getMaxNumberFromAttribute(Document doc, String attributeName) {
        NodeList nodeList = doc.getElementsByTagName("element"); // Reemplaza "element" con el nombre del elemento que contiene el atributo

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                Element element = (Element) nodeList.item(i);
                String id = element.getAttribute(attributeName);
                String numberString = id.replaceAll("[^0-9]", "");
                if (!numberString.isEmpty()) {
                    int number = Integer.parseInt(numberString);
                    numbers.add(number);
                }
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("No se encontraron números en los atributos.");
            return -1; // Puedes elegir cómo manejar esto en tu aplicación.
        }

        Collections.sort(numbers, Collections.reverseOrder());
        return numbers.get(0);
    }
}