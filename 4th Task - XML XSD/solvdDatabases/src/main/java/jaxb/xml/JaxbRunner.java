package jaxb.xml;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jaxb.dao.Areas;

public class JaxbRunner {
    
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Areas.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        
        Areas areas;
        areas = (Areas) jaxbUnmarshaller.unmarshal
                (JaxbRunner.class.getClassLoader().
                        getResourceAsStream("src/main/resources/areas.xml"));
        System.out.println(areas);
        
    }

}
