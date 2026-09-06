program programa04;
type
	alquiler = record
		cod: integer;
		num_cliente: integer;
		dia_alquiler: integer;
		horas_alquiladas: integer;
		importe: real;
	end;

	arbol1 = ^nodo1;
	nodo1 = record
		dato: alquiler;
		HI: arbol1;
		HD: arbol1;
	end;

	alquilerInfo = record
		num_cliente: integer;
		dia_alquiler: integer;
		horas_alquiladas: integer;
		importe: real;
	end;

	lista = ^nodoLista;
	nodoLista = record
		dato: alquilerInfo;
		sig: lista;
	end;

	bicicleta = record
		cod: integer;
		alquileres: lista;
	end;

	arbol2 = ^nodo2;
	nodo2 = record
		dato: bicicleta;
		HI: arbol2;
		HD: arbol2;
	end;

	biciHoras = record
		cod: integer;
		horas_totales: integer;
	end;

	listaHoras = ^nodoHoras;
	nodoHoras = record
		dato: biciHoras;
		sig: listaHoras;
	end;

procedure leerAlquiler(var a: alquiler);
begin
	a.cod:= random(101);
	if (a.cod <> 0) then begin
		a.num_cliente:= random(100);
		a.dia_alquiler:= random(31);
		a.horas_alquiladas:= random(25);
		a.importe:= random(30000);
	end;
end;

procedure insertarArbol(var a: arbol1; alq: alquiler);
var
	aux: arbol1;
begin
	if (a = nil) then begin
		new(aux);
		aux^.dato:= alq;
		aux^.HI:= nil;
		aux^.HD:= nil;
		a:= aux;
	end
	else if (alq.cod < a^.dato.cod) then
		insertarArbol(a^.HI, alq)
	else
		insertarArbol(a^.HD, alq);
end;

procedure agregarLista (var l: lista; a: alquilerInfo);
var
	nue: lista;
begin
	new(nue);
	nue^.dato:= a;

	if (l = nil) then
		nue^.sig:= nil
	else
		nue^.sig:= l;
	l:= nue;
end;

procedure insertarArbol2(var a: arbol2; alq: alquiler);
var
	aux: arbol2;
	b: bicicleta;
	alq_info: alquilerInfo;
begin
	alq_info.num_cliente:= alq.num_cliente;
	alq_info.dia_alquiler:= alq.dia_alquiler;
	alq_info.horas_alquiladas:= alq.horas_alquiladas;
	alq_info.importe:= alq.importe;

	if (a = nil) then begin
		new(aux);
		b.cod:= alq.cod;
		b.alquileres:= nil;
		agregarLista(b.alquileres, alq_info);
		aux^.dato:= b;
		aux^.HI:= nil;
		aux^.HD:= nil;
		a:= aux;
	end
	else if (a^.dato.cod = alq.cod) then
		agregarLista(a^.dato.alquileres, alq_info)
	else if (alq.cod < a^.dato.cod) then
		insertarArbol2(a^.HI, alq)
	else
		insertarArbol2(a^.HD, alq);
end;

procedure cargarArboles(var a: arbol1; var a2: arbol2);
var
	alq: alquiler;
begin
	leerAlquiler(alq);
	while (alq.cod <> 0) do begin
		insertarArbol(a, alq);
		insertarArbol2(a2, alq);
		leerAlquiler(alq);
	end;
end;

function retornarCodMasGrande (a: arbol1): integer;
begin
	if (a^.HD = nil) then
		retornarCodMasGrande:= a^.dato.cod
	else
		retornarCodMasGrande:= retornarCodMasGrande(a^.HD);
end;

function retornarCodMasChico (a: arbol2): integer;
begin
	if (a^.HI = nil) then
		retornarCodMasChico:= a^.dato.cod
	else
		retornarCodMasChico:= retornarCodMasChico(a^.HI);
end;

function retornarCantAlquileresClientePorBici (l: lista; num: integer): integer;
begin
	if (l = nil) then
		retornarCantAlquileresClientePorBici:= 0
	else if (l^.dato.num_cliente = num) then
		retornarCantAlquileresClientePorBici:= 1 + retornarCantAlquileresClientePorBici(l^.sig, num)
	else
		retornarCantAlquileresClientePorBici:= retornarCantAlquileresClientePorBici(l^.sig, num)
end;

function retornarCantAlquileresCliente2 (a: arbol2; num: integer): integer;
begin
	if (a = nil) then
		retornarCantAlquileresCliente2:= 0
	else
		retornarCantAlquileresCliente2:= retornarCantAlquileresClientePorBici(a^.dato.alquileres, num) + retornarCantAlquileresCliente2(a^.HI, num) + retornarCantAlquileresCliente2(a^.HD, num);
end;

function retornarCantAlquileresCliente (a: arbol1; num: integer): integer;
begin
	if (a = nil) then
		retornarCantAlquileresCliente:= 0
	else if (a^.dato.num_cliente = num) then
		retornarCantAlquileresCliente:= 1 + retornarCantAlquileresCliente(a^.HI, num) + retornarCantAlquileresCliente(a^.HD, num)
	else
		retornarCantAlquileresCliente:= retornarCantAlquileresCliente(a^.HI, num) + retornarCantAlquileresCliente(a^.HD, num);
