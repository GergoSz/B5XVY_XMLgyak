package SaxB5XVY71019;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;



public class SaxExample {

	public static void main(String[] args) {
		try {
			
			SAXParserFactory saxPF = SAXParserFactory.newInstance();
			
			SAXParser saxP = saxPF.newSAXParser();
			
			SaxHandler handler = new SaxHandler();
			
			saxP.parse(new File("szemelyekB5XVY7.xml"), handler);
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO: handle exception
		}
	}
	
}
