import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class LectorDeArchivo {
    //
    public static String leerArchivoTexto(String nombreArchivo){
        try {
            return Files.readString(Path.of(nombreArchivo));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//    return contenido.toString();
    }
    public static void escribirArchivoDeTexto(String textoParaArchivo){
        try {
            Files.writeString(Path.of("archivocopy.txt"), textoParaArchivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