end;

procedure generarListaHoras (a: arbol1; var l: listaHoras; var ultimo: listaHoras);
var
	nue: listaHoras;
begin
	if (a <> nil) then begin
		generarListaHoras(a^.HI, l, ultimo);

		if (ultimo <> nil) and (ultimo^.dato.cod = a^.dato.cod) then
			ultimo^.dato.horas_totales:= ultimo^.dato.horas_totales + a^.dato.horas_alquiladas
		else begin
			new(nue);
			nue^.dato.cod:= a^.dato.cod;
			nue^.dato.horas_totales:= a^.dato.horas_alquiladas;
			nue^.sig:= nil;
			if (l = nil) then
				l:= nue
			else
				ultimo^.sig:= nue;
			ultimo:= nue;
		end;

		generarListaHoras(a^.HD, l, ultimo);
	end;
end;

function sumarHorasLista (l: lista): integer;
begin
	if (l = nil) then
		sumarHorasLista:= 0
	else
		sumarHorasLista:= l^.dato.horas_alquiladas + sumarHorasLista(l^.sig);
end;

procedure generarListaHoras2 (a: arbol2; var l: listaHoras; var ultimo: listaHoras);
var
	nue: listaHoras;
begin
	if (a <> nil) then begin
		generarListaHoras2(a^.HI, l, ultimo);

		new(nue);
		nue^.dato.cod:= a^.dato.cod;
		nue^.dato.horas_totales:= sumarHorasLista(a^.dato.alquileres);
		nue^.sig:= nil;
		if (l = nil) then
			l:= nue
		else
			ultimo^.sig:= nue;
		ultimo:= nue;

		generarListaHoras2(a^.HD, l, ultimo);
	end;
end;

procedure imprimirListaHoras (l: listaHoras);
begin
	if (l <> nil) then begin
		writeln('Codigo: ', l^.dato.cod, ' | Horas totales: ', l^.dato.horas_totales);
		imprimirListaHoras(l^.sig);
	end;
end;

function retornarImporteEntre1 (a: arbol1; min, max: integer): real;
begin
	if (a = nil) then
		retornarImporteEntre1:= 0
	else if (a^.dato.cod < min) then
		retornarImporteEntre1:= retornarImporteEntre1(a^.HD, min, max)
	else if (a^.dato.cod > max) then
		retornarImporteEntre1:= retornarImporteEntre1(a^.HI, min, max)
	else
		retornarImporteEntre1:= a^.dato.importe + retornarImporteEntre1(a^.HI, min, max) + retornarImporteEntre1(a^.HD, min, max);
end;

function sumarImporteLista (l: lista): real;
begin
	if (l = nil) then
		sumarImporteLista:= 0
	else
		sumarImporteLista:= l^.dato.importe + sumarImporteLista(l^.sig);
end;

function retornarImporteEntre2 (a: arbol2; min, max: integer): real;
begin
	if (a = nil) then
		retornarImporteEntre2:= 0
	else if (a^.dato.cod < min) then
		retornarImporteEntre2:= retornarImporteEntre2(a^.HD, min, max)
	else if (a^.dato.cod > max) then
		retornarImporteEntre2:= retornarImporteEntre2(a^.HI, min, max)
	else
		retornarImporteEntre2:= sumarImporteLista(a^.dato.alquileres) + retornarImporteEntre2(a^.HI, min, max) + retornarImporteEntre2(a^.HD, min, max);
end;

var
	a1: arbol1;
	a2: arbol2;
	lh1, ult1: listaHoras;
	lh2, ult2: listaHoras;
	num, cod1, cod2: integer;
begin
	Randomize;
	a1:= nil;
	a2:= nil;
	cargarArboles(a1, a2);

	writeln('el codigo de bicicleta mas grande es ', retornarCodMasGrande(a1));
	writeln('el codigo de bicicleta mas chico es ', retornarCodMasChico(a2));

	writeln('ingrese un numero de cliente para buscar cuantos alquileres tiene');
	readln(num);
	writeln('la cantidad de alquileres es de ', retornarCantAlquileresCliente(a1, num));
	writeln('la cantidad de alquileres es de ', retornarCantAlquileresCliente2(a2, num));

	lh1:= nil;
	ult1:= nil;
	generarListaHoras(a1, lh1, ult1);

	lh2:= nil;
	ult2:= nil;
	generarListaHoras2(a2, lh2, ult2);

	writeln('horas totales por bicicleta (a partir de arbol2):');
	imprimirListaHoras(lh2);

	writeln('ingrese dos codigos de bicicleta para calcular el importe recaudado entre ellos');
	readln(cod1);
	readln(cod2);
	writeln('el importe recaudado (arbol1) es de ', retornarImporteEntre1(a1, cod1, cod2):0:2);
	writeln('el importe recaudado (arbol2) es de ', retornarImporteEntre2(a2, cod1, cod2):0:2);
end.
