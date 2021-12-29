package jaxb.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jaxb.dao.Parks;
import jaxb.interfaces.IParksDAO;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

@XmlRootElement(name = "parks")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParksService implements IParksDAO {
    private static File FILE = new File("src/main/resources/parks.xml");

    @XmlElement(name = "park")
    private List<Parks> parks = null;

    @Override
    public void save(Parks park) {
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
    public Parks getById(String NameP) {
        parks = unmarshall();
        return parks.stream()
                .filter(element -> element.getNameP() == NameP)
                .findAny()
                .orElse(null);
    }  

    @Override
    public void update(Parks entity){
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

    private List<Parks> unmarshall() {
        try {
            JAXBContext context = JAXBContext.newInstance(ParksService.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return ((ParksService) unmarshaller.unmarshal(FILE)).getParks();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Parks> getParks() {
        return parks;
    }
    
    public void setParks(List<Parks> parks) {
        this.parks = parks;
    }

    @Override
    public void delete(Parks entity) {
        parks = unmarshall();
        parks.removeIf(element -> element.getNameP() == entity.getNameP());
        marshall(this);
    }

}
