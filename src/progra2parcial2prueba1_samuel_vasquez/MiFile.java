/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2parcial2prueba1_samuel_vasquez;

import java.io.*;
import java.util.Date;

/**
 *
 * @author unwir
 */
public class MiFile {

    private File file = null;

    public void setFile(String dir) {
        file = new File(dir);
    }

    public void crearArchivo() throws IOException {
        if (file.createNewFile()) {
            System.out.println("Archivo creado exitosamente.");
        } else {
            System.out.println("Error, no se pudo crear");
        }
    }

    public void crearFolder() throws IOException {
        if (file.mkdirs()) {
            System.out.println("Folder creado exitosamente.");
        } else {
            System.out.println("Error, no se pudo crear.");
        }
    }

    public boolean borrar(File f) throws IOException {
        return f.delete();
    }

    public boolean borrarTodo() throws IOException {
        if (file.delete()) {
            return true;
        } else {
            File archivos[] = file.listFiles();

            for (File archivo : archivos) {
                archivo.delete();
            }
            return file.delete();
        }
    }

    public void info() {
        if (file.exists()) {
            System.out.println("Si existe");
            System.out.println("\n Nombre: " + file.getName());
            System.out.println("\n Path: " + file.getPath());
            System.out.println("\n Absolute path: " + file.getAbsolutePath());
            System.out.println("\n Padre: " + file.getAbsoluteFile().getParentFile().getParent());
            System.out.println("\n Bytes: " + file.length());
            if (file.isFile()) {
                System.out.println("Es un archivo");
            } else if (file.isDirectory()) {
                System.out.println("Es un folder");
                System.out.println("Ultima modi: " + new Date(file.lastModified()));
            }
        } else {
            System.out.println("No existe");
        }
    }

    public File getFile() {
        return file;
    }

    public void mostrarDir(File arch) {
        if (arch.exists()) {
            if (arch.isDirectory()) {
                String modis = "";
                String names = "";
                int cantArch = 0;
                int cantFiles = 0;
                double tamArch = 0;
                double tamFiles = 0;
                System.out.println("Directorio de: " + arch.getAbsolutePath());
                System.out.println("ULTIMA MODIFICACION - TIPO - TAMAÑO - NOMBRE");
                for (File f : arch.listFiles()) {
                    if (!f.isHidden()) {
                        if (f.isFile()) {
                            cantFiles++;
                            tamFiles += f.length();
                        } else if (f.isDirectory()) {
                            cantArch++;
                            tamArch += f.length();
                        }
                        modis += new Date(f.lastModified()) + "   " + ((f.isFile()) ? "FILE" : "<DIR>")
                                + "   " + ((f.isFile()) ? f.length() + "KB" : "-")  + "   " + f.getName() + "\n";
                    }
                }
                System.out.println(modis);
                System.out.println("Files: " + cantFiles + " - " + tamFiles + "KB");
                System.out.println("Archivos: " + cantArch + " - " + String.format("%.2f",tamArch) + "GB Libres");
            } else {
                System.out.println("Porfavor, use un directorio para mostrar informacion y no un archivo");
            }
        } else {
            System.out.println("Error, archivo no existe");
        }

    }

    private void tree(String dir, File f) {
        if(f.isDirectory()){
            System.out.println(dir + f.getName());
            for(File m : f.listFiles()){
                if(!m.isHidden()){
                    tree(dir + "--", f);
                }
            }
        }
    }
    
    public void tree(){
        tree("-", file);
    }

}
