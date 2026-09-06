{
Un centro cultural desea procesar la información de las inscripciones a los talleres que
ofrece. De cada inscripción se conoce: número de inscripción, código de taller, número de
documento del participante y cantidad de clases a las que asistió.
La lectura de las inscripciones finaliza cuando se ingresa el número de inscripción -1.
Implementar un programa que invoque a los siguientes módulos y compruebe el correcto
funcionamiento del mismo.

a. Un módulo que retorne la información de los talleres en una estructura de datos
eficiente para la búsqueda por código de taller. De cada taller deben almacenarse:
código de taller, cantidad total de participantes inscriptos y cantidad total de
asistencias registradas.

b. Un módulo que imprima el contenido de la estructura ordenado por código de taller.

c. Un módulo que retorne el código del taller con mayor cantidad de participantes
inscriptos.

d. Un módulo que retorne la cantidad de talleres cuyos códigos sean menores que un
valor recibido como parámetro.

e. Un módulo que retorne la cantidad total de asistencias correspondientes a los talleres
cuyos códigos se encuentren comprendidos entre dos valores recibidos como
parámetros, sin incluir dichos valores.
}

program programa03;
type
	inscripcion = record
		numero: integer;
		dni: integer;
		clases_asist: integer;
	end;
	
	taller = record
		cod_taller: integer;
		participantes: integer;
		asistencias_totales: integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: taller;
		HI: arbol;
		HD: arbol;
	end;

function leerInscripcion (var i: inscripcion): integer;
var
	cod: integer;
begin
	cod:= random(22) - 1;
	if (cod <> -1) then begin
		i.numero:= random(100);
		i.dni:= random(1000);
		i.clases_asist:= random(21);
	end;
	leerInscripcion:= cod;
end;

procedure agregarArbol(var a: arbol; i: inscripcion; cod: integer);
var
	aux: arbol;
	t: taller;
begin
	if (a = nil) then begin
		new(aux);
		t.cod_taller:= cod;
		t.participantes:= 1;
		t.asistencias_totales:= i.clases_asist;
		aux^.dato:= t;
		aux^.HI:= nil;
		aux^.HD:= nil;
		a:= aux;
	end
	else if (a^.dato.cod_taller = cod) then begin
		a^.dato.participantes:= a^.dato.participantes + 1;
		a^.dato.asistencias_totales:= a^.dato.asistencias_totales + i.clases_asist;
	end
	else if (cod > a^.dato.cod_taller) then
		agregarArbol(a^.HD, i, cod)
	else
		agregarArbol(a^.HI, i, cod);
end;

procedure cargarArbol(var a: arbol);
var
	i: inscripcion;
	cod: integer;
begin
	cod:= leerInscripcion(i);
	while (cod <> -1) do begin
		agregarArbol(a, i, cod);
		cod:= leerInscripcion(i);
	end;
end;

procedure imprimirArbol(a: arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln('Codigo de taller: ', a^.dato.cod_taller, ' | Inscripciones: ', a^.dato.participantes, ' | Clases asistidas totales: ', a^.dato.asistencias_totales);
		imprimirArbol(a^.HD);
	end;
end;

procedure buscarMasInscripciones(a: arbol; var cod_taller_max, max: integer);
begin
	if (a <> nil) then begin
		if (a^.dato.participantes > max) then begin
			cod_taller_max:= a^.dato.cod_taller;
			max:= a^.dato.participantes;
		end;
		buscarMasInscripciones(a^.HI, cod_taller_max, max);
		buscarMasInscripciones(a^.HD, cod_taller_max, max);
	end;
end;

procedure imprimirMasInscripciones(a: arbol);
var
	cod_taller_max: integer;
	max: integer;
begin
	cod_taller_max:= -1;
	max:= -1;
	buscarMasInscripciones(a, cod_taller_max, max);
	writeln('el codigo de taller con mas inscripciones es el: ', cod_taller_max);
end;

function retornarTalleresMenoresQue(a: arbol; cod: integer): integer;
begin
	if (a = nil) then
		retornarTalleresMenoresQue:= 0
	else if (a^.dato.cod_taller < cod) then
		retornarTalleresMenoresQue:= 1 + retornarTalleresMenoresQue(a^.HI, cod) + retornarTalleresMenoresQue(a^.HD, cod)
	else
		retornarTalleresMenoresQue:= retornarTalleresMenoresQue(a^.HI, cod)
end;

function retornarTotalAsistenciasEntre(a: arbol; min, max: integer): integer;
begin
	if (a = nil) then
		retornarTotalAsistenciasEntre:= 0
	else if (a^.dato.cod_taller < min) then
		retornarTotalAsistenciasEntre:= retornarTotalAsistenciasEntre(a^.HD, min, max)
	else if (a^.dato.cod_taller > max) then
		retornarTotalAsistenciasEntre:= retornarTotalAsistenciasEntre(a^.HI, min, max)
	else
		retornarTotalAsistenciasEntre:= a^.dato.asistencias_totales + retornarTotalAsistenciasEntre(a^.HI, min, max) + retornarTotalAsistenciasEntre(a^.HD, min, max);
end;

var
	a: arbol;
	cod, min, max: integer;
begin
	Randomize;
	a:= nil;
	cargarArbol(a);
	imprimirArbol(a);
	imprimirMasInscripciones(a);
	writeln('ingresa un codigo de taller para ver cuantos codigos de talleres menores hay');
	readln(cod);
	writeln('la cantidad de talleres menores que ', cod, ' fueron de ', retornarTalleresMenoresQue(a, cod));
	
	writeln('ingrese un valor minimo y maximo');
	readln(min);
	readln(max);
	
	writeln('la cantidad de asistencias entre ese rango fue de: ', retornarTotalAsistenciasEntre(a, min, max));
end.
