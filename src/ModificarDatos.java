import java.util.ArrayList;

public class ModificarDatos {
    void modificarNombreCliente (ArrayList<Cliente> listaClientes, String claveCliente, String nuevoNombreCliente){

        for(int i = 0; i<listaClientes.size();i++){
            if(claveCliente == listaClientes.get(i).numCliente)
                listaClientes.get(i).setNombreCliente(nuevoNombreCliente);
        }
    }

    void modificarSaldoCuenta (ArrayList<Cuenta> listaCuentas, String claveCuenta, String nuevoSaldoCuenta){
        for(int i = 0; i<listaCuentas.size();i++){
            if(claveCuenta == listaCuentas.get(i).numCuenta)
                listaCuentas.get(i).setSaldoCuenta(nuevoSaldoCuenta);
        }
    }
}
