package com.solvd.jaxb.interfaces;

import com.solvd.jaxb.dao.parks;

public interface IParksDAO extends IEntityDAO<parks> {
    
    parks getById(String NameP);
}
