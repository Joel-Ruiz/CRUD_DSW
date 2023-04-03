import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ModificarArchivo {
    
    void ModificarArchivoClientes (String nombreArchivo, ArrayList<Cliente> listaClientes){
        EscritorArchivo escritor = new EscritorArchivo();
        vaciarArchivo(nombreArchivo);

        for (int i = 0;i<listaClientes.size();i++){
            escritor.aniadirCliente(nombreArchivo, listaClientes.get(i));
        }
    }

    void ModificarArchivoCuentas (String nombreArchivo, ArrayList<Cuenta> listaCuentas){
        EscritorArchivo escritor = new EscritorArchivo();
        vaciarArchivo(nombreArchivo);

        for (int i = 0;i<listaCuentas.size();i++){
            escritor.aniadirCuenta(nombreArchivo, listaCuentas.get(i));
        }
    }

    private void vaciarArchivo (String nombreArchivo){
    try (FileOutputStream fos = new FileOutputStream(nombreArchivo, false)) { }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
