package com.solvd.jaxb.xml;


import com.solvd.jaxb.dao.areas;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class JaxbRunner {
    
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(areas.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        
        areas areas;
        areas = (areas) jaxbUnmarshaller.unmarshal
                (JaxbRunner.class.getClassLoader().
                        getResourceAsStream("XML/areas.xml"));
        System.out.println(areas);
        
    }

}
