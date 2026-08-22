{2. El administrador de un edificio de oficinas cuenta, en papel, con la información del
pago de las expensas de dichas oficinas. Implementar un programa que invoque a
módulos para cada uno de los siguientes puntos:

a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De
cada oficina se ingresa el código de identificación, DNI del propietario y valor
de la expensa. La lectura finaliza cuando se ingresa el código de identificación
-1, el cual no se procesa.

b. Ordene el vector aplicando el método de selección, por código de
identificación de la oficina.}

program programa02;
const
	dimF = 300;
type
	oficina = record
		id: integer;
		dni: integer;
		valor_expensa: real;
	end;
	tvector = array[1..dimF] of oficina;

procedure cargarVector(var v: tvector; var diml: integer);
var
	o: oficina;
begin
	repeat
		writeln('ingrese el id');
		readln(o.id);
		
		if (o.id <> -1) then begin
			writeln('ingrese el dni');
			readln(o.dni);
			writeln('ingrese el valor de la expensa');
			readln(o.valor_expensa);
			
			diml:= diml + 1;
			v[diml]:= o;
		end;
	until (o.id = -1) or (diml = dimF);
end;
procedure ordenarVector(var v: tvector; diml: integer);
var
	i, j, pos: integer;
	aux: oficina;
begin
	for i:= 1 to diml - 1 do begin
		pos:= i;
		for j:= i + 1 to diml do begin
			if (v[j].id < v[pos].id) then begin
				pos:= j;
			end;
		end;
		aux:= v[i];
		v[i]:= v[pos];
		v[pos]:= aux;
		
	end;
end;

procedure imprimirVector(v: tvector; diml: integer);
var
	i: integer;
begin
	for i:= 1 to diml do begin
		writeln('oficina ', v[i].id, ' | dni ', v[i].dni, ' | expensa ', v[i].valor_expensa:0:2);
	end;
end;
var
	v: tvector;
	diml: integer;
begin
	diml:= 0;
	cargarVector(v, diml);
	ordenarVector(v, diml);
	imprimirVector(v, diml);
end.
