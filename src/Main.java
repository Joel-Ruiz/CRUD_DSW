import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
      
      String nombreArchivoClientes = "clientes.txt";
      String nombreArchivoCuentas = "cuentas.txt";
      LectorArchivo lector = new LectorArchivo();
      ArrayList<String> listaClientes = new ArrayList<String>();
      ArrayList<String> listaCuentas = new ArrayList<String>();

      lector.leerArchivo(nombreArchivoClientes, listaClientes);
      lector.leerArchivo(nombreArchivoCuentas, listaCuentas);

      for(int i=0; i<listaClientes.size();i++){

        String[] datosCliente = listaClientes.get(i).split(",");
        System.out.println("Num. Cliente: "+datosCliente[0]+" Nombre: "+datosCliente[1]);

        for(i=0; i<listaCuentas.size();i++){

          String[] datosCuentas = listaCuentas.get(i).split(",");
          
          if (datosCuentas[0].equals(datosCliente[0])){
            System.out.println("Num. Cuenta: "+datosCuentas[1]+" Saldo: "+datosCuentas[2]);
          }
        }
      }

      EscritorArchivo aniadirAlArchivo = new EscritorArchivo();
      Cliente clienteNuevo = new Cliente();
      Cuenta cuentaNueva = new Cuenta();
      ValidadorCliente validarCliente = new ValidadorCliente();
      ValidadorCuenta validarCuenta = new ValidadorCuenta();

      clienteNuevo.setNumCliente("1234467000033300");
      clienteNuevo.setNombreCliente("Augusto Quintal");


      if(validarCliente.validarCliente(clienteNuevo))
        aniadirAlArchivo.aniadirCliente(nombreArchivoClientes, clienteNuevo);
      
      
      cuentaNueva.setNumCliente(clienteNuevo.numCliente);
      cuentaNueva.setNumCuenta("1200343454005670");
      cuentaNueva.setSaldoCuenta("15000");

      if(validarCuenta.validarCuenta(cuentaNueva))
        aniadirAlArchivo.aniadirCuenta(nombreArchivoCuentas, cuentaNueva);
    }
  }
