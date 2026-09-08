{
2) La Feria del Libro necesita implementar un programa para obtener estadísticas sobre los
libros presentados. El programa debe contener los siguientes módulos:
a) Un módulo que lea información de los libros. De cada libro se conoce: ISBN, código del
autor y código del género (1: literario, 2: filosofía, 3: biología, 4: arte, 5: computación,
6: medicina, 7: ingeniería). La lectura finaliza con el valor 0 para el ISBN (se sugiere
utilizar el módulo para leer un libro que se especifica más abajo).
Se debe retornar dos estructuras de datos:

i) Un árbol binario de búsqueda ordenado por código de autor. Para cada código
de autor debe almacenarse la cantidad de libros correspondientes al código.

ii) Un vector que almacena para cada género, el código del género y la cantidad
de libros del género.

b) Implementar un módulo que reciba el vector generado en el inciso a) y lo ordene por
cantidad de libros de mayor a menor.

c) Implementar un módulo que retorne el nombre de género con mayor cantidad
cantidad de libros.

d) Implementar un módulo que reciba el árbol generado en el inciso a) y dos códigos de
autores. El módulo debe retornar la cantidad total de libros correspondientes a los
códigos de autores entre los dos códigos ingresados (incluidos ambos).
}

program programa02;
type
	subGenero = 1..7;
	
	libro = record
		isbn: integer;
		codAutor: integer;
		genero: subGenero;
	end;
	
	datoAutor = record
		codAutor: integer;
		cantLibros: integer;
	end;
	
	arbol = ^arbolnodo;
	arbolnodo = record
		dato: datoAutor;
		HI: arbol;
		HD: arbol;
	end;
	datoGenero = record
		codGenero: integer;
		cantLibros: integer;
	end;
	
	vector = array[subGenero] of datoGenero;

procedure leerLibro (var l: libro);
begin
	l.isbn:= Random(1000);
	if (l.isbn <> 0) then begin
		l.codAutor:= Random(300) + 100;
		l.genero:= Random(7) + 1;
	end;
end;

procedure insertar(var a: arbol; l: libro);
var
	aux: arbol;
	d: datoAutor;
begin
	
	if (a = nil) then begin
		new(aux);
		d.codAutor:= l.codAutor;
		d.cantLibros:= 1;
		aux^.dato:= d;
		aux^.HI:= nil;
		aux^.HD:= nil;
		a:= aux;
	end
	else if (a^.dato.codAutor = l.codAutor) then
		a^.dato.cantLibros:= a^.dato.cantLibros + 1
	else if (a^.dato.codAutor < l.codAutor) then
		insertar(a^.HD, l)
	else
		insertar(a^.HI, l)
end;

procedure inicializarVector (var v: vector);
var
	i: integer;
	d: datoGenero;
begin
	d.cantLibros:= 0;
	for i:= 1 to 7 do begin
		d.codGenero:= i;
		v[i]:= d;
	end;
end;


procedure cargarEstructuras(var a: arbol; var v: vector);
var
	l: libro;
begin
	leerLibro(l);
	while (l.isbn <> 0) do begin
		insertar(a, l);
		v[l.genero].cantLibros:= v[l.genero].cantLibros + 1;
		leerLibro(l);
	end;
end;

procedure imprimirArbol(a: arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln(a^.dato.codAutor, ' ', a^.dato.cantLibros);
		imprimirArbol(a^.HD);
	end;
end;
	
procedure imprimirVector(v: vector);
var
	i: integer;
begin
	for i:= 1 to 7 do begin
		writeln(v[i].codGenero, ' cant libros: ', v[i].cantLibros);
	end;
end;


procedure ordenarVector(var v: vector);
var
	i, j, pos: integer;
	d: datoGenero;
begin
	for i:= 1 to 6 do begin
		pos:= i;
		for j:= i + 1 to 7 do begin
			if (v[pos].cantLibros < v[j].cantLibros) then begin
				pos:= j;
			end;
		end;
		d:= v[pos];
		v[pos]:= v[i];
		v[i]:= d;
	end;
end;


function retornarCantLibrosEntre(a: arbol; min, max: integer): integer;
begin
	if (a = nil) then
		retornarCantLibrosEntre:= 0
	else if (min > a^.dato.codAutor) then
		retornarCantLibrosEntre:= retornarCantLibrosEntre(a^.HD, min, max)
	else if (max < a^.dato.codAutor) then
		retornarCantLibrosEntre:= retornarCantLibrosEntre(a^.HI, min, max)
	else
		retornarCantLibrosEntre:= a^.dato.cantLibros + retornarCantLibrosEntre(a^.HI, min, max) + retornarCantLibrosEntre(a^.HD, min, max);
end;

var
	a: arbol;
	v: vector;
	v2: array [subGenero] of string = ('literario', 'filosofia', 'arte', 'biologia', 'computacion', 'medicina', 'ingenieria');
	min, max: integer;
	
procedure retornarNombreGeneroMasLibros (v: vector);
var
	i, max: integer;
begin
	max:= 1;
	for i:= 1 to 7 do begin
		if (v[max].cantLibros < v[i].cantLibros) then
			max:= v[i].codGenero;
	end;
	writeln('el genero con mas libros es ', v2[v[max].codGenero], ' con ', v[max].cantLibros, ' libros');
end;

begin
	Randomize;
	a:= nil;
	inicializarVector(v);
	cargarEstructuras(a, v);
	imprimirArbol(a);
	imprimirVector(v);
	writeln();
	ordenarVector(v);
	imprimirVector(v);
	writeln();
	retornarNombreGeneroMasLibros(v);
	
	writeln('ingresa un valor minimo');
	readln(min);
	writeln('ingresa un valor maximo');
	readln(max);
	writeln(retornarCantLibrosEntre(a, min, max), ' libros')
end.
