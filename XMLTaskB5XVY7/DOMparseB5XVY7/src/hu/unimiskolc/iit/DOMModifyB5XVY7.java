package hu.unimiskolc.iit;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMModifyB5XVY7 {

    public static void main(String[] args) {
        NodeList nodeList;
        try{
            DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(new File("B5XVY7.xml"));
            document.getDocumentElement().normalize();

            System.out.println("Minden eszköz állapot 0-ra állítása:");
            nodeList=document.getElementsByTagName("Eszkoz");
            for(int i =0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element) node;
                    element.getElementsByTagName("allapot").item(0).setTextContent("0");
                    System.out.println("Eszköz id: " + element.getAttribute("eszkozazon"));
                    System.out.println("Eszköznév: " + element.getElementsByTagName("eszkoznev").item(0).getTextContent());
                    System.out.println("Állapot: " + element.getElementsByTagName("allapot").item(0).getTextContent());

                }
            }
            //létrehozza az xml fájlt módositva
            Transformer transformer= TransformerFactory.newInstance().newTransformer();
            Source input=new DOMSource(document);
            Result output=new StreamResult(new File("Modded_B5XVY.xml"));
            transformer.transform(input,output);
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
