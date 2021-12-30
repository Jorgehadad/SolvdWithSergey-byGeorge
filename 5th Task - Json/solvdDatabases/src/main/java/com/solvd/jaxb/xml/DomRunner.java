package com.solvd.jaxb.xml;

import java.io.IOException;



import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DomRunner {

    public static void main (String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
        Document dom = documentBuilder.parse("src/main/resources/areas.xml");
        dom.getDocumentElement().normalize();

        for (int i = 0; i < dom.getElementsByTagName("NameA").getLength(); i++) {
            System.out.println(dom.getElementsByTagName("NameA").item(i).getTextContent());
        }
    }
    
}
