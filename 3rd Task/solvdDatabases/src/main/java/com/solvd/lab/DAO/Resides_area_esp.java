package com.solvd.lab.dao;

public class Resides_area_esp {
    private String NameA;
    private Integer individualsNumber;
    private String scientific_name;

    public Resides_area_esp() {
    }

    public Resides_area_esp(String NameA, Integer individualsNumber, String scientific_name) {
        this.NameA = NameA;
        this.individualsNumber = individualsNumber;
        this.scientific_name = scientific_name;
    }

    public String getNameA() {
        return NameA;
    }

    public void setNameA(String NameA) {
        this.NameA = NameA;
    }

    public Integer getIndividualsNumber() {
        return individualsNumber;
    }   

    public void setIndividualsNumber(Integer individualsNumber) {
        this.individualsNumber = individualsNumber;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    @Override
    public String toString() {
        return "Resides_area_esp{" + "NameA=" + NameA + ", individualsNumber=" + individualsNumber + ", scientific_name=" + scientific_name + '}';
    }
    
}
