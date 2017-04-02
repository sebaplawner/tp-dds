import com.tp.dds.empresa.Empresa;
import com.tp.dds.gui.StartupGUI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Empresa> empresas = cargarEmpresas();

        StartupGUI startupGUI = new StartupGUI(empresas);
    }

    private static List<Empresa> cargarEmpresas() {
        try {
            List<Empresa> empresas = new ArrayList<>();

            File inputFile = new File("empresas.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("empresa");

            for (int i = 0; i < nList.getLength(); i++) {
                Element empresaNodo = (Element) nList.item(i);
                empresas.add(Empresa.getInstance(empresaNodo));
            }

            return empresas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
