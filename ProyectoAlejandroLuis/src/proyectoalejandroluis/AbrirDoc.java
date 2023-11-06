
package proyectoalejandroluis;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class AbrirDoc {
    
    Document doc;
    
    public Document abrirDoc(File f)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = (Document) builder.parse(f);
            
            System.out.println("DOM creado correctamente");
            
            return doc;
        }
        catch (IOException | ParserConfigurationException | SAXException e)
        {
            System.out.println(e);
            return null;
        }
    }
}
