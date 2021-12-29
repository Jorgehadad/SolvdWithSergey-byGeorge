package jaxb;

import java.sql.Connection;
import java.sql.SQLException;

import com.solvd.lab.connections.PoolConnection;

import jaxb.dao.Areas;
import jaxb.service.AreasService;

public class Main {
    public static void main(String[] args) throws SQLException {


        Areas area = new Areas();
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
