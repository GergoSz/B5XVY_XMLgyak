package hu.unimiskolc.iit;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMReadB5XVY7 {

    public static void main(String[] args) {
        NodeList list;
        try {
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=factory.newDocumentBuilder();
            Document document=documentBuilder.parse(new File("B5XVY7.xml"));
            document.getDocumentElement().normalize();
            System.out.println("Root element : " + document.getDocumentElement().getNodeName());
            System.out.println("----------------");
            list=document.getElementsByTagName("Pek");

            for (int i=0;i<list.getLength();i++) {
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("Személyi szam: " + element.getAttribute("szemszam"));
                    System.out.println("Eszközazonosító id: " + element.getAttribute("eszkoz"));
                    System.out.println("Név: " + element.getElementsByTagName("nev").item(0).getTextContent());
                    System.out.println("Beosztás: " + element.getElementsByTagName("beosztas").item(0).getTextContent());

                    Node nodelakcim=list.item(i);
                    if(nodelakcim.getNodeType()==Node.ELEMENT_NODE){
                        Element elementlakcim=(Element) node;
                        System.out.println("Lakcím: " 
                                            + elementlakcim.getElementsByTagName("varos").item(0).getTextContent() 
                                            + " " + elementlakcim.getElementsByTagName("utca").item(0).getTextContent() 
                                            + " " + elementlakcim.getElementsByTagName("hazszam").item(0).getTextContent());
                    }
                }
            }
            
            list=document.getElementsByTagName("Pekseg");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("Pékség név: " + element.getAttribute("pnev"));
                    System.out.println("Cím: " + element.getElementsByTagName("pcim").item(0).getTextContent());
                    System.out.println("Nyitott: " + element.getElementsByTagName("nyitas").item(0).getTextContent());
                }
            }
            
            list=document.getElementsByTagName("Eszkoz");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                //Verseny Bírok adatainak kiirása
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("Eszköz id: " + element.getAttribute("eszkozazon"));
                    System.out.println("Eszköznév: " + element.getElementsByTagName("eszkoznev").item(0).getTextContent());
                    System.out.println("Állapot: " + element.getElementsByTagName("allapot").item(0).getTextContent());
                }
            }
            
            list=document.getElementsByTagName("Vevo");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("Vevőszám: " + element.getAttribute("vevoszam"));
                    System.out.println("Fizetett összeg: " + element.getElementsByTagName("fizetett").item(0).getTextContent());
                    System.out.println("Kiszolgálta: " + element.getElementsByTagName("kiszolgalta").item(0).getTextContent());

                }
            }
            
            list=document.getElementsByTagName("Termek");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("Termek kód: " + element.getAttribute("tkod"));
                    System.out.println("Név: " + element.getElementsByTagName("termeknev").item(0).getTextContent());
                    System.out.println("Sós/Édes: " + element.getElementsByTagName("sosedes").item(0).getTextContent());
                    System.out.println("Készítés ideje: " + element.getElementsByTagName("kesitesideje").item(0).getTextContent());
                }
            }
            
            list=document.getElementsByTagName("Vegzettseg");

            for(int i=0;i<list.getLength();i++){
                Node node=list.item(i);
                System.out.println("\nAktuális elem: " + node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element=(Element) node;
                    System.out.println("Végzettség id: " + element.getAttribute("ID"));
                    System.out.println("Neve: " + element.getElementsByTagName("megnevezes").item(0).getTextContent());

                }
            }

        }catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
