{
3.- Escribir un programa que invoque a los siguientes módulos e informe el resultado:

a. Un módulo recursivo que retorne un vector de a lo sumo 20 caracteres que conformen una
palabra. La lectura de los caracteres termina en ‘.’

b. Un módulo recursivo que reciba la “palabra” generada en a) y determine si dicha palabra es
un palíndromo, es decir, si puede leerse de la misma manera de izquierda a derecha que de
derecha a izquierda. Este módulo debe retornar el valor booleano correspondiente.
}

program programa03;
const
	DIMF = 20;
type
	vector = array[1..DIMF] of char;
	
	
procedure cargarVector (var v: vector;  var diml: integer);
var
	c: char;
begin
	readln(c);
	if (diml < DIMF) and (c <> '.') then begin
		diml:= diml + 1;
		v[diml]:= c;
		cargarVector(v, diml);
	end;
end;
	
	
function palindromo (v: vector; ini, fin: integer): boolean;
begin
	if ini >= fin then
		palindromo:= true
	else if v[ini] = v[fin] then
		palindromo:= palindromo(v, ini + 1, fin - 1)
	else
		palindromo:= false
end;
	
var
	v: vector;
	diml: integer;
	ok: boolean;
	
begin
	diml:= 0;
	cargarVector(v, diml);
	ok:= palindromo(v, 1, diml);
	
	if ok then writeln('es palindromo')
	else writeln('no es palindromo');
end.
