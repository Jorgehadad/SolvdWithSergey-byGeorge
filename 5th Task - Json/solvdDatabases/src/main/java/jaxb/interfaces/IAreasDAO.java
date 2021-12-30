package jaxb.interfaces;

import jaxb.dao.areas;

public interface IAreasDAO extends IEntityDAO<areas> {
    
    areas getById(String NameA);

}
