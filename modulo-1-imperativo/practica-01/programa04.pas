{
4. Una librería requiere el procesamiento de la información de sus productos. De cada
producto se conoce el código del producto, código de rubro (del 1 al 6) y precio.
Implementar un programa que invoque a módulos para cada uno de los siguientes
puntos:

a. Lea los datos de los productos y los almacene ordenados por código de
producto y agrupados por rubro, en una estructura de datos adecuada. El
ingreso de los productos finaliza cuando se lee el precio -1.

b. Una vez almacenados, muestre los códigos de los productos pertenecientes a
cada rubro.

c. Genere un vector (de a lo sumo 20 elementos) con los productos del rubro 3.
Considerar que puede haber más o menos de 20 productos del rubro 3. Si la
cantidad de productos del rubro 3 es mayor a 20, se debe almacenar los
primeros 20 que están en la lista e ignore el resto.

d. Ordenar, por precio, los elementos del vector generado en c) utilizando el
método visto en la teoría.

e. Muestre los precios del vector resultante del punto d).

f. Calcule el promedio de los precios del vector resultante del punto d).
}

program programa04;
const
	RUBROS = 6;
type
	producto = record
		codigo: integer;
		cod_rubro: 1..RUBROS;
		precio: integer;
	end;
	
	lista = ^nodo;
	nodo = record
		dato: producto;
		sig: lista;
	end;
	vector = array[1..RUBROS] of lista;
	vector20 = array[1..20] of producto;
	
procedure insertarOrdenado (var l: lista; p: producto);
var
	nue: lista;
	ant, act: lista;
begin
	new(nue);
	nue^.dato:= p;
	ant:= l;
	act:= l;
	while (act <> nil) and (p.codigo > act^.dato.codigo) do begin
		ant:= act;
		act:= act^.sig;
	end;
	if (act = ant)then
		l:= nue
	else 
		ant^.sig:= nue;
	nue^.sig:= act;
	
end;

procedure leerProductos (var v: vector);
var
	p: producto;
begin
	writeln('ingrese el precio del producto');
	readln(p.precio);
	while (p.precio <> -1) do begin
		writeln('ingrese el codigo del producto');
		readln(p.codigo);
		writeln('ingrese el codigo de rubro del producto');
		readln(p.cod_rubro);
		
		insertarOrdenado(v[p.cod_rubro], p);
		
		writeln('ingrese el precio del producto');
		readln(p.precio);
	end;
end;

procedure inicializarVector(var v: vector);
var
	i: integer;
	l: lista;
begin
	for i:= 1 to RUBROS do begin
		new(l);
		l:= nil;
		v[i]:= l;
	end;
end;

procedure imprimirLista(v: vector);
var
	i: integer;
	l: lista;
begin
	for i:= 1 to RUBROS do begin
		l:= v[i];
		writeln('RUBRO ', i);
		while (l <> nil) do begin
			writeln(l^.dato.codigo);
			l:= l^.sig;
		end;
	end;
end;

procedure generarVector20(var v20: vector20; var diml: integer; v: vector);
var
	l: lista;
begin
	l:= v[3];
	while (l <> nil) and (diml < 20) do begin
		diml:= diml + 1;
		v20[diml]:= l^.dato;
		l:= l^.sig;
	end;
end;

procedure imprimirVector(v: vector20; diml: integer);
var
	i: integer;
begin
	for i:= 1 to diml do begin
		writeln('$', v[i].precio);
	end;
end;

procedure ordenarvector(var v: vector20; diml: integer);
var
  i, j, pos: integer;
  aux: producto;
begin
  for i := 1 to diml - 1 do begin
    pos := i;
    for j := i + 1 to diml do begin
      if v[j].precio < v[pos].precio then
        pos := j;
    end;
    aux := v[i];
    v[i] := v[pos];
    v[pos] := aux;
  end;
end;

function calcularPromedio (v: vector20; diml: integer): real;
var
	i: integer;
	sum: integer;
begin
	sum:= 0;
	for i:=1 to diml do begin
		sum:= sum + v[i].precio;
	end;
	calcularPromedio:= sum / diml;
end;

var
	v: vector;
	v20: vector20;
	diml: integer;
begin
	inicializarVector(v);
	leerProductos(v);
	imprimirLista(v);
	
	diml:= 0;
	generarVector20(v20, diml, v);
	
	writeln('----------- vector 20 -----------------');
	ordenarvector(v20, diml);
	imprimirVector(v20, diml);
	
	writeln('el promedio de precios es: ', calcularPromedio(v20, diml));
end.
