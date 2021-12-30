package jaxb.xml;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jaxb.dao.areas;

public class JaxbRunner {
    
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(areas.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        
        areas areas;
        areas = (areas) jaxbUnmarshaller.unmarshal
                (JaxbRunner.class.getClassLoader().
                        getResourceAsStream("src/main/resources/areas.xml"));
        System.out.println(areas);
        
    }

}
