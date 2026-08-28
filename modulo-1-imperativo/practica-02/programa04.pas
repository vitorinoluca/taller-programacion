{
4.- Implementar un programa que invoque a los siguientes módulos.

a. Un módulo recursivo que retorne un vector de 30 números enteros “random” mayores a 300
y menores a 550 (incluidos ambos).

b. Un módulo que reciba el vector generado en a) y lo retorne ordenado. (Utilizar lo realizado
en la práctica anterior)

c. Un módulo que realice una búsqueda dicotómica en el vector, utilizando el siguiente
encabezado:
Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
}

program programa04;

const
  dimf = 30;

type
  vector = array[1..dimf] of integer;
  indice = 0..dimf;


procedure cargarVector(var v: vector; var diml: integer);
var
  n: integer;
begin
  n := Random(251) + 300;

  if (diml <> dimf) then begin
    diml := diml + 1;
    v[diml] := n;
    cargarVector(v, diml);
  end;
end;


procedure ordenarVector(var v: vector; diml: integer);
var
  i, j, aux, pos: integer;
begin
  for i := 1 to diml - 1 do begin
    aux := v[i];
    pos := i;

    for j := i + 1 to diml do begin
      if aux > v[j] then begin
        aux := v[j];
        pos := j;
      end;
    end;

    v[pos] := v[i];
    v[i] := aux;
  end;
end;


procedure busquedaDicotomica(v: vector; ini, fin: indice; dato: integer; var pos: indice);
var
  mitad: integer;
begin
  pos := 0;

  while (ini <= fin) and (pos = 0) do begin
    mitad := (ini + fin) div 2;

    if (dato = v[mitad]) then
      pos := mitad
    else if (dato < v[mitad]) then
      fin := mitad - 1
    else
      ini := mitad + 1;
  end;
end;


var
  v: vector;
  diml: integer;
  i: integer;
  dato: integer;
  pos: indice;

begin
  randomize;

  diml := 0;
  cargarVector(v, diml);
  ordenarVector(v, diml);

  writeln('--- VECTOR ORDENADO ---');
  for i := 1 to diml do begin
    writeln(v[i]);
  end;

  writeln;
  write('Ingrese un valor a buscar: ');
  readln(dato);

  busquedaDicotomica(v, 1, diml, dato, pos);

  if (pos <> 0) then
    writeln('El valor se encuentra en la posicion ', pos)
  else
    writeln('El valor no se encuentra en el vector');
end.
