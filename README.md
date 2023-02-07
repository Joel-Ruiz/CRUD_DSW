# Prueba de desempeño Unidad 1
Este proyecto en java se trata de la ultima version disponible de mi propia implementacion del CRUD para clientes y cuentas
## Descripcion del proyecto

Este proyecto usa la arquitectura `Modelo-Vista-Controlador` como base, sin el uso de un paquete Vista. El proyecto se encuentra distribuido en los paquetes:
```
+Main
+Controladores
+Validadores
+Modelo
```

### Main
La carpeta Main solo contiene la clase `Main` desde la que se inicializa el programa. Desde aqui se abren y leen los archivos usados como BD del programa, se llama a la clase `ImprimirDatos` para llevar a cabo la impresion en pantallas de los usuarios con sus cuentas asociadas y se llama la clase `Intermediario` que realiza la Creación, Eliminación, Modificación y Lectura de los archivos.

### Controladores
Contiene todas las clases que realizan las operacionesd del programa, la Creación, Eliminación, Modificación y Lectura de los objetos `Cliente` y `Cuenta`, asi como la lectura y escritura de los archivos  TXT que utiliza el programa como BD. 

### Validadores
Contiene las dos clases de validadores `ValidadorClientes` y `ValidadorCuentas` que, como su nombre indican, contienen los metodos para validar que la informacion de las cuentas y clientes que se añadan tengan el formato correcto . Tambien verifican si el cliente o la cuenta a crear ya existen.

### Modelo
Contiene los modelos de los dos tipos de objetos utilizados por le programa, el `Cliente` y `Cuenta`, asi como sus metodos para *setear* los datos de cada objeto.

## Conceptos generales de diseño
```
1. Ocultamiento de la información
2. Modularidad
3. Acoplamiento y cohesion
```
### 1. Ocultamiento de la información
Podemos visualizar el concepto general de diseño del `ocultamiento de la informacion` descrito en ***SWEBOK V3.0*** de la `IEEE` definido como el agrupar y empaquetar los detalles internos de una abstracción y hacerlos inaccesibles para entidades externas. Esto lo podemos observar en las clases `ValidadorClientes` y `ValidadorCuentas`.

```
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
```
En el bloque de codigo anterior de la clase  `ValidadorCuentas` podemos observar que el unico método accesible fuera de la clase es `validarCuenta`, y los otros métodos `validarNumCuenta`, que valida el hecho de que la clave de la cuenta tenga los 16 digitos correspondientes y no hayan letras; y `validarSaldoCuenta`, que valida que el saldo sea un flotante; son metodos privados de la clase, unicamente accesible por `validarCuenta` y a los que ninguna entidad externa puede acceder.

### 2. Modularidad
El concepto general de diseño `modularización` descrito en ***SWEBOK V3.0*** de la `IEEE` lo define como la tecnica de dividir un software extenso en pequeñas piesas de codigo denominadas componentes. Podemos identificarlo en la mayoria del programa como por ejemplo en la clase `ImprimirDatos` como muestra el siguiente bloque de codigo:

```
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
```
En este bloque de codigo podemos observar que, si bien seria posible imprimir tanto las cuentas como los clientes en un mismo metodo e incluso directamente en la clase `Main`, la impresion de tanto clientes como cuentas se encuentra por separado, necesitando un metodo para cada tipo de impresion. El metodo `imprimirCuentasCliente` solo se puede llamar desde `imprimirClientes` para que, al momento de imprimir un Cliente, se imprimieran junto a este todas sus cuentas registradas.

### 3. Acoplamiento y cohesion
El concepto general de diseño `acoplamiento y cohesion` descrito en ***SWEBOK V3.0*** de la `IEEE` lo podemos definir como una medida en la que evaluamos que tan relacionados estan las operaciones que realiza un componente (acoplamiento) y que tan relacionados estan un cierto modulo con el resto de modulos del programa (acoplamiento). Se puede ejemplificar en la clase `EscritorArchivo` como se muestra en el siguinete bloque de codigo:

```
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
```

En cuention a la cohesion que estos modulos exhiben, podemos decir que tienen unan alta cohesion ya que estos modulos, tanto `aniadirCliente` como `aniadirCuenta` solo realizan una unica operacion, la cual es escribir una linea en el archivo que se determine. En cuanto al acomplamiento, podemos decir que tienen un bajo acomplamiento ya que, si bien seria necesario modificar el objeto que reciben de ser necesario, es posible tomar cualquier modulo y reutilizarlo en otro programa sin la necesidad de una gran modificacion.


## Actividad de diseño
## Elemento de diseño
## Error de diseño 