package com.solvd.jaxb.dao;

public class species_area {
    private Integer id;
    private String area;
    private String scientific_name;

    public species_area() {
    }

    public species_area(Integer id, String area, String scientific_name) {
        this.id = id;
        this.area = area;
        this.scientific_name = scientific_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    @Override
    public String toString() {
        return "Species_area{" + "id=" + id + ", area=" + area + ", scientific_name=" + scientific_name + '}';
    }
    
}
