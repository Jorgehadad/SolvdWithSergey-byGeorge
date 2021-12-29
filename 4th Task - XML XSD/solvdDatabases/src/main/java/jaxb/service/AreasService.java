package jaxb.service;



import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jaxb.dao.Areas;
import jaxb.interfaces.IAreasDAO;


import java.io.File;
import java.util.List;

@XmlRootElement(name = "areas")
@XmlAccessorType(XmlAccessType.FIELD)
public class AreasService implements IAreasDAO {
    private static File FILE = new File("src/main/resources/areas.xml");

    @XmlElement(name = "area")
    private List<Areas> areas = null;

    public AreasService(List<Areas> areas) {
        this.areas = areas;
    }

    public AreasService() {
    }

    @Override
    public void save(Areas entity) {
        areas = unmarshall();
        areas.add(entity);
        marshall(this);
    }

    //marshall
    private void marshall(AreasService areasDAO) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AreasService.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(areasDAO, FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    //unmarshall
    private List<Areas> unmarshall() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AreasService.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            AreasService areasDAO = (AreasService) unmarshaller.unmarshal(FILE);
            return areasDAO.getAreas();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    //getAreas
    public List<Areas> getAreas() {
        return areas;
    }

    @Override
    public void update(Areas entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Areas entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Areas getById(String NameA) {
        // TODO Auto-generated method stub
        return null;
    }

}
