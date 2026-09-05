{
4. Implementar un programa que contenga:

a. Un módulo que lea información de los finales rendidos por los alumnos de la Facultad de
Informática y los almacene en una estructura de datos. La información que se lee es legajo
(1000 a 1050), código de materia (1 a 25), fecha y nota. La lectura de los alumnos finaliza con
legajo 0. La estructura generada debe ser eficiente para la búsqueda por número de legajo y
para cada alumno deben guardarse los finales que rindió en una lista. Nota: No repetir
información!!!

b. Un módulo que reciba la estructura generada en a. e informe, para cada alumno, su legajo y
su cantidad de finales aprobados (nota mayor o igual a 4).

c. Un módulo que reciba la estructura generada en a. y un código de materia. El módulo debe
retornar la cantidad de alumnos que aprobó la materia recibida y la cantidad de alumnos que
desaprobó la materia recibida.

d. Un módulo que reciba la estructura generada en a. y un valor entero. Este módulo debe
retornar la cantidad de alumnos con cantidad de finales rendidos igual al valor entero recibido
}

program programa04;

type
    tfinal = record
        cod_materia: 1..25;
        fecha: integer;
        nota: real;
    end;

    lista = ^nodoLista;
    nodoLista = record
        dato: tfinal;
        sig: lista;
    end;

    alumnoInfo = record
        legajo: 1000..1050;
        finales: lista;
    end;

    arbol = ^nodoArbol;
    nodoArbol = record
        dato: alumnoInfo;
        HI: arbol;
        HD: arbol;
    end;

procedure agregarLista(var l: lista; f: tfinal);
var
    nue: lista;
begin
    new(nue);
    nue^.dato:= f;
    nue^.sig:= l;
    l:= nue;
end;

procedure agregarArbol(var a: arbol; f: tfinal; leg: integer);
var
    nue: arbol;
begin
    if (a = nil) then begin
        new(nue);
        nue^.dato.legajo:= leg;
        nue^.dato.finales:= nil;
        agregarLista(nue^.dato.finales, f);
        nue^.HI:= nil;
        nue^.HD:= nil;
        a:= nue;
    end
    else if (leg = a^.dato.legajo) then
        agregarLista(a^.dato.finales, f)
    else if (leg < a^.dato.legajo) then
        agregarArbol(a^.HI, f, leg)
    else
        agregarArbol(a^.HD, f, leg);
end;

procedure leerFinales(var a: arbol);
var
    f: tfinal;
    legajo: integer;
begin
    if (random(20) = 0) then
        legajo:= 0
    else
        legajo:= random(51) + 1000;

    if (legajo <> 0) then begin
        f.cod_materia:= random(25) + 1;
        f.fecha:= random(100);
        f.nota:= random(11);
        agregarArbol(a, f, legajo);
        leerFinales(a);
    end;
end;

function cantFinalesApro(l: lista): integer;
begin
    if (l = nil) then
        cantFinalesApro:= 0
    else if (l^.dato.nota >= 4) then
        cantFinalesApro:= 1 + cantFinalesApro(l^.sig)
    else
        cantFinalesApro:= cantFinalesApro(l^.sig);
end;

procedure aprobadosAlumnos(a: arbol);
begin
    if (a <> nil) then begin
        aprobadosAlumnos(a^.HI);
        writeln('el alumno ', a^.dato.legajo, ' tiene ', cantFinalesApro(a^.dato.finales), ' aprobados');
        aprobadosAlumnos(a^.HD);
    end;
end;

procedure buscarResultadosLista(l: lista; materia: integer; var apro, desa: integer);
begin
    if (l <> nil) then begin
        if (l^.dato.cod_materia = materia) then begin
            if (l^.dato.nota >= 4) then
                apro:= apro + 1
            else
                desa:= desa + 1;
        end;
        buscarResultadosLista(l^.sig, materia, apro, desa);
    end;
end;

procedure resultadosMateria(a: arbol; m: integer; var apro, desa: integer);
begin
    if (a <> nil) then begin
        resultadosMateria(a^.HI, m, apro, desa);
        buscarResultadosLista(a^.dato.finales, m, apro, desa);
        resultadosMateria(a^.HD, m, apro, desa);
    end;
end;

function retornarCantFinales(l: lista): integer;
var
    i: integer;
begin
    i:= 0;
    while (l <> nil) do begin
        i:= i + 1;
        l:= l^.sig;
    end;
    retornarCantFinales:= i;
end;

function cantAlumnosConNFinales(a: arbol; cant: integer): integer;
begin
    if (a = nil) then
        cantAlumnosConNFinales:= 0
    else if (retornarCantFinales(a^.dato.finales) = cant) then
        cantAlumnosConNFinales:= 1 + cantAlumnosConNFinales(a^.HI, cant) + cantAlumnosConNFinales(a^.HD, cant)
    else
        cantAlumnosConNFinales:= cantAlumnosConNFinales(a^.HI, cant) + cantAlumnosConNFinales(a^.HD, cant);
end;

var
    a: arbol;
    m, apro, desa, valor, totalD: integer;

begin
    randomize;
    a:= nil;

    leerFinales(a);

    writeln('----- Finales aprobados por alumno ----->');
    aprobadosAlumnos(a);

    writeln;
    write('Ingrese un codigo de materia (1-25): ');
    readln(m);
    apro:= 0;
    desa:= 0;
    resultadosMateria(a, m, apro, desa);
    writeln('La materia ', m, ' tuvo ', apro, ' aprobados y ', desa, ' desaprobados');

    writeln;
    write('Ingrese una cantidad de finales rendidos a buscar: ');
    readln(valor);
    totalD:= cantAlumnosConNFinales(a, valor);
    writeln('Cantidad de alumnos con exactamente ', valor, ' finales rendidos: ', totalD);
end.
