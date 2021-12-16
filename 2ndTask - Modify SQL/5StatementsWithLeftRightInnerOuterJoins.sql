select *
from personal p left join investigador i on p.DNI=i.DNI;

select *
from personal p right join investigador i on p.DNI=i.DNI;

select *
from personal p inner join investigador i on p.DNI=i.DNI;

select *
from personal p union select * from investigador i;
/*-------------------------------------------------------*/
select *
from personal p left join conservacion i on p.DNI=i.DNI;

select *
from personal p right join conservacion i on p.DNI=i.DNI;

select *
from personal p inner join conservacion i on p.DNI=i.DNI;

select *
from personal p union select * from conservacion i;
/*-------------------------------------------------------*/
select *
from personal p left join gestion i on p.DNI=i.DNI;

select *
from personal p right join gestion i on p.DNI=i.DNI;

select *
from personal p inner join gestion i on p.DNI=i.DNI;

select *
from personal p union select * from gestion i;
/*-------------------------------------------------------*/
select *
from parques p left join areas i on p.NombreP=i.NombreP;

select *
from parques p right join areas i on p.NombreP=i.NombreP;

select *
from parques p inner join areas i on p.NombreP=i.NombreP;

select *
from parques p union select * from areas i;
/*-------------------------------------------------------*/