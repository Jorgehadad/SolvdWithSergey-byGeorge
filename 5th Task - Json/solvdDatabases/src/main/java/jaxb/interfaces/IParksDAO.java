package jaxb.interfaces;

import jaxb.dao.parks;

public interface IParksDAO extends IEntityDAO<parks> {
    
    parks getById(String NameP);
}
