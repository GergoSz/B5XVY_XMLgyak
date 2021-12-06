package hu.unimiskolc.iit;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMQuerryB5XVY7 {

    public static void main(String[] args) {
        try {
            NodeList nodeList;

            DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(new File("B5XVY7.xml"));
            document.getDocumentElement().normalize();

            nodeList=document.getElementsByTagName("Eszkoz");


            System.out.println("Működő eszközök listája(állapot == 1): ");
            for(int i =0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);

                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element) node;
                    String allapot= element.getElementsByTagName("allapot").item(0).getTextContent();

                    if(allapot.equals("1"))
                    {
                        System.out.println("\nAktuális elem: " + node.getNodeName());
                        System.out.println("-------");
                        System.out.println("");
                        System.out.println("Eszköz id: " + element.getAttribute("eszkozazon"));
                        System.out.println("Eszköznév: " + element.getElementsByTagName("eszkoznev").item(0).getTextContent());
                        System.out.println("Állapot: " + element.getElementsByTagName("allapot").item(0).getTextContent());

                }
            }
        }
    } catch (ParserConfigurationException | IOException | SAXException e){
        e.printStackTrace();
    }
    }

}
