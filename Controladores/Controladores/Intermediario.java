import java.util.ArrayList;
import java.util.Scanner;

public class Intermediario {
    
    public static void modificarArchivo(ArrayList<Cliente> listaClientes, ArrayList<Cuenta> listaCuentas,String archivoCuenta, String archivoCliente){
        
        
        ModificarArchivo modificarArchivo = new ModificarArchivo();
        Scanner scanner = new Scanner(System.in);
        EliminarDatos eliminador = new EliminarDatos();

        int opcion = 0;
        String clave;
        do {
            System.out.println("Selecciona una operacion: ");
            System.out.println("1: Eliminar Cliente\n2: Eliminar cuenta\n3: Modificar nombre de cliente\n4: Salir");
            opcion = scanner.nextInt();

            
            
            switch(opcion){
                case 1:
                    

                    scanner.nextLine();
                    System.out.println("Clave de cliente: ");
                    clave = scanner.nextLine();
                    eliminador.eliminarCliente(listaClientes, clave);
                    eliminador.eliminarCuenta(listaCuentas, clave, "0", 1);
                    modificarArchivo.ModificarArchivoClientes(archivoCliente, listaClientes);
                    modificarArchivo.ModificarArchivoCuentas(archivoCuenta, listaCuentas);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Clave de cuenta: ");
                    clave = scanner.nextLine();
                    eliminador.eliminarCuenta(listaCuentas,"0", clave, 2);
                    modificarArchivo.ModificarArchivoCuentas(archivoCuenta, listaCuentas);
                case 3:
                    ModificarDatos modificador = new ModificarDatos();
                    scanner.nextLine();
                    System.out.println("Clave de cliente: ");
                    clave = scanner.nextLine();
                    System.out.println("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    modificador.modificarNombreCliente(listaClientes, clave, nuevoNombre);
                    break;
                default:
                    break;
            }
            scanner.nextLine();
        } while (opcion != 4);
        
    }

    public static void añadirDatos(ArrayList<Cliente> listaClientes, ArrayList<Cuenta> listaCuentas, String archivoCuenta, String archivoCliente){
        EscritorArchivo aniadirAlArchivo = new EscritorArchivo();
        ValidadorCliente validarCliente = new ValidadorCliente();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String claveCliente;
        do{
            System.out.println("Selecciona una operacion: ");
            System.out.println("1: Añadir cliente\n2: Añadir cuenta\n3: Salir");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    Cliente clienteNuevo = new Cliente();
                    
                    scanner.nextLine();
                    System.out.println("Clave de cliente (16 digitos): ");
                    claveCliente = scanner.nextLine();
                    System.out.println("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
        
                    if (validarCliente.clienteUnico(claveCliente, listaClientes)){
                        clienteNuevo.setNumCliente(claveCliente);
                        clienteNuevo.setNombreCliente(nombre);
                        if (validarCliente.validarCliente(clienteNuevo)){
                            listaClientes.add(clienteNuevo);
                            aniadirAlArchivo.aniadirCliente(archivoCliente, clienteNuevo);
                        }
                    }
                    break;
                case 2:
                    Cuenta cuentaNueva = new Cuenta();
                    ValidadorCuenta validarCuenta = new ValidadorCuenta();
                    
                    scanner.nextLine();
                    System.out.println("Clave de cliente (16 digitos): ");
                    claveCliente = scanner.nextLine();
                    System.out.println("Clave de cuenta (16 digitos): ");
                    String claveCuenta = scanner.nextLine();
                    System.out.println("Saldo de la cuenta(ejm. 0.00): ");
                    String saldoCuenta = scanner.nextLine();

                    if (!validarCliente.clienteUnico(claveCliente, listaClientes)){
                        if(validarCuenta.cuentaUnica(claveCuenta, listaCuentas)){
                            cuentaNueva.setNumCliente(claveCliente);
                            cuentaNueva.setNumCuenta(claveCuenta);
                            cuentaNueva.setSaldoCuenta(saldoCuenta);
                            if(validarCuenta.validarCuenta(cuentaNueva)){
                                listaCuentas.add(cuentaNueva);
                                aniadirAlArchivo.aniadirCuenta(archivoCuenta, cuentaNueva);
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
            
            scanner.nextLine();
        }while(opcion != 3);
    }

    
}
