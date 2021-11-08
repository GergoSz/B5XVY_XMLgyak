package SaxB5XVY71019;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XSDValidation {
	
	public static final String XMLPATH = "/SaxB5XVY7/szemelyekB5XVY7.xml";
	public static final String XSDPATH = "/SaxB5XVY7/szemelyekB5XVY7.xsd";
	
	public static void main(String[] args) {

		File schemaFile = new File(XSDPATH);
		Source xmlFile = new StreamSource(new File(XMLPATH));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);
			System.out.println("XSD Validation successful");
		} catch (SAXException e) {
			System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
		} catch (IOException e) {
		}

	}

}