package com.solvd.jaxb;

import java.sql.SQLException;

import com.solvd.jaxb.dao.areas;
import com.solvd.jaxb.service.AreasService;

public class Main {
    public static void main(String[] args) throws SQLException {


        areas area = new areas();
        area.setNameA("Area16");
        area.setNameP("With Summer");
        area.setExtencion(100.0);
        


        AreasService areasDAO = new AreasService();
        areasDAO.save(area);
        //areasDAO.getById(area.getNameA());
        //areasDAO.update(area);
        //areasDAO.delete(area);

    }    
}
