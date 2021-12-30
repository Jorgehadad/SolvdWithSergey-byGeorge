package com.solvd.jaxb.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.jaxb.dao.parks;



public class jsonParserJackson {
    //Json Parser With Jackson
    //https://www.baeldung.com/jackson-json-parser
    //https://www.baeldung.com/jackson-json-parser-tutorial
    //https://www.baeldung.com/jackson-json-parser-tutorial-java


    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        parks park = new parks();

        parks newpark = mapper.readValue(new File("src/main/java/jaxb/json/parks.json"), parks.class);

        System.out.println(newpark.getNameP());
        System.out.println(newpark.getDate_Declaracion());
        System.out.println(park);
        System.out.println(newpark);

        //mapper.writeValue(new File("src/main/java/jaxb/json/parks.json"), park);

    }



    
}
