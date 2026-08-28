{
2.- Escribir un programa que:

a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
“random” en el rango 200-230. Finalizar con el número 200.

b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el
mismo orden que están almacenados.

c. Implemente un módulo recursivo que reciba la lista generada en a) e imprima los valores de
la lista en orden inverso al que están almacenados.

d. Implemente un módulo recursivo que reciba la lista generada en a) y devuelva el mínimo
valor de la lista.

e. Implemente un módulo recursivo que reciba la lista generada en a) y un valor y devuelva
verdadero si dicho valor se encuentra en la lista o falso en caso contrario.
}

program programa02;

type
  lista = ^nodo;
  nodo = record
    dato: integer;
    sig: lista;
  end;


procedure generarLista(var l: lista);
var
  n: integer;
  nue: lista;
begin
  n := random(31) + 200;

  if (n <> 200) then begin
    new(nue);
    nue^.dato := n;
    nue^.sig := l;
    l := nue;

    generarLista(l);
  end;
end;


procedure imprimirLista(l: lista);
begin
  if (l <> nil) then begin
    writeln(l^.dato);
    imprimirLista(l^.sig);
  end;
end;


procedure imprimirListaInverso(l: lista);
begin
  if (l <> nil) then begin
    imprimirListaInverso(l^.sig);
    writeln(l^.dato);
  end;
end;


function retornarMinimo(l: lista): integer;
var
  min: integer;
begin
  if (l^.sig = nil) then
    retornarMinimo := l^.dato
  else begin
    min := retornarMinimo(l^.sig);

    if (l^.dato < min) then
      retornarMinimo := l^.dato
    else
      retornarMinimo := min;
  end;
end;


function buscarValor(l: lista; valor: integer): boolean;
begin
  if (l <> nil) then begin
    if (l^.dato = valor) then
      buscarValor := true
    else
      buscarValor := buscarValor(l^.sig, valor);
  end
  else
    buscarValor := false;
end;


var
  l: lista;
  valor: integer;
  encontre: boolean;

begin
  Randomize;

  l := nil;
  generarLista(l);

  writeln('-- IMPRESION NORMAL --');
  imprimirLista(l);

  writeln('-- IMPRESION INVERSA --');
  imprimirListaInverso(l);

  writeln('El minimo es: ', retornarMinimo(l));

  writeln('Ingrese un valor a buscar');
  readln(valor);

  encontre := buscarValor(l, valor);

  if (encontre) then
    writeln('El ', valor, ' esta en la lista')
  else
    writeln('El ', valor, ' no esta en la lista');
end.
