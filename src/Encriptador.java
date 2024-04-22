import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encriptador {
    public static void encriptarArchivo(int clave, String archivoParaEncriptar) {

        int extensionIndex = archivoParaEncriptar.lastIndexOf(".txt");
        String archivoEncriptado = archivoParaEncriptar.substring(0, extensionIndex) + "_encriptado.txt";


        try (FileReader reader = new FileReader(archivoParaEncriptar);
             FileWriter writer = new FileWriter(archivoEncriptado)) {

            while (reader.ready()) {
                char ch = (char) reader.read();
                ch+=(char) clave;
                writer.append(ch);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Algo salió mal : No se encontró el archivo especificado" + e);
        } catch (IOException e) {
            System.out.println("Algo salió mal : " + e);
        }
    }

}
