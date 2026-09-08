{
1) El administrador de un edificio de oficinas tiene la información del pago de expensas.
Implementar un programa con:

a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas. Se deben
cargar, para cada oficina, el código de identificación, DNI del propietario y valor de la
expensa. La lectura finaliza cuando llega el código de identificación 0.

b) Un módulo que reciba el vector retornado en inciso a) y retorne dicho vector ordenado
por código de identificación de la oficina.

c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector
generado en el inciso b) y un código de identificación de oficina. En caso de
encontrarlo, debe retornar la posición del vector donde se encuentra y en caso
contrario debe retornar 0. Luego el programa debe informar el DNI del propietario o un
cartel indicando que no se encontró la oficina.

d) Un módulo recursivo que retorne el monto total acumulado de las expensas.

}

program programa01;
const
	dimf = 300;
type
	oficina = record
		id: integer;
		dni: integer;
		valor_expensa: integer;
	end;
	
	vector = array[1..dimf] of oficina;

procedure leerOficina(var o: oficina);
begin
	o.id:= random(100);
	if (o.id <> 0) then begin
		o.dni:= random(1000);
		o.valor_expensa:= random(10000);
	end;
end;

procedure ordenarVector(var v:vector; diml: integer);
var
	i, j, pos: integer;
	item: oficina;
begin
	for i:= 1 to (diml - 1) do begin
		pos:= i;
		for j:= i + 1 to diml do begin
			if (v[j].id < v[pos].id)
				then pos:= j;
		end;
		item:= v[pos];
		v[pos]:= v[i];
		v[i]:= item;
	end;
end;

procedure cargarVector(var v: vector; var diml: integer);
var
	o: oficina;
begin
	leerOficina(o);
	while (o.id <> 0) do begin
		diml:= diml + 1;
		v[diml]:= o;
		leerOficina(o);
	end;
end;

procedure buscaDicotomica(v: vector; inicio, fin, id: integer);
var
    mitad: integer;
begin
    if inicio > fin then
        writeln('no se encontro')
    else begin
        mitad := (inicio + fin) div 2;
        if v[mitad].id = id then
            writeln('se encontro')
        else if v[mitad].id > id then
            buscaDicotomica(v, inicio, mitad - 1, id)
        else
            buscaDicotomica(v, mitad + 1, fin, id);
    end;
end;

var
	v: vector;
	diml: integer;
begin
	Randomize;
	diml:= 0;
	
	cargarVector(v, diml);
	ordenarVector(v, diml);
	buscaDicotomica(v, 1, diml, 4);
end.
