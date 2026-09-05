Program ImperativoClase3;

type rangoEdad = 12..100;
     rangoSocio = 100..200;
     cadena15 = string [15];
     socio = record
               numero: rangoSocio;
               nombre: cadena15;
               edad: rangoEdad;
             end;
     arbol = ^nodoArbol;
     nodoArbol = record
                    dato: socio;
                    HI: arbol;
                    HD: arbol;
                 end;
     conjunto = set of rangoSocio;
     
procedure GenerarArbol (var a: arbol);
{ Implementar un modulo que almacene informacion de socios de un club en un arbol binario de busqueda. De cada socio se debe almacenar numero de socio, 
nombre y edad. La carga finaliza con el numero de socio 0 y el arbol debe quedar ordenado por numero de socio. La informacion de cada socio debe generarse
aleatoriamente. }

  Procedure CargarSocio (var s: socio; var conj: conjunto);
  var vNombres:array [0..9] of string= ('Ana', 'Jose', 'Luis', 'Ema', 'Ariel', 'Pedro', 'Lena', 'Lisa', 'Martin', 'Lola'); 
  
  begin
    s.numero:= random (51) + 100;
    while (s.numero in conj) do
      s.numero:= random (51) + 100;
    If (s.numero <> 100)
    then begin
           conj:= conj + [s.numero];
           s.nombre:= vNombres[random(10)];
           s.edad:= 12 + random (79);
         end;
  end;  
  
  Procedure InsertarElemento (var a: arbol; elem: socio);
  Begin
    if (a = nil) 
    then begin
           new(a);
           a^.dato:= elem; 
           a^.HI:= nil; 
           a^.HD:= nil;
         end
    else if (elem.numero < a^.dato.numero) 
         then InsertarElemento(a^.HI, elem)
         else InsertarElemento(a^.HD, elem); 
  End;

var unSocio: socio;  
    conj: conjunto;
Begin
 writeln;
 writeln ('----- Ingreso de socios y armado del arbol ----->');
 writeln;
 a:= nil;
 conj:=[];
 CargarSocio (unSocio, conj);
 while (unSocio.numero <> 100)do
  begin
   writeln ('Numero generado: ', unSocio.numero);
   InsertarElemento (a, unSocio);
   CargarSocio (unSocio, conj);
  end;
 writeln;
 writeln ('//////////////////////////////////////////////////////////');
 writeln;
end;

procedure InformarNumeroSocioConMasEdad (a: arbol);
{ Informar el numero de socio con mayor edad. Debe invocar a un modulo recursivo que retorne dicho valor.  }

     procedure actualizarMaximo(var maxValor,maxElem : integer; nuevoValor, nuevoElem : integer);
	begin
	  if (nuevoValor >= maxValor) then
	  begin
		maxValor := nuevoValor;
		maxElem := nuevoElem;
	  end;
	end;
	procedure NumeroMasEdad (a: arbol; var maxEdad: integer; var maxNum: integer);
	begin
	   if (a <> nil) then
	   begin
		  actualizarMaximo(maxEdad,maxNum,a^.dato.edad,a^.dato.numero);
		  numeroMasEdad(a^.hi, maxEdad,maxNum);
		  numeroMasEdad(a^.hd, maxEdad,maxNum);
	   end; 
	end;

var maxEdad, maxNum: integer;
begin
  writeln;
  writeln ('----- Informar Numero Socio Con Mas Edad ----->');
  writeln;
  maxEdad := -1;
  NumeroMasEdad (a, maxEdad, maxNum);
  if (maxEdad = -1) 
  then writeln ('Arbol sin elementos')
  else begin
         writeln;
         writeln ('Numero de socio con mas edad: ', maxNum);
         writeln;
       end;
  writeln;
  writeln ('//////////////////////////////////////////////////////////');
  writeln;
end;

procedure AumentarEdadNumeroImpar (a: arbol);
{Aumentar en 1 la edad de los socios con edad impar e informar la cantidad de socios que se les aumento la edad.}
  
  function AumentarEdad (a: arbol): integer;
  var resto: integer;
  begin
     if (a = nil) 
     then AumentarEdad:= 0
     else begin
            resto:= a^.dato.edad mod 2;
            if (resto = 1) then a^.dato.edad:= a^.dato.edad + 1;
            AumentarEdad:= resto + AumentarEdad (a^.HI) + AumentarEdad (a^.HD);
          end;  
  end;

begin
  writeln;
  writeln ('----- Cantidad de socios con edad aumentada ----->');
  writeln;
  writeln ('Cantidad: ', AumentarEdad (a));
  writeln;
  writeln;
  writeln ('//////////////////////////////////////////////////////////');
  writeln;
end;


procedure InformarSociosOrdenCreciente (a: arbol);
{ Informar los datos de los socios en orden creciente. }
  
  procedure InformarDatosSociosOrdenCreciente (a: arbol);
  begin
    if (a <> nil) then begin
        InformarDatosSociosOrdenCreciente (a^.HI);
        writeln ('Numero: ', a^.dato.numero, ' Nombre: ', a^.dato.nombre, ' Edad: ', a^.dato.edad);
        InformarDatosSociosOrdenCreciente (a^.HD);
    end;
  end;

