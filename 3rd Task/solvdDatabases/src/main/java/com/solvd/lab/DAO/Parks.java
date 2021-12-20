package com.solvd.lab.DAO;

import java.sql.Date;

public class Parks {

    private String NameP;
    private Date Date_Declaracion;



    public String getNameP() {
        return NameP;
    }

    public void setNameP(String nameP) {
        NameP = nameP;
    }

    public Date getDate_Declaracion() {
        return Date_Declaracion;
    }

    public void setDate_Declaracion(Date date_Declaracion) {
        Date_Declaracion = date_Declaracion;
    }

    @Override
    public String toString() {
        return "Parks{" +
                "NameP='" + NameP + '\'' +
                ", Date_Declaracion=" + Date_Declaracion +
                '}';
    }
    
    
}
 