create database solvd;

/* TEXT DESCRITION
  The Minister of the Environment has decided to create an information system on the natural parks managed by each autonomous community (hereinafter, CA). 
      After carrying out a detailed analysis, the following conclusions have been reached:
  An autonomous community can have several natural parks. In all of CA there is one and only one body responsible for the parks. A park can be shared by more than one CA.
  A natural park is identified by a name, it was declared on a date, it is made up of several areas identified by a name and characterized by a certain extension. For reasons of efficiency, it is desired to favor inquiries regarding the number 
      of existing parks in each AC and the total area declared a natural park in each AC.
  In each area there are necessarily species that can be of three types: plants, animals and minerals. Each species has a scientific name, a common name, 
      and an inventoried number of individuals per area. Of the plant species it is desired to know if they have flowering and in what period it occurs; of the 
      animals you want to know their type of feeding (herbivorous, carnivorous or omnivorous) and their annual heat period; of the minerals you want to know 
      if it is crystals or rocks. In addition, it is interesting to record which species serve as food for other species, taking into account that no mineral species 
      is considered food for any other species and that a plant species does not feed on any other species.

  Park personnel keep their DNI, social security number, address, telephone numbers (home, mobile) and salary. The different types of personnel are distinguished:
  • Management staff: records the data of park visitors and they are posted at a park entrance (entrances are identified by a number).
  • Surveillance personnel: they monitor a certain area of ​​the park that a vehicle travels through (type and license plate).
  • Conservation staff: maintains and conserves a certain area of ​​the park. Each one performs it in a specific specialty (cleaning, roads, etc.).
  • Research staff: they have a qualification that must be collected and they can carry out (even jointly) research projects on a certain species, 
    so that a researcher works on a project analyzing several species, a species can be investigated by a researcher in several projects and in a project a species 
    can be investigated by several researchers.
  
  A research project has a budget and an unrealization period.
A visitor (ID, name, address and profession) must stay within the accommodation available in the park; These have a limited capacity 
    and are of a certain category.
The accommodations organize excursions to the park, in a vehicle or on foot, on certain days of the week and at a certain time. 
    Any visitor to the park can attend these excursions.
*/



/*GLOSSARY*/
/*
  NombreP: Is the name of the park
  NroAlojamiento: Is the number of the accommodation

*/


