package Modelo;

public class Cliente {
    String numCliente;
    String nombreCliente;

    public Cliente(String numCliente, String nombreCliente) {
        this.numCliente = numCliente;
        this.nombreCliente = nombreCliente;
    }
    
    public Cliente(){

    }

    public String getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(String numCliente) {
        this.numCliente = numCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return "\n" + numCliente + "," + nombreCliente;
    }

}
