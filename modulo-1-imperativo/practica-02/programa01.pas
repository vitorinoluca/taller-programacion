{1.- Implementar un programa que invoque a los siguientes m�dulos.
a. Un m�dulo recursivo que retorne un vector de a lo sumo 15 n�meros enteros �random� mayores a 130 y menores a 145 (incluidos ambos). La carga finaliza con 
el valor 130.
b. Un m�dulo no recursivo que reciba el vector generado en a) e imprima el contenido del vector.
c. Un m�dulo recursivo que reciba el vector generado en a) e imprima el contenido del vector.
d. Un m�dulo recursivo que reciba el vector generado en a) y devuelva la suma de los valores contenidos en el vector.
e. Un m�dulo recursivo que reciba el vector generado en a) y devuelva el m�ximo valor del vector.
f. Un m�dulo recursivo que reciba el vector generado en a) y un valor y devuelva verdadero si dicho valor se encuentra en el vector o falso en caso contrario.
g. Un m�dulo que reciba el vector generado en a) e imprima, para cada n�mero contenido en el vector, sus d�gitos en el orden en que aparecen en el n�mero. 
Debe implementarse un m�dulo recursivo que reciba el n�mero e imprima lo pedido. Ejemplo si se recibe el valor 134, se debe imprimir 1  3  4
}

Program Clase2MI;
const dimF = 15;
      min = 130;
      max = 145;
type vector = array [1..dimF] of integer;
     

procedure CargarVector (var v: vector; var dimL: integer);

  procedure CargarVectorRecursivo (var v: vector; var dimL: integer);
  var valor: integer;
  begin
    valor:= min + random (max - min + 1);
    if ((valor <> 130 ) and (dimL < dimF)) 
    then begin
          dimL:= dimL + 1;
          v[dimL]:= valor;
          CargarVectorRecursivo (v, dimL);
         end;
  end;
  
begin
  dimL:= 0;
  CargarVectorRecursivo (v, dimL);
end;
 
procedure ImprimirVector (v: vector; dimL: integer);
var
   i: integer;
begin
     for i:= 1 to dimL do
         write ('------');
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        write(v[i], ' | ');
     end;
     writeln;
     for i:= 1 to dimL do
         write ('------');
     writeln;
     writeln;
End;     

procedure ImprimirVectorRecursivo (v: vector; dimL: integer);
begin    
     {-- Completar HECHO --}
     if (diml > 1) then begin
		ImprimirVectorRecursivo(v, diml - 1);
     end;
     writeln(v[diml]);
end; 
    
function Sumar (v: vector; dimL: integer): integer; 

  function SumarRecursivo (v: vector; pos, dimL: integer): integer;

  Begin
    if (pos <= dimL)  
    then SumarRecursivo:= SumarRecursivo (v, pos + 1, dimL) + v[pos]  
    else SumarRecursivo:=0  
  End;
 
var pos: integer; 
begin
 pos:= 1;
 Sumar:= SumarRecursivo (v, pos, dimL);
end;

function  ObtenerMaximo (v: vector; dimL: integer): integer;
var
	max: integer;
begin
	{-- Completar HECHO --} 
	if diml = 1 then
		ObtenerMaximo:= v[1]
	else begin
		max:= ObtenerMaximo(v, diml - 1);
		if (v[diml] > max) then
			ObtenerMaximo:= v[diml]
		else ObtenerMaximo:= max;
	end;
end;     
     
function BuscarValor (v: vector; dimL, valor: integer): boolean;
begin
	{-- Completar HECHO --}
	if diml = 0 then
		BuscarValor:= false
	else if v[diml] = valor then
		BuscarValor:= true
	else
		BuscarValor:= BuscarValor(v, diml - 1, valor);
end; 

procedure ImprimirDigitos (v: vector; dimL: integer);

  procedure ImprimirNumero (num: integer);
  begin
    if (num >= 10)
    then
      ImprimirNumero(num div 10);

    write(num mod 10, ' ');
  end;

begin
  if (dimL > 0)
  then begin
    ImprimirDigitos(v, dimL - 1);
    ImprimirNumero(v[dimL]);
    writeln;
  end;
end;

var dimL, suma, maximo, valor: integer; 
    v: vector;
    encontre: boolean;

Begin 
  randomize;
  CargarVector (v, dimL);
  writeln;
  if (dimL = 0) then writeln ('--- Vector sin elementos ---')
                else begin
                       ImprimirVector (v, dimL);
                       ImprimirVectorRecursivo (v, dimL);
                     end;
  writeln;
  writeln;                   
  suma:= Sumar(v, dimL);
  writeln;
  writeln;
  writeln('La suma de los valores del vector es ', suma); 
  writeln;
  writeln;
  maximo:= ObtenerMaximo(v, dimL);
  writeln;
  writeln;
  writeln('El maximo del vector es ', maximo); 
  writeln;
  writeln;
  write ('Ingrese un valor a buscar: ');
  read (valor);
  encontre:= BuscarValor(v, dimL, valor);
  writeln;
  writeln;
  if (encontre) then writeln('El ', valor, ' esta en el vector')
                else writeln('El ', valor, ' no esta en el vector');
                
  writeln;
  writeln;
  ImprimirDigitos (v, dimL);
end.
