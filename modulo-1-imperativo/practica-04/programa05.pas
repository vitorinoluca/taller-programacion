{
5. Una veterinaria desea procesar la información de las consultas realizadas durante el año.
De cada consulta se conoce: número de consulta, número de historia clínica de la mascota,
fecha, tipo de consulta y costo de la consulta. La lectura de las consultas finaliza cuando se
ingresa el número de consulta -1. Implementar un programa que invoque a los siguientes módulos y compruebe el correcto
funcionamiento del mismo.

a. Un módulo que retorne la información de las historias clínicas en un árbol binario de
búsqueda ordenado por número de historia clínica. Para cada historia clínica se debe
almacenar una lista con las consultas realizadas a la mascota correspondiente.

b. Un módulo que imprima recursivamente todas las historias clínicas en orden creciente
de número.

c. Un módulo que reciba el árbol y retorne el número de historia clínica con mayor
cantidad de consultas.

d. Un módulo que reciba el árbol y un número de historia clínica. Debe retornar la
cantidad total de consultas realizadas a dicha mascota.

e. Un módulo que reciba el árbol y un valor de costo. Debe retornar la cantidad de
consultas cuyo costo supera el valor recibido.

f. Un módulo que reciba el árbol y dos números de historia clínica. Debe retornar el costo
total de las consultas correspondientes a las historias clínicas comprendidas entre
ambos números, inclusive.

g. Un módulo que reciba el árbol y genere una nueva estructura ordenada por número de
historia clínica, donde cada historia aparezca una única vez junto con el costo total
acumulado de sus consultas.

}
program programa05;
type
	consulta = record
		num_consulta: integer;
		tipo_consulta: integer;
		fecha: integer;
		costo: integer;
	end;
	
	lista = ^nodolista;
	nodolista = record
		dato: consulta;
		sig: lista;
	end;
	
	historia_clinica = record
		numero: integer;
		consultas: lista;
	end;
	
	arbol = ^nodoarbol;
	nodoarbol = record
		dato: historia_clinica;
		HI: arbol;
		HD: arbol;
	end;
	
	historia_lista = record
		num: integer;
		monto: integer;
	end;
	
	lista2 = ^nodo2;
	nodo2 = record
		dato: historia_lista;
		sig: lista2;
	end;

function leerConsulta (var c: consulta): integer;
begin
	c.num_consulta:= random(20) - 1;	
	if (c.num_consulta <> -1) then begin
		c.tipo_consulta:= random(11);
		c.fecha:= random(31);
		c.costo:= random(10000);
	end;
	leerConsulta:= random(21);
end;

procedure agregarLista(var l: lista; c: consulta);
var
	aux: lista;
begin
	new(aux);
	aux^.dato:= c;
	
	if (l = nil) then
		aux^.sig:= nil
	else
		aux^.sig:= l;
	l:= aux;
end;

procedure agregar(var a: arbol; n: integer; c: consulta);
var
	aux: arbol;
begin
	if (a = nil) then begin
		new(aux);
		aux^.dato.numero:= n;
		aux^.dato.consultas:= nil;
		agregarLista(aux^.dato.consultas, c);
		aux^.HI:= nil;
		aux^.HD:= nil;
		a:= aux;
	end
	else if (a^.dato.numero = n) then
		agregarLista(a^.dato.consultas, c)
	else if (n < a^.dato.numero) then
		agregar(a^.HI, n, c)
	else
		agregar(a^.HD, n, c);
end;

procedure cargarArbol(var a: arbol);
var
	c: consulta;
	num_hist_clinica: integer;
begin
	num_hist_clinica:= leerConsulta(c);
	while (c.num_consulta <> -1) do begin
		agregar(a, num_hist_clinica, c);
		num_hist_clinica:= leerConsulta(c);
	end;
end;

procedure imprimirLista(l: lista);
begin
	if (l <> nil) then begin
		writeln('Numero de consulta ', l^.dato.num_consulta,' | Tipo de consulta ', l^.dato.tipo_consulta, ' | Costo de consulta ', l^.dato.costo);
		imprimirLista(l^.sig);
	end;
end;

procedure imprimirHistoriasClinicas(a: arbol);
begin
	if (a <> nil) then begin
		imprimirHistoriasClinicas(a^.HI);
		writeln('Mascota ', a^.dato.numero);
		imprimirLista(a^.dato.consultas);
		imprimirHistoriasClinicas(a^.HD);
	end;
end;

function contarConsultasPorLista(l: lista): integer;
begin
	if (l <> nil) then
		contarConsultasPorLista:= 1 + contarConsultasPorLista(l^.sig)
	else
		contarConsultasPorLista:= 0;