Begin
 writeln;
 writeln ('----- Socios en orden creciente por numero de socio ----->');
 writeln;
 InformarDatosSociosOrdenCreciente (a);
 writeln;
 writeln ('//////////////////////////////////////////////////////////');
 writeln;
end;

procedure InformarSociosOrdenDecreciente(a: arbol);

	procedure InformarDatosSociosOrdenDecreciente (a: arbol);
	begin
		if (a <> nil) then begin
			InformarDatosSociosOrdenDecreciente(a^.HD);
			writeln ('Numero: ', a^.dato.numero, ' Nombre: ', a^.dato.nombre, ' Edad: ', a^.dato.edad);
			InformarDatosSociosOrdenDecreciente (a^.HI);
			
		end;
	end;
begin
 writeln;
 writeln ('----- Socios en orden Decreciente por numero de socio ----->');
 writeln;
 InformarDatosSociosOrdenDecreciente (a);
 writeln;
 writeln ('//////////////////////////////////////////////////////////');
 writeln;
end;

procedure InformarExistenciaNombreSocio(a: arbol);
	
	function existe (a: arbol; n: string): boolean;
	begin
		if (a = nil) then existe:= false
		else if (a^.dato.nombre = n) then 
			existe:= true
		else if (existe(a^.HI, n)) then
			existe:= true
		else
			existe:= existe(a^.HD, n);
	end;
var
	n: string;
begin
	writeln('Ingrese un nombre a buscar');
	readln(n);
	
	if (existe(a, n)) then 
		writeln('existe')
	else
		writeln('no existe');
end;

function contar (a: arbol): integer;
begin
	if (a = nil) then
		contar:= 0
	else contar:= 1 + contar(a^.HI) + contar(a^.HD);
end;

procedure InformarCantidadSocios(a: arbol);	
begin
	writeln('cantidad total de socios: ', contar(a));
end;

procedure InformarPromedioDeEdad (a: arbol);
	
	function sumaEdades (a: arbol): integer;
	begin
		if (a = nil) then
			sumaEdades:= 0
		else
			sumaEdades:= a^.dato.edad + sumaEdades(a^.HI) + sumaEdades(a^.HD);
	end;
var
	total: integer;
begin
	total:= sumaEdades(a);
	writeln('el promedio de edad es de: ', total / contar(a), ' años');
end;

function retornarNumSocioMayor (a: arbol): integer;
begin
	if (a = nil) then
		retornarNumSocioMayor:= 0
	else if (a^.HD = nil) then
		retornarNumSocioMayor:= a^.dato.numero
	else
		retornarNumSocioMayor:= retornarNumSocioMayor(a^.HD)
end;

procedure retornarDatosNumSocioMenor (a: arbol);
begin
	if (a^.HI = nil) then
		writeln('codigo ', a^.dato.numero, ' edad ', a^.dato.edad, ' nombre: ', a^.dato.nombre)
	else
		retornarDatosNumSocioMenor(a^.HI);
end;

function existeSocio (a: arbol; cod: integer): boolean;
begin
	if (a = nil) then
		existeSocio:= false
	else if (a^.dato.numero = cod) then
		existeSocio:= true
	else if (cod > a^.dato.numero) then
		existeSocio:= existeSocio(a^.HD, cod)
	else
		existeSocio:= existeSocio(a^.HI, cod);
end;

function cantSociosEntre(a: arbol; num1, num2: integer): integer;
begin
    if (a = nil) then
        cantSociosEntre:= 0
    else if (a^.dato.numero < num1) then
        cantSociosEntre:= cantSociosEntre(a^.HD, num1, num2)
    else if (a^.dato.numero > num2) then
        cantSociosEntre:= cantSociosEntre(a^.HI, num1, num2)
    else
        cantSociosEntre:= 1 + cantSociosEntre(a^.HI, num1, num2) + cantSociosEntre(a^.HD, num1, num2);
end;
var
	a: arbol;
	cod: integer;
	num1, num2: integer;
Begin
	randomize;
	GenerarArbol (a);
	InformarSociosOrdenCreciente (a);
	InformarSociosOrdenDecreciente (a);
	InformarNumeroSocioConMasEdad (a);
	AumentarEdadNumeroImpar (a);
	InformarSociosOrdenCreciente (a);
	InformarExistenciaNombreSocio (a);
	InformarCantidadSocios (a);
	InformarPromedioDeEdad (a);
	writeln('el mayor numero de socio es el ', retornarNumSocioMayor(a));
	retornarDatosNumSocioMenor(a);
  
	writeln('ingrese un codigo a buscar');
	readln(cod);
	if (existeSocio(a, cod) = true) then
		writeln('existe')
	else
		writeln('no existe');
	
	writeln('ingresa un numero minimo');
	readln(num1);
	writeln('ingresa un numero maximo');
	readln(num2);
	
	writeln('la cantidad de socios entre esos numeros son de ', cantSociosEntre(a, num1, num2))
End.

