import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XmlFile {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();

        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse("D:\\XmlFiles\\homework.xml");

            NodeList lines = document.getElementsByTagName("line");

            for(int i = 0; i < lines.getLength();i++){
                Node line = lines.item(i);
                NodeList lines1 = line.getChildNodes();
                for(int j = 0; j < lines1.getLength(); j++){
                    Node line1 = lines1.item(j);
                    System.out.println(line1.getTextContent());
                    list.add(line1.getTextContent() + "\n");
                }
            }
            System.out.println(list);
        }
        catch (Exception e){
            System.out.println("e");
        }

            BufferedWriter file = new BufferedWriter(new FileWriter("D:\\XmlFiles\\William_Shakespeare" +
                    "_Sonnet 130.txt"));

        for(String loop: list){
            file.write(loop);
        }

        file.close();
    }
}