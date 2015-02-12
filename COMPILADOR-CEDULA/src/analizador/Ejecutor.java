package analizador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XIMENA ASTUDILLO
 */
public class Ejecutor {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            String path = System.getProperty("user.dir") + "/src/analizador/analizador.flex";
            File archivo = new File(path);
            JFlex.Main.generate(archivo);
        } catch (Exception ex) {
            System.out.println("ERROR ");
        }
        // TODO code application logic here
//
        String opciones[] = new String[5];
        opciones[0] = "-destdir";
        opciones[1] = "src"+File.separator+"analizador";
        opciones[2] = "-parser";
        opciones[3] = "parser";
        opciones[4] = "src"+File.separator+"analizador"+File.separator+"XimenaAstudillo_ASintactico.cup";

        try {
            java_cup.Main.main(opciones);
        } catch (Exception e) {
            System.out.print(e);
        }
        
             
        validaCadena();
    }
    
    public static void validaCadena() throws FileNotFoundException, IOException {
//        String ar = "";
//        Scanner leer= new Scanner(System.in);
//        System.out.println("Ingrese el numero de cedula:");
//        ar = leer.next();
//        FileOutputStream F = new FileOutputStream("C:\\Users\\Informatico\\Documents\\IX MODULO NUEVO\\COMPILADORES\\Tarea 21.01.2015\\COMPILADOR-CEDULA\\src\\analizador\\archivo.txt");
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(F));
//        bw.write(ar);
//        bw.close();
        
        
        try {
            //        String salida = "";
//        try {
//            System.out.println("________________ "+cadena);
//            analizador.Analizador analizador = new analizador.Analizador(new StringReader(cadena));
//            salida = analizador.yytext().toString();
//            System.out.println("________________ "+salida);
//        } catch (Exception ex) {
//            System.out.println("ERROR "+ex);
//        }
//        return salida;
            
            
        parser p=new parser(new Analizador(new InputStreamReader(new FileInputStream("C:\\Users\\Informatico\\Documents\\IX MODULO NUEVO\\COMPILADORES\\Tarea 21.01.2015\\COMPILADOR-CEDULA\\src\\analizador\\archivo.txt"))));
        p.parse();      
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejecutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Ejecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
}
