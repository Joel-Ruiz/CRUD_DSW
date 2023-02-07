import java.util.ArrayList;

public class ImprimirDatos {
    
    public void imprimirClientes(ArrayList<String> listaClientes, ArrayList<String>listaCuentas){
        for(int i=0; i<listaClientes.size();i++){
            String[] datosCliente = listaClientes.get(i).split(",");
            System.out.println("N. Cliente: "+datosCliente[0]+" Nombre: "+datosCliente[1]);
            System.out.println("Cuentas del Cliente: ");
            imprimirCuentasCliente(listaCuentas, datosCliente[0]);
        }
    }

    private void imprimirCuentasCliente (ArrayList<String> listaCuentas, String numeroCliente){
        for(int i=0; i<listaCuentas.size();i++){
            String[] datosCuentas = listaCuentas.get(i).split(",");
            
            if (datosCuentas[0].equals(numeroCliente)){
                System.out.println("Num. Cuenta: "+datosCuentas[1]+" Saldo: "+datosCuentas[2]);
            }
        }
    }
}
