package Controladores;

import java.util.ArrayList;

public class ConvertirDatos {
    
    static ArrayList<Cliente> convertirCliente(ArrayList<String>listaClientes){
        ArrayList<Cliente> nuevavListaClientes = new ArrayList<Cliente>();
        Cliente cliente = new Cliente();

        for(int i=0; i<listaClientes.size();i++){
            String[] datosCliente = listaClientes.get(i).split(",");
            cliente.setNumCliente(datosCliente[0]);
            cliente.setNombreCliente(datosCliente[1]);
            nuevavListaClientes.add(cliente);
        }

        return nuevavListaClientes;
    }

    static ArrayList<Cuenta> convertirCuenta(ArrayList<String>listaCuentas){
        ArrayList<Cuenta> nuevavListaCuentas = new ArrayList<Cuenta>();
        Cuenta cuenta = new Cuenta();

        for(int i=0; i<listaCuentas.size();i++){
            String[] datosCliente = listaCuentas.get(i).split(",");
            cuenta.setNumCliente(datosCliente[0]);
            cuenta.setNumCuenta(datosCliente[1]);
            cuenta.setSaldoCuenta(datosCliente[2]);
            nuevavListaCuentas.add(cuenta);
        }

        return nuevavListaCuentas;
    }
}