end;

procedure retornarHistoriaMayorCantConsultas(a: arbol; var num_max, cant: integer);
var
	consultas: integer;
begin
	if (a <> nil) then begin
		consultas:= contarConsultasPorLista(a^.dato.consultas);
		if (consultas > cant) then begin
			cant:= consultas;
			num_max:= a^.dato.numero;
		end;
		retornarHistoriaMayorCantConsultas(a^.HI, num_max, cant);
		retornarHistoriaMayorCantConsultas(a^.HD, num_max, cant);
	end;
end;

procedure imprimirHistoria(a: arbol; n: integer);
begin
	if (a <> nil) then begin
		if (n < a^.dato.numero) then
			imprimirHistoria(a^.HI, n)
		else if (n > a^.dato.numero) then
			imprimirHistoria(a^.HD, n)
		else if (n = a^.dato.numero) then
			writeln(contarConsultasPorLista(a^.dato.consultas), ' consultas')
		end
	else
		writeln('no se encontraron consultas');
end;

function retornarCostosMasGrandesQue(l: lista; n: integer): integer;
begin
	if (l <> nil) then
		if (l^.dato.costo > n) then
			retornarCostosMasGrandesQue:= 1 + retornarCostosMasGrandesQue(l^.sig, n)
		else
			retornarCostosMasGrandesQue:= retornarCostosMasGrandesQue(l^.sig, n)
	else
		retornarCostosMasGrandesQue:= 0;
end;

function contarCostosMasGrandesQue(a: arbol; n: integer): integer;
begin
	if (a <> nil) then
		contarCostosMasGrandesQue:= retornarCostosMasGrandesQue(a^.dato.consultas, n) + contarCostosMasGrandesQue(a^.HI, n) + contarCostosMasGrandesQue(a^.HD, n)
	else
		contarCostosMasGrandesQue:= 0;
end;

function retornarCostosLista (l: lista): integer;
begin
	if (l = nil) then
		retornarCostosLista:= 0
	else
		retornarCostosLista:= l^.dato.costo + retornarCostosLista(l^.sig);
end;

function retornarCostosEntre(a: arbol; num1, num2: integer): integer;
begin
	if (a = nil) then
		retornarCostosEntre:= 0
	else if (a^.dato.numero < num1) then
		retornarCostosEntre:= retornarCostosEntre(a^.HD, num1, num2)
	else if (a^.dato.numero > num2) then
		retornarCostosEntre:= retornarCostosEntre(a^.HI, num1, num2)
	else
		retornarCostosEntre:= retornarCostosLista(a^.dato.consultas)
		                     + retornarCostosEntre(a^.HI, num1, num2)
		                     + retornarCostosEntre(a^.HD, num1, num2);
end;

procedure generarListaOrdenada(a: arbol; var l, ult: lista2);
var
	aux: lista2;
begin
	if (a <> nil) then begin
		generarListaOrdenada(a^.HI, l, ult);
		
		new(aux);
		aux^.dato.num:= a^.dato.numero;
		aux^.dato.monto:= retornarCostosLista(a^.dato.consultas);
		aux^.sig:= nil;
		if (l = nil) then begin
			l:= aux;
			ult:= l;
		end
		else begin
			ult^.sig:= aux;
			ult:= aux;
		end;
		generarListaOrdenada(a^.HD, l, ult);
	end;
end;

procedure imprimirLista2(l: lista2);
begin
	if (l <> nil) then begin
		writeln('Historia ', l^.dato.num, ' | Costo total ', l^.dato.monto);
		imprimirLista2(l^.sig);
	end;
end;

var
	a: arbol;
	num_max, cant: integer;
	num: integer;
	costo: integer;
	num1, num2: integer;
	l, ult: lista2;
begin
	Randomize;
	a:= nil;
	cargarArbol(a);
	imprimirHistoriasClinicas(a);
	cant:= -1;
	num_max:= -1;
	retornarHistoriaMayorCantConsultas(a, num_max, cant);
	writeln(num_max, ' es la historia clinica con mayor cantidad de consultas.');
	
	writeln('consulte una historia clinica');
	readln(num);
	imprimirHistoria(a, num);
	
	writeln('ingrese un costo para buscar la cantidad de consultas mas grandes que');
	readln(costo);
	writeln('la cantidad es ', contarCostosMasGrandesQue(a, costo));
	
	writeln('ingrese un numero minimo');
	readln(num1);
	writeln('ingrese un numero maximo');
	readln(num2);
	
	writeln(retornarCostosEntre(a, num1, num2));
	
	l:= nil;
	ult:= nil;
	generarListaOrdenada(a, l, ult);
	imprimirLista2(l);
end.
