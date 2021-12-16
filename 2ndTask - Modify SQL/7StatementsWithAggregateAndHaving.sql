#Nombre de los parques en donde residen al menos 10 especies distintas.
SELECT a.NombreP 
from reside_area_esp r inner join areas a on r.NombreA = a.NombreA 
group by a.NombreP 
having count(r.nom_cientifico)>=10;

SELECT a.NombreP 
from reside_area_esp r inner join areas a on r.NombreA = a.NombreA 
group by a.NombreP 
having count(r.nom_cientifico)>=7;

SELECT a.NombreP 
from reside_area_esp r inner join areas a on r.NombreA = a.NombreA 
group by a.NombreP 
having count(r.nom_cientifico)>=6;

SELECT a.NombreP 
from reside_area_esp r inner join areas a on r.NombreA = a.NombreA 
group by a.NombreP 
having count(r.nom_cientifico)>=5;

SELECT a.NombreP 
from reside_area_esp r inner join areas a on r.NombreA = a.NombreA 
group by a.NombreP 
having count(r.nom_cientifico)>=4;

SELECT a.NombreP 
from reside_area_esp r inner join areas a on r.NombreA = a.NombreA 
group by a.NombreP 
having count(r.nom_cientifico)>=3;

SELECT a.NombreP 
from reside_area_esp r inner join areas a on r.NombreA = a.NombreA 
group by a.NombreP 
having count(r.nom_cientifico)>=2;