package jaxb.interfaces;

import jaxb.dao.Parks;

public interface IParksDAO extends IEntityDAO<Parks> {
    
    Parks getById(String NameP);
}