/*the action between a Visitant of the Park and 
with the place where they sleep*/
CREATE TABLE `aloja` (
  `NroAlojamiento` int NOT NULL,
  `dniVisitante` int NOT NULL,
  `F_Llegada` date DEFAULT NULL,
  `F_Salida` date DEFAULT NULL,
  `habitacion` varchar(66) DEFAULT NULL,
  PRIMARY KEY (`NroAlojamiento`,`dniVisitante`),
  KEY `dniVisitante` (`dniVisitante`),
  CONSTRAINT `aloja_ibfk_1` FOREIGN KEY (`NroAlojamiento`) REFERENCES `alojamiento` (`NroAlojamiento`),
  CONSTRAINT `aloja_ibfk_2` FOREIGN KEY (`dniVisitante`) REFERENCES `visitantes` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/* The place where the visitors  */
CREATE TABLE `alojamiento` (
  `NroAlojamiento` int NOT NULL,
  `Capacidad` int DEFAULT NULL,
  `Categoria` varchar(20) DEFAULT NULL,
  `NombreP` varchar(30) NOT NULL,
  PRIMARY KEY (`NroAlojamiento`,`NombreP`),
  KEY `alojamiento_ibfk_1` (`NombreP`),
  CONSTRAINT `alojamiento_ibfk_1` FOREIGN KEY (`NombreP`) REFERENCES `parques` (`NombreP`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/* animals of the park */
CREATE TABLE `animales` (
  `nom_cientifico` varchar(15) NOT NULL,
  `alimentacion` varchar(10) DEFAULT NULL,
  `f_inicio` date DEFAULT NULL,
  `f_fin` date DEFAULT NULL,
  PRIMARY KEY (`nom_cientifico`),
  KEY `indice_Animal` (`nom_cientifico`),
  CONSTRAINT `animales_ibfk_1` FOREIGN KEY (`nom_cientifico`) REFERENCES `especies` (`nom_cientifico`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `areas` (
  `NombreA` varchar(50) NOT NULL,
  `NombreP` varchar(50) NOT NULL,
  `Extension` double DEFAULT NULL,
  PRIMARY KEY (`NombreA`,`NombreP`),
  KEY `NombreP` (`NombreP`),
  CONSTRAINT `areas_ibfk_1` FOREIGN KEY (`NombreP`) REFERENCES `parques` (`NombreP`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `come_se_alimenta_aa` (
  `nom_cientifico_come` varchar(15) NOT NULL,
  `nom_cientifico_escomido` varchar(15) NOT NULL,
  PRIMARY KEY (`nom_cientifico_come`,`nom_cientifico_escomido`),
  KEY `se_alimenta_aa_ibfk_2` (`nom_cientifico_escomido`),
  CONSTRAINT `se_alimenta_aa_ibfk_1` FOREIGN KEY (`nom_cientifico_come`) REFERENCES `animales` (`nom_cientifico`) ON UPDATE CASCADE,
  CONSTRAINT `se_alimenta_aa_ibfk_2` FOREIGN KEY (`nom_cientifico_escomido`) REFERENCES `animales` (`nom_cientifico`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

CREATE TABLE `comunidad` (
  `Nombre_CA` varchar(50) NOT NULL,
  `org_respon` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Nombre_CA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `conservacion` (
  `DNI` int NOT NULL,
  `Especialidad` varchar(30) DEFAULT NULL,
  `NombreA` varchar(50) NOT NULL,
  `NombreP` varchar(50) NOT NULL,
  PRIMARY KEY (`DNI`),
  KEY `conservacion_ibfk_2` (`NombreA`),
  KEY `conservacion_ibfk_3` (`NombreP`),
  CONSTRAINT `conservacion_ibfk_2` FOREIGN KEY (`NombreA`) REFERENCES `areas` (`NombreA`) ON UPDATE CASCADE,
  CONSTRAINT `de_conservacion_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `personal` (`DNI`) ON UPDATE CASCADE,
  CONSTRAINT `de_conservacion_ibfk_3` FOREIGN KEY (`NombreP`) REFERENCES `parques` (`NombreP`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `disfruta` (
  `DNI` int NOT NULL,
  `Cod_Excursion` int NOT NULL,
  PRIMARY KEY (`Cod_Excursion`,`DNI`),
  KEY `participa_ibfk_1` (`Cod_Excursion`),
  KEY `participa_ibfk_2` (`DNI`),
  CONSTRAINT `participa_ibfk_1` FOREIGN KEY (`Cod_Excursion`) REFERENCES `excursiones` (`Cod_Excursion`) ON UPDATE CASCADE,
  CONSTRAINT `participa_ibfk_2` FOREIGN KEY (`DNI`) REFERENCES `visitantes` (`DNI`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `entrada` (
  `NroEntrada` int NOT NULL,
  `NombreP` varchar(30) NOT NULL,
  `DNI` int NOT NULL,
  `precio` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`NroEntrada`),
  KEY `NomParqueEn` (`NombreP`),
  KEY `indice_4` (`NroEntrada`),
  KEY `entrada_ibfk_1` (`DNI`),
  CONSTRAINT `entrada_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `personal` (`DNI`) ON UPDATE CASCADE,
  CONSTRAINT `NomParqueEn` FOREIGN KEY (`NombreP`) REFERENCES `parques` (`NombreP`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `especie_area` (
  `id` int NOT NULL AUTO_INCREMENT,
  `area` varchar(50) DEFAULT NULL,
  `nom_cientifico` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `especie_area_ibfk_1` (`nom_cientifico`),
  KEY `especie_area_ibfk_2` (`area`),
  CONSTRAINT `especie_area_ibfk_1` FOREIGN KEY (`nom_cientifico`) REFERENCES `especies` (`nom_cientifico`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `especie_area_ibfk_2` FOREIGN KEY (`area`) REFERENCES `areas` (`NombreA`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `especies` (
  `nom_cientifico` varchar(15) NOT NULL,
  `nom_vulgar` varchar(15) DEFAULT NULL,
  `nro_inventario` int DEFAULT NULL,
  PRIMARY KEY (`nom_cientifico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `excursiones` (
  `Cod_Excursion` int NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `Vehiculo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Cod_Excursion`),
  KEY `idx_cod_excursion` (`Cod_Excursion`)
) ENGINE=InnoDB AUTO_INCREMENT=124201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `exempleados` (
  `DNI` int NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `sueldo` double DEFAULT NULL,
  `NumSegSoc` int DEFAULT NULL,
  `dirección` varchar(30) DEFAULT NULL,
  `telefono_fijo` int DEFAULT NULL,
  `telefono_móvil` int DEFAULT NULL,
  `NombreP` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  KEY `personal_ibfk_1` (`NombreP`),
  KEY `indice_personal` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `gestion` (
  `DNI` int NOT NULL,
  `NroEntrada` int DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  CONSTRAINT `gestion_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `personal` (`DNI`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `investigador` (
  `DNI` int NOT NULL,
  `titulacion` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  CONSTRAINT `investigador_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `personal` (`DNI`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `minerales` (
  `nom_cientifico` varchar(15) NOT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`nom_cientifico`),
  CONSTRAINT `minerales_ibfk_1` FOREIGN KEY (`nom_cientifico`) REFERENCES `especies` (`nom_cientifico`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `organiza` (
  `NroAlojamiento` int NOT NULL,
  `NombreP` varchar(30) NOT NULL,
  `Cod_Excursion` int NOT NULL,
  PRIMARY KEY (`NroAlojamiento`,`NombreP`,`Cod_Excursion`),
  KEY `organiza_ibfk_2` (`NombreP`),
  KEY `organiza_ibfk_3` (`Cod_Excursion`),
  CONSTRAINT `organiza_ibfk_1` FOREIGN KEY (`NroAlojamiento`) REFERENCES `alojamiento` (`NroAlojamiento`) ON UPDATE CASCADE,
  CONSTRAINT `organiza_ibfk_2` FOREIGN KEY (`NombreP`) REFERENCES `alojamiento` (`NombreP`) ON UPDATE CASCADE,
  CONSTRAINT `organiza_ibfk_3` FOREIGN KEY (`Cod_Excursion`) REFERENCES `excursiones` (`Cod_Excursion`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;




CREATE TABLE `parques` (
  `NombreP` varchar(50) NOT NULL,
  `Fecha_declaracion` date DEFAULT NULL,
  PRIMARY KEY (`NombreP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;




CREATE TABLE `personal` (
  `DNI` int NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `sueldo` double DEFAULT NULL,
  `NumSegSoc` int DEFAULT NULL,
  `dirección` varchar(30) DEFAULT NULL,
  `telefono_fijo` int DEFAULT NULL,
  `telefono_móvil` int DEFAULT NULL,
  `NombreP` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  KEY `personal_ibfk_1` (`NombreP`),
  KEY `indice_personal` (`DNI`),
  CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`NombreP`) REFERENCES `parques` (`NombreP`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `proyecto` (
  `nombreProyecto` varchar(30) NOT NULL,
  `presupuesto` double DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  PRIMARY KEY (`nombreProyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
CREATE TABLE `realiza_proy_inv_esp` (
  `NombreProyecto` varchar(30) NOT NULL,
  `DNI` int NOT NULL,
  `nom_cientifico` varchar(50) NOT NULL,
  PRIMARY KEY (`DNI`,`NombreProyecto`,`nom_cientifico`),
  KEY `participa_proy_inv_ibfk_2` (`NombreProyecto`),
  KEY `realiza_ibfk_3` (`nom_cientifico`),
  CONSTRAINT `realiza_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `personal` (`DNI`) ON UPDATE CASCADE,
  CONSTRAINT `realiza_ibfk_2` FOREIGN KEY (`NombreProyecto`) REFERENCES `proyecto` (`nombreProyecto`) ON UPDATE CASCADE,
  CONSTRAINT `realiza_ibfk_3` FOREIGN KEY (`nom_cientifico`) REFERENCES `especies` (`nom_cientifico`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `registra` (
  `NroEntrada` int NOT NULL,
  `NombreP` varchar(50) NOT NULL,
  `DNI` int NOT NULL,
  `fecha_registro` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`NroEntrada`,`NombreP`,`DNI`),
  KEY `registra_ibfk_2` (`DNI`),
  KEY `NroEntradaReg` (`NroEntrada`),
  KEY `NombreParReg` (`NombreP`),
  CONSTRAINT `NombreParReg` FOREIGN KEY (`NombreP`) REFERENCES `entrada` (`NombreP`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `NroEntradaReg` FOREIGN KEY (`NroEntrada`) REFERENCES `entrada` (`NroEntrada`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `registra_ibfk_2` FOREIGN KEY (`DNI`) REFERENCES `visitantes` (`DNI`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `reside_area_esp` (
  `NombreA` varchar(50) NOT NULL,
  `cantIndividuos` int DEFAULT NULL,
  `nom_cientifico` varchar(55) NOT NULL,
  PRIMARY KEY (`NombreA`,`nom_cientifico`),
  KEY `nom_cientifico` (`nom_cientifico`),
  CONSTRAINT `reside_area_esp_ibfk_1` FOREIGN KEY (`nom_cientifico`) REFERENCES `especies` (`nom_cientifico`),
  CONSTRAINT `reside_area_esp_ibfk_2` FOREIGN KEY (`NombreA`) REFERENCES `areas` (`NombreA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

CREATE TABLE `resultado_audit_maxentdia` (
  `NombreP` varchar(50) NOT NULL,
  `fecha_registro` varchar(15) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`NombreP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `se_alimenta_av` (
  `nom_cientifico_come` varchar(15) NOT NULL,
  `nom_cientifico_escomido` varchar(15) NOT NULL,
  PRIMARY KEY (`nom_cientifico_come`,`nom_cientifico_escomido`),
  KEY `se_alimenta_av_ibfk_2` (`nom_cientifico_escomido`),
  CONSTRAINT `se_alimenta_av_ibfk_1` FOREIGN KEY (`nom_cientifico_come`) REFERENCES `animales` (`nom_cientifico`) ON UPDATE CASCADE,
  CONSTRAINT `se_alimenta_av_ibfk_2` FOREIGN KEY (`nom_cientifico_escomido`) REFERENCES `vegetales` (`nom_cientifico`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `tiene_comunidad_parques` (
  `Nombre_CA` varchar(50) NOT NULL,
  `NombreP` varchar(50) NOT NULL,
  PRIMARY KEY (`Nombre_CA`,`NombreP`),
  KEY `comunidad_parques_ibfk_2` (`NombreP`),
  CONSTRAINT `comunidad_parques_ibfk_1` FOREIGN KEY (`Nombre_CA`) REFERENCES `comunidad` (`Nombre_CA`) ON UPDATE CASCADE,
  CONSTRAINT `comunidad_parques_ibfk_2` FOREIGN KEY (`NombreP`) REFERENCES `parques` (`NombreP`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `vegetales` (
  `nom_cientifico` varchar(15) NOT NULL,
  `Floracion` tinyint(1) DEFAULT NULL,
  `f_inicio` date DEFAULT NULL,
  `f_fin` date DEFAULT NULL,
  PRIMARY KEY (`nom_cientifico`),
  CONSTRAINT `vegetales_ibfk_1` FOREIGN KEY (`nom_cientifico`) REFERENCES `especies` (`nom_cientifico`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;





CREATE TABLE `venta` (
  `DNI` int NOT NULL,
  `NombreP` varchar(50) NOT NULL,
  `NombreA` varchar(50) NOT NULL,
  `NroEntrada` int NOT NULL,
  `fecha_pago` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`DNI`,`NroEntrada`,`NombreP`),
  KEY `NroEntrada` (`NroEntrada`),
  KEY `NombreP` (`NombreP`),
  KEY `NombreA` (`NombreA`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `visitantes` (`DNI`),
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`NroEntrada`) REFERENCES `entrada` (`NroEntrada`),
  CONSTRAINT `venta_ibfk_3` FOREIGN KEY (`NombreP`) REFERENCES `parques` (`NombreP`),
  CONSTRAINT `venta_ibfk_4` FOREIGN KEY (`NombreA`) REFERENCES `areas` (`NombreA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `vigilancia` (
  `DNI` int NOT NULL,
  `NombreA` varchar(50) NOT NULL,
  `NombreP` varchar(50) NOT NULL,
  `matricula` varchar(55) DEFAULT NULL,
  `tipo` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  KEY `de_vigilancia_ibfk_2` (`NombreA`),
  KEY `de_vigilancia_ibfk_3` (`NombreP`),
  CONSTRAINT `de_vigilancia_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `personal` (`DNI`) ON UPDATE CASCADE,
  CONSTRAINT `de_vigilancia_ibfk_2` FOREIGN KEY (`NombreA`) REFERENCES `areas` (`NombreA`) ON UPDATE CASCADE,
  CONSTRAINT `de_vigilancia_ibfk_3` FOREIGN KEY (`NombreP`) REFERENCES `areas` (`NombreP`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


CREATE TABLE `visitantejson` (
  `doc` json DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;




CREATE TABLE `visitantes` (
  `DNI` int NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `Domicilio` varchar(30) DEFAULT NULL,
  `Profesion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  KEY `indice_visitantes` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



CREATE TABLE `visitantesjson` (
  `doc` json DEFAULT NULL,
  `_id` int GENERATED ALWAYS AS (json_unquote(json_extract(`doc`,_utf8mb4'$.dni'))) STORED NOT NULL,
  `_json_schema` json GENERATED ALWAYS AS (_utf8mb4'{"type":"object"}') VIRTUAL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;