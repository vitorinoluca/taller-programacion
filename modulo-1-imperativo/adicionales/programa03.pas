{
5) La Feria del Artesano necesita implementar un programa para obtener estadísticas sobre
las artesanías presentadas. En el programa se pide:

a) Implementar un módulo que lea información de las artesanías. De cada artesanía se
conoce: código de identificación de la artesanía, DNI del artesano y nombre del
material base. La lectura finaliza con el valor 0 para el DNI. Este módulo debe retornar
dos estructuras de datos:

i) Un árbol binario de búsqueda ordenado por el DNI del artesano. Para cada DNI del
artesano debe almacenarse la cantidad de artesanías correspondientes.

ii) Una lista que almacene en cada nodo el nombre del material base y la cantidad
total de artesanías de ese material.

b) Implementar un módulo que reciba el árbol generado en el inciso a)i), y un DNI. El
módulo debe retornar la cantidad de artesanos con DNI menor al DNI ingresado.

c) Implementar un módulo recursivo que reciba la lista generada en el inciso a)ii) y
retorne el nombre de material base con mayor cantidad de artesanías.

}

program programa03;
type
	artesania = record
		id: integer;
		dni_artesano: integer;
		nombre: string;
	end;
	
	datoArtesano = record
		dni: integer;
		cant: integer;
	end;
	
	arbol = ^nodoArbol;
	nodoArbol = record
		dato: datoArtesano;
		HI: arbol;
		HD: arbol;
	end;
	
	material = record
		nombre: string;
		cant: integer;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		dato: material;
		sig: lista;
	end;


procedure leerArtesania (var a: artesania);

	function materialRandom: string;
	const
		materiales: array[1..5] of string = ('madera', 'ceramica', 'cuero', 'lana', 'metal');
	begin
		materialRandom:= materiales[Random(5) + 1];
	end;
	
begin
	a.dni_artesano:= random(100);
	if (a.dni_artesano <> 0) then begin
		a.id:= random(50);
		a.nombre:= materialRandom;
	end;
end;

procedure insertarArbol(var a: arbol; art: integer);
var
	aux: arbol;
	d: datoArtesano;
begin
	if (a = nil) then begin
		new(aux);
		d.dni:= art;
		d.cant:= 1;
		aux^.dato:= d;
		aux^.HI:= nil;
		aux^.HD:= nil;
		a:= aux;
	end
	else if (a^.dato.dni = art) then
		a^.dato.cant:= a^.dato.cant + 1
	else if (a^.dato.dni > art) then
		insertarArbol(a^.HI, art)
	else
		insertarArbol(a^.HD, art)
end;

procedure insertarLista(var l: lista; a: string);
var
	nue: lista;
begin
	if (l = nil) then begin
		new(nue);
		nue^.dato.nombre:= a;
		nue^.dato.cant:= 1;
		nue^.sig:= nil;
		l:= nue;
	end
	else if (l^.dato.nombre = a) then
		l^.dato.cant:= l^.dato.cant + 1
	else
		insertarLista(l^.sig, a);
end;

procedure cargarEstructuras(var a: arbol; var l: lista);
var
	art: artesania;
begin
	leerArtesania(art);
	while (art.dni_artesano <> 0) do begin
		insertarLista(l, art.nombre);
		insertarArbol(a, art.dni_artesano);
		leerArtesania(art);
	end;
end;

function cantDniMenorQue(a: arbol; dni: integer): integer;
begin
	if (a = nil) then
		cantDniMenorQue:= 0
	else if (a^.dato.dni >= dni) then
		cantDniMenorQue:= cantDniMenorQue(a^.HI, dni)
	else
		cantDniMenorQue:= 1 + cantDniMenorQue(a^.HI, dni) + cantDniMenorQue(a^.HD, dni);
end;

function materialMasArtesanias(l: lista): material;
var
	resto: material;
begin
	if (l^.sig = nil) then
		materialMasArtesanias:= l^.dato
	else begin
		resto:= materialMasArtesanias(l^.sig);
		if (l^.dato.cant >= resto.cant) then
			materialMasArtesanias:= l^.dato
		else
			materialMasArtesanias:= resto;
	end;
end;

var
	a: arbol;
	l: lista;
	dni: integer;
	mejorMaterial: material;
begin
	Randomize;
	a:= nil;
	l:= nil;
	cargarEstructuras(a, l);

	writeln('ingresa un dni para ver cuantos nodos tienen dni menor');
	readln(dni);
	writeln('la cantidad de nodos con dni menor a ', dni, ' es de ', cantDniMenorQue(a, dni));

	mejorMaterial:= materialMasArtesanias(l);
	writeln('el material con mas artesanias es: ', mejorMaterial.nombre, ' con ', mejorMaterial.cant, ' artesanias');
end.
