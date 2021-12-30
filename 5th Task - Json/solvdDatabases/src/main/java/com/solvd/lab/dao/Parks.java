package com.solvd.lab.dao;


public class Parks {

    private String NameP;
    private String Date_Declaracion;

    public String getNameP() {
        return NameP;
    }

    public void setNameP(String nameP) {
        NameP = nameP;
    }

    public String getDate_Declaracion() {
        return Date_Declaracion;
    }

    public void setDate_Declaracion(String date_Declaracion) {
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
 