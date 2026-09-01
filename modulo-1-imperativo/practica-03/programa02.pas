{
2. Escribir un programa que:

a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio.
Para cada venta generar código de producto (entre 1 y 100), fecha (día, mes, año) y cantidad de
unidades vendidas. Finalizar con el código de producto 0. Un producto puede estar en más de
una venta. Se pide:

i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de producto.
Los códigos repetidos van a la derecha.

ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la cantidad
total de unidades vendidas.

iii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo debe contener el código de producto y la lista de las ventas
realizadas del producto. Nota: No repetir información.

Nota: El módulo debe retornar TRES árboles.

b. Implemente un módulo que reciba el árbol generado en i. y una fecha (día, mes y año) y
retorne la cantidad total de productos vendidos en la fecha recibida.

c. Implemente un módulo que reciba el árbol generado en ii. y retorne el código de producto
con mayor cantidad total de unidades vendidas.

d. Implemente un módulo que reciba el árbol generado en iii. y retorne el código de producto
con mayor cantidad de ventas.
}

program programa02;

type
    venta = record
        codigo: 0..100;
        dia: 1..30;
        mes: 1..12;
        anio: 2000..2030;
        unidades: integer;
    end;

    arbol = ^nodo;

    nodo = record
        dato: venta;
        HI: arbol;
        HD: arbol;
    end;

    arbol2 = ^nodo2;

    nodo2 = record
        codigo: 1..100;
        unidades: integer;
        HI: arbol2;
        HD: arbol2;
    end;

    lista = ^nodoLista;

    nodoLista = record
        dato: venta;
        sig: lista;
    end;

    arbol3 = ^nodo3;

    nodo3 = record
        codigo: 1..100;
        ventas: lista;
        HI: arbol3;
        HD: arbol3;
    end;


procedure generarInformacion(var a: arbol);

    procedure insertar(var a: arbol; v: venta);
    var
        nue: arbol;
    begin
        if (a = nil) then
        begin
            new(nue);
            nue^.dato := v;
            nue^.HI := nil;
            nue^.HD := nil;
            a := nue;
        end
        else if (v.codigo < a^.dato.codigo) then
            insertar(a^.HI, v)
        else
            insertar(a^.HD, v);
    end;

var
    v: venta;
begin
    v.codigo := Random(101);

    while (v.codigo <> 0) do
    begin
        v.dia := Random(30) + 1;
        v.mes := Random(12) + 1;
        v.anio := Random(31) + 2000;
        v.unidades := Random(15) + 1;

        insertar(a, v);

        v.codigo := Random(101);
    end;
end;


procedure generarArbolOrdenado(a: arbol; var a2: arbol2);

    procedure insertar2(var a: arbol2; v: venta);
    var
        nue: arbol2;
    begin
        if (a = nil) then
        begin
            new(nue);
            nue^.codigo := v.codigo;
            nue^.unidades := v.unidades;
            nue^.HI := nil;
            nue^.HD := nil;
            a := nue;
        end
        else if (v.codigo < a^.codigo) then
            insertar2(a^.HI, v)
        else if (v.codigo > a^.codigo) then
            insertar2(a^.HD, v)
        else
            a^.unidades := a^.unidades + v.unidades;
    end;

begin
    if (a <> nil) then
    begin
        insertar2(a2, a^.dato);
        generarArbolOrdenado(a^.HI, a2);
        generarArbolOrdenado(a^.HD, a2);
    end;
end;


procedure generarArbolListas(a: arbol; var a3: arbol3);

    procedure insertar3(var a3: arbol3; v: venta);
    var
        nue: arbol3;
        l: lista;
    begin
        if (a3 = nil) then
        begin
            new(nue);
            new(l);

            l^.dato := v;
            l^.sig := nil;

            nue^.codigo := v.codigo;
            nue^.HI := nil;
            nue^.HD := nil;
            nue^.ventas := l;

            a3 := nue;
        end
        else if (a3^.codigo = v.codigo) then
        begin
            new(l);
            l^.sig := a3^.ventas;
            l^.dato := v;
            a3^.ventas := l;
        end
        else if (a3^.codigo < v.codigo) then
            insertar3(a3^.HD, v)
        else
            insertar3(a3^.HI, v);
    end;

begin
    if (a <> nil) then
    begin
        insertar3(a3, a^.dato);
        generarArbolListas(a^.HI, a3);
        generarArbolListas(a^.HD, a3);
    end;
end;


procedure retornarUnidadesDia(a: arbol);

    function retornarCantVentas(a: arbol; d, m, an: integer): integer;
    begin
        if (a = nil) then
            retornarCantVentas := 0
        else if (a^.dato.dia = d) and
                (a^.dato.mes = m) and
                (a^.dato.anio = an) then
            retornarCantVentas :=
                a^.dato.unidades +
                retornarCantVentas(a^.HI, d, m, an) +
                retornarCantVentas(a^.HD, d, m, an)
        else
            retornarCantVentas :=
                retornarCantVentas(a^.HI, d, m, an) +
                retornarCantVentas(a^.HD, d, m, an);
    end;

var
    dia: 1..30;
    mes: 1..12;
    anio: 2000..2030;
begin
    writeln('Ingrese un dia:');
    readln(dia);

    writeln('Ingrese un mes:');
    readln(mes);

    writeln('Ingrese un anio:');
    readln(anio);

    writeln(
        'La cantidad de productos vendidos en el dia fue de: ',
        retornarCantVentas(a, dia, mes, anio)
    );
end;


procedure retornarCodMasUnidades(a: arbol2; var codMas, cantMas: integer);
begin
    if (a <> nil) then
    begin
        if (a^.unidades > cantMas) then
        begin
            codMas := a^.codigo;
            cantMas := a^.unidades;
        end;

        retornarCodMasUnidades(a^.HI, codMas, cantMas);
        retornarCodMasUnidades(a^.HD, codMas, cantMas);
    end;
end;


procedure retornarCodMasVentas(a: arbol3);

    procedure buscarCodMasVentas(a: arbol3; var codMas, cantMas: integer);
    var
        l: lista;
        cantVentas: integer;
    begin
        if (a <> nil) then
        begin
            l := a^.ventas;
            cantVentas := 0;

            while (l <> nil) do
            begin
                cantVentas := cantVentas + 1;
                l := l^.sig;
            end;

            if (cantVentas > cantMas) then
            begin
                cantMas := cantVentas;
                codMas := a^.codigo;
            end;

            buscarCodMasVentas(a^.HI, codMas, cantMas);
            buscarCodMasVentas(a^.HD, codMas, cantMas);
        end;
    end;

var
    codMas: integer;
    cantMas: integer;
begin
    codMas := 0;
    cantMas := 0;

    buscarCodMasVentas(a, codMas, cantMas);

    writeln(
        'El codigo de producto con mayor cantidad de ventas es el ',
        codMas
    );
end;


var
    a: arbol;
    a2: arbol2;
    a3: arbol3;
    codMas: integer;
    cantMas: integer;

begin
    Randomize;

    a := nil;
    a2 := nil;
    a3 := nil;

    codMas := 0;
    cantMas := 0;

    generarInformacion(a);
    generarArbolOrdenado(a, a2);
    generarArbolListas(a, a3);

    retornarUnidadesDia(a);

    retornarCodMasUnidades(a2, codMas, cantMas);

    writeln(
        'El codigo con mas unidades vendidas fue el ',
        codMas,
        ' con ',
        cantMas,
        ' unidades.'
    );

    retornarCodMasVentas(a3);
end.
