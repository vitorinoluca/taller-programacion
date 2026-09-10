program program04;
type
	sub_dia = 1..31;
	sub_mes = 1..12;
	compra = record
		cod_cliente: integer;
		dia: sub_dia;
		mes: sub_mes;
		monto: integer;
	end;
	vector = array[sub_mes] of integer;
	
	cliente = record
		cod_cliente: integer;
		v: vector;
	end;
	
	arbol = ^arbolNodo;
	arbolNodo = record
		dato: cliente;
		HI: arbol;
		HD: arbol;
	end;
	
procedure leerCompra(var c: compra);
begin
	c.cod_cliente:= random(100);
	if (c.cod_cliente <> 0) then begin
		c.dia:= random(31) + 1;
		c.mes:= random(12) + 1;
		c.monto:= random(10000);
	end;
end;

procedure insertar(var a: arbol; c: compra);
var
	aux: arbol;
	i: integer;
begin
	if (a = nil) then begin
		new(aux);
		aux^.dato.cod_cliente:= c.cod_cliente;
		for i:= 1 to 12 do
			aux^.dato.v[i]:= 0;
		aux^.dato.v[c.mes]:= aux^.dato.v[c.mes] + c.monto;
		aux^.HI:= nil;
		aux^.HD:= nil;
		a:= aux;
	end
	else if (a^.dato.cod_cliente = c.cod_cliente) then
		a^.dato.v[c.mes]:= a^.dato.v[c.mes] + c.monto
	else if (a^.dato.cod_cliente > c.cod_cliente) then
		insertar(a^.HI, c)
	else
		insertar(a^.HD, c)
end;

procedure cargarArbol (var a: arbol);
var
	c: compra;
begin
	leerCompra(c);
	while (c.cod_cliente <> 0) do begin
		insertar(a, c);
		leerCompra(c);
	end;
end;

procedure imprimirArbol(a: arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln(a^.dato.cod_cliente);
		imprimirArbol(a^.HD);
	end;
end;

function retornarPosVector(v: vector): integer;
var
	i: integer;
	pos: integer;
begin
	pos:= 1;
	for i:= 1 to 12 do begin
		if (v[i] > v[pos]) then
			pos:= i;
	end;
	retornarPosVector:= pos;
end;

procedure retornarMesMayorGasto (a: arbol; c: integer);
begin
	if (a = nil) then
		writeln('no se encontro al cliente')
	else if (a^.dato.cod_cliente = c) then
		writeln('el mes ', retornarPosVector(a^.dato.v), ' fue el que mas gasto tuvo')
	else if (a^.dato.cod_cliente > c) then
		retornarMesMayorGasto(a^.HI, c)
	else
		retornarMesMayorGasto(a^.HD, c)
end;


function retornarSiHuboGasto(v: vector; m: integer): integer;
begin
	if (v[m] = 0) then
		retornarSiHuboGasto:= 1
	else
		retornarSiHuboGasto:= 0;
end;

function contarCantClientes(a: arbol; m: integer): integer;
begin
	if (a <> nil) then
		contarCantClientes:= retornarSiHuboGasto(a^.dato.v, m) + 
		contarCantClientes(a^.HI, m) + contarCantClientes(a^.HD, m)
	else
		contarCantClientes:= 0;
end;

var
	a: arbol;
	c, m: integer;
begin
	Randomize;
	a:= nil;
	cargarArbol(a);
	imprimirArbol(a);
	writeln('ingrese un numero de cliente');
	readln(c);
	retornarMesMayorGasto(a, c);
	
	writeln('ingrese un numero de mes 1..12');
	readln(m);
	writeln('la cantidad de clientes que no compraron en el mes ', m, ' fue de ', contarCantClientes(a, m));
end.
