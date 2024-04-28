import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Desencriptador {

    public static String desencriptarArchivo(int clave, String archivoParaEncriptar) {

//        int extensionIndex = archivoParaEncriptar.lastIndexOf(".txt");
        String archivoEncriptado = "archivo_desencriptado.txt";

        try (FileReader reader = new FileReader(archivoParaEncriptar);
             FileWriter writer = new FileWriter(archivoEncriptado)) {

            while (reader.ready()) {
                char ch = (char) reader.read();
                ch-=(char) clave;
                writer.append(ch);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Algo salió mal : No se encontró el archivo especificado" + e);
        } catch (IOException e) {
            System.out.println("Algo salió mal : " + e);
        }
        return archivoEncriptado;
    }
    public static boolean comprobarTexto(String archivoEncriptado) throws IOException {
        String cadenaDeComprobacion;
        int contador = 0;
        String letrasEspanol = "aeiouáéíóúüñ";
            cadenaDeComprobacion = Files.readString(Path.of(archivoEncriptado));
            cadenaDeComprobacion = cadenaDeComprobacion.toLowerCase(); // Convertir el texto a minúsculas para facilitar la comparación
            //System.out.println("algo salio mal");;

        // Contar la cantidad de letras comunes en español presentes en el texto

        for (char c : cadenaDeComprobacion.toCharArray()) {
            if (letrasEspanol.contains(Character.toString(c))) {
                contador++;
            }
        }
        // Si más del 50% de las letras del texto son comunes en español, asumimos que el texto está en español
        return (double) contador / cadenaDeComprobacion.length() > 0.5;
    }

}
