public class Cuenta {
    String numCliente;
    String numCuenta;
    String saldoCuenta;

    public Cuenta(String numCliente, String numCuenta, String saldoCuenta) {
        this.numCliente = numCliente;
        this.numCuenta = numCuenta;
        this.saldoCuenta = saldoCuenta;
    }

    public Cuenta(){

    }

    public String getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(String numCliente) {
        this.numCliente = numCliente;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(String saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    @Override
    public String toString() {
        return "\n" + numCliente + "," + numCuenta + "," + saldoCuenta;
    }

    
}
