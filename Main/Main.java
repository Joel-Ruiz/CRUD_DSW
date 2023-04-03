import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
      
      final String NOMBRE_ARCHIVO_CLIENTES = "clientes.txt";
      final String NOMBRE_ARCHIVO_CUENTAS = "cuentas.txt";

      LectorArchivo lector = new LectorArchivo();
      ArrayList<String> listaClientes = new ArrayList<String>();
      ArrayList<String> listaCuentas = new ArrayList<String>();
      ImprimirDatos imprimir = new ImprimirDatos();

      lector.leerArchivo(NOMBRE_ARCHIVO_CLIENTES, listaClientes);
      lector.leerArchivo(NOMBRE_ARCHIVO_CUENTAS, listaCuentas);

      imprimir.imprimirClientes(listaClientes, listaCuentas);

      ArrayList<Cliente> listaClientesNueva = new ArrayList<Cliente>();
      ArrayList<Cuenta> listaCuentasNueva = new ArrayList<Cuenta>();

      listaClientesNueva = ConvertirDatos.convertirCliente(listaClientes);
      listaCuentasNueva = ConvertirDatos.convertirCuenta(listaCuentas);
      
      Intermediario.añadirDatos(listaClientesNueva, listaCuentasNueva, NOMBRE_ARCHIVO_CUENTAS, NOMBRE_ARCHIVO_CLIENTES);

      Intermediario.modificarArchivo(listaClientesNueva, listaCuentasNueva, NOMBRE_ARCHIVO_CUENTAS, NOMBRE_ARCHIVO_CLIENTES);
    }
  }
