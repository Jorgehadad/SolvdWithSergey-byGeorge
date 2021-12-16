select count(*)
from personal
group by Nombre;

select max(sueldo)
from personal
group by sueldo;

select avg(sueldo)
from personal
group by sueldo;

select min(sueldo)
from personal
group by sueldo;