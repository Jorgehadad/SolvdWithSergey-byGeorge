package jaxb.interfaces;

import jaxb.dao.Areas;

public interface IAreasDAO extends IEntityDAO<Areas> {
    
    Areas getById(String NameA);

}
