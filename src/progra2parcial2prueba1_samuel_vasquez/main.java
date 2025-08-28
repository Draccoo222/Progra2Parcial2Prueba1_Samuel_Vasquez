/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2parcial2prueba1_samuel_vasquez;



import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hnleo
 */
public class main {

    static MiFile mf = new MiFile();
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        do {
            System.out.println("\nMENU\n");
            System.out.println("1- Set el archivo/folder");
            System.out.println("2- Ver informacion");
            System.out.println("3- Crear archivo");
            System.out.println("4- Crear folder");
            System.out.println("5- Borrar Arhcivo/Folder");
            System.out.println("6- Listar");
            System.out.println("7- Mostrar Detalles");
            System.out.println("8- Salir");
            System.out.print("Elija una opción: ");
            try {
                option = leer.nextInt();
                switch (option) {
                    case 1:
                        set();
                        break;
                    case 2:
                        mf.info();
                        break;
                    case 3:
                        mf.crearArchivo();
                        break;
                    case 4:
                        mf.crearFolder();
                        break;
                    case 5:
                        
                        if(mf.borrar(mf.getFile())){
                            System.out.println("Borrado con éxito.");
                        }else{
                            System.out.println("No se pudo borrar.");
                        }
                        break;
                        
                    case 6:
                        mf.tree();
                        break;
                        
                    case 7: 
                        mf.mostrarDir(mf.getFile());
                        break;
                }
            } catch (InputMismatchException e) {
                leer.nextLine();
                System.out.println("Por favor ingrese una opción correcta: ");
            } catch (NullPointerException e){
                System.out.println("Debes seleccionar la opción 1, por lo menos una vez.");
            } catch (IOException e){
                System.out.println("Error en Disco: "+e.getMessage());
            }

        } while (option != 8);
    }
   private static void set(){
       System.out.println("Dirección: ");
       mf.setFile(leer.next());
   }
}
