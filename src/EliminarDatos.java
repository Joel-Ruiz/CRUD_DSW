import java.util.ArrayList;

public class EliminarDatos {
    void eliminarCliente(ArrayList<Cliente> listaClientes, String claveCliente){
        ArrayList<Cliente> listaClientesTemp = new ArrayList<Cliente>();
        int i;

        for (i = 0; i<listaClientes.size();i++){
            if(claveCliente != listaClientes.get(i).numCliente){
                listaClientesTemp.add(listaClientes.get(i));
            }
        }
        listaClientes.clear();
        for(i=0;i<listaClientesTemp.size();i++){
            listaClientes.add(listaClientesTemp.get(i));
        }
    }

    void eliminarCuenta(ArrayList<Cuenta> listaCuentas, String claveCliente, String claveCuenta, int opcionCuenta){
        ArrayList<Cuenta> listaCuentasTemp = new ArrayList<Cuenta>();
        int i;
        if (opcionCuenta == 1){
            for (i = 0; i<listaCuentas.size();i++){
                if(claveCliente != listaCuentas.get(i).numCliente)
                    listaCuentasTemp.add(listaCuentas.get(i));
            }
            listaCuentas.clear();
            for(i=0;i<listaCuentasTemp.size();i++){
                listaCuentas.add(listaCuentasTemp.get(i));
            }
        }else if (opcionCuenta == 2){
            for (i = 0; i<listaCuentas.size();i++){
                if(claveCuenta != listaCuentas.get(i).numCuenta)
                    listaCuentasTemp.add(listaCuentas.get(i));
            }
            listaCuentas.clear();
            for(i=0;i<listaCuentasTemp.size();i++){
                listaCuentas.add(listaCuentasTemp.get(i));
            }
        }
        
    }
}
