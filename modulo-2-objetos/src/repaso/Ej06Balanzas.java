package repaso;

/*
 * 6- Queremos representar dos versiones de balanzas comerciales para ser
 * utilizadas en verdulerías. La versión básica mantiene el número de compra
 * actual y los productos correspondientes a la compra actual (como máximo 30).
 * La versión avanzada, es igual a la básica pero además mantiene dos contadores
 * para la compra actual: uno cuenta la cantidad de productos de verdulería y
 * otro la cantidad de productos de frutería. De los productos se conoce:
 * descripción, rubro (indica si es verdura o fruta), peso en kilos y precio
 * por kilo. Ambas versiones, al finalizar una compra, emiten un Ticket con
 * nro. de compra, resumen (String) y monto total a pagar.
 *
 * a) Genere las clases necesarias. Provea constructores para iniciar los
 *    objetos de su modelo a partir de la información necesaria. En particular,
 *    las balanzas inician con número de compra actual 1, sin productos, con
 *    capacidad de guardar un máximo de 30 productos; además, la versión
 *    avanzada inicia con sus contadores a 0.
 *
 * b) Implemente los métodos necesarios, en las clases que corresponda, para:
 *    i-   Reiniciar la balanza, preparándola para una nueva compra. Para esto:
 *         incrementa el nro. de compra actual y borra los productos
 *         almacenados; además, la versión avanzada reinicia sus contadores a 0.
 *    ii-  Registrar un producto, esto es: agrega el producto en la balanza;
 *         además la versión avanzada debe incrementar el contador adecuado
 *         según este producto sea verdura o fruta.
 *    iii- Obtener el monto total a pagar por la compra, teniendo en cuenta que
 *         es la suma de los precios finales de los productos cargados (el
 *         precio final de un producto es peso_en_kilos*precio_por_kilo).
 *    iv-  Finalizar la compra, teniendo en cuenta que: la balanza de versión
 *         básica crea y retorna un Ticket con nro. de compra, resumen (que
 *         concatena de cada producto: descripción y su precio final), y monto
 *         total de la compra; además la balanza de versión avanzada añade al
 *         resumen de ese Ticket la cantidad de frutas y cantidad de verduras
 *         de la compra.
 *
 * c) Realice un programa que instancie dos balanzas (una básica y una
 *    avanzada). Registre algunos productos en cada balanza. Finalice la compra
 *    en cada balanza y muestre todos los datos de los tickets obtenidos.
 *    Luego, reinicie cada balanza para una nueva compra.
 */
public class Ej06Balanzas {
    public static void main(String[] args) {
        // Balanza básica
        Balanza b = new Balanza();
        b.agregarProducto(new Producto("Papa", "verdura", 2.0, 800.0));
        b.agregarProducto(new Producto("Manzana", "fruta", 1.5, 1500.0));
        b.agregarProducto(new Producto("Lechuga", "verdura", 0.5, 1200.0));
        System.out.println("=== BÁSICA ===");
        System.out.println(b.finalizarCompra());

        // Segunda compra, debería salir con nro 2
        b.agregarProducto(new Producto("Banana", "fruta", 1.0, 1300.0));
        System.out.println(b.finalizarCompra());

        // Balanza avanzada
        BalanzaAvanzada ba = new BalanzaAvanzada();
        ba.agregarProducto(new Producto("Tomate", "verdura", 1.0, 2000.0));
        ba.agregarProducto(new Producto("Naranja", "fruta", 2.0, 900.0));
        ba.agregarProducto(new Producto("Pera", "fruta", 1.0, 1700.0));
        System.out.println("\n=== AVANZADA ===");
        System.out.println(ba.finalizarCompra());

        // Segunda compra: contadores reiniciados
        ba.agregarProducto(new Producto("Cebolla", "verdura", 1.0, 700.0));
        System.out.println(ba.finalizarCompra());
    }
}