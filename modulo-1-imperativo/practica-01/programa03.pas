{3. Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
septiembre de 2025. De cada película se conoce: código de película, código de género
(1: acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8:
terror) y puntaje promedio otorgado por las críticas. Implementar un programa que
invoque a módulos para cada uno de los siguientes puntos:

a. Lea los datos de películas, almacenarlos por orden de llegada y agrupados por
código de género, y retornar en una estructura de datos adecuada. La lectura
finaliza cuando se lee el código de la película -1.

b. Genere y retorne en un vector, para cada género, el código de película con
mayor puntaje obtenido entre todas las críticas, a partir de la estructura
generada en a).

c. Ordene los elementos del vector generado en b) por puntaje utilizando el
método visto en la teoría.

d. Muestre el código de película con mayor puntaje y el código de película con
menor puntaje, del vector obtenido en el punto c)}

program programa03;
type
	tgeneros = 1..8;
	pelicula = record
		codigo: integer;
		genero: tgeneros;
		puntaje: real;
	end;
	
	lista = ^nodo;
	nodo = record
		dato: pelicula;
		sig: lista;
	end;
	
	vector = array [tgeneros] of lista;
	mejorPelicula = record
		codigo: integer;
		puntaje: real;
	end;
	vector2 = array [tgeneros] of mejorPelicula;

procedure leerPelicula(var p: pelicula);
begin
	writeln('ingrese el codigo de la pelicula');
	readln(p.codigo);
	if (p.codigo <> -1) then begin
		writeln('ingrese el genero de la pelicula');
		readln(p.genero);
		writeln('ingrese el puntaje de la pelicula');
		readln(p.puntaje);
	end;
end;

procedure leerPeliculas(var v: vector);
var
	p: pelicula;
	nue: lista;
begin
	leerPelicula(p);
	while (p.codigo <> -1) do begin
		new(nue);
		nue^.dato:= p;
		nue^.sig:= v[p.genero];
		v[p.genero]:= nue;
		leerPelicula(P);
	end;
end;

procedure imprimirVector(v: vector);
var
	i: integer;
	l: lista;
begin
	for i:= 1 to 8 do begin
		l:= v[i];
		writeln('-----------');
		writeln('GENERO ', i);
		while (l <> nil) do begin
			writeln(l^.dato.codigo);
			l:= l^.sig;
		end;
	end;
end;

procedure retornarMayorPuntaje (v1: vector; var v: vector2);
var
	i: integer;
	l: lista;
begin
	for i:= 1 to 8 do begin
		l:= v1[i];
		v[i].codigo:= 0;
		v[i].puntaje:= -1;
		while (l <> nil) do begin
			if (l^.dato.puntaje > v[i].puntaje) then begin
				v[i].puntaje:= l^.dato.puntaje;
				v[i].codigo:= l^.dato.codigo;
			end;
			l:= l^.sig;
		end;
	end;
end;

procedure ordenarVector(var v: vector2);
var
	i, j, pos: integer;
	aux: mejorPelicula;
begin
	for i:= 1 to 8 - 1 do begin
		pos:= i;
		for j:= i + 1 to 8 do begin
			if (v[j].puntaje < v[pos].puntaje) then begin
				pos:= j;
			end;
		end;
		aux:= v[i];
		v[i]:= v[pos];
		v[pos]:= aux;
	end;
end;

var
	v: vector;
	v2: vector2;
begin
	leerPeliculas(v);
	imprimirVector(v);
	retornarMayorPuntaje(v, v2);
	ordenarVector(v2);
end.
