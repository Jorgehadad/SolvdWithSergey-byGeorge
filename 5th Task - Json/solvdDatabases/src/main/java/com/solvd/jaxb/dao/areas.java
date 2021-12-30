package com.solvd.jaxb.dao;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "areas")
@XmlAccessorType(XmlAccessType.FIELD)
public class areas  {

    @JsonProperty("NameA")
    private String NameA;

    @JsonProperty("NameP")
    private String NameP;

    @JsonProperty("Extension")
    private Double Extencion;

    public String getNameA() {
        return NameA;
    }

    @XmlElement(name = "NameA")
    public void setNameA(String nameA) {
        NameA = nameA;
    }

    public String getNameP() {
        return NameP;
    }

    @XmlElement(name = "NameP")
    public void setNameP(String nameP) {
        NameP = nameP;
    }

    public Double getExtencion() {
        return Extencion;
    }

    @XmlElement(name = "Extencion")
    public void setExtencion(Double extencion) {
        Extencion = extencion;
    }

    @Override
    public String toString() {
        return "Areas{" +
                "NameA='" + NameA + '\'' +
                ", NameP='" + NameP + '\'' +
                ", Extencion=" + Extencion +
                '}';
    }

    public areas(String nameA, String nameP, Double extencion) {
        NameA = nameA;
        NameP = nameP;
        Extencion = extencion;
    }

    public areas() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        areas areas = (areas) o;

        if (NameA != null ? !NameA.equals(areas.NameA) : areas.NameA != null) return false;
        if (NameP != null ? !NameP.equals(areas.NameP) : areas.NameP != null) return false;
        return Extencion != null ? Extencion.equals(areas.Extencion) : areas.Extencion == null;
    }

    @Override
    public int hashCode() {
        int result = NameA != null ? NameA.hashCode() : 0;
        result = 31 * result + (NameP != null ? NameP.hashCode() : 0);
        result = 31 * result + (Extencion != null ? Extencion.hashCode() : 0);
        return result;
    }

}
