import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Local local = new Local();
        Empleado empleado = new Empleado(local);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1 - Registrar productos nacionales");
            System.out.println("2 - Registrar productos importados");
            System.out.println("3 - Listar productos nacionales");
            System.out.println("4 - Listar productos importados");
            System.out.println("5 - Buscar producto nacional");
            System.out.println("6 - Buscar producto importado");
            System.out.println("0 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarProductoNacional(local, scanner);
                    break;
                case 2:
                    registrarProductoImportado(local, scanner);
                    break;
                case 3:
                    listarProductosNacionales(local);
                    break;
                case 4:
                    listarProductosImportados(local);
                    break;
                case 5:
                    buscarProductoNacional(local, scanner);
                    break;
                case 6:
                    buscarProductoImportado(local, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    public static void registrarProductoNacional(Local local, Scanner scanner) {
        System.out.print("Ingrese el código del producto nacional: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del producto nacional: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el registro DIAN del producto nacional: ");
        String registroDIAN = scanner.nextLine();

        Nacional productoNacional = new Nacional(codigo, nombre, registroDIAN);
        local.agregarProducto(productoNacional);
        System.out.println("Producto nacional registrado con éxito.");
    }

    public static void registrarProductoImportado(Local local, Scanner scanner) {
        System.out.print("Ingrese el código del producto importado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del producto importado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la licencia de importación del producto importado: ");
        String licenciaImportacion = scanner.nextLine();

        Importado productoImportado = new Importado(codigo, nombre, licenciaImportacion);
        local.agregarProducto(productoImportado);
        System.out.println("Producto importado registrado con éxito.");
    }

    public static void listarProductosNacionales(Local local) {
        System.out.println("Productos nacionales:");
        for (Producto producto : local.getProductos()) {
            if (producto instanceof Nacional) {
                Nacional nacional = (Nacional) producto;
                System.out.println("Código: " + nacional.getCodigo() + ", Nombre: " + nacional.getNombre() +
                        ", Registro DIAN: " + nacional.getRegistroDIAN());
            }
        }
    }

    public static void listarProductosImportados(Local local) {
        System.out.println("Productos importados:");
        for (Producto producto : local.getProductos()) {
            if (producto instanceof Importado) {
                Importado importado = (Importado) producto;
                System.out.println("Código: " + importado.getCodigo() + ", Nombre: " + importado.getNombre() +
                        ", Licencia de Importación: " + importado.getLicenciaImportacion());
            }
        }
    }

    public static void buscarProductoNacional(Local local, Scanner scanner) {
        System.out.print("Ingrese el código del producto nacional a buscar: ");
        int codigoABuscar = scanner.nextInt();
        scanner.nextLine();

        for (Producto producto : local.getProductos()) {
            if (producto instanceof Nacional && producto.getCodigo() == codigoABuscar) {
                Nacional nacional = (Nacional) producto;
                System.out.println("Producto nacional encontrado - Nombre: " + nacional.getNombre() +
                        ", Registro DIAN: " + nacional.getRegistroDIAN());
                return;
            }
        }
        System.out.println("Producto nacional no encontrado.");
    }

    public static void buscarProductoImportado(Local local, Scanner scanner) {
        System.out.print("Ingrese el código del producto importado a buscar: ");
        int codigoABuscar = scanner.nextInt();
        scanner.nextLine();

        for (Producto producto : local.getProductos()) {
            if (producto instanceof Importado && producto.getCodigo() == codigoABuscar) {
                Importado importado = (Importado) producto;
                System.out.println("Producto importado encontrado - Nombre: " + importado.getNombre() +
                        ", Licencia de Importación: " + importado.getLicenciaImportacion());
                return;
            }
        }
        System.out.println("Producto importado no encontrado.");
    }
}