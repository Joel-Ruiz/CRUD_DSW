package Validadores;
import java.util.ArrayList;
import Modelo.*;

public class ValidadorCuenta {
    
    public boolean validarCuenta(Cuenta cuenta){
        String numCuenta = cuenta.getNumCuenta();
        String saldoCuenta = cuenta.getSaldoCuenta();

        boolean cuentaValida = validarNumCuenta(numCuenta) && validarSaldoCuenta(saldoCuenta);

        if(cuentaValida){
            System.out.println("Cuenta validada");
            return true;
        }else{
            System.out.println("Fallo de validacion: cuenta");
            return false; 
        }

    }
    
    int TAMANO_NUM = 16;
    private boolean validarNumCuenta(String numCuenta){
        if(numCuenta.isEmpty() || numCuenta.length() != TAMANO_NUM){
            System.out.println("El numero de cuenta es invalido o esta incompleto");
            return false;
        }else if(numCuenta.matches("[0-9]+")){
            return true;
        }
        System.out.println("El numero de cuenta no puede contener letras");
        return false;
    }

    private boolean validarSaldoCuenta (String saldoCuenta){
        try {
            float validarSaldo = Float.parseFloat(saldoCuenta);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean cuentaUnica(String numCuenta, ArrayList<Cuenta> listaCuentas){
        for (int i = 0; i<listaCuentas.size();i++){
            if(numCuenta.equals(listaCuentas.get(i).numCuenta)){
                System.out.println("La cuenta ya existe");
                return false;
            }
        }
        return true;
    }
}
