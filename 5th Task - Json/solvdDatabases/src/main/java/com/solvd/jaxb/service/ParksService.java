package com.solvd.jaxb.service;

import java.io.File;
import java.util.List;

import com.solvd.jaxb.dao.parks;
import com.solvd.jaxb.interfaces.IParksDAO;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "parks")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParksService implements IParksDAO {
    private static File FILE = new File("src/main/resources/parks.xml");

    @XmlElement(name = "park")
    private List<parks> parks = null;

    @Override
    public void save(parks park) {
        parks = unmarshall();
        parks.add(park);
        saveToXML();
    }

    private void saveToXML() {
        try {
            JAXBContext context = JAXBContext.newInstance(ParksService.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(this, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public parks getById(String NameP) {
        parks = unmarshall();
        return parks.stream()
                .filter(element -> element.getNameP() == NameP)
                .findAny()
                .orElse(null);
    }  

    @Override
    public void update(parks entity){
        parks = unmarshall();
        parks.stream()
                .filter(element -> element.getNameP() == entity.getNameP())
                .findAny()
                .ifPresent(updateElement -> updateElement.setNameP(entity.getNameP()));
        marshall(this);
    }

    private void marshall(ParksService parksDAO) {
        try {
            JAXBContext context = JAXBContext.newInstance(ParksService.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(parksDAO, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private List<parks> unmarshall() {
        try {
            JAXBContext context = JAXBContext.newInstance(ParksService.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return ((ParksService) unmarshaller.unmarshal(FILE)).getParks();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<parks> getParks() {
        return parks;
    }
    
    public void setParks(List<parks> parks) {
        this.parks = parks;
    }

    @Override
    public void delete(parks entity) {
        parks = unmarshall();
        parks.removeIf(element -> element.getNameP() == entity.getNameP());
        marshall(this);
    }

}
