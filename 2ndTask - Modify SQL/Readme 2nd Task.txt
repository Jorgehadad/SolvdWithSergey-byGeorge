Homework

1) Theory

W3schools links:
https://www.w3schools.com/sql/sql_insert.asp
https://www.w3schools.com/sql/sql_select.asp
https://www.w3schools.com/sql/sql_update.asp
https://www.w3schools.com/sql/sql_delete.asp
https://www.w3schools.com/sql/sql_join.asp
https://www.w3schools.com/sql/sql_union.asp
https://www.w3schools.com/sql/sql_groupby.asp
https://www.w3schools.com/sql/sql_having.asp


Normalization of DB (3 normal forms), alternative article:
https://www.geeksforgeeks.org/normal-forms-in-dbms/













 
2) Practical tasks

1.	Make text description of your DB entities and relationships
/* TEXT DESCRITION
  The Minister of the Environment has decided to create an information system on the natural parks managed by each autonomous community (hereinafter, CA). 
      After carrying out a detailed analysis, the following conclusions have been reached:
  An autonomous community can have several natural parks. In all of CA there is one and only one body responsible for the parks. A park can be shared by more than one CA.
  A natural park is identified by a name, it was declared on a date, it is made up of several areas identified by a name and characterized by a certain extension. For reasons of efficiency, it is desired to favor inquiries regarding the number of existing parks in each AC and the total area declared a natural park in each AC.
  In each area there are necessarily species that can be of three types: plants, animals and minerals. Each species has a scientific name, a common name, and an inventoried number of individuals per area. Of the plant species it is desired to know if they have flowering and in what period it occurs; of the animals you want to know their type of feeding (herbivorous, carnivorous or omnivorous) and their annual heat period; of the minerals you want to know if it is crystals or rocks. In addition, it is interesting to record which species serve as food for other species, considering that no mineral species 
      is considered food for any other species and that a plant species does not feed on any other species.

  Park personnel keep their DNI, social security number, address, telephone numbers (home, mobile) and salary. The different types of personnel are distinguished:
  • Management staff: records the data of park visitors and they are posted at a park entrance (entrances are identified by a number).
  • Surveillance personnel: they monitor a certain area of the park that a vehicle travels through (type and license plate).
  • Conservation staff: maintains and conserves a certain area of the park. Each one performs it in a specific specialty (cleaning, roads, etc.).
  • Research staff: they have a qualification that must be collected, and they can carry out (even jointly) research projects on a certain species, 
    so that a researcher works on a project analyzing several species, a species can be investigated by a researcher in several projects and in a project a species 
    can be investigated by several researchers.
  
  A research project has a budget and an unrealization period.
A visitor (ID, name, address and profession) must stay within the accommodation available in the park; These have a limited capacity and are of a certain category.
The accommodations organize excursions to the park, in a vehicle or on foot, on certain days of the week and at a certain time. 
    Any visitor to the park can attend these excursions.
*/

2.	In separate .sql file implement next points:
 1)	10 statements for insertion.
 2)	10 statements for updating.
 3)	10 statements for deletions.
 4)	5 alter table.
 5)	1 big statement to join all tables in the database.
 6)	5 statements with left, right, inner, outer joins.
 7)	7 statements with aggregate functions and group by and without having.
 8)	7 statements with aggregate functions and group by and with having.
