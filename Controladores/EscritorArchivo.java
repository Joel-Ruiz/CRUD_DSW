import java.io.FileWriter;

public class EscritorArchivo {

    public void aniadirCliente(String direccionArchivo,Cliente cliente){
        try {
            FileWriter fw = new FileWriter(direccionArchivo, true);    
            String clienteNuevo = cliente.toString();    
            fw.write(clienteNuevo);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void aniadirCuenta(String direccionArchivo, Cuenta cuenta){
        try {
            FileWriter fw = new FileWriter(direccionArchivo, true);    
            String cuentaNueva = cuenta.toString();    
            fw.write(cuentaNueva);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
