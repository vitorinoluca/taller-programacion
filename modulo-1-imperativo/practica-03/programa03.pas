{
3. Implementar un programa que contenga:

a. Un módulo que lea información de los préstamos de libros realizados por los socios de una
biblioteca y los almacene en una estructura de datos. De cada préstamo se lee: número de
socio (1 a 60), código de libro (200 a 230), fecha de préstamo y cantidad de días del préstamo.
La lectura de los préstamos finaliza con número de socio 0. La estructura generada debe ser
eficiente para la búsqueda por número de socio y, para cada socio, deben almacenarse en una
lista los préstamos de libros que realizó. Nota: No repetir información.

b. Un módulo que reciba la estructura generada en el inciso a) y retorne la cantidad de socios
cuyo número de socio es múltiplo de 5.

c. Un módulo que reciba la estructura generada en el inciso a) e informe, para cada socio, su
número de socio y la cantidad de préstamos de libros cuya duración fue menor o igual a 7 días.

d. Un módulo que reciba la estructura generada en el inciso a) y un valor real que representa
una cantidad promedio de días. El módulo debe retornar los números de socio y el promedio
de días de préstamo de aquellos socios cuyo promedio supere el valor ingresado
}

program programa03;
type
	prestamo = record
		num_socio: 0..60;
		cod_libro: 200..230;
		fecha: integer;
		cant_dias: integer;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		dato: prestamo;
		sig: lista;
	end;
	
	datoSocio = record
		num_socio: 1..60;
		lista: lista;
	end;
	
	arbol = ^nodoArbol;
	nodoArbol = record
		dato: datoSocio;
		HI: arbol;
		HD: arbol;
	end;
	
	
procedure leerPrestamo (var p: prestamo);
begin
	p.num_socio:= random(61);
	p.cod_libro:= random(31) + 200;
	p.fecha:= random(100);
	p.cant_dias:= random(100);
end;

procedure agregarLista (var l: lista; p: prestamo);
var
	nue: lista;
begin
	new(nue);
	nue^.dato:= p;
	if (l = nil) then begin
		nue^.sig:= nil;
		l:= nue;
	end
	else begin
		nue^.sig:= l;
		l:= nue;
	end;
end;

procedure agregarArbol(var a: arbol; p: prestamo);
begin
    if (a = nil) then begin
        new(a);
        a^.dato.num_socio:= p.num_socio;
        a^.dato.lista:= nil;
        agregarLista(a^.dato.lista, p);
        a^.HI:= nil;
        a^.HD:= nil;
    end
    else if (a^.dato.num_socio = p.num_socio) then
        agregarLista(a^.dato.lista, p)
    else if (p.num_socio < a^.dato.num_socio) then
        agregarArbol(a^.HI, p)
    else
        agregarArbol(a^.HD, p);
end;

procedure leerPrestamos (var a: arbol);
var
	p: prestamo;
begin
	leerPrestamo(p);
	if (p.num_socio <> 0) then begin
		agregarArbol(a, p);
		leerPrestamos(a);
	end;
end;

function contarPrestamosMenorIgual7(l: lista): integer;
begin
    if (l = nil) then
        contarPrestamosMenorIgual7:= 0
    else if (l^.dato.cant_dias <= 7) then
        contarPrestamosMenorIgual7:= 1 + contarPrestamosMenorIgual7(l^.sig)
    else
        contarPrestamosMenorIgual7:= contarPrestamosMenorIgual7(l^.sig);
end;

procedure imprimirCantPrestamos7dias(a: arbol);
begin
    if (a <> nil) then begin
        imprimirCantPrestamos7dias(a^.HI);
        writeln('Socio ', a^.dato.num_socio, ': ', contarPrestamosMenorIgual7(a^.dato.lista));
        imprimirCantPrestamos7dias(a^.HD);
    end;
end;

function retornarCantSociosMultiplo5 (a: arbol): integer;
var
	aux: integer;
begin
	if (a = nil) then
		retornarCantSociosMultiplo5:= 0
	else begin
		aux:= a^.dato.num_socio mod 5;
		if (aux = 0) then begin
			retornarCantSociosMultiplo5:= 1 + retornarCantSociosMultiplo5(a^.HI) + retornarCantSociosMultiplo5(a^.HD);
		end
		else
			retornarCantSociosMultiplo5:= retornarCantSociosMultiplo5(a^.HI) + retornarCantSociosMultiplo5(a^.HD);
	end;
end;

function retornarPromedioPrestamos(l: lista): real;
var
	i: integer;
	sum: integer;
begin
	i:= 0;
	sum:= 0;
	while (l <> nil) do begin
		i:= i + 1;
		sum:= sum + l^.dato.cant_dias;
		l:= l^.sig;
	end;
	retornarPromedioPrestamos:= sum / i;
end;

procedure imprimirPromedioSociosPrestamo(a: arbol; prom: real);
var
	prom_socio: real;
begin
	if (a <> nil) then begin
		imprimirPromedioSociosPrestamo(a^.HI, prom);
		prom_socio:= retornarPromedioPrestamos(a^.dato.lista);
		if (prom_socio > prom) then
			writeln('el socio ', a^.dato.num_socio, ' tiene un promedio de entrega de ', prom_socio, ' dias');
		imprimirPromedioSociosPrestamo(a^.HD, prom);
	end;
end;

var
	a: arbol;
	prom: real;
begin
	Randomize;
	a:= nil;
	leerPrestamos(a);
	writeln('la cantidad de socios cuyo numero de socio es multiplo de 5 es ', retornarCantSociosMultiplo5(a));
	imprimirCantPrestamos7dias(a);
	writeln('ingrese un promedio de dias');
	readln(prom);
	imprimirPromedioSociosPrestamo(a, prom);
end.
