package com.solvd.lab.dao;

public class Areas {
    private String NameA;
    private String NameP;
    private Double Extencion;

    public String getNameA() {
        return NameA;
    }

    public void setNameA(String nameA) {
        NameA = nameA;
    }

    public String getNameP() {
        return NameP;
    }

    public void setNameP(String nameP) {
        NameP = nameP;
    }

    public Double getExtencion() {
        return Extencion;
    }

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

}
