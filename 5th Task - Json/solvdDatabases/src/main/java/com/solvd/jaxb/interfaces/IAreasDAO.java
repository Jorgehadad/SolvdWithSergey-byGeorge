package com.solvd.jaxb.interfaces;

import com.solvd.jaxb.dao.areas;

public interface IAreasDAO extends IEntityDAO<areas> {
    
    areas getById(String NameA);

}
