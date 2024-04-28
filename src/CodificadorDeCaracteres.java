import java.util.Arrays;
import java.util.List;

public class CodificadorDeCaracteres {
    char recorrerLetra(char letraOriginal, int clave){
        int codigoLetraMovida = letraOriginal + clave;
        char letraMovida = (char) codigoLetraMovida;
        return letraMovida;
    }
    String recorrerLetra(String textoOriginal, int clave){
        StringBuilder creadorDeCadenas = new StringBuilder();
        for (int i = 0; i < textoOriginal.length(); i++) {
            char letraOriginal = textoOriginal.charAt(i);
            char letraCambiada = recorrerLetra(letraOriginal, clave);
            creadorDeCadenas.append(letraCambiada);
        }
        String textoRecorrido = creadorDeCadenas.toString();
        return textoRecorrido;
    }
}
