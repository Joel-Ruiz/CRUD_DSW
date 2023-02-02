public class ValidadorCliente {
    
    public boolean validarCliente(Cliente cliente){
        String numCliente = cliente.getNumCliente();
        String nombreCliente = cliente.getNombreCliente();

        boolean clienteValido = validarNumCliente(numCliente) && validarNombreCliente(nombreCliente);

        if(clienteValido){
            System.out.println("Cliente validado");
            return true;
        }else{
            System.out.println("Fallo de validacion: cliente");
            return false;
        }
    }

    int TAMANO_NUM = 16;
    boolean validarNumCliente(String numCliente){
        if(numCliente.isEmpty() || numCliente.length() != TAMANO_NUM ){
            System.out.println("El numero de cliente es invalido o esta incompleto");
            return false;
        }else if (numCliente.matches("[0-9]+")){
            return true;
        }
        System.out.println("El numero de cliente no puede contener letras");
        return false;
    }

    

    boolean validarNombreCliente(String nombreCliente){
        if(nombreCliente.isEmpty()){
            System.out.println("El nombre del cliente es invalido");
            return false;
        }else if(nombreCliente.matches("^([A-Z]{1}[a-z]+[ ]?){1,4}$")){
            return true;
        }
        System.out.println("El nombre del cliente no puede contener numeros");
        return false;
    }

    
}
