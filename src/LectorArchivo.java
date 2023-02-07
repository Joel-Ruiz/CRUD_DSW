import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorArchivo {

    public void leerArchivo(String direccionArchivo, ArrayList<String> listaDatos){
        
        try{
            Scanner scanner = new Scanner(Paths.get(direccionArchivo));
            String lineaTexto;
            while(scanner.hasNextLine()){
                lineaTexto = scanner.nextLine();
                listaDatos.add(lineaTexto);
            } 
       
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            
        } 
    }
    
}
