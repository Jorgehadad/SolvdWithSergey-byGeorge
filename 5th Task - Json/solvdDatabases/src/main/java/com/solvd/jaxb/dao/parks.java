package com.solvd.jaxb.dao;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class parks {

    @JsonProperty("nameP")
    private String nameP;

    @JsonProperty("date_Declaracion")
    private Date date_Declaracion;

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        nameP = nameP;
    }

    public Date getDate_Declaracion() {
        return date_Declaracion;
    }

    public void setDate_Declaracion(String date_Declaracion) {
        date_Declaracion = date_Declaracion;
    }

    @Override
    public String toString() {
        return "Parks{" +
                "NameP='" + nameP + '\'' +
                ", Date_Declaracion=" + date_Declaracion +
                '}';
    }

    
}
 